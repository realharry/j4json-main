package org.minijson;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ org.minijson.common.AllTests.class, org.minijson.util.AllTests.class, org.minijson.parser.core.AllTests.class, org.minijson.parser.policy.base.AllTests.class, org.minijson.parser.impl.AllTests.class, org.minijson.builder.impl.AllTests.class, org.minijson.mini.AllTests.class, org.minijson.base.AllTests.class })
public class AllTests
{

}
