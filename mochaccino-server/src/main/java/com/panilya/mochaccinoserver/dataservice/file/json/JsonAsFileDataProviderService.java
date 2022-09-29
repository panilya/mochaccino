package com.panilya.mochaccinoserver.dataservice.file.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.dataservice.ProviderService;
import com.panilya.mochaccinoserver.dataservice.file.FileProviderService;
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
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(tempDataFile.toFile(), provideData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = Files.readAllBytes(tempDataFile);
        Files.delete(tempDataFile);
        return bytes;
    }
}
