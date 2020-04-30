import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Email {

    public void createNewEmail(WebDriver driver, String sendTo, String subject, String message) throws InterruptedException {

        new WebDriverWait(driver, 5).until(presenceOfElementLocated(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")));
        WebElement newMail = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
        newMail.sendKeys(Keys.ENTER);

        new WebDriverWait(driver, 5).until(presenceOfElementLocated(By.xpath("//textarea[@class='vO']")));
        WebElement sendToEl = driver.findElement(By.xpath("//textarea[@class='vO']"));
        sendToEl.sendKeys(sendTo);

        new WebDriverWait(driver, 5).until(presenceOfElementLocated(By.xpath("//input[@name='subjectbox']")));
        WebElement subjectEl = driver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectEl.sendKeys(subject);

        WebElement messageEl = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']"));
        messageEl.sendKeys(message);

        new WebDriverWait(driver, 5).until(presenceOfElementLocated(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")));
        WebElement sendBtnEl = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']"));
        sendBtnEl.sendKeys(Keys.ENTER);

    }

    public void readFirstEmail(WebDriver driver) throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='zA zE']")));

        List<WebElement> mails = driver.findElements(By.xpath("//*[@class='zA zE']"));//driver.findElements(By.xpath("//*[@class='zA zE']"));
        System.out.println("Total No. of Unread Mails: " + mails.size());
        for(int i=0;i<mails.size();i++){

            System.out.println(mails.get(i).getText());

        }
        mails.get(0).click();
        Thread.sleep(5000);

    }
}
