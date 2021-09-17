package main.java.top.liyuejin.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyj
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : this.propertyValueList) {
            if (propertyName.equals(propertyValue.getName())) {
                return propertyValue;
            }
        }
        return null;
    }
}
