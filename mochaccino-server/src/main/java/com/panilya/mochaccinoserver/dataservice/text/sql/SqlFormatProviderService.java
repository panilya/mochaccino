package com.panilya.mochaccinoserver.dataservice.text.sql;

import com.panilya.mochaccinoserver.dataservice.ProviderService;
import com.panilya.mochaccinoserver.dataservice.text.csv.CsvDataProvider;
import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import net.datafaker.Faker;
import net.datafaker.transformations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SqlFormatProviderService implements ProviderService {

    private final Faker faker;

    @Autowired
    public SqlFormatProviderService(Faker faker) {
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

        return new SqlTransformer.SqlTransformerBuilder().dialect(SqlDialect.POSTGRES).tableName("person").build().generate(generateSchema(values), requestEntity.getLimit());
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
