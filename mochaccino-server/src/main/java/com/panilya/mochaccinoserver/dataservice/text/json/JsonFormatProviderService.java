package com.panilya.mochaccinoserver.dataservice.text.json;

import com.panilya.mochaccinoserver.dataservice.ProviderService;
import com.panilya.mochaccinoserver.dataservice.text.csv.CsvDataProvider;
import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import net.datafaker.Faker;

import net.datafaker.formats.Format;
import net.datafaker.formats.Json;
import net.datafaker.transformations.Field;
import net.datafaker.transformations.JsonTransformer;
import net.datafaker.transformations.Schema;
import net.datafaker.transformations.SimpleField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class JsonFormatProviderService implements ProviderService {

    private final Faker faker;

    @Autowired
    public JsonFormatProviderService(Faker faker) {
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

        return new JsonTransformer<>().generate(generateSchema(values), requestEntity.getLimit());
    }

    private Schema generateSchema(List<String> columns) {
        List<SimpleField<Object, String>> fields = new ArrayList<>(columns.size());

        for (String column : columns) {
            CsvDataProvider provider = CsvDataProvider.of(column);
            SimpleField<Object, String> field = Field.field(provider.getName(), () -> provider.getProvider().apply(faker));
            fields.add(field);
        }

        return new Schema.SchemaBuilder<>().of(fields.toArray(new Field[0])).build();
    }

}
