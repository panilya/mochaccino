package com.panilya.mochaccinoserver.utils;

import com.panilya.mochaccinoserver.dataservice.DataFormat;
import lombok.SneakyThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RequestEntityUtilsTest {

    private static Stream<? extends Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("csv", DataFormat.CSV),
                Arguments.of("json", DataFormat.JSON),
                Arguments.of("sql", DataFormat.SQL)
        );
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("provideArguments")
    void testReadFormatHelper(String format, DataFormat dataFormat) {
        assertThat(RequestEntityUtils.readFormatParam(format)).isEqualTo(dataFormat);
    }

}
