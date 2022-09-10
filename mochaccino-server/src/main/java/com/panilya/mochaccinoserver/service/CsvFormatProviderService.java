package com.panilya.mochaccinoserver.service;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import net.datafaker.Faker;
import net.datafaker.fileformats.Csv;
import net.datafaker.fileformats.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CsvFormatProviderService implements ProviderService {

    private final Faker faker;

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

        String csv = Format.toCsv(traverseCsvColumnsList(values)).header(true).separator(",").build().get();
        System.out.println(csv);
        return csv;
    }

    private List<Csv.Column> traverseCsvColumnsList(List<String> columns) {
        List<Csv.Column> result = new ArrayList<>();

        Map<String, DataProvider> supportedProviders = new HashMap<>();
        supportedProviders.put("firstName", DataProvider.FIRST_NAME);
        supportedProviders.put("lastName", DataProvider.LAST_NAME);

        for (String column : columns) {
            DataProvider provider = supportedProviders.get(column);
            result.add(Csv.Column.of(provider.getHeader(), provider.getProvider().apply(faker)));
        }
        return result;
    }
}
