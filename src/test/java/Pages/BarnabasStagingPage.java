package Pages;

import DriverManager.Constant;
import DriverManager.DriverFactory;
import Utility.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Random;

public class BarnabasStagingPage extends DriverFactory {

    public String userName,userPassword,categoryType,eventType,locationNameDetails,streetAddressDetails,
            eventCityDetails,eventStateDetails,eventZipcodeDetails,contactPersonDetails,contactPersonPhoneDetails
            ,contactPersonEmailDetails,getTilteEvent,contactTypeEvent,presentMinistrie,eventTitleName,getEventTitleName,getEventName;
    public WebElement selectCategory,selectType,selectPresentMinistries;

    @FindBy(xpath = "//input[@id='Login_email']")
    protected WebElement username;

    @FindBy(xpath = "//input[@id='Login_password']")
    protected WebElement password;

    @FindBy(xpath = "//span[text()='Login']")
    protected WebElement loginBtn;

    @FindBy(xpath = "//span[contains(@class,'anticon-plus')]")
    protected WebElement addEventBtn;

    @FindBy(xpath = "//label[text()='Category']/ancestor::div[contains(@class,'ant-form-item-label')]/following-sibling::div//div[contains(@class,'ant-select-single')]")
    protected WebElement categoryDropdown;

    @FindBy(xpath = "//label[text()='Type']/ancestor::div[contains(@class,'ant-form-item-label')]/following-sibling::div//div[contains(@class,'ant-select-single')]")
    protected WebElement typeDropdown;

    @FindBy(xpath = "//input[@id='start_date']")
    protected WebElement sendStartDate;

    @FindBy(xpath = "//label[text()='Select Date']/ancestor::div[contains(@class,'ant-form-item-label')]/following-sibling::div//div[contains(@class,'ant-picker-input')]")
    protected WebElement selectDateCalender;

    @FindBy(xpath = "//label[text()='Start Time']/ancestor::div[contains(@class,'ant-form-item-label')]/following-sibling::div//div[contains(@class,'ant-picker-input')]")
    protected WebElement selectStartTime;

    @FindBy(xpath = "//input[@id='start_time']")
    protected WebElement sendStartTime;

    @FindBy(xpath = "//li[@class='ant-picker-ok']")
    protected WebElement startTimeOKBtn;

    @FindBy(xpath = "//label[text()='End Time']/ancestor::div[contains(@class,'ant-form-item-label')]/following-sibling::div//div[contains(@class,'ant-picker-input')]")
    protected WebElement selectEndTime;

    @FindBy(xpath = "//input[@id='end_time']")
    protected WebElement sendEndTime;

    @FindBy(xpath = "(//li[@class='ant-picker-ok'])[2]")
    protected WebElement endTimeOKBtn;

    @FindBy(xpath = "//input[@id='location_name']")
    protected WebElement locationName;

    @FindBy(xpath = "//input[@id='street_address']")
    protected WebElement streetAddress;

    @FindBy(xpath = "//input[@id='city']")
    protected WebElement eventCity;

    @FindBy(xpath = "//input[@id='state']")
    protected WebElement eventState;

    @FindBy(xpath = "//input[@id='zipcode']")
    protected WebElement eventZipcode;

    @FindBy(xpath = "//input[@id='contacts_0_name']")
    protected WebElement contactPersonName;

    @FindBy(xpath = "//label[text()='Contact Type']/ancestor::div[contains(@class,'ant-form-item-label')]/following-sibling::div//div[contains(@class,'ant-select-single')]")
    protected WebElement contactTypeDropdown;

    @FindBy(xpath = "//input[@id='contacts_0_phone_no']")
    protected WebElement contactPersonPhone;

    @FindBy(xpath = "//input[@id='contacts_0_email']")
    protected WebElement contactPersonEmail;

    @FindBy(xpath = "//input[@id='max_attendees']")
    protected WebElement maxAttendanceNo;

    @FindBy(xpath = "//input[@id='no_of_waitlist']")
    protected WebElement noWaitListNo;

    @FindBy(xpath = "//span[text()='Create Event']")
    protected WebElement createEventBtn;

