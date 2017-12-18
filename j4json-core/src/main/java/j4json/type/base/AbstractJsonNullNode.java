package j4json.type.base;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.logging.Logger;

import j4json.builder.JsonBuilderException;
import j4json.common.Literals;
import j4json.type.JsonNullNode;


public class AbstractJsonNullNode extends AbstractJsonLeafNode implements JsonNullNode, Serializable
{
    private static final Logger log = Logger.getLogger(AbstractJsonNullNode.class.getName());
    private static final long serialVersionUID = 1L;

    public static final AbstractJsonNullNode NULL = new AbstractJsonNullNode() {
        private static final long serialVersionUID = 1L;
    };
    
    
    public AbstractJsonNullNode()
    {
    }


    ///////////////////////////////////
    // JsonNode interface

    @Override
    public Object getValue()
    {
        return null;
    }


    ///////////////////////////////////
    // JsonSerializable interface

    @Override
    public String toJsonString(int indent) throws JsonBuilderException
    {
        // temporary
        return Literals.NULL;
    }


    // For debugging...
    @Override
    public String toString()
    {
        return "AbstractJsonNull []";
    }

    
    
}
