import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();



        Account firstAccount = new Account(driver);
        firstAccount.logIn("petrsurta742@gmail.com", "PasswordPetr");
        Thread.sleep(1000);
        Email firstEmail = new Email();
        firstEmail.createNewEmail(driver, "larisasurta742@gmail.com", "firstMail", "text1");
        Thread.sleep(1000);
        Email secondEmail = new Email();
        secondEmail.createNewEmail(driver, "larisasurta742@gmail.com", "secondMail", "text2");

        firstAccount.logOut();
        driver.quit();

        driver = new ChromeDriver();
        Account secondAccount = new Account(driver);
        secondAccount.logIn("larisasurta742@gmail.com", "PasswordLarisa");

        Email recievedEmail = new Email();
        recievedEmail.readFirstEmail(driver);

        Thread.sleep(10000);
        driver.quit();


    }
}
