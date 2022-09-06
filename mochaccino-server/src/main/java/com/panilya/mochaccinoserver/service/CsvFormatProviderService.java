package com.panilya.mochaccinoserver.service;

import com.panilya.mochaccinoserver.model.RequestEntity;
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

    @Autowired
    public CsvFormatProviderService(Faker faker) {
        this.faker = faker;
    }

    @Override
    public String provideData(RequestEntity requestEntity) {
        List<String> values;
        try {
            values = RequestEntityUtils.getValues(requestEntity);
        } catch (IllegalAccessException e) {
            System.err.print("Error while getting values from RequestEntity in RequestEntityUtils.getValues");
            values = Collections.emptyList();
        }

        String csv = Format.toCsv(traverseCsvColumnsList(values)).header(true).separator(",").build().get();
        System.out.println(csv);
        return csv;
    }

    private List<Csv.Column> traverseCsvColumnsList(List<String> columns) {
        List<Csv.Column> result = new ArrayList<>();

        for (String column : columns) {
            if (column.contains("firstName")) {
                result.add(Csv.Column.of("first_name", () -> faker.name().firstName()));
            } else if (column.contains("fullName")) {
                result.add(Csv.Column.of("full_name", () -> faker.name().fullName()));
            } else if (column.contains("lastName")) {
                result.add(Csv.Column.of("last_name", () -> faker.name().lastName()));
            } else if (column.contains("phoneNumber")) {
                result.add(Csv.Column.of("phone_number", () -> faker.phoneNumber().phoneNumber()));
            } else if (column.contains("address")) {
                result.add(Csv.Column.of("address", () -> faker.address().fullAddress()));
            }
        }
        return result;
    }

}
