package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDefinitions {
	
	public static WebDriver driver;
	public static SoftAssert sa;
	public static Properties prop;
	public static Map<String,Map<String,String>> dt;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static LoginPage lp;
	public static HomePage hp;
	public static  LeadPage ldp ;
	public static String TCName;
	

	public void init()
	{
		
		dt = GetTestData();		
		prop = GetProperties();		
		launchApp();
		
	}
	
	public void launchApp()
	{
		if(prop.getProperty("Browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("Browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(prop.getProperty("Browser").equals("headless"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=chrome");
			driver = new ChromeDriver(options);			
		}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
			
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		sa = new SoftAssert();
	}
	
	public Properties GetProperties()
	{
		Properties prop=null;
		try
		{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/Setting.properties");
		prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public Map<String,Map<String,String>> GetTestData()
	{
		try
		{
		String excelPath=System.getProperty("user.dir")+"/src/test/resources/TestData/Data.xlsx";
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(excelPath);
		String strQuery="Select * from Sheet1";
		Recordset recordset=connection.executeQuery(strQuery);
		Map<String,Map<String,String>> dt = new HashMap<String,Map<String,String>>();
		List<String> colms = recordset.getFieldNames();
		int counter = 0;
		while(recordset.next()){
		Map<String,String> rowdata = new HashMap<String,String>();	
		System.out.println(colms.get(counter));
		for(String colm:colms)
		{
			String colvalue = recordset.getField(colm);
			rowdata.put(colm, colvalue);
		}
		dt.put(recordset.getField("TCName"), rowdata);
		counter++;
		}
		
		recordset.close();
		connection.close();
		return dt;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	public void createReport() 
	{
		
		DateFormat f = new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str = f.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+str+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("VTiger Test Automation Report"); 
		            // Name of the report
		htmlReporter.config().setReportName("Regression Test Result"); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 
	}
	

	public void closeApp()
	{
		sa.assertAll();
		driver.quit();
	}


}
