package j4json.parser;

import j4json.parser.policy.ParserPolicy;


/**
 * JsonParser with configurable options.
 */
public interface FlexibleJsonParser extends JsonParser
{
    /**
     * Returns the parserPolicy.
     * @return The ParserPolciy objects associated with JsonParser.
     */
    ParserPolicy getParserPolicy();
}
