package amazon;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    WebDriver driver;

    @Given("^User lauches the URL$")
    public void userLauchesTheURL() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.co.uk/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=gbflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.co.uk%2F%3Fref_%3Dnav_custrec_signin&switch_account=");

    }

    @When("^User enters username as \"([^\"]*)\"$")
    public void userEntersUsernameAs(String arg0) {
        driver.findElement(By.id("ap_email")).sendKeys(arg0);
        WebElement ContinueButton = driver.findElement((By.id("continue")));
        ContinueButton.click();
    }

    @When("^User enters Password as \"([^\"]*)\"$")
    public void userEntersPasswordAs(String arg0) throws Throwable {
        driver.findElement(By.id("ap_password")).sendKeys(arg0);
        WebElement SignInButton = driver.findElement((By.id("signInSubmit")));
        SignInButton.click();
    }

    @Then("^User is navigated to Amazon portal home page$")
    public void userIsNavigatedToAmazonPortalHomePage() {
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Assert.assertTrue(bodyText.contains("Hello, Teena"));

    }



    @Given("^User is navigated to Amazon portal$")
    public void userIsNavigatedToAmazonPortal() {

    }

    @When("^User clicks on Search Bar and Enter \"([^\"]*)\"$")
    public void userClicksOnSearchBarAndEnter(String arg0)  {
        WebElement searchBox = driver.findElement((By.id("twotabsearchtextbox")));
        searchBox.sendKeys(arg0);
    }

    @And("^Click on Search Button$")
    public void clickOnSearchButton() {
        WebElement searchSubmitText = driver.findElement((By.id("nav-search-submit-text")));
        searchSubmitText.click();
    }

    @Then("^Search Page with \"([^\"]*)\" will open$")
    public void searchPageWithWillOpen(String arg0)  {
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Assert.assertTrue(bodyText.contains("surgical masks"));

    }

    @When("^User Clicks on first item$")
    public void userClicksOnFirstItem() {
        WebElement firstItem = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        firstItem.click();
    }

    @Then("^Item Detail Page will Open$")
    public void itemDetailPageWillOpen() {
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Assert.assertTrue(bodyText.contains("MXG Atos 50 Pcs Pack Surgical Face Masks 3 Ply - 3 Layers - Sealed Bag"));
    }

    @When("^User Clicks on Add to Basket Button$")
    public void userClicksOnAddToBasketButton() {
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
    }

    @Then("^User can see an item Added in a Basket$")
    public void userCanSeeAnItemAddedInABasket() {
        WebElement basketButton = driver.findElement(By.id("nav-cart"));
        basketButton.click();
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        Assert.assertTrue(bodyText.contains("MXG Atos 50 Pcs Pack Surgical Face Masks 3 Ply - 3 Layers - Sealed Bag"));

    }

    @After
    public void stop(){
        driver.quit();
    }


}
