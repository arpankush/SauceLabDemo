package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Initializer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SauceLabHomePage {
    protected WebDriver driver;
    Initializer initializer;

    public SauceLabHomePage() throws IOException {
        initializer = new Initializer();
        this.driver = initializer.getDriver();
    }

    private By userNameTextBox = By.xpath("//*[@id='user-name']");
    private By passwordTextBox = By.xpath("//*[@id='password']");
    private By loginButton = By.xpath("//*[@id='login-button']");
    private By productsText = By.xpath("//span[@class='title' and text()='Products']");
    private By item1AddToCart = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    private By item2AddToCart = By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']");
    private By shoppingCart = By.xpath("//*[@id='shopping_cart_container']");
    private By item1InShoppingCart = By.xpath("//*[@id='cart_contents_container']/descendant::div[text()='Sauce Labs Backpack']");
    private By item2InShoppingCart = By.xpath("//*[@id='cart_contents_container']/descendant::div[text()='Sauce Labs Bike Light']");
    private By item1InShoppingCartRemove = By.xpath("//*[@id='remove-sauce-labs-backpack']");
    private By continueShopping = By.xpath("//*[@id='continue-shopping']");
    private By checkout = By.xpath("//*[@id='checkout']");
    private By checkoutContinue = By.xpath("//*[@id='continue']");
    private By checkoutFinish = By.xpath("//*[@id='finish']");
    private By firstNameTextBox = By.xpath("//*[@id='first-name']");
    private By lastNameTextBox = By.xpath("//*[@id='last-name']");
    private By postalCodeTextBox = By.xpath("//*[@id='postal-code']");
    private By sortSelect = By.xpath("//select[@data-test='product-sort-container']");
    private By firstItemInListName = By.xpath("//div[@data-test='inventory-list']/div[1]/div[2]/div[1]/a/div");

    public void i_open_the_website() {
        driver.get(initializer.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(initializer.implicitWaitTimeInSeconds, TimeUnit.SECONDS);
    }
    public void i_login_with_the_user_id_and_password(String string, String string2) {
        driver.findElement(userNameTextBox).sendKeys(string);
        driver.findElement(passwordTextBox).sendKeys(string2);
        driver.findElement(loginButton).click();
    }
    public void i_validate_the_login_is_successful() {
        Assert.assertTrue(driver.findElement(productsText).isDisplayed());
    }
    public void i_add_to_the_cart(String string) throws InterruptedException {
        switch(string){
            case "item1" :
                driver.findElement(item1AddToCart).click();
                Thread.sleep(2000);
                break;
            case "item2":
                driver.findElement(item2AddToCart).click();
                Thread.sleep(2000);
                break;
        }
    }
    public void i_go_to_the_cart() throws InterruptedException {
        driver.findElement(shoppingCart).click();
        Thread.sleep(2000);
    }
    public void i_checkout_with_items_in_the_cart() throws InterruptedException {
        driver.findElement(checkout).click();
        Thread.sleep(2000);
        driver.findElement(firstNameTextBox).sendKeys("FN");
        Thread.sleep(2000);
        driver.findElement(lastNameTextBox).sendKeys("LN");
        Thread.sleep(2000);
        driver.findElement(postalCodeTextBox).sendKeys("PC");
        Thread.sleep(2000);
        driver.findElement(checkoutContinue).click();
        Thread.sleep(2000);
        driver.findElement(checkoutFinish).click();
        Thread.sleep(2000);
    }
    public void i_verify_in_the_cart(String string) throws InterruptedException {
        switch (string){
            case "item1":
                Assert.assertTrue(driver.findElement(item1InShoppingCart).isDisplayed());
                Thread.sleep(2000);
                break;
            case "item2":
                Assert.assertTrue(driver.findElement(item2InShoppingCart).isDisplayed());
                Thread.sleep(2000);
                break;
        }
    }
    public void i_remove_a_item_in_the_cart() throws InterruptedException {
        driver.findElement(item1InShoppingCartRemove).click();
        Thread.sleep(2000);
    }
    public void i_go_back_continue_shopping() throws InterruptedException {
        driver.findElement(continueShopping).click();
        Thread.sleep(2000);
    }
    public void i_check_the_sort() throws InterruptedException {
        WebElement we = driver.findElement(sortSelect);
        Select select = new Select(we);
        Thread.sleep(2000);
        select.selectByValue("za");
        Thread.sleep(2000);
        String firstItemName = driver.findElement(firstItemInListName).getText();
        Assert.assertEquals(firstItemName, "Test.allTheThings() T-Shirt (Red)");
    }
    public void i_quit_my_browser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
