package com.dooapp.xstreamfx;

import com.thoughtworks.xstream.converters.Converter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.WritableValue;

/**
 * Created at 17/09/11 10:52.<br>
 *
 * @author antoine
 */
public class StringPropertyConverter extends AbstractPropertyConverter<String> implements Converter {

    public StringPropertyConverter(Converter converter) {
        super(StringProperty.class, converter);
    }

    @Override
    protected WritableValue<String> createProperty() {
        return new SimpleStringProperty();
    }
}