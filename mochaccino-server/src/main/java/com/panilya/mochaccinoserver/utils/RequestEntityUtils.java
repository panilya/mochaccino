package com.panilya.mochaccinoserver.utils;

import com.panilya.mochaccinoserver.service.DataFormat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RequestEntityUtils {

    /**
     * Util method that allows to extract variables with 'true' state in order to process request.
     * @throws IllegalAccessException
     */
    public static List<String> getValues(Object object) throws IllegalAccessException {
        List<String> variablesToProcess = new ArrayList<>(object.getClass().getDeclaredFields().length); // initialCapacity of the List is the total number of fields in passed Object

        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            if (!(f.get(object) instanceof Boolean)) {
                continue;
            }
            Boolean variable = (Boolean) f.get(object);
            if (variable) {
                variablesToProcess.add(f.getName());
            }
        }
        return variablesToProcess;
    }

    public static DataFormat readFormatString(Object object) throws NoSuchFieldException, IllegalAccessException {

//        String format = (String) object.getClass().getField("format").get(object);

        Field field = object.getClass().getDeclaredField("format");
        field.setAccessible(true);
        String format = (String) field.get(object);

        switch (format.toLowerCase()) {
            case "csv":
                return DataFormat.CSV;
            case "json":
                return DataFormat.JSON;
            default:
                throw new NoSuchFieldException("Format is not specified");
        }
    }
}
