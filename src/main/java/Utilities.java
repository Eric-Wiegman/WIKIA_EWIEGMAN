import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

/**
 * This is a set of generic utilities that may come in handy when doing any
 * automation. If this file gets too large, it is recommended to split it
 * into smaller files by functionality (such as file handling, Date/Time, etc).
 */
public class Utilities {

    /**
     * Sets the Web Driver for the test.
     *
     * @return the driver
     */
    public WebDriver setDriver() {
        //seems to be a likely default
        WebDriver mydriver;

        String propFileName = "config.properties";
        Properties prop = null;

        try {
            prop = getPropertiesFromClasspath(propFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String sDriver = prop.getProperty("mydriver");
        String chromedriverExeLocation = prop.getProperty
                ("chromedriverExeLocation");

        if (sDriver.toLowerCase().equals("firefox")) {
            mydriver = new FirefoxDriver();
        } else {
            if (sDriver.toLowerCase().equals("chrome")) {
                System.setProperty(
                        "webdriver.chrome.driver",
                        System.getProperty("user.dir") + chromedriverExeLocation);
                mydriver = new ChromeDriver();
            } else {
                // fall back on this as a default
                mydriver = new FirefoxDriver();
            }
        }

        return mydriver;
    }

    /**
     * Gets properties from classpath.
     *
     * @param propFileName the property file name
     * @return the properties from classpath
     * @throws IOException the IO exception
     */
    public Properties getPropertiesFromClasspath(
            String propFileName
    ) throws IOException {
        Properties props = new Properties();
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream(propFileName);

        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + propFileName
                    + "' not found in the classpath");
        }

        props.load(inputStream);

        return props;
    }

    /**
     * Returns the old fashioned timezone (such as 'PDT' or 'PST' for input)
     *
     * @param webinarTimezone the webinar's timezone (such as
     *                        '(GMT-07:00) Pacific Time (US and Canada);Tijuana)')
     * @return the timezone formatted portion of the date (such as 'GMT' or 'PDT')
     */
    public String getWebinarShortTimezone(String webinarTimezone) {

        String serverTimeShortTZ = "XXX";
        // if above is returned, this method has a major problem

        int webinarTimezoneFirstSpaceIndex = webinarTimezone.indexOf(Const.SPACE);
        String parseTheCode = webinarTimezone.substring(0, webinarTimezoneFirstSpaceIndex);

        final TimeZone tz = TimeZone.getTimeZone(parseTheCode);
        final Calendar cal = Calendar.getInstance(tz);
        cal.setTime(new Date());
        Date serverTime = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("z");
        serverTimeShortTZ = format.format(serverTime);

        //RETURNS the short old-fashioned code such as "PDT"
        return serverTimeShortTZ;
    }

    /**
     * Special version of sendKeys, which doesn't natively select existing
     * value in the input text field and clear it out before typing in the
     * new value.<br><br>Since the native sendKeys, on some browsers, can lead
     * to appending the new value to the end (or perhaps the middle) of the
     * existing value, this method was written.<br><br>
     * TODO: A subclass of the WebElement interface should be done and this
     * method added to it in an object oriented fashion.
     *
     * @param webElement the WebElement
     * @param value the value to 'type' into the input (text) field
     */
    public void setText(WebElement webElement, String value) {
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        webElement.sendKeys(selectAll);
        webElement.sendKeys(Keys.BACK_SPACE);
        webElement.sendKeys(value);
    }

    /**
     * Do Hover.
     *
     * @param driver the driver
     * @param webElement the web element
     */
    public void doHover (WebDriver driver, WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
    }
}
