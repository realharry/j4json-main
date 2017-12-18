package j4json.builder.factory;

import j4json.builder.BareJsonBuilder;


// TBD: This is potentially a problem....
public interface BareJsonBuilderFactory extends JsonBuilderFactory
{
    // ???
    // Vs. JsonBuilderFactory.createBuilder() ???
    BareJsonBuilder createBuilder();
}
