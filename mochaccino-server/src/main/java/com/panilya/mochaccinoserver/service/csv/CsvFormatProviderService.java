package com.panilya.mochaccinoserver.service.csv;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.service.ProviderService;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import net.datafaker.Faker;
import net.datafaker.fileformats.Csv;
import net.datafaker.fileformats.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CsvFormatProviderService implements ProviderService {

    private final Faker faker;
    private static final String DEFAULT_SEPARATOR = ",";

    @Autowired
    public CsvFormatProviderService(Faker faker) {
        this.faker = faker;
    }

    @Override
    public String provideData(RequestEntity requestEntity) {
        List<String> values;
        try {
            values = RequestEntityUtils.getValues(requestEntity);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            System.err.print("Error while getting values from RequestEntity in RequestEntityUtils.getValues");
            values = Collections.emptyList();
        }

        String csv = Format.toCsv(traverseCsvColumnsList(values))
                .header(requestEntity.isHeader())
                .separator(getSeparator(requestEntity))
                .limit(requestEntity.getLimit())
                .build().get();
        System.out.println(csv);
        return csv;
    }

    private List<Csv.Column> traverseCsvColumnsList(List<String> columns) {
        List<Csv.Column> result = new ArrayList<>();

        for (String column : columns) {
            DataProvider provider = DataProvider.of(column);
            result.add(Csv.Column.of(provider.getHeader(), provider.getProvider().apply(faker)));
        }
        return result;
    }

    private String getSeparator(RequestEntity requestEntity) {
        if (requestEntity.getSeparator() == null) {
            return DEFAULT_SEPARATOR;
        }
        return requestEntity.getSeparator();
    }
}
