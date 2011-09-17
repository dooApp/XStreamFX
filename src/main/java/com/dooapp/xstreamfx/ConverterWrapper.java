package com.dooapp.xstreamfx;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * Created at 17/09/11 12:37.<br>
 *
 * @author Antoine Mischler <antoine@dooapp.com>
 */
public class ConverterWrapper implements Converter {

    private final Converter converter;

    private final Class clazz;

    public ConverterWrapper(Converter converter, Class clazz) {
        this.converter = converter;
        this.clazz = clazz;
    }

    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        converter.marshal(source, writer, context);
    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        return converter.unmarshal(reader, context);
    }

    public boolean canConvert(Class type) {
        return clazz.isAssignableFrom(type);
    }
}