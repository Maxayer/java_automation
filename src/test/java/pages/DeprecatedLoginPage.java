package pages;

import common.PageElement;
import common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DeprecatedLoginPage extends BasePage {
    private static final PageElement usernameField = new PageElement(
            "Username field",
            By.id("UserUsername"),
            true);
    private static final PageElement passwordField = new PageElement(
            "Password field",
            By.id("UserPassword"),
            true);
    private static final PageElement signInButton = new PageElement(
            "Sign In button",
            By.xpath("//*[@type='submit']"),
            true);
    private static final PageElement invalidMassage = new PageElement(
            "Invalid Massage",
            By.id("flashMessage"),
            false);
    private static final PageElement userLoginForm = new PageElement(
            "User Login Form",
            By.id("UserLoginForm"),
            true);

    public DeprecatedLoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean pageIsDisplayed(){
        return allRequiredElementDisplayed();
    }

    public void fillUsernameField(String strUserName){
        enterText(usernameField, strUserName);
    }

    public void fillPasswordField(String strPassword){
        enterText(passwordField, strPassword);
    }

    public void clickSignIn(){
        click(signInButton);
    }

    public void makeLogin(String strUserName, String strPasword){
        this.fillUsernameField(strUserName);
        this.fillPasswordField(strPasword);
        this.clickSignIn();
    }

    public boolean invalidMassageIsDisplayed(){
        return isElementPresent(invalidMassage);
    }

    public void takeScreenshotByElement(String imgName){
        String imgPath = System.getProperty("user.dir") + "/src/test/resources/screenshotsComparison/";
        Utils.sleep(3000);
        WebElement userLoginForm = driver.findElement(By.id("UserLoginForm"));
        Screenshot myScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver, userLoginForm);
        try {
            ImageIO.write(myScreenshot.getImage(), "PNG", new File(imgPath + imgName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean screenshotCompare(String image1, String image2, String image3){
        String imgPath = System.getProperty("user.dir") + "/src/test/resources/screenshotsComparison/";
        BufferedImage expectedImage = null;
        try {
            expectedImage = ImageIO.read(new File(imgPath + image1 + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage actualImage = null;
        try {
            actualImage = ImageIO.read(new File(imgPath + image2 + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualImage);
        BufferedImage diffImage = diff.getMarkedImage();
        try {
            ImageIO.write(diffImage, "PNG", new File(imgPath + image3 + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return diff.hasDiff();
    }

    public boolean isFieldRequired(){
        waitToBeVisible(userLoginForm);
        Utils.sleep(3000);
        takeScreenshotByElement("Login User Form before");
        click(signInButton);
        takeScreenshotByElement("Login User Form after");
        return screenshotCompare("Login User Form before", "Login User Form after", "Login User Form Diff");
    }
}
