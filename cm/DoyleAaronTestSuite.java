package cm;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({DoyleAaronRateTests.class, DoyleAaronPeriodTests.class})
public class DoyleAaronTestSuite {
}
