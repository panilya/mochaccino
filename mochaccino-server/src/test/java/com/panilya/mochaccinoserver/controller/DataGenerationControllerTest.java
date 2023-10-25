package com.panilya.mochaccinoserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panilya.mochaccinoserver.model.RequestEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DataGenerationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void generateCsvContentText() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(post("/data")
                .content(objectMapper.writeValueAsString(new RequestEntity(List.of("firstName"), 5)))
                .contentType(MediaType.APPLICATION_JSON)
                        .param("format", "csv"))
                .andExpect(status().isOk());
    }

    @Test
    void generateJsonContentText() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(post("/data")
                        .content(objectMapper.writeValueAsString(new RequestEntity(List.of("firstName"), 5)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("format", "json"))
                .andExpect(status().isOk());
    }

    @Test
    void generateSqlContentText() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(post("/data")
                        .content(objectMapper.writeValueAsString(new RequestEntity(List.of("firstName"), 5)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("format", "sql"))
                .andExpect(status().isOk());
    }

    @Test
    void generateCsvContentFile() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(post("/data/download")
                        .content(objectMapper.writeValueAsString(new RequestEntity(List.of("firstName"), 5)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("format", "csv"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM));

    }

    @Test
    void generateJsonContentFile() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(post("/data/download")
                        .content(objectMapper.writeValueAsString(new RequestEntity(List.of("firstName"), 5)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("format", "json"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM));

    }

    @Test
    void generateSqlContentFile() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(post("/data/download")
                        .content(objectMapper.writeValueAsString(new RequestEntity(List.of("firstName"), 5)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("format", "sql"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM));

    }

}
