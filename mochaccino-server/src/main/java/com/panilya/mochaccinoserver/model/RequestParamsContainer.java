package com.panilya.mochaccinoserver.model;

public class RequestParamsContainer {

    public final String tableName;
    public final String dialect;
    public final Boolean header;
    public final String separator;

    public RequestParamsContainer(String tableName, String dialect, Boolean header, String separator) {
        this.tableName = tableName;
        this.dialect = dialect;
        this.header = header;
        this.separator = separator;
    }

}
