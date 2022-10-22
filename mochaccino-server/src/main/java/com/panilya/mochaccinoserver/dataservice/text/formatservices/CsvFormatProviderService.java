package com.panilya.mochaccinoserver.dataservice.text.formatservices;

import com.panilya.mochaccinoserver.model.RequestEntity;
import net.datafaker.Faker;
import net.datafaker.transformations.CsvTransformer;
import net.datafaker.transformations.Schema;
import org.springframework.stereotype.Service;

@Service
public class CsvFormatProviderService extends BaseDataProvider {

    private static final String DEFAULT_SEPARATOR = ",";

    public CsvFormatProviderService(Faker faker) {
        super(faker);
    }

    @Override
    protected String generateData(Schema schema, RequestEntity requestEntity) {
        return new CsvTransformer.CsvTransformerBuilder<>().header(requestEntity.isHeader()).separator(getSeparator(requestEntity)).build().generate(schema, requestEntity.getLimit());
    }

    private String getSeparator(RequestEntity requestEntity) {
        if (requestEntity.getSeparator() == null) {
            return DEFAULT_SEPARATOR;
        }
        return requestEntity.getSeparator();
    }

}
