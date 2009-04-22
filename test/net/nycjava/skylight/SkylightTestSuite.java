package net.nycjava.skylight;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.nycjava.skylight.dependencyinjection.DependencyInjectingObjectFactoryTest;

public class SkylightTestSuite extends TestSuite {
	public static Test suite() {

		TestSuite suite = new TestSuite();

		suite.addTestSuite(DependencyInjectingObjectFactoryTest.class);

		return suite;
	}

}
