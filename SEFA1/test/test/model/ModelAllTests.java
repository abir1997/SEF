package test.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ProductTest.class, SalesLineItemTest.class, SalesTest.class, CustomerTest.class})

public class ModelAllTests {

}
