package j4json;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ j4json.common.AllTests.class, j4json.util.AllTests.class, j4json.parser.core.AllTests.class, j4json.parser.policy.base.AllTests.class, j4json.parser.impl.AllTests.class, j4json.builder.impl.AllTests.class, j4json.mini.AllTests.class, j4json.base.AllTests.class })
public class AllTests
{

}
