package com.dooapp.xstreamfx;

import com.thoughtworks.xstream.converters.Converter;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.value.WritableValue;

/**
 * Created at 17/09/11 11:17.<br>
 *
 * @author Antoine Mischler <antoine@dooapp.com>
 * @since 2.0
 */
public class LongPropertyConverter extends AbstractPropertyConverter<Number> implements Converter {

    public LongPropertyConverter(Converter converter) {
        super(LongProperty.class, converter);
    }

    @Override
    protected WritableValue<Number> createProperty() {
        return new SimpleLongProperty();
    }
}