package j4json.type.base;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Map;
import java.util.logging.Logger;

import j4json.builder.JsonBuilderException;
import j4json.type.JsonNode;


public abstract class AbstractJsonNode implements JsonNode, Serializable
{
    private static final Logger log = Logger.getLogger(AbstractJsonNode.class.getName());
    private static final long serialVersionUID = 1L;
    
    public AbstractJsonNode()
    {
        // TODO Auto-generated constructor stub
    }

    
//    @Override
//    public Object getValue()
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public String toJsonString()
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void toJsonString(Writer writer) throws IOException
//    {
//        // TODO Auto-generated method stub
//        
//    }
//
//    @Override
//    public Map<String, Object> toJsonStructure() throws JsonBuilderException
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public Map<String, Object> toJsonStructure(int depth) throws JsonBuilderException
//    {
//        // TODO Auto-generated method stub
//        return null;
//    }



}
