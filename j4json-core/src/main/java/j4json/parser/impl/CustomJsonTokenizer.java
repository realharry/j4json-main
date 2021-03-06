package j4json.parser.impl;

import java.io.Reader;
import java.util.logging.Logger;

import j4json.parser.FlexibleJsonTokenizer;
import j4json.parser.TraceableJsonTokenizer;
import j4json.parser.policy.ParserPolicy;


// Base class for customizable Json tokenizer.
public class CustomJsonTokenizer extends AbstractJsonTokenizer implements TraceableJsonTokenizer, FlexibleJsonTokenizer
{
    private static final Logger log = Logger.getLogger(CustomJsonTokenizer.class.getName());

    public CustomJsonTokenizer(String str)
    {
        super(str);
    }
    public CustomJsonTokenizer(Reader reader)
    {
        super(reader);
    }
    public CustomJsonTokenizer(Reader reader, ParserPolicy parserPolicy)
    {
        super(reader, parserPolicy);
    }

    @Override
    protected void init()
    {
        // Enable "tracing" by default.
        enableTracing();
    }

    @Override
    public ParserPolicy getParserPolicy()
    {
        return super.getParserPolicy();
    }

}
