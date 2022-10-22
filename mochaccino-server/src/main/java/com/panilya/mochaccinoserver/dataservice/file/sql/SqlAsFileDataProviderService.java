package com.panilya.mochaccinoserver.dataservice.file.sql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panilya.mochaccinoserver.dataservice.file.FileProviderService;
import com.panilya.mochaccinoserver.dataservice.text.formatservices.BaseDataProvider;
import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.RequestParamsContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;

public class SqlAsFileDataProviderService implements FileProviderService {

    private final BaseDataProvider providerService;

    @Autowired
    public SqlAsFileDataProviderService(@Qualifier("sqlFormatProviderService") BaseDataProvider providerService) {
        this.providerService = providerService;
    }

    @Override
    public byte[] getDataAsFile(RequestEntity requestEntity, RequestParamsContainer parameters) throws IOException {
        String provideData = providerService.generateData(requestEntity, parameters);
        ObjectMapper mapper = new ObjectMapper();

        byte[] bytes = new byte[0];
        try {
            bytes = mapper.writeValueAsBytes(provideData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

}
