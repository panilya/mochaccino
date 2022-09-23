package com.panilya.mochaccinoserver.controller;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.service.file.FileDataGenerationService;
import com.panilya.mochaccinoserver.service.text.DataGenerationService;
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

    @PostMapping("/data")
    public ResponseEntity<String> generateMockData(@RequestBody RequestEntity requestEntity, @RequestParam(name = "format") String format) {
        return org.springframework.http.ResponseEntity.ok(dataGenerationService.generateData(requestEntity, format));
    }

    @PostMapping("/data/download")
    public ResponseEntity<byte[]> downloadMockDataAsFile(@RequestBody RequestEntity requestEntity, @RequestParam(name = "format") String format) {
        MediaType applicationOctetStream = MediaType.APPLICATION_OCTET_STREAM;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Content-Disposition");
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "MOCK_DATA." + format + "\"");
        httpHeaders.add("Data-Fileformat", "."+format);
        byte[] dataInFile = fileDataGenerationService.generateDataInFile(requestEntity, format);
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(applicationOctetStream)
                .body(dataInFile);
    }
}
