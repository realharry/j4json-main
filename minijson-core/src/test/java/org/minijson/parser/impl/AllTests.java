package org.minijson.parser.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AbstractBareJsonParserTest.class,
        AbstractJsonTokenizerTest.class, AbstractRichJsonParserTest.class })
public class AllTests
{

}
