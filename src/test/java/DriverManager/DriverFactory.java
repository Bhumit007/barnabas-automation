package DriverManager;

import Pages.BarnabasStagingPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

public class DriverFactory {

    public static String chromePath;
    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    public static WebDriver driver;
    public static String filePath;
    public static Properties prop;
    public static BarnabasStagingPage barnabasStagingPage;

    public static class Log {
        private static Logger Log = Logger.getLogger(Log.class.getName());
        public static void info(String message) {
            Log.info(message);
        }
        public static void error(String message) {
            Log.error(message);
        }
    }


    public void property() {
        if (this.getClass().getCanonicalName().contains("BarnabasStagingTest")) {
            filePath = System.getProperty("user.dir") + "/src/main/resources/barnabas.properties";
        }
        try {
            prop = new Properties();
            FileInputStream fip = new FileInputStream(filePath);
            try {
                prop.load(fip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Browser Configuration
     */
    @BeforeSuite

    public void setUp() {
        property();
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setJavascriptEnabled(true);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            chromePath = System.getProperty("user.dir") + prop.getProperty("chromeDriverPath");
            System.setProperty("webdriver.chrome.driver", chromePath);
            options.addArguments("--start-maximized");
            //options.addArguments("--window-size=1366,768");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--dns-prefetch-disable");
            options.addArguments("--always-authorize-plugins");
            options.addArguments("enable-automation");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-extensions");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(options);
            driver.get(prop.getProperty("baseURL"));
        }else{
            System.out.println("User has only support of chromedriver");
        }
        barnabasStagingPage = PageFactory.initElements(driver, BarnabasStagingPage.class);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException, IOException {
        killChromeDriver();
    }

    /**
     * kill ChromeDriver
     */

    public void killChromeDriver() {
        String cmd;
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            cmd = "taskkill /f /t /IM chromedriver.exe";
        }else{
            cmd = "taskkill /f /t /IM geckodriver.exe";
        }
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
