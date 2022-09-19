package com.panilya.mochaccinoserver.service.file;

import com.panilya.mochaccinoserver.service.DataFormat;
import com.panilya.mochaccinoserver.service.file.csv.CsvAsFileDataProviderService;
import com.panilya.mochaccinoserver.service.file.json.JsonAsFileDataProviderService;
import com.panilya.mochaccinoserver.service.text.csv.CsvFormatProviderService;
import com.panilya.mochaccinoserver.service.text.json.JsonFormatProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileProviderServiceFactory {

    private final JsonFormatProviderService jsonFormatProviderService;
    private final CsvFormatProviderService csvFormatProviderService;

    @Autowired
    public FileProviderServiceFactory(JsonFormatProviderService jsonFormatProviderService, CsvFormatProviderService csvFormatProviderService) {
        this.jsonFormatProviderService = jsonFormatProviderService;
        this.csvFormatProviderService = csvFormatProviderService;
    }

    public FileProviderService createDataProviderService(DataFormat dataFormat) {
        switch (dataFormat) {
            case JSON:
                return new JsonAsFileDataProviderService(jsonFormatProviderService);
            case CSV:
                return new CsvAsFileDataProviderService(csvFormatProviderService);
            default:
                throw new IllegalStateException("Error in FileProviderServiceFactory");
        }
    }
}
