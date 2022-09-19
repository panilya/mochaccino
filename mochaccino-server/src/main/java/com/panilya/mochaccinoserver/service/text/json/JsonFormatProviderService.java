package com.panilya.mochaccinoserver.service.text.json;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.service.ProviderService;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import net.datafaker.Faker;
import net.datafaker.fileformats.Format;
import net.datafaker.fileformats.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Json.JsonFromCollectionBuilder<JsonFormatPOJO> json = Format.toJson(
                        faker.collection(() -> JsonFormatPOJO.builder()
                                .name(faker.name())
                                .address(faker.address())
                                .build()).len(requestEntity.getLimit()).build());

        for (String column : values) {
            json.set(JsonDataProvider.of(column).getName(), JsonDataProvider.of(column).getProvider());
        }

        return json.build().generate();
    }
}
