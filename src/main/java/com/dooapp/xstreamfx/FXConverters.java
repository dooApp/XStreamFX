package com.dooapp.xstreamfx;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.List;
import java.util.Map;

/**
 * Utility to configure a xStream with JavaFX property converters.<br>
 * <br>
 * Created at 17/09/11 11:18.<br>
 *
 * @author Antoine Mischler <antoine@dooapp.com>
 * @since 2.0
 */
public class FXConverters {

    public static void configure(XStream xStream) {
        xStream.registerConverter(new StringPropertyConverter(lookupTypeConverter(xStream, String.class)));
        xStream.registerConverter(new BooleanPropertyConverter(lookupTypeConverter(xStream, Boolean.class)));
        xStream.registerConverter(new ObjectPropertyConverter(lookupTypeConverter(xStream, Object.class)));
        xStream.registerConverter(new DoublePropertyConverter(lookupTypeConverter(xStream, Double.class)));
        xStream.registerConverter(new LongPropertyConverter(lookupTypeConverter(xStream, Long.class)));
        xStream.registerConverter(new IntegerPropertyConverter(lookupTypeConverter(xStream, Integer.class)));
        xStream.registerConverter(new ConverterWrapper(lookupTypeConverter(xStream, List.class), ObservableList.class));
        xStream.registerConverter(new ConverterWrapper(lookupTypeConverter(xStream, Map.class), ObservableMap.class));
    }

    private static Converter lookupTypeConverter(XStream xStream, Class clazz) {
        return xStream.getConverterLookup().lookupConverterForType(clazz);
    }

}