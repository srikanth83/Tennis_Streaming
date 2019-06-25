package Step_Definitions;

import core.CucumberPageWrapper;
import core.Tennis_Video_Page;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;


@ContextConfiguration("classpath:cucumber.xml")
public class Tennis_Streaming_Step_Definitions {

    @Autowired
    Tennis_Video_Page tennis_video_page ;

   
    @Given("^I am Eurosport Customer$")
    public void iAmEurosportCustomer() {

        tennis_video_page.visit_Eurosport_Homepage();
        tennis_video_page.acceptCookiesButton().click();

    }

    @And("^On Videos Hub Page$")
    public void onVideosHubPage() {
        Assert.assertTrue(tennis_video_page.videoSectionPage().isDisplayed());
        Assert.assertTrue(tennis_video_page.tennis_Video_Text().getText().contains("Tennis"));
    }

    @When("^I select to watch the videos from Tennis Section$")
    public void iSelectToWatchTheVideosFromTennisSection() {
        tennis_video_page.click_On_Tennis_Video().click();

    }

    @Then("^the selected video is playing$")
    public void theSelectedVideoIsPlaying() {

        //click on skip ad handling dynamically

        if(tennis_video_page.skipAd_Present()==true){
            tennis_video_page.wait_For_Skip_Ad_To_Present_And_Click();
        }
    }

    @And("^the following player controls are displayed$")
    public void theFollowingPlayerControlsAreDisplayed(DataTable table) {
        List<String> totalList = table.asList(String.class);
        tennis_video_page.hover_On_Video();

        for(String list: totalList ){
            if(list.equals("Play")){
                Assert.assertTrue(tennis_video_page.pause_Button().isDisplayed());
                tennis_video_page.pause_Button().click();
            }
            else{
                if(list.equals("Pause")){
                    Assert.assertTrue(tennis_video_page.play_Button().isDisplayed());
                }
            else{
                if(list.equals("Maximize")){
                    Assert.assertTrue(tennis_video_page.full_Screen_Button().isDisplayed());
                }
                }
            }
        }

    }

    @When("^I click on more videos button from tennis section$")
    public void iClickOnMoreVideosButtonFromTennisSection() {
          tennis_video_page.more_Videos_Button().click();
    }


    @Then("^filter should be defaulted to Tennis and Latest videos$")
    public void filterShouldBeDefaultedToTennisAndLatestVideos() {

        Assert.assertEquals(tennis_video_page.current_Dropdown().getText(), "Tennis");
        Assert.assertEquals(tennis_video_page.latest_Videos_Text().getText(), "Latest videos");
    }

    @When("^I select tennis from toggle menu$")
    public void iSelectTennisFromToggleMenu() {

        tennis_video_page.toggle_Menu().click();
        tennis_video_page.select_Tennis_From_Hanmburg_Menu().click();
    }

    @And("^select tennis from hamburg menu$")
    public void selectTennisFromHamburgMenu() {
        tennis_video_page.select_Tennis_From_Hanmburg_Menu().click();
    }


    @Then("^I should be navigated to tennis video page$")
    public void iShouldBeNavigatedToTennisVideoPage() {
        Assert.assertTrue(tennis_video_page.getCurrentUrl().contains("tennis"));
        tennis_video_page.acceptCookiesButton().click();
    }

    @And("^the following list of top tennis events should be displayed on the header of the page$")
    public void theFollowingListOfTopTennisEventsShouldBeDisplayedOnTheHeaderOfThePage(DataTable table) {
        List<String> totalList = table.asList(String.class);
        List<String> tennisTournaments = tennis_video_page.getListOfFamousTennisTournaments();

        for(int i=1;i<tennisTournaments.size();i++){
            Assert.assertEquals(totalList.get(i-1),tennisTournaments.get(i));
        }
    }



}
