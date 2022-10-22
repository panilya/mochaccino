package com.panilya.mochaccinoserver.dataservice.text.formatservices;

import com.panilya.mochaccinoserver.model.RequestEntity;
import net.datafaker.Faker;
import net.datafaker.transformations.Schema;
import net.datafaker.transformations.SqlDialect;
import net.datafaker.transformations.SqlTransformer;
import org.springframework.stereotype.Service;

@Service
public class SqlFormatProviderService extends BaseDataProvider {

    public SqlFormatProviderService(Faker faker) {
        super(faker);
    }

    @Override
    protected String generateData(Schema schema, RequestEntity requestEntity) {
        return new SqlTransformer.SqlTransformerBuilder().dialect(SqlDialect.POSTGRES).tableName("person").build().generate(schema, requestEntity.getLimit());
    }
}
