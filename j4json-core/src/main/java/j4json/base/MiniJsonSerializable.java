package j4json.base;

import java.io.IOException;
import java.io.Writer;

import j4json.IndentedJsonSerializable;
import j4json.builder.BareJsonBuilder;
import j4json.builder.JsonBuilderException;
import j4json.mini.MiniJsonBuilder;


// Convenience class to be used as a base class for JsonSerializable classes.
public abstract class MiniJsonSerializable implements IndentedJsonSerializable
{
    // Lazy initialized.
    private BareJsonBuilder miniJsonBuilder = null;

    public MiniJsonSerializable()
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

}
