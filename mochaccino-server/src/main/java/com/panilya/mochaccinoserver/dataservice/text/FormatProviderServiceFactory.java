package com.panilya.mochaccinoserver.dataservice.text;

import com.panilya.mochaccinoserver.dataservice.DataFormat;
import com.panilya.mochaccinoserver.dataservice.text.formatservices.BaseDataProvider;
import com.panilya.mochaccinoserver.dataservice.text.formatservices.CsvFormatProviderService;
import com.panilya.mochaccinoserver.dataservice.text.formatservices.JsonFormatProviderService;
import com.panilya.mochaccinoserver.dataservice.text.formatservices.SqlFormatProviderService;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatProviderServiceFactory {

    private final Faker faker;

    @Autowired
    public FormatProviderServiceFactory(Faker faker) {
        this.faker = faker;
    }

    public BaseDataProvider createProviderService(DataFormat dataFormat) {
        switch (dataFormat) {
            case CSV:
                return new CsvFormatProviderService(faker);
            case JSON:
                return new JsonFormatProviderService(faker);
            case SQL:
                return new SqlFormatProviderService(faker);
            default:
                throw new IllegalStateException("Error in ProviderServiceFactory");
        }
    }
}
