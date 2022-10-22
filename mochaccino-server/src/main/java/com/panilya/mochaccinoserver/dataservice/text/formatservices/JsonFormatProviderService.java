package com.panilya.mochaccinoserver.dataservice.text.formatservices;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.RequestParamsContainer;
import net.datafaker.Faker;
import net.datafaker.transformations.JsonTransformer;
import net.datafaker.transformations.Schema;
import org.springframework.stereotype.Service;

@Service
public class JsonFormatProviderService extends BaseDataProvider {

    public JsonFormatProviderService(Faker faker) {
        super(faker);
    }

    @Override
    protected String generateData(Schema schema, RequestEntity requestEntity, RequestParamsContainer parameters) {
        return new JsonTransformer<>().generate(schema, requestEntity.getLimit());
    }
}
