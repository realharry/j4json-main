package j4json.base;

import java.util.List;

import j4json.JsonArray;


public final class MiniJsonArray extends MiniJsonWrapper implements JsonArray
{

    // JSON builder
    public MiniJsonArray(List<Object> list)
    {
        super(list);
    }

    // JSON Parser
    public MiniJsonArray(String jsonStr)
    {
        super(jsonStr);
    }


//    // @Override
//    public boolean isJsonStructureArray()
//    {
//        return true;
//    }

}
