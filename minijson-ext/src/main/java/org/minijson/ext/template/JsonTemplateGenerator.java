package org.minijson.ext.template;

import org.minijson.builder.JsonBuilderException;


// Dynamic template generator.
public interface JsonTemplateGenerator
{
    String generate(Object object) throws JsonBuilderException;
    String generate(Object object, int indent) throws JsonBuilderException;
}
