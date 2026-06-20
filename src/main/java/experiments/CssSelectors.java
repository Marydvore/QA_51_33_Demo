package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        pause(3000);

        WebElement footer = driver.findElement(By.tagName("footer"));
        System.out.println(footer.getTagName());

        hideFooter();
        WebElement element = driver.findElement(By.cssSelector(".card-body"));
        element.click();

        driver.navigate().back();

        //WebElement element1 = driver.findElement(By.cssSelector("div[class='card-body']"));
        WebElement element1 = driver.findElement(By.xpath("//div[@class='card-body']"));
        //div[class='card-body']
        //*[class='card-body']
        element1.click();
        pause(3000);

        driver.navigate().back();

        WebElement element2 = driver.findElement(By.className("card-body"));
        element2.click();

        WebElement textBox = driver.findElement(By.cssSelector("#item-0"));
        textBox.click();

        driver.navigate().back();

        WebElement textBox1 = driver.findElement(By.id("item-0"));
        textBox1.click();
        // li[id='item-0']
        // *[id='item-0']

        driver.navigate().back();
        driver.navigate().back();
        pause(3000);

        //WebElement bookStore = driver.findElement(By.cssSelector("div[class='category-cards'] a:last-child div[class='card mt-4 top-card']"));
        //bookStore.click();

        WebElement alertFrame = driver.findElement(By.cssSelector("div[class='category-cards'] a:nth-child(3) div[class='card mt-4 top-card']"));
        alertFrame.click();


    }


    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }

    public void scrollActions(){ // метод скролл прокрутка, мне не понадобился
        Actions actions = new Actions(driver);

        for (int i = 0; i < 10; i++) {
            actions.scrollByAmount(0, 700).perform();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
