package com.dooapp.xstreamfx;

import com.thoughtworks.xstream.converters.Converter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.WritableValue;

/**
 * Created at 17/09/11 11:10.<br>
 *
 * @author Antoine Mischler <antoine@dooapp.com>
 * @since 2.0
 */
public class ObjectPropertyConverter extends AbstractPropertyConverter<String> implements Converter {

    public ObjectPropertyConverter(Converter converter) {
        super(ObjectProperty.class, converter);
    }

    @Override
    protected WritableValue<String> createProperty() {
        return new SimpleObjectProperty<String>();
    }
}