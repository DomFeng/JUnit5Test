package com.suite;
import com.testcase1.Junit5Demo1Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"com"})
@IncludePackages({"com.testcase1","com.testcase2"})
@SelectClasses(com.testcase.Junit5Demo1Test.class)
@IncludeTags({"fun3Demo","fun4Demo"})
public class Junit5SuiteTest {

}
