import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
class StartMovieFinder extends Thread{
    public StringBuilder infoAboutMovies = new StringBuilder();
    public String movieUrlQuery;
    private WebDriver driver;
    private String baseUrl;
    StartMovieFinder(String movieNameURLEncoded){
        this.movieUrlQuery = movieNameURLEncoded;
    }
    //TODO JFrame - windows, buttons
    @Override
    public void run()  {
        try {
            setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sleep(500);
            searchElements();
        } catch (Exception e) {
            e.printStackTrace();
        }
        teardown();
    }
    void setUp() throws Exception
    {
        System.setProperty("webdriver.chrome.driver","C:\\IntellijJavaProjects\\movie-finder-selenium\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.allmovie.com/search/all/" + this.movieUrlQuery;
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
     void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void searchElements() throws Exception{
        driver.get(baseUrl);
        System.out.println(driver.getTitle());

        WebElement searchResult = driver.findElement(By.className("movie"));//search-results

        //minimize browser window
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_N);

        WebElement el = searchResult.findElement(By.className("info"));
        System.out.format("Info about movie:\n%s\n", el.getText());//el.getText();
    }
}