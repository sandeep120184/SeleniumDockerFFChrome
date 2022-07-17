package TestRunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Runner {
	
	static TestNG testng;
		public static void main(String[] args) {
	
		
				testng = new TestNG();
				String strPath = System.getProperty("user.dir")+"/testng.xml";
				
				List<String> xmlsuite = new ArrayList<String>();
				xmlsuite.add(strPath);
				testng.setTestSuites(xmlsuite);
				testng.run();
			}


	}


