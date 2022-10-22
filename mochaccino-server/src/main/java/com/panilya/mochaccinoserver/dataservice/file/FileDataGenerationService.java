package com.panilya.mochaccinoserver.dataservice.file;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.dataservice.DataFormat;
import com.panilya.mochaccinoserver.utils.RequestEntityUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FileDataGenerationService {

    private final FileProviderServiceFactory fileProviderServiceFactory;

    @Autowired
    public FileDataGenerationService(FileProviderServiceFactory fileProviderServiceFactory) {
        this.fileProviderServiceFactory = fileProviderServiceFactory;
    }

    @SneakyThrows
    public byte[] generateDataInFile(RequestEntity requestEntity, String requestParamFormat) {
        DataFormat format;
        try {
            format = RequestEntityUtils.readFormatParam(requestParamFormat);
        } catch (NoSuchFieldException e) {
            throw new NoSuchElementException("Format is not specified");
        }

        FileProviderService providerService = fileProviderServiceFactory.createDataProviderService(format);
        return providerService.getDataAsFile(requestEntity);
    }

}
