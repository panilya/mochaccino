package com.panilya.mochaccinoserver.service.file;

import com.panilya.mochaccinoserver.service.DataFormat;
import com.panilya.mochaccinoserver.service.ProviderService;
import com.panilya.mochaccinoserver.service.file.csv.CsvAsFileDataProviderService;
import com.panilya.mochaccinoserver.service.file.json.JsonAsFileDataProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FileProviderServiceFactory {

    private final ProviderService providerService;

    @Autowired
    public FileProviderServiceFactory(@Qualifier("csvFormatProviderService") ProviderService providerService) {
        this.providerService = providerService;
    }

    public FileProviderService createDataProviderService(DataFormat dataFormat) {
        switch (dataFormat) {
            case JSON:
                return new JsonAsFileDataProviderService(providerService);
            case CSV:
                return new CsvAsFileDataProviderService(providerService);
            default:
                throw new IllegalStateException("Error in FileProviderServiceFactory");
        }
    }
}
