package j4json.parser.impl;

import java.util.logging.Logger;

import j4json.parser.FlexibleJsonParser;
import j4json.parser.RichJsonParser;
import j4json.parser.policy.ParserPolicy;
import j4json.type.factory.JsonTypeFactory;


public class CustomJsonParser extends AbstractRichJsonParser implements RichJsonParser, FlexibleJsonParser
{
    private static final Logger log = Logger.getLogger(CustomJsonParser.class.getName());

    public CustomJsonParser()
    {
    }
    public CustomJsonParser(JsonTypeFactory jsonTypeFactory)
    {
        super(jsonTypeFactory);
    }

    public CustomJsonParser(JsonTypeFactory jsonTypeFactory, ParserPolicy parserPolicy)
    {
        super(jsonTypeFactory, parserPolicy);
    }

    @Override
    protected void init()
    {
        // Enable "tracing" by default.
        enableTracing();
    }


}
