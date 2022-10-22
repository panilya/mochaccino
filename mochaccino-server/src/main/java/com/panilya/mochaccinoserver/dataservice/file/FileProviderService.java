package com.panilya.mochaccinoserver.dataservice.file;

import com.panilya.mochaccinoserver.model.RequestEntity;
import com.panilya.mochaccinoserver.model.RequestParamsContainer;

import java.io.IOException;

public interface FileProviderService {

    byte[] getDataAsFile(RequestEntity requestEntity, RequestParamsContainer parameters) throws IOException;

}
