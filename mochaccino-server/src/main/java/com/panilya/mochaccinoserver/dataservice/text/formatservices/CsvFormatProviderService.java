package com.panilya.mochaccinoserver.dataservice.text.formatservices;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.RequestParamsContainer;
import net.datafaker.Faker;
import net.datafaker.transformations.CsvTransformer;
import net.datafaker.transformations.Schema;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CsvFormatProviderService extends BaseDataProvider {

    private static final String DEFAULT_SEPARATOR = ",";

    public CsvFormatProviderService(Faker faker) {
        super(faker);
    }

    @Override
    protected String generateData(Schema schema, RequestEntity requestEntity, RequestParamsContainer parameters) {
        return new CsvTransformer.CsvTransformerBuilder<>().header(parameters.header).separator(getSeparator(parameters)).build().generate(schema, requestEntity.getLimit());
    }

    private String getSeparator(RequestParamsContainer parameters) {
        return Objects.requireNonNullElse(parameters.separator, DEFAULT_SEPARATOR);
    }

}
