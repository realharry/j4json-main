package j4json.type;

import java.util.List;

import j4json.JsonCompatible;


public interface JsonArrayNode extends JsonStructNode, List<Object>
{
    boolean hasChildren();
    List<JsonNode> getChildren();

    JsonNode getChildNode(int index);

    void addChild(JsonNode child);
    void addAllChildren(List<JsonNode> children);

}