    @FindBy(xpath = "//textarea[@id='additional_photos_0_short_description']")
    protected WebElement photoDescription;

    @FindBy(xpath = "//span[text()='Select Presenting Ministries']")
    protected WebElement presentMinistries;

    @FindBy(xpath = "//header[@class='ant-layout-header']")
    protected WebElement headerTag;

    @FindBy(xpath = "//input[@id='name']")
    protected WebElement eventTitle;

    @FindBy(xpath = "//div[contains(@class,'ant-message-success')]/span[2]")
    protected WebElement validationMsgForEvent;

    @FindBy(xpath = "//input[@class='ant-input']")
    protected WebElement searchBoxEvent;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    protected WebElement eventTitleTable;

    @FindBy(xpath = "//span[contains(@class,'ant-spin-dot-spin')]/i")
    protected WebElement spinDotHighlight;

    @FindBy(xpath = "//span[contains(@class,'anticon-edit')]")
    protected WebElement editButton;

    @FindBy(xpath = "//span[contains(text(),'Save Changes')]")
    protected WebElement saveChangeBtn;

    @FindBy(xpath = "//span[contains(text(),'Yes')]")
    protected WebElement yesBtn;

    @FindBy(xpath = "//span[contains(text(),'Publish Event')]")
    protected WebElement publishBtn;

    @FindBy(xpath = "//span[contains(text(),'Duplicate')]")
    protected WebElement duplicateEventBtn;

    @FindBy(xpath = "//span[contains(text(),'Duplicate Event')]")
    protected WebElement saveDuplicateEventBtn;

    //@FindBy(xpath = "//input[@id='rc_select_9']")
    @FindBy(xpath = "//span[text()='Sort by Status']/preceding-sibling::span/input")
    protected WebElement statusDropdown;

    @FindBy(xpath = "//span[text()='Published']/preceding-sibling::span/input")
    //@FindBy(xpath = "//span[text()='Sort by Status']")
    protected WebElement statusDropdownFirst;

    @FindBy(xpath = "//div[text()='Published']")
    protected WebElement publishedStatus;

    @FindBy(xpath = "//div[text()='Unpublished']")
    protected WebElement unpublishedStatus;

    @FindBy(xpath = "//a[@class='gx-site-logo']")
    protected WebElement barnabasLogo;

    @FindBy(xpath = "//span[text()='RSVP Management']")
    protected WebElement rsvpMgtBtn;

    @FindBy(xpath = "//span[text()='Event Management']")
    protected WebElement eventMgtBtn;

