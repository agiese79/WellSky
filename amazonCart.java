import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
from selenium.webdriver.common.action_chains import ActionChains;

public class HomePageTests {
	private WebDriver driver;
    private String baseUrl;
    
    @BeforeMethod
    public void beforeMethod() {
       driver = new ChromeDriver();
       baseUrl = "https://www.amazon.com";
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       WebDriverWait wait = new WebDriverWait(driver, 30);
       
    }

    @Test
    public void EvilTesterBook() {
        driver.get(baseUrl);

        WebElement catDrpDwn = driver.findElement(By.id("searchDropDownBox"));
        catDrpDwn.click();

        WebElement catBook = driver.findElement(By.label("Books"));
        catBook.click();

        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("evil tester");
        
        WebElement search = driver.findElement(By.id("nav-search-submit-text"));
        search.click();

        WebElement evilTester = driver.findElement(By.xpath("//a[contains(text(), ' "Dear Evil Tester: Provocative Advice That Could Change Your Approach To Testing Forever" ')]"));
        evilTester.click();

        WebElement aboutAuthor = driver.find_element_by_id("books-entity-teaser");

        action = ActionChains(driver);
        action.move_to_element(aboutAuthor).perform();

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
                FileUtils.copyFile(src, new File("C:/selenium/evilTesterBio.png"));
            }       
        catch (IOException e)
            {
                System.out.println(e.getMessage());
    
            }

        window.scrollTo(0, 0);
        
        WebElement buyUsed = driver.findElement(By.id("usedOfferAccordionRow"));
        buyUsed.click();

        WebElement buyNew = driver.findElement(By.id("newOfferAccordionRow"));
        buyNew.click();

        WebElement addToCart = driver.findElement(By.id("add-to-cart-button-ubb"));
        addToCart.click();

        WebElement goToCart = driver.findElement(By.class("nav-cart-icon nav-sprite"));
        goToCart.click();

        }  
        
    @AfterMethod
    public void afterMethod() {
        driver.quit();
        }
    }
}






