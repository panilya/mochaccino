package com.panilya.mochaccinoserver.dataservice.text.formatservices;

import com.panilya.mochaccinoserver.dataservice.text.AvailableDataProviders;
import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.RequestParamsContainer;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import net.datafaker.Faker;
import net.datafaker.transformations.Field;
import net.datafaker.transformations.Schema;
import net.datafaker.transformations.SimpleField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public abstract class BaseDataProvider {

    private final Faker faker;

    @Autowired
    public BaseDataProvider(Faker faker) {
        this.faker = faker;
    }

    protected abstract String generateData(Schema schema, RequestEntity requestEntity, RequestParamsContainer parameters);

    public String generateData(RequestEntity requestEntity, RequestParamsContainer parameters) {
        return generateData(generateSchema(extractColumns(requestEntity)), requestEntity, parameters);
    }

    private Schema generateSchema(List<String> columns) {
        List<SimpleField<Object, String>> fields = new ArrayList<>(columns.size());

        for (String column : columns) {
            AvailableDataProviders provider = AvailableDataProviders.of(column);
            SimpleField<Object, String> field = Field.field(provider.getName(), () -> provider.getProvider().apply(faker));
            fields.add(field);
        }

        return new Schema.SchemaBuilder<>().of(fields.toArray(new Field[0])).build();
    }

    private List<String> extractColumns(RequestEntity request) {
        List<String> values;
        try {
            values = RequestEntityUtils.getValues(request);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            System.err.print("Error while getting values from RequestEntity in RequestEntityUtils.getValues");
            values = Collections.emptyList();
        }

        return values;
    }

}
