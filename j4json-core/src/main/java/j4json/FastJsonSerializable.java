package j4json;

import j4json.builder.JsonBuilderException;


/**
 * Place holder.
 */
public interface FastJsonSerializable extends JsonSerializable, JsonTemplateable
{
    // String buildJsonUsingTemplate(Object ... args);
    String buildJsonUsingTemplate(String ... args) throws JsonBuilderException;
}
