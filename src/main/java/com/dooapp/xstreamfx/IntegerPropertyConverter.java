package com.dooapp.xstreamfx;

import com.thoughtworks.xstream.converters.Converter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.WritableValue;

/**
 * Created at 17/09/11 11:16.<br>
 *
 * @author Antoine Mischler <antoine@dooapp.com>
 */
public class IntegerPropertyConverter extends AbstractPropertyConverter<Number> implements Converter {

    public IntegerPropertyConverter(Converter converter) {
        super(IntegerProperty.class, converter);
    }

    @Override
    protected WritableValue<Number> createProperty() {
        return new SimpleIntegerProperty();
    }
}