package com.panilya.mochaccinoserver.dataservice.text.csv;

import com.panilya.mochaccinoserver.dataservice.ProviderService;
import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import net.datafaker.Faker;
import net.datafaker.formats.Csv;
import net.datafaker.formats.Format;
import net.datafaker.transformations.CsvTransformer;
import net.datafaker.transformations.Field;
import net.datafaker.transformations.Schema;
import net.datafaker.transformations.SimpleField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.io.File.separator;

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

        CsvTransformer<?> transformer =
                new CsvTransformer.CsvTransformerBuilder<>().header(requestEntity.isHeader()).separator(getSeparator(requestEntity)).build();
        String generate = transformer.generate(generateSchema(values), requestEntity.getLimit());

//        String csv = Format.toCsv(traverseCsvColumnsList(values))
//                .header(requestEntity.isHeader())
//                .separator(getSeparator(requestEntity))
//                .limit(requestEntity.getLimit())
//                .build().get();
        return generate;
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

//    private List<Csv.Column> traverseCsvColumnsList(List<String> columns) {
//        List<Csv.Column> result = new ArrayList<>();
//
//        for (String column : columns) {
//            CsvDataProvider provider = CsvDataProvider.of(column);
//            result.add(Csv.Column.of(provider.getHeader(), provider.getProvider().apply(faker)));
//        }
//        return result;
//    }

    private String getSeparator(RequestEntity requestEntity) {
        if (requestEntity.getSeparator() == null) {
            return DEFAULT_SEPARATOR;
        }
        return requestEntity.getSeparator();
    }
}
