package com.panilya.mochaccinoserver.service.file.json;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.service.ProviderService;
import com.panilya.mochaccinoserver.service.file.FileProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class JsonAsFileDataProviderService implements FileProviderService {

    private final ProviderService providerService;
    private final static String FILE_SUFFIX = ".json";

    @Autowired
    public JsonAsFileDataProviderService(@Qualifier("jsonFormatProviderService") ProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public byte[] getDataAsFile(RequestEntity requestEntity) throws IOException {
        String provideData = providerService.provideData(requestEntity);

        Path tempDataFile = Files.createTempFile("MOCK_DATA", FILE_SUFFIX);
        Path writtenFile = Files.writeString(tempDataFile.toAbsolutePath(), provideData);
        byte[] bytes = Files.readAllBytes(writtenFile);
        Files.delete(tempDataFile);
        return bytes;
    }

}
