package j4json.type;

import j4json.JsonCompatible;
import j4json.IndentedJsonSerializable;


/**
 * Base class for a node in a JSON parsed tree.
 * Note that JsonNodes are used only for "Rich" parsers/builders.
 * ("Bare" parsers/builders use only Java Maps and Lists.)
 */
public interface JsonNode extends IndentedJsonSerializable
{
    /**
     * Returns the "value" of this node, that is, a Map, a List, a String, etc...
     * @return The value of this node.
     */
    Object getValue();
    
//    boolean isObject();
//    boolean isArray();
//    boolean isString();
//    boolean isNumber();
//    boolean isBoolean();
//    boolean isNull();

//    boolean hasChildren();
//    List<JsonNode> getChildren();
//    
//    void addChild(JsonNode child);
//    void addChildren(List<JsonNode> children);
}
