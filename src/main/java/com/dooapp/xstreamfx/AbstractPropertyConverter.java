package com.dooapp.xstreamfx;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableValue;

/**
 * Base class for all property converters.<br>
 * <br>
 * Created at 17/09/11 10:58.<br>
 *
 * @author Antoine Mischler <antoine@dooapp.com>
 */
public abstract class AbstractPropertyConverter<T> implements Converter {

    private final Class clazz;

    private final Converter converter;

    public AbstractPropertyConverter(Class clazz, Converter converter) {
        this.clazz = clazz;
        this.converter = converter;
    }

    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        if (source != null) {
            T value = ((ObservableValue<T>) source).getValue();
            if (value != null) {
                converter.marshal(value, writer, context);
            }
        }
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        WritableValue<T> property = createProperty();
        property.setValue((T) converter.unmarshal(reader, context));
        return property;
    }

    protected abstract WritableValue<T> createProperty();

    public boolean canConvert(Class type) {
        return clazz.isAssignableFrom(type);
    }

}