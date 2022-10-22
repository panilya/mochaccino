package com.panilya.mochaccinoserver.dataservice.file;

import com.panilya.mochaccinoserver.dataservice.DataFormat;
import com.panilya.mochaccinoserver.dataservice.file.csv.CsvAsFileDataProviderService;
import com.panilya.mochaccinoserver.dataservice.file.json.JsonAsFileDataProviderService;
import com.panilya.mochaccinoserver.dataservice.file.sql.SqlAsFileDataProviderService;
import com.panilya.mochaccinoserver.dataservice.text.formatservices.CsvFormatProviderService;
import com.panilya.mochaccinoserver.dataservice.text.formatservices.JsonFormatProviderService;
import com.panilya.mochaccinoserver.dataservice.text.formatservices.SqlFormatProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileProviderServiceFactory {

    private final JsonFormatProviderService jsonFormatProviderService;
    private final CsvFormatProviderService csvFormatProviderService;
    private final SqlFormatProviderService sqlFormatProviderService;

    @Autowired
    public FileProviderServiceFactory(JsonFormatProviderService jsonFormatProviderService, CsvFormatProviderService csvFormatProviderService, SqlFormatProviderService sqlFormatProviderService) {
        this.jsonFormatProviderService = jsonFormatProviderService;
        this.csvFormatProviderService = csvFormatProviderService;
        this.sqlFormatProviderService = sqlFormatProviderService;
    }

    public FileProviderService createDataProviderService(DataFormat dataFormat) {
        switch (dataFormat) {
            case JSON:
                return new JsonAsFileDataProviderService(jsonFormatProviderService);
            case CSV:
                return new CsvAsFileDataProviderService(csvFormatProviderService);
            case SQL:
                return new SqlAsFileDataProviderService(sqlFormatProviderService);
            default:
                throw new IllegalStateException("Error in FileProviderServiceFactory");
        }
    }
}
