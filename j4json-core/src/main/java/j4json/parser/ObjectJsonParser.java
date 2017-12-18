package j4json.parser;

import java.io.IOException;
import java.io.Reader;

import j4json.mapper.ObjectConverter;


// TBD:
public interface ObjectJsonParser extends JsonParser
{
    Object parse(String jsonStr, ObjectConverter converter) throws JsonParserException;
    Object parse(Reader reader, ObjectConverter converter) throws JsonParserException, IOException;
}
