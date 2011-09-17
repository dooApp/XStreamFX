package com.dooapp.xstreamfx;

import com.thoughtworks.xstream.converters.Converter;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.WritableValue;

/**
 * Created at 17/09/11 11:12.<br>
 *
 * @author Antoine Mischler <antoine@dooapp.com>
 * @since 2.0
 */
public class DoublePropertyConverter extends AbstractPropertyConverter<Number> implements Converter {

    public DoublePropertyConverter(Converter converter) {
        super(DoubleProperty.class, converter);
    }

    @Override
    protected WritableValue<Number> createProperty() {
        return new SimpleDoubleProperty();
    }
}