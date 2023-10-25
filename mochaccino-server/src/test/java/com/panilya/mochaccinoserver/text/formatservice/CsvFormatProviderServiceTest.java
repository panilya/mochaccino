package com.panilya.mochaccinoserver.text.formatservice;

import com.panilya.mochaccinoserver.dataservice.text.formatservices.CsvFormatProviderService;
import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.RequestParamsContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CsvFormatProviderServiceTest {

    @Autowired
    CsvFormatProviderService csvFormatProviderService;

    @Test
    void testDataGeneration() {
        assertThat(csvFormatProviderService.generateData(
                new RequestEntity(List.of("address"), 5),
                new RequestParamsContainer("table", "POSTGRES", true, ","))
        ).isNotEmpty();
    }

}
