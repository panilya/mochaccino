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
public class DataProviderService {

    private final Faker faker;

    @Autowired
    public DataProviderService(Faker faker) {
        this.faker = faker;
    }

    public void provideFakeData(RequestEntity requestEntity) {
        List<String> values;
        try {
            values = RequestEntityUtils.getValues(requestEntity);
        } catch (IllegalAccessException e) {
            System.err.print("Error while getting values from RequestEntity in RequestEntityUtils.getValues");
            values = Collections.emptyList();
        }

        String csv = Format.toCsv(traverseCsvColumnsList(values)).header(true).separator(",").build().get();
        System.out.println(csv);
    }

    private List<Csv.Column> traverseCsvColumnsList(List<String> columns) {
        List<Csv.Column> result = new ArrayList<>();

        for (String column : columns) {
            if (columns.contains("firstName")) {
                result.add(Csv.Column.of("first_name", () -> faker.name().firstName()));
            } else if (columns.contains("fullName")) {
                result.add(Csv.Column.of("full_name", () -> faker.name().fullName()));
            } else if (columns.contains("lastName")) {
                result.add(Csv.Column.of("last_name", () -> faker.name().lastName()));
            } else if (columns.contains("phoneNumber")) {
                result.add(Csv.Column.of("phone_number", () -> faker.phoneNumber().phoneNumber()));
            } else if (columns.contains("address")) {
                result.add(Csv.Column.of("address", () -> faker.address().fullAddress()));
            }
        }
        return result;
    }
}
