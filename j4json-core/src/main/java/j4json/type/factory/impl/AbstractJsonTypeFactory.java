package j4json.type.factory.impl;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import j4json.type.base.AbstractJsonArrayNode;
import j4json.type.base.AbstractJsonBooleanNode;
import j4json.type.base.AbstractJsonNullNode;
import j4json.type.base.AbstractJsonNumberNode;
import j4json.type.base.AbstractJsonObjectNode;
import j4json.type.base.AbstractJsonStringNode;
import j4json.type.factory.JsonTypeFactory;


public class AbstractJsonTypeFactory implements JsonTypeFactory
{
    private static final Logger log = Logger.getLogger(AbstractJsonTypeFactory.class.getName());
    
    private AbstractJsonTypeFactory()
    {
    }

    // Initialization-on-demand holder.
    private static final class AbstractJsonTypeFactoryHolder
    {
        private static final AbstractJsonTypeFactory INSTANCE = new AbstractJsonTypeFactory();
    }
    // Singleton method
    public static AbstractJsonTypeFactory getInstance()
    {
        return AbstractJsonTypeFactoryHolder.INSTANCE;
    }

    
    @Override
    public Object createNull()
    {
        return AbstractJsonNullNode.NULL;
    }
    @Override
    public Object createBoolean(Boolean value)
    {
        if(value == null) {
            return AbstractJsonBooleanNode.NULL;
        }
        if(Boolean.TRUE.equals(value)) {
            return AbstractJsonBooleanNode.TRUE;
        } else {
            return AbstractJsonBooleanNode.FALSE;
        }
    }
    @Override
    public Object createNumber(Number value)
    {
        if(value == null) {
            return AbstractJsonNumberNode.NULL;
        }
        return new AbstractJsonNumberNode(value);
    }
    @Override
    public Object createString(String value)
    {
        if(value == null) {
            return AbstractJsonStringNode.NULL;
        }
        return new AbstractJsonStringNode(value);
    }
    @Override
    public Map<String, Object> createObject(Map<String, Object> map)
    {
        if(map == null) {
            return AbstractJsonObjectNode.NULL;
        }
        return new AbstractJsonObjectNode(map);
    }
    @Override
    public List<Object> createArray(List<Object> list)
    {
        if(list == null) {
            return AbstractJsonArrayNode.NULL;
        }
        return new AbstractJsonArrayNode(list);
    }
    
    
}
