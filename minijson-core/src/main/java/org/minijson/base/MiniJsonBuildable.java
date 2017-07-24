package org.minijson.base;

import java.io.IOException;
import java.io.Writer;

import org.minijson.JsonBuildable;
import org.minijson.builder.BareJsonBuilder;
import org.minijson.builder.JsonBuilderException;
import org.minijson.mini.MiniJsonBuilder;
import org.minijson.parser.JsonParser;


// Convenience class to be used as a base class for JsonSerializable classes.
public abstract class MiniJsonBuildable implements JsonBuildable
{
    // Lazy initialized.
    private BareJsonBuilder miniJsonBuilder = null;

    public MiniJsonBuildable()
    {
    }

    protected BareJsonBuilder getJsonBuilder()
    {
        if(miniJsonBuilder == null) {
            miniJsonBuilder = new MiniJsonBuilder();
        }
        return miniJsonBuilder;
    }

    @Override
    public String toJsonString() throws JsonBuilderException
    {
        // return MiniJsonBuilder.DEFAULT_INSTANCE.build(this);
        return getJsonBuilder().build(this);
    }

    @Override
    public String toJsonString(int indent) throws JsonBuilderException
    {
        // return MiniJsonBuilder.DEFAULT_INSTANCE.build(this, indent);
        return getJsonBuilder().build(this, indent);
    }

    @Override
    public void writeJsonString(Writer writer) throws IOException, JsonBuilderException
    {
        // MiniJsonBuilder.DEFAULT_INSTANCE.build(writer, this);
        getJsonBuilder().build(writer, this);
    }

    @Override
    public void writeJsonString(Writer writer, int indent) throws IOException, JsonBuilderException
    {
        // MiniJsonBuilder.DEFAULT_INSTANCE.build(writer, this, indent);
        getJsonBuilder().build(writer, this, indent);
    }

    @Override
    public Object toJsonStructure() throws JsonBuilderException
    {
        // return MiniJsonBuilder.DEFAULT_INSTANCE.buildJsonStructure(this);
        return getJsonBuilder().buildJsonStructure(this);
    }

    @Override
    public Object toJsonStructure(int depth) throws JsonBuilderException
    {
        // return MiniJsonBuilder.DEFAULT_INSTANCE.buildJsonStructure(this, depth);
        return getJsonBuilder().buildJsonStructure(this, depth);
    }

}
