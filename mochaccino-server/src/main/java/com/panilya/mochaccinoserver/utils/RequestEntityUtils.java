package com.panilya.mochaccinoserver.utils;

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

    public static DataFormat readFormatString(Object object) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField("format");
        field.setAccessible(true);
        String formatString = (String) field.get(object);

        switch (formatString.toLowerCase()) {
            case "csv":
                return DataFormat.CSV;
            case "json":
                return DataFormat.JSON;
            default:
                throw new NoSuchFieldException("Format is not specified");
        }
    }
}
