package com.panilya.mochaccinoserver.text.formatservice;

import com.panilya.mochaccinoserver.dataservice.text.formatservices.SqlFormatProviderService;
import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.RequestParamsContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SqlFormatProviderServiceTest {

    @Autowired
    SqlFormatProviderService sqlFormatProviderService;

    @Test
    void testDataGeneration() {
        assertThat(sqlFormatProviderService.generateData(
                new RequestEntity(List.of("address"), 5),
                new RequestParamsContainer("table", "POSTGRES", true, ","))
        ).isNotEmpty();
    }

}
