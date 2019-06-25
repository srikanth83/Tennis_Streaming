package core;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Tennis_Video_Page {

    @Autowired
    CucumberPageWrapper  cucumberPageWrapper;


    By acceptCookiesButton = By.cssSelector("button[class*='qc']");
    By videoSectionPage = By.cssSelector("div[class*='video_section']");
    By tennis_Video_Text = By.cssSelector(".video_section_event_v8_5:nth-of-type(4) ");
    By click_On_Tennis_Video = By.cssSelector(".video_section_event_v8_5:nth-of-type(4) .secondary-video .video_thumbnail:nth-of-type(1)");
    By pause_Button = By.cssSelector("button.vjs-play-control.vjs-control.vjs-button.vjs-playing");
    By play_Button = By.cssSelector("button.vjs-play-control.vjs-control.vjs-button.vjs-paused");
    By full_Screen_Button = By.cssSelector("button[title='Fullscreen']");
    By more_Videos_Button = By.cssSelector(".video-section__button-more >a[href*='tennis']");
    By current_Dropdown = By.cssSelector("#dropdown-video-list-sport  .dropdown__current");
    By popular_Videos_Text = By.cssSelector("#dropdown-video-list  .dropdown__current");
    By toggle_Menu = By.cssSelector("div[data-modal-id='navallsport'] >button >span");
    By select_Tennis_From_Hanmburg_Menu = By.cssSelector("li[class*='modalnav__rightcol-item modalnav__rightcol-item--favorite'] >a[href*='tennis']");



    public void visit_Eurosport_Homepage(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chrome_driver/chromedriver.exe");
        cucumberPageWrapper.driver = new ChromeDriver();
        cucumberPageWrapper.driver.get("https://video.eurosport.co.uk");
    }

    public WebElement acceptCookiesButton(){
        return cucumberPageWrapper.waitForExpectedElement(acceptCookiesButton);
    }

    public WebElement videoSectionPage(){
        return cucumberPageWrapper.waitForExpectedElement(videoSectionPage);
    }

    public WebElement tennis_Video_Text(){
        return cucumberPageWrapper.waitForExpectedElement(tennis_Video_Text);
    }

    public WebElement click_On_Tennis_Video(){
        return cucumberPageWrapper.waitForExpectedElement(click_On_Tennis_Video);
    }

    public WebElement pause_Button(){
        return cucumberPageWrapper.waitForExpectedElement(pause_Button);
    }

    public WebElement play_Button(){
        return cucumberPageWrapper.waitForExpectedElement(play_Button);
    }

    public WebElement full_Screen_Button(){
        return cucumberPageWrapper.waitForExpectedElement(full_Screen_Button);
    }

    public WebElement more_Videos_Button(){
        return cucumberPageWrapper.waitForExpectedElement(more_Videos_Button);
    }

    public WebElement current_Dropdown(){
        return cucumberPageWrapper.waitForExpectedElement(current_Dropdown);
    }

    public WebElement latest_Videos_Text(){
        return cucumberPageWrapper.waitForExpectedElement(popular_Videos_Text);
    }

    public WebElement toggle_Menu(){
        return cucumberPageWrapper.waitForExpectedElement(toggle_Menu);
    }

    public WebElement select_Tennis_From_Hanmburg_Menu(){
        return cucumberPageWrapper.waitForExpectedElement(select_Tennis_From_Hanmburg_Menu);
    }

    public boolean skipAd_Present()
    {
        try
        {
            cucumberPageWrapper.driver.findElement(By.cssSelector("div[class='video__skip']"));
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public void wait_For_Skip_Ad_To_Present_And_Click(){
        WebDriverWait wait = new WebDriverWait(cucumberPageWrapper.driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='video__skip video__skip--skippable']")));
              element.click();

    }


    public void hover_On_Video(){
        Actions builder = new Actions(cucumberPageWrapper.driver);
        builder.moveToElement(cucumberPageWrapper.driver.findElement(By.cssSelector("video[id*='vjs_video']"))).perform();
    }

    public String getCurrentUrl(){
       return cucumberPageWrapper.driver.getCurrentUrl();
    }

    public List<String> getListOfFamousTennisTournaments(){
        cucumberPageWrapper.driver.manage().window().maximize();
        List<String> tennisTournaments = new ArrayList<>();
        List<WebElement> tournaments = cucumberPageWrapper.driver.findElements(By.cssSelector("#nav_category .categorylist .categorylist__item"));

        for(WebElement tournament : tournaments){
            tennisTournaments.add(tournament.getText());
        }

        return tennisTournaments;
    }


}
