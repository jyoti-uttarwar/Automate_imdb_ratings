package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//Selenium Imports
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    //INTV-1/Session-7/4/Activity 9: Automate_imdb_ratings
    public  void TC_ImdbRatings() throws InterruptedException{
        System.out.println("Start Test case: TC_ImdbRatings");
        // Load he url  "https://www.imdb.com/chart/top"
        driver.get("https://www.imdb.com/chart/top");
        // Locate & store the highest rated movie Using Locator "XPath" "//ul[contains(@class, 'ipc-metadata-list')]/li[1]//h3"
        WebElement eleHighestRatedMovie = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/li[1]//h3"));
        // Print the highest rated movie  
        System.out.println("Highest Rated Movie : " + eleHighestRatedMovie.getText());
        // Locate & store the count of movies listed on the page Using Locator "XPath" "//ul[contains(@class, 'ipc-metadata-list')]/li"
        List<WebElement> listOfMovies = driver.findElements(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/li"));
        // Print the count of the movies listed  
        System.out.println("Total Movies listed on the page : " + listOfMovies.size());
        // Locate the dropdown & sorted the list Using Locator "ID" "sort-by-selector"
        Select drpSort = new Select(driver.findElement(By.id("sort-by-selector")));
        // Select the option "Release date" By value  "RELEASE_DATE"
        drpSort.selectByValue("RELEASE_DATE");
        Thread.sleep(1000);
        // Locate & store the recent movie on the list Using Locator "XPath" "//ul[contains(@class,'ipc-metadata-list')]/li[1]//h3"
        WebElement eleRecentMovie = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/li[1]//h3"));
        // Locate & store the year of the recent movie Using Locator "XPath" "//ul[contains(@class,'ipc-metadata-list')]/li[1]//span[contains(@class,'sc-14dd939d-6')][1]"
        WebElement eleRecentMovieYear = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/li[1]//span[contains(@class,'sc-14dd939d-6')][1]"));
        // Print the name & year of the recent movie  
        System.out.println("Recent Movie & the year : " + eleRecentMovie.getText() + " ( " +eleRecentMovieYear.getText()+ " )");
        // Locate & click "Descending order" button Using Locator "XPath" "//button[@id='swap-sort-order-button']"
        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        Thread.sleep(1000);
        // locate & store the oldest movie on the list Using Locator "XPath" "//ul[contains(@class,'ipc-metadata-list')]/li[1]//h3"
        WebElement eleOldestMovie = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/li[1]//h3"));
        // Locate & store the year of the recent movie Using Locator "XPath" "//ul[contains(@class,'ipc-metadata-list')]/li[1]//span[contains(@class,'sc-14dd939d-6')][1]"
        WebElement eleOldestMovieYear = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/li[1]//span[contains(@class,'sc-14dd939d-6')][1]"));
        // Print the name & year of the oldest movie  
        System.out.println("Oldest Movie & the year : " + eleOldestMovie.getText() + " ( " +eleOldestMovieYear.getText()+ " )");
        // Select the option "Number Of ratings" By Value  "USER_RATING_COUNT"
        Select drpSortBy = new Select(driver.findElement(By.id("sort-by-selector")));
        drpSortBy.selectByValue("USER_RATING_COUNT");
        Thread.sleep(1000);
        // locate & store the movie has most user rating Using Locator "XPath" "//ul[contains(@class,'ipc-metadata-list')]/li[1]//h3"
        WebElement eleUserRatingMovie = driver.findElement(By.xpath("//ul[contains(@class,'ipc-metadata-list')]/li[1]//h3"));
        // Print the name of movie has the most user rating
        System.out.println("Most User Rating Movie : " + eleUserRatingMovie.getText());
        System.out.println("end Test case: TC_ImdbRatings");
    }


}
