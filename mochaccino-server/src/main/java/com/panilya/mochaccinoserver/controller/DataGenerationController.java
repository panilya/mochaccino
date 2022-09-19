package com.panilya.mochaccinoserver.controller;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.service.file.FileDataGenerationService;
import com.panilya.mochaccinoserver.service.text.DataGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS;

@RestController()
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
        ContentDisposition contentDisposition = ContentDisposition.attachment().filename("MOCK_DATA"+format.toLowerCase(), StandardCharsets.UTF_8).build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccessControlExposeHeaders(Collections.singletonList(ACCESS_CONTROL_EXPOSE_HEADERS));
        httpHeaders.setContentDisposition(contentDisposition);

        byte[] dataInFile = fileDataGenerationService.generateDataInFile(requestEntity, format);
        System.out.println(Arrays.toString(dataInFile));
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .contentType(applicationOctetStream)
                .body(dataInFile);
    }
}
