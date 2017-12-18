package j4json.ext.template;

import j4json.builder.JsonBuilderException;


// Dynamic template generator.
public interface JsonTemplateGenerator
{
    String generate(Object object) throws JsonBuilderException;
    String generate(Object object, int indent) throws JsonBuilderException;
}
