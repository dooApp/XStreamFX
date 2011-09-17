package com.dooapp.xstreamfx;

import com.thoughtworks.xstream.converters.Converter;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.WritableValue;

/**
 * Created at 17/09/11 11:09.<br>
 *
 * @author Antoine Mischler <antoine@dooapp.com>
 * @since 2.0
 */
public class BooleanPropertyConverter extends AbstractPropertyConverter<Boolean> implements Converter {

    public BooleanPropertyConverter(Converter converter) {
        super(BooleanProperty.class, converter);
    }

    @Override
    protected WritableValue<Boolean> createProperty() {
        return new SimpleBooleanProperty();
    }
}