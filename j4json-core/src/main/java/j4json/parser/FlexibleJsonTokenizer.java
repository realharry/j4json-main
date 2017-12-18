package j4json.parser;

import j4json.parser.policy.ParserPolicy;


/**
 * "Flexible" (configurable) Json tokenizer.
 */
public interface FlexibleJsonTokenizer extends JsonTokenizer
{
    /**
     * Returns the parserPolicy.
     * @return The ParserPolciy objects associated with JsonParser.
     */
    ParserPolicy getParserPolicy();
}
