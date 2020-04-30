import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Account {

    private WebDriver driver;

    public Account(WebDriver driver){
        this.driver = driver;

    }
    public void logIn(String login, String password) throws InterruptedException {
        driver.get("https://stackoverflow.com/users/signup?ssrc=head&returnurl=%2fusers%2fstory%2fcurrent");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"openid-buttons\"]/button[1]")).click();
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(login);
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password, Keys.ENTER);
        Thread.sleep(1000);
        driver.get("https://gmail.com");



        /*driver.findElement(By.id("identifierId")).sendKeys(login, Keys.ENTER);
        WebDriverWait wait=new WebDriverWait(driver, 5);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        WebElement nextPassword = driver.findElement(By.id("passwordNext"));
        nextPassword.sendKeys(Keys.ENTER);*/
    }


    public void logOut() throws InterruptedException {
        WebElement accountBtn = driver.findElement(By.xpath("//a[@class='gb_D gb_Ra gb_i']"));
        accountBtn.sendKeys(Keys.ENTER);
        Thread.sleep(300);

        WebElement logOutButton = driver.findElement(By.id("gb_71"));
        logOutButton.sendKeys(Keys.ENTER);
        Thread.sleep(300);




    }


}
