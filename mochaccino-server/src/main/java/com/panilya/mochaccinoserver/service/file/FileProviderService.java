package com.panilya.mochaccinoserver.service.file;

import com.panilya.mochaccinoserver.model.RequestEntity;

import java.io.IOException;

public interface FileProviderService {

    byte[] getDataAsFile(RequestEntity requestEntity) throws IOException;

}
