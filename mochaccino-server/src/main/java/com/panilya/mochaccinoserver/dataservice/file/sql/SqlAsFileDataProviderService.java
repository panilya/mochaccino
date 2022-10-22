package com.panilya.mochaccinoserver.dataservice.file.sql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panilya.mochaccinoserver.dataservice.ProviderService;
import com.panilya.mochaccinoserver.dataservice.file.FileProviderService;
import com.panilya.mochaccinoserver.model.RequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;

public class SqlAsFileDataProviderService implements FileProviderService {

    private final ProviderService providerService;

    @Autowired
    public SqlAsFileDataProviderService(@Qualifier("sqlFormatProviderService") ProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public byte[] getDataAsFile(RequestEntity requestEntity) throws IOException {
        String provideData = providerService.provideData(requestEntity);
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
