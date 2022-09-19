package com.panilya.mochaccinoserver.service.file.csv;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.service.ProviderService;
import com.panilya.mochaccinoserver.service.file.FileProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CsvAsFileDataProviderService implements FileProviderService {

    private final ProviderService providerService;

    @Autowired
    public CsvAsFileDataProviderService(@Qualifier("csvFormatProviderService") ProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public byte[] getDataAsFile(RequestEntity requestEntity) throws IOException {
        return new byte[0]; //TODO
    }
}
