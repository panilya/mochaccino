package com.panilya.mochaccinoserver.controller;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.dataservice.file.FileDataGenerationService;
import com.panilya.mochaccinoserver.dataservice.text.DataGenerationService;
import com.panilya.mochaccinoserver.model.RequestParamsContainer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin("*")
public class DataGenerationController {

    private final DataGenerationService dataGenerationService;
    private final FileDataGenerationService fileDataGenerationService;

    @Autowired
    public DataGenerationController(DataGenerationService dataGenerationService, FileDataGenerationService fileDataGenerationService) {
        this.dataGenerationService = dataGenerationService;
        this.fileDataGenerationService = fileDataGenerationService;
    }

    @Operation(summary = "Generate data in text")
    @PostMapping("/data")
    public ResponseEntity<String> generateMockData(@RequestBody RequestEntity requestEntity,
                                                   @RequestParam(name = "format") String format,
                                                   @RequestParam(name = "tableName", required = false, defaultValue = "table") String tableName,
                                                   @RequestParam(name = "dialect", required = false, defaultValue = "POSTGRES") String dialect,
                                                   @RequestParam(name = "header", required = false, defaultValue = "true") Boolean header,
                                                   @RequestParam(name = "separator", required = false, defaultValue = ",") String separator) {

        RequestParamsContainer parameters = new RequestParamsContainer(tableName, dialect, header, separator);
        return org.springframework.http.ResponseEntity.ok(dataGenerationService.generateData(requestEntity, format, parameters));
    }

    @Operation(summary = "Generate data in files")
    @PostMapping("/data/download")
    public ResponseEntity<byte[]> downloadMockDataAsFile(@RequestBody RequestEntity requestEntity, @RequestParam(name = "format") String format,
                                                         @RequestParam(name = "tableName", required = false, defaultValue = "table") String tableName,
                                                         @RequestParam(name = "dialect", required = false, defaultValue = "POSTGRES") String dialect,
                                                         @RequestParam(name = "header", required = false, defaultValue = "true") Boolean header,
                                                         @RequestParam(name = "separator", required = false, defaultValue = ",") String separator) {

        RequestParamsContainer parameters = new RequestParamsContainer(tableName, dialect, header, separator);
        byte[] dataInFile = fileDataGenerationService.generateDataInFile(requestEntity, format, parameters);

        MediaType applicationOctetStream = MediaType.APPLICATION_OCTET_STREAM;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition");
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "MOCK_DATA." + format + "\"");
        httpHeaders.add("Data-Fileformat", "."+format);
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(applicationOctetStream)
                .body(dataInFile);
    }
}
