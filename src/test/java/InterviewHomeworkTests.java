import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * The Class AutomationChallengeTest.
 */
public class InterviewHomeworkTests {

    // ******************** INITIALISATION *********************** //

    /**
     * The Utils.
     */
// initializing the utility methods
    Utilities utils = new Utilities();

    /**
     * The Selenium WebDriver, used to give a handle to current browser.
     */
    WebDriver driver = utils.setDriver();

    /**
     * The Wikia home page.
     */
// initializing the pages used in this set of tests
    WikiaHomePage wikiaHomePage = new WikiaHomePage(driver);
    /**
     * The Wikia video add page.
     */
    WikiaVideoAddPage wikiaVideoAddPage = new WikiaVideoAddPage(driver);
    /**
     * The Videos on this wiki page.
     */
    VideosOnThisWikiPage videosOnThisWikiPage = new
         VideosOnThisWikiPage (driver);
    /**
     * The Best classical music page.
     */
    BestClassicalMusicPage bestClassicalMusicPage = new
        BestClassicalMusicPage(driver);

    /**
     * Setup routine, run before the Test. <BR>
     * It launches the browser with the starting URL.
     */
    @BeforeTest()
    public void setup() {
        driver.get(Const.TEMPLATE__URL);
    }

    /**
     * Teardown routine. It quits the browser.
     */
    @AfterTest()
    public void teardown () {driver.quit();}

    // ******************** TESTCASE SCENARIOS *********************** //

    /**
     * Verify login has occurred and the Avatar has changed from anonymous to
     * your avatar.
     *
     * @param rememberMe   the 'Remember me' checkbox is checked, if set to true ... else, it
     *  remains unchecked
     * @throws IOException   Exception thrown if config.properties (defining login credentials, etc.)
     *  is not in classpath
     */
    @Test(
            dataProvider = "HomeWork_LoginData",
            dataProviderClass = WikiaDataProviderPage.class
    )
    public void testWikiaLogin(
            boolean rememberMe
    ) throws IOException {

        String user = commonLogin(rememberMe);

        wikiaHomePage.waitForUserAvatar(driver);

        String avatarTitle = wikiaHomePage.usernameText.getAttribute("title");
        Assert.assertEquals(
                avatarTitle,
                user + " - My page",
                "User isn't logged in - 'Log in' label displays instead of username.");
    }

    /**
     * Verify login has occurred and the Avatar has changed from anonymous to
     * your avatar.
     *
     * @param rememberMe   the 'Remember me' checkbox is checked, if set to true ... else, it
     *  remains unchecked
     * @param videoURL   the text to type in the input field to specify the video to download and
     *  put on the wiki page
     * @param videoTitle   the title associated with the downloaded video
     * @throws IOException   Exception thrown if config.properties (defining login credentials, etc.)
     *  is not in classpath
     */
    @Test(
            dataProvider = "HomeWork_VideoAddedData",
            dataProviderClass = WikiaDataProviderPage.class
    )
    public void testWikiaVideoAdd(
            boolean rememberMe,
            String videoURL,
            String videoTitle
    ) throws IOException {

        commonLogin(rememberMe);

        wikiaHomePage.waitForUserAvatar(driver);
        wikiaHomePage.contributeButton.click();
        wikiaHomePage.addVideoMenuItem.click();

        wikiaVideoAddPage.waitForAddVideoInputElement(driver);
        wikiaVideoAddPage.nameOfVideoToAdd.sendKeys(videoURL);
        wikiaVideoAddPage.addButton.click();

        videosOnThisWikiPage.linkToAddedVideo.click();

        Assert.assertEquals(
                bestClassicalMusicPage.bestMusicHeader.getText(),
                videoTitle,
                "The Header text on the page doesn't match the Video's Title."
        );


    }


    // ************** Reusable code  ************** //


    private String commonLogin (boolean rememberMe) throws IOException {
        String propFileName = Const.PROPERTY_FILE;
        Properties prop = utils.getPropertiesFromClasspath(propFileName);

        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        int tries = 0;


        while (tries < 2) {
            try {
                wikiaHomePage.invokeLoginPage(driver);

                wikiaHomePage.login(
                        username,
                        password,
                        rememberMe
                );
                //hooray! no exception thrown. We go to 'finally'.
            } catch (Exception e) {
                // menu did not pop up OR
                // username or password field not found OR
                // rememberMe button wasn't seen

                //thus, we try again
                tries ++;
            } finally {
                //makes sure the menu (pop-up) goes away by hovering elsewhere
                utils.doHover(driver,wikiaHomePage.headerTitle);
            }
        }
        return username;
    }
}
