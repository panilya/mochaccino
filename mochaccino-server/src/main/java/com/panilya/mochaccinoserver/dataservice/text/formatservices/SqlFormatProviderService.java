package com.panilya.mochaccinoserver.dataservice.text.formatservices;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.RequestParamsContainer;
import net.datafaker.Faker;
import net.datafaker.transformations.Schema;
import net.datafaker.transformations.sql.SqlDialect;
import net.datafaker.transformations.sql.SqlTransformer;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SqlFormatProviderService extends BaseDataProvider {

    public SqlFormatProviderService(Faker faker) {
        super(faker);
    }

    @Override
    protected String generateData(Schema schema, RequestEntity requestEntity, RequestParamsContainer parameters) {
        return SqlTransformer.builder().dialect(determineDialect(parameters.dialect)).tableName(parameters.tableName).build().generate(schema, requestEntity.getLimit());
    }

    private SqlDialect determineDialect(String dialect) {
        switch (dialect.toUpperCase()) {
            case "ANSI":
                return SqlDialect.ANSI;
            case "BIGQUERY":
                return SqlDialect.BIGQUERY;
            case "CALCITE":
                return SqlDialect.CALCITE;
            case "CLICKHOUSE":
                return SqlDialect.CLICKHOUSE;
            case "EXASOL":
                return SqlDialect.EXASOL;
            case "FIREBOLT":
                return SqlDialect.FIREBOLT;
            case "H2":
                return SqlDialect.H2;
            case "INFOBRIGHT":
                return SqlDialect.INFOBRIGHT;
            case "LUCIDDB":
                return SqlDialect.LUCIDDB;
            case "MSSQL":
                return SqlDialect.MSSQL;
            case "MYSQL":
                return SqlDialect.MYSQL;
            case "NETEZZA":
                return SqlDialect.NETEZZA;
            case "ORACLE":
                return SqlDialect.ORACLE;
            case "PARACCEL":
                return SqlDialect.PARACCEL;
            case "PHOENIX":
                return SqlDialect.PHOENIX;
            case "POSTGRES":
                return SqlDialect.POSTGRES;
            case "PRESTO":
                return SqlDialect.PRESTO;
            case "REDSHIFT":
                return SqlDialect.REDSHIFT;
            case "SNOWFLAKE":
                return SqlDialect.SNOWFLAKE;
            case "TERADATA":
                return SqlDialect.TERADATA;
            case "VERTICA":
                return SqlDialect.VERTICA;
        }
        throw new NoSuchElementException("Dialect is not correct!");
    }

}
