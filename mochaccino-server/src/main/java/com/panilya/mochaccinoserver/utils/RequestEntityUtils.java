package com.panilya.mochaccinoserver.utils;

import com.panilya.mochaccinoserver.exception.IncorrectFormatException;
import com.panilya.mochaccinoserver.exception.NotImplementedException;
import com.panilya.mochaccinoserver.service.DataFormat;

import java.lang.reflect.Field;
import java.util.List;

public class RequestEntityUtils {

    public static List<String> getValues(Object object) throws IllegalAccessException, NoSuchFieldException {
        Field providers = object.getClass().getDeclaredField("providers");
        providers.setAccessible(true);
        List<String> providersVariable = (List<String>) providers.get(object);
        System.out.println(providersVariable);
        return providersVariable;
    }

    public static DataFormat readFormatParam(String format) throws NoSuchFieldException, NotImplementedException {

        if (!format.isEmpty() && !(format.equals("json") || format.equals("csv") || format.equals("sql"))) {
            throw new IncorrectFormatException("Incorrect format!");
        }

        switch (format.toLowerCase()) {
            case "csv":
                return DataFormat.CSV;
            case "json":
                return DataFormat.JSON;
            case "sql":
                throw new NotImplementedException("SQL format is not implemented yet");
            default:
                throw new NoSuchFieldException("Format is not specified");
        }
    }
}
