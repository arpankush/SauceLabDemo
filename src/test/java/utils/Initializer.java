package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Initializer {

    private WebDriver driver;
    public String url;
    public long implicitWaitTimeInSeconds;
    public String browser;

    public Initializer() throws IOException {
        Properties prop = propertiesReader();
        url = prop.getProperty("url").toLowerCase();
        implicitWaitTimeInSeconds = Long.parseLong(prop.getProperty("implicitWaitTimeInSeconds"));
        browser = prop.getProperty("browser");
    }

    public WebDriver getDriver() {
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    break;
            }
        }
        return driver;
    }

    public static Properties propertiesReader() throws IOException {
        FileInputStream file = null;
        Properties prop = null;
        try {
            file = new FileInputStream("src/test/java/config/config.properties");
            prop = new Properties();
            prop.load(file);
        } catch (FileNotFoundException fnf) {
            System.out.println("---File Not Found---");
            fnf.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("---IOException---");
            ioe.printStackTrace();
        } finally {
            assert file != null;
            file.close();
        }
        return prop;
    }



}
