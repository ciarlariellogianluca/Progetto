package com.univpm.EsameOOP;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@SuppressWarnings("deprecation")
@RunWith(JUnitPlatform.class)
@SelectClasses({EventTest.class,FiltersBodyClassTest.class,FiltersTest.class})
public class AllTest {
	
}
