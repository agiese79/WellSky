import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests {
	private WebDriver driver;
    private String baseUrl;
    
    @BeforeMethod
    public void beforeMethod() {
       driver = new ChromeDriver();
       baseUrl = "https://www.google.com";
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get(baseUrl);
       WebDriverWait wait = new WebDriverWait(driver, 120);
       
    }

    @Test
    public void AhGoogle() {
        driver.get(baseUrl);
        
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("selenium");
        
        WebElement go = driver.findElement(By.name("btnK"));
        go.click();

        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
                FileUtils.copyFile(src, new File("C:/selenium/googleShot.png"));
            }       
        catch (IOException e)
            {
                System.out.println(e.getMessage());
    
            }

        List <WebElement> searchItem = driver.findElements(By.class("g"));
        
        searchItem.get(4).click();

        driver.manage.implicitlyWait(15, TimeUnit.SECONDS);

        System.out.println("The page url is: " + driver.getCurrentUrl());

        driver.navigate().back();

        searchItem.get(0).click();

        driver.manage.implicitlyWait(15, TimeUnit.SECONDS);

        System.out.println("The page url is: " + driver.getCurrentUrl());

    }

}