    /**
     * Enter username.
     * @return
     */
    public BarnabasStagingPage enterUserName() {
        Utilities.getUtilities().waitForVisibilityOfElement(username,driver);
        userName = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "loginCredential", "Username", 2);
        Utilities.getUtilities().sendKey(username,userName);
        return this;
    }

    /**
     * Enter password.
     * @return
     */
    public BarnabasStagingPage enterPassword() {
        Utilities.getUtilities().waitForVisibilityOfElement(username,driver);
        userPassword = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "loginCredential", "Password", 2);
        Utilities.getUtilities().sendKey(password,userPassword);
        return this;
    }

    /**
     * Click on login button
     * @return
     */
    public BarnabasStagingPage clickOnLoginBtn(){
        Utilities.getUtilities().waitForVisibilityOfElement(loginBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(loginBtn,driver);
        Utilities.getUtilities().javaScriptClickOnElement(loginBtn,driver);
        Log.info("Click On Login Button.");
        return this;
    }

    /**
     * Click on barnanas logo.
     * @return
     */
    public BarnabasStagingPage clickOnBarnabasLogo(){
        Utilities.getUtilities().waitForVisibilityOfElement(barnabasLogo,driver);
        Utilities.getUtilities().waitForElementTobeClickable(barnabasLogo,driver);
        try {
            Utilities.getUtilities().clickOnElement(barnabasLogo);
        }catch (Exception e){
            Utilities.getUtilities().javaScriptClickOnElement(barnabasLogo,driver);
        }
        Log.info("Click On Login Button.");
        return this;
    }

    /**
     * Click on rsvp logo.
     * @return
     */
    public BarnabasStagingPage clickOnRSVPButton(){
        Utilities.getUtilities().waitForVisibilityOfElement(rsvpMgtBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(rsvpMgtBtn,driver);
        try {
            Utilities.getUtilities().clickOnElement(rsvpMgtBtn);
        }catch (Exception e){
            Utilities.getUtilities().javaScriptClickOnElement(rsvpMgtBtn,driver);
        }
        return this;
    }

    /**
     * Click on event button.
     * @return
     */
    public BarnabasStagingPage clickOnEventMgtBtn(){
        Utilities.getUtilities().waitForVisibilityOfElement(eventMgtBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(eventMgtBtn,driver);
        try {
            Utilities.getUtilities().clickOnElement(eventMgtBtn);
        }catch (Exception e){
            Utilities.getUtilities().javaScriptClickOnElement(eventMgtBtn,driver);
        }
        return this;
    }

    /**
     * NAvigate to home page logo.
     * @return
     */
    public BarnabasStagingPage navigateToHomePage(){
        driver.get("https://barnabas-staging.cpptl.co/event");
        return this;
    }

    /**
     * login to application.
     * @return
     */
    public BarnabasStagingPage loginToApplication() throws InterruptedException {
        enterUserName();
        enterPassword();
        clickOnLoginBtn();
        return this;
    }

    /**
     * click on add new event button.
     * @return
     */
    public BarnabasStagingPage clickOnAddEventButton(){
        Utilities.getUtilities().waitForVisibilityOfElement(addEventBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(addEventBtn,driver);
        Utilities.getUtilities().javaScriptClickOnElement(addEventBtn,driver);
        return this;
    }

    /**
     * Click on event category dropdown.
     * @return
     */
    public BarnabasStagingPage clickOnEventCategoryDropdown() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(categoryDropdown,driver);
        Utilities.getUtilities().waitForElementTobeClickable(categoryDropdown,driver);
        Utilities.getUtilities().clickOnElement(categoryDropdown);
        Thread.sleep(1000);
        return this;
    }

    /**
     * Select event category.
     * @return
     */
    public BarnabasStagingPage selectEventCategory(String categoryType){
        selectCategory = driver.findElement(By.xpath("//div[text()='"+categoryType+"']"));
        selectCategory.click();
        return this;
    }

    /**
     * Select event contact type.
     * @return
     */
    public BarnabasStagingPage selectContactType(){
        contactTypeEvent = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Contact Type", 2);
        Utilities.getUtilities().waitForVisibilityOfElement(contactTypeDropdown,driver);
        Utilities.getUtilities().clickOnElement(contactTypeDropdown);
        selectCategory = driver.findElement(By.xpath("//div[text()='"+contactTypeEvent+"']"));
        selectCategory.click();
        return this;
    }

    /**
     * Click on type category dropdown.
     * @return
     */
    public BarnabasStagingPage clickOnTypeCategoryDropdown(){
        Utilities.getUtilities().waitForVisibilityOfElement(typeDropdown,driver);
        Utilities.getUtilities().waitForElementTobeClickable(typeDropdown,driver);
        Utilities.getUtilities().clickOnElement(typeDropdown);
        return this;
    }

    /**
     * Select type category.
     * @return
     */
    public BarnabasStagingPage selectTypeCategory(String eventType){
        selectType = driver.findElement(By.xpath("//div[text()='"+eventType+"']"));
        selectType.click();
        return this;
    }

    /**
     * Event Title
     * @return
     */
    public BarnabasStagingPage sendEventTitle(String eventTitleName){
        Random random = new Random();
        int x = random.nextInt(10000);
        getEventName = Integer.toString(x);
        getTilteEvent = getEventName+" "+eventTitleName;
        Utilities.getUtilities().waitForVisibilityOfElement(eventTitle,driver);
        System.out.println(getTilteEvent);
        Utilities.getUtilities().sendKey(eventTitle,getTilteEvent);
        return this;
    }

    /**
     * Select calender.
     * @return
     */
    public BarnabasStagingPage selectCalender(){
        Utilities.getUtilities().waitForElementTobeClickable(selectDateCalender,driver);
        Utilities.getUtilities().clickOnElement(selectDateCalender);
        return this;
    }

    /**
     * Send start date.
     * @return
     */
    public BarnabasStagingPage sendStartDate() throws InterruptedException {
        Utilities.getUtilities().waitForElementTobeClickable(sendStartDate,driver);
        Utilities.getUtilities().sendKey(sendStartDate,"05/19/2021");
        return this;
    }

    /**
     * Select calender.
     * @return
     */
    public BarnabasStagingPage selectStartTime(){
        Utilities.getUtilities().waitForElementTobeClickable(selectStartTime,driver);
        Utilities.getUtilities().clickOnElement(selectStartTime);
        return this;
    }

    /**
     * Select start time OK button.
     * @return
     */
    public BarnabasStagingPage selectStartTimeOKBtn(){
        Utilities.getUtilities().waitForElementTobeClickable(startTimeOKBtn,driver);
        Utilities.getUtilities().clickOnElement(startTimeOKBtn);
        return this;
    }

    /**
     * Send start date.
     * @return
     */
    public BarnabasStagingPage sendStartTime() {
        Utilities.getUtilities().waitForElementTobeClickable(sendStartTime,driver);
        Utilities.getUtilities().sendKey(sendStartTime,"11:00 pm");
        return this;
    }

    /**
     * Select calender.
     * @return
     */
    public BarnabasStagingPage selectEndTime(){
        Utilities.getUtilities().waitForElementTobeClickable(selectEndTime,driver);
        Utilities.getUtilities().clickOnElement(selectEndTime);
        return this;
    }

    /**
     * Select start time OK button.
     * @return
     */
    public BarnabasStagingPage selectEndTimeOKBtn(){
        Utilities.getUtilities().waitForElementTobeClickable(endTimeOKBtn,driver);
        Utilities.getUtilities().clickOnElement(endTimeOKBtn);
        return this;
    }

    /**
     * Send start date.
     * @return
     */
    public BarnabasStagingPage sendEndTime() {
        Utilities.getUtilities().waitForElementTobeClickable(sendEndTime,driver);
        Utilities.getUtilities().sendKey(sendEndTime,"11:10 pm");
        return this;
    }

    /**
     * send location name.
     * @return
     */
    public BarnabasStagingPage sendLocationName() {
        Utilities.getUtilities().waitForVisibilityOfElement(locationName,driver);
        locationNameDetails = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Location Name", 2);
        Utilities.getUtilities().sendKey(locationName,locationNameDetails);
        return this;
    }

    /**
     * send location name.
     * @return
     */
    public BarnabasStagingPage sendStreetAddressName() {
        Utilities.getUtilities().waitForVisibilityOfElement(streetAddress,driver);
        streetAddressDetails = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Street Address", 2);
        Utilities.getUtilities().sendKey(streetAddress,streetAddressDetails);
        return this;
    }

    /**
     * send city name.
     * @return
     */
    public BarnabasStagingPage sendEventCityName() {
        Utilities.getUtilities().waitForVisibilityOfElement(eventCity,driver);
        eventCityDetails = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "City", 2);
        Utilities.getUtilities().sendKey(eventCity,eventCityDetails);
        return this;
    }

    /**
     * send state name.
     * @return
     */
    public BarnabasStagingPage sendEventStateName() {
        Utilities.getUtilities().waitForVisibilityOfElement(eventState,driver);
        eventStateDetails = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "State", 2);
        Utilities.getUtilities().sendKey(eventState,eventStateDetails);
        return this;
    }

    /**
     * send zipcode name.
     * @return
     */
    public BarnabasStagingPage sendEventZipcode() {
        Utilities.getUtilities().waitForVisibilityOfElement(eventZipcode,driver);
        eventZipcodeDetails = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Zipcode", 2);
        Utilities.getUtilities().sendKey(eventZipcode,"123456");
        return this;
    }

    /**
     * send contact person name.
     * @return
     */
    public BarnabasStagingPage sendContactPersonName() {
        Utilities.getUtilities().waitForVisibilityOfElement(contactPersonName,driver);
        contactPersonDetails = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Contact Person Name", 2);
        Utilities.getUtilities().sendKey(contactPersonName,contactPersonDetails);
        return this;
    }

    /**
     * send contact person phone.
     * @return
     */
    public BarnabasStagingPage sendContactPersonPhone() {
        Utilities.getUtilities().waitForVisibilityOfElement(contactPersonPhone,driver);
        contactPersonPhoneDetails = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Phone", 2);
        WebElement test = driver.findElement(By.xpath("//input[@id='contacts_0_phone_no']"));
        Utilities.getUtilities().clickOnElement(test);
        test.sendKeys("1111111111");
        return this;
    }

    /**
     * send contact person email.
     * @return
     */
    public BarnabasStagingPage sendContactPersonEmail() {
        Utilities.getUtilities().waitForVisibilityOfElement(contactPersonEmail,driver);
        contactPersonEmailDetails = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Email", 2);
        Utilities.getUtilities().sendKey(contactPersonEmail,contactPersonEmailDetails);
        return this;
    }

    /**
     * send Max event attendance number.
     * @return
     */
    public BarnabasStagingPage sendMaxEventAttendanceNo() {
        Utilities.getUtilities().waitForVisibilityOfElement(maxAttendanceNo,driver);
        Utilities.getUtilities().sendKey(maxAttendanceNo,"100");
        return this;
    }

    /**
     *  No of wait list number.
     * @return
     */
    public BarnabasStagingPage sendNumberOfWaitListNo() {
        Utilities.getUtilities().waitForVisibilityOfElement(noWaitListNo,driver);
        Utilities.getUtilities().sendKey(noWaitListNo,"100");
        return this;
    }

    /**
     *  add event photo.
     * @return
     */
    public BarnabasStagingPage addEventPhoto() {
        WebElement eventPhotos = driver.findElement(By.xpath("(//span[@class='ant-upload']/input)[1]"));
        eventPhotos.sendKeys("C:\\Users\\Bhumit\\Desktop\\Freelance Project\\barnabas-automation\\refPhotos\\Button.png");
        return this;
    }

    /**
     *  add description photo.
     * @return
     */
    public BarnabasStagingPage addDescriptionPhoto() {
        WebElement descriptionPhotos = driver.findElement(By.xpath("//input[@id='additional_photos_0_image_url']"));
        descriptionPhotos.sendKeys("C:\\Users\\Bhumit\\Desktop\\Freelance Project\\barnabas-automation\\refPhotos\\Button.png");
        return this;
    }

    public BarnabasStagingPage sendTextDescriptions(){
        Utilities.getUtilities().waitForVisibilityOfElement(photoDescription,driver);
        Utilities.getUtilities().sendKey(photoDescription,"test description");
        return this;
    }

    /**
     * Create event button.
     * @return
     */
    public BarnabasStagingPage clickOnCreateEventBtn() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(createEventBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(createEventBtn,driver);
        Utilities.getUtilities().javaScriptClickOnElement(createEventBtn,driver);
        Thread.sleep(2000);
        return this;
    }

    /**
     * Select present ministries.
     * @return
     */
    public BarnabasStagingPage selectPresentMinistries(){
        Utilities.getUtilities().waitForVisibilityOfElement(presentMinistries,driver);
        Utilities.getUtilities().waitForElementTobeClickable(presentMinistries,driver);
        Utilities.getUtilities().clickOnElement(presentMinistries);
        presentMinistrie = Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Presenting Ministries", 2);
        selectPresentMinistries = driver.findElement(By.xpath("//div[text()='"+presentMinistrie+"']"));
        selectPresentMinistries.click();
        Utilities.getUtilities().waitForElementTobeClickable(headerTag,driver);
        Utilities.getUtilities().clickOnElement(headerTag);
        return this;
    }

    /**
     * Validation message for event create.
     * @return
     */
    public BarnabasStagingPage verifyValidationMsgForEvent(String validationRefMsgForCreate){
        Utilities.getUtilities().waitForVisibilityOfElement(validationMsgForEvent,driver);
        Assert.assertEquals(validationMsgForEvent.getText(),validationRefMsgForCreate);
        return this;
    }

    /**
     *
     * Verify search functionality.
     * @return
     */
    public BarnabasStagingPage verifySearchFunctionality(){
        Utilities.getUtilities().waitForVisibilityOfElement(searchBoxEvent,driver);
        Utilities.getUtilities().waitForElementTobeClickable(searchBoxEvent,driver);
        Utilities.getUtilities().sendKey(searchBoxEvent,getTilteEvent);
        Utilities.getUtilities().waitForVisibilityOfElement(spinDotHighlight,driver);
        Utilities.getUtilities().waitForVisibilityOfElement(eventTitleTable,driver);
        getEventTitleName = eventTitleTable.getText();
        Assert.assertEquals(getTilteEvent,getEventTitleName);
        return this;
    }

    /**
     * verify newly created event.
     * @return
     */
    public BarnabasStagingPage verifyNewEvent() throws InterruptedException {
        clickOnAddEventButton();
        clickOnEventCategoryDropdown();
        selectEventCategory(Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Category", 2));
        clickOnTypeCategoryDropdown();
        selectTypeCategory(Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Type", 2));
        sendEventTitle(Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Event Title", 2));
        selectCalender();
        sendStartDate();
        selectStartTime();
        sendStartTime();
        selectStartTimeOKBtn();
        selectEndTime();
        sendEndTime();
        selectEndTimeOKBtn();
        sendLocationName();
        sendStreetAddressName();
        sendEventCityName();
        sendEventStateName();
        sendEventZipcode();
        addEventPhoto();
        sendContactPersonName();
        selectContactType();
        sendContactPersonPhone();
        sendContactPersonEmail();
        sendMaxEventAttendanceNo();
        sendNumberOfWaitListNo();
        addDescriptionPhoto();
        sendTextDescriptions();
        selectPresentMinistries();
        clickOnCreateEventBtn();
        verifyValidationMsgForEvent(prop.getProperty("validationMsgForEventCreate"));
        verifySearchFunctionality();
        return this;
    }

    /**
     * Click on edit event button.
     * @return
     */
    public BarnabasStagingPage clickOnEditEventBtn() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(editButton,driver);
        Utilities.getUtilities().waitForElementTobeClickable(editButton,driver);
        Utilities.getUtilities().javaScriptClickOnElement(editButton,driver);
        Thread.sleep(2000);
        return this;
    }

    /**
     * Click on edit event button.
     * @return
     */
    public BarnabasStagingPage clickOnSaveChangeBtn() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(saveChangeBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(saveChangeBtn,driver);
        Utilities.getUtilities().javaScriptClickOnElement(saveChangeBtn,driver);
        Thread.sleep(2000);
        return this;
    }

    /**
     * Click on edit event button.
     * @return
     */
    public BarnabasStagingPage clickOnYesBtn(){
        Utilities.getUtilities().waitForVisibilityOfElement(yesBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(yesBtn,driver);
        Utilities.getUtilities().javaScriptClickOnElement(yesBtn,driver);
        return this;
    }

    /**
     * Click on publish event button.
     * @return
     */
    public BarnabasStagingPage clickOnPublishBtn(){
        Utilities.getUtilities().waitForVisibilityOfElement(publishBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(publishBtn,driver);
        Utilities.getUtilities().javaScriptClickOnElement(publishBtn,driver);
        return this;
    }

    /**
     * Edit and verify event.
     * @return
     */
    public BarnabasStagingPage editAndVerifyEvents() throws InterruptedException {
        clickOnEditEventBtn();
        clickOnEventCategoryDropdown();
        selectEventCategory(Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Category", 3));
        clickOnTypeCategoryDropdown();
        selectTypeCategory(Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Type", 3));
        Thread.sleep(1000);
        Utilities.getUtilities().clickOnElement(eventTitle);
        eventTitle.clear();
        sendEventTitle(Utilities.getUtilities().readDataFromExcel(Constant.barnabasExcelFile, "EventDetails", "Event Title", 3));
        clickOnPublishBtn();
        clickOnYesBtn();
        verifyValidationMsgForEvent(prop.getProperty("validationMsgForEventUpdate"));
        clickOnSaveChangeBtn();
        verifyValidationMsgForEvent(prop.getProperty("validationMsgForEventUpdate"));
        return this;
    }

    /**
     * duplicate event button.
     * @return
     */
    public BarnabasStagingPage clickOnDuplicateEventBtn(){
        Utilities.getUtilities().waitForVisibilityOfElement(duplicateEventBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(duplicateEventBtn,driver);
        Utilities.getUtilities().javaScriptClickOnElement(duplicateEventBtn,driver);
        return this;
    }

    /**
     * duplicate event button.
     * @return
     */
    public BarnabasStagingPage clickOnSaveDuplicateEventBtn(){
        Utilities.getUtilities().waitForVisibilityOfElement(saveDuplicateEventBtn,driver);
        Utilities.getUtilities().waitForElementTobeClickable(saveDuplicateEventBtn,driver);
        Utilities.getUtilities().javaScriptClickOnElement(saveDuplicateEventBtn,driver);
        return this;
    }

    /**
     * Verify duplicate event.
     * @return
     */
    public BarnabasStagingPage verifyDuplicateEvent() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(searchBoxEvent,driver);
        Utilities.getUtilities().waitForElementTobeClickable(searchBoxEvent,driver);
        Utilities.getUtilities().sendKey(searchBoxEvent,getTilteEvent);
        clickOnEditEventBtn();
        clickOnDuplicateEventBtn();
        clickOnYesBtn();
        clickOnSaveDuplicateEventBtn();
        return this;
    }

    /**
     * click on status dropdown.
     * @return
     */
    public BarnabasStagingPage clickOnStatusDropdown() throws InterruptedException {
        Thread.sleep(5000);
        try {
                Utilities.getUtilities().clickOnElement(statusDropdown);
        }catch (Exception e){
                Utilities.getUtilities().javaScriptClickOnElement(statusDropdown,driver);
        }
        return this;
    }

    /**
     * click on status dropdown.
     * @return
     */
    public BarnabasStagingPage clickOnStatusDropdownFirst() throws InterruptedException {
        Thread.sleep(5000);
        try {
                Utilities.getUtilities().clickOnElement(statusDropdownFirst);
        }catch (Exception e){
                Utilities.getUtilities().javaScriptClickOnElement(statusDropdownFirst,driver);
        }
        return this;
    }

    /**
     * Click on publish dropdown.
     * @return
     */
    public BarnabasStagingPage selectPublishDropdown(){
        Utilities.getUtilities().waitForVisibilityOfElement(publishedStatus,driver);
        Utilities.getUtilities().waitForElementTobeClickable(publishedStatus,driver);
        Utilities.getUtilities().clickOnElement(publishedStatus);
        return this;
    }

    /**
     * Click on publish dropdown.
     * @return
     */
    public BarnabasStagingPage selectUnpublishDropdown(){
        Utilities.getUtilities().waitForVisibilityOfElement(unpublishedStatus,driver);
        Utilities.getUtilities().waitForElementTobeClickable(unpublishedStatus,driver);
        Utilities.getUtilities().clickOnElement(unpublishedStatus);
        return this;
    }

    /**
     * Verify sorting of dropdown.
     * @return
     */
    public BarnabasStagingPage verifySortingOfDropdown() throws InterruptedException {
        clickOnRSVPButton();
        clickOnEventMgtBtn();
        clickOnStatusDropdown();
        selectPublishDropdown();
        Utilities.getUtilities().waitForVisibilityOfElement(publishedStatus,driver);
        if(driver.findElements(By.xpath("//span[text()='Published']")).size()>1){
            System.out.println("Published sorting working properly");
        }
        clickOnStatusDropdownFirst();
        selectUnpublishDropdown();
        Utilities.getUtilities().waitForVisibilityOfElement(unpublishedStatus,driver);
        if(driver.findElements(By.xpath("//span[text()='Unpublished']")).size()>1){
            System.out.println("Unpublished sorting working properly");
        }
        return this;
    }
}
