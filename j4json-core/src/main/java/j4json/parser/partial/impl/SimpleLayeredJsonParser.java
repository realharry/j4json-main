package j4json.parser.partial.impl;

import java.util.logging.Logger;

import j4json.parser.partial.LayeredJsonParser;
import j4json.parser.policy.ParserPolicy;
import j4json.type.factory.JsonTypeFactory;


/**
 * Simple LayeredJsonParser wrapper.
 */
public final class SimpleLayeredJsonParser extends AbstractLayeredJsonParser implements LayeredJsonParser
{
    private static final Logger log = Logger.getLogger(SimpleLayeredJsonParser.class.getName());

    public SimpleLayeredJsonParser()
    {
    }
    public SimpleLayeredJsonParser(JsonTypeFactory jsonTypeFactory)
    {
        super(jsonTypeFactory);
    }
    public SimpleLayeredJsonParser(JsonTypeFactory jsonTypeFactory, ParserPolicy parserPolicy)
    {
        super(jsonTypeFactory, parserPolicy);
    }
    public SimpleLayeredJsonParser(JsonTypeFactory jsonTypeFactory, ParserPolicy parserPolicy, boolean threadSafe)
    {
        super(jsonTypeFactory, parserPolicy, threadSafe);
    }

    @Override
    protected void init()
    {
        // Disable "tracing" by default.
        disableTracing();
    }

}
