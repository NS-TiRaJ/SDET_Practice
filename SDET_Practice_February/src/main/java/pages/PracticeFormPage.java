package pages;

import helpers.GenerateRandomData;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Month;

import static helpers.Waiter.waitToBeClickable;
import static helpers.Waiter.waitUntilVisible;

public class PracticeFormPage {
    private final WebDriver driver;
    public PracticeFormPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/input")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement email;
    @FindBy(xpath = "//*[@id='genterWrapper']/div[2]/div[1]")
    private WebElement maleGender;
    @FindBy(xpath = "//*[@id='genterWrapper']/div[2]/div[2]")
    private WebElement femaleGender;
    @FindBy(xpath = "//*[@id='genterWrapper']/div[2]/div[3]")
    private WebElement otherGender;
    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement mobileNumber;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement birthdayDateInput;
    @FindBy(xpath = "//*[@class='react-datepicker__year-select']")
    private WebElement yearSelect;
    @FindBy(xpath = "//*[@class='react-datepicker__month-select']")
    private WebElement monthSelect;
    @FindBy(xpath = "//*[@id='subjectsInput']")
    private WebElement subjects;
    @FindBy(xpath = "//*[@id='hobbiesWrapper']/div[2]/div[1]")
    private WebElement sportHobbies;
    @FindBy(xpath = "//*[@id='hobbiesWrapper']/div[2]/div[2]")
    private WebElement readingHobbies;
    @FindBy(xpath = "//*[@id='hobbiesWrapper']/div[2]/div[3]")
    private WebElement musicHobbies;
    @FindBy(xpath = "//*[@id='uploadPicture']")
    private WebElement upload;
    @FindBy(xpath = "//*[@id='currentAddress']")
    private WebElement currentAddress;
    @FindBy(xpath = "//input[@id='react-select-3-input']")
    private WebElement state;
    @FindBy(xpath = "//input[@id='react-select-4-input']")
    private WebElement city;
    @FindBy(xpath = "//div[contains(@id,'react-select')]")
    private WebElement reactSelect;
    @FindBy(xpath = "//*[@id='submit']")
    private WebElement submitButton;

    @Step ("Ввод случайного имени")
    public void inputFirstName() {
        waitToBeClickable(driver, firstName);
        firstName.sendKeys(GenerateRandomData.generateRandomFirstName());
    }

    @Step ("Ввод случайной фамилии")
    public void inputLastName() {
        waitToBeClickable(driver, lastName);
        lastName.sendKeys(GenerateRandomData.generateRandomLastName());
    }

    @Step ("Ввод случайного email")
    public void inputEmail() {
        waitToBeClickable(driver, email);
        email.sendKeys(GenerateRandomData.generateRandomEmail());
    }

    @Step ("Выбор случайного гендера")
    public void selectGender() {
        int i = GenerateRandomData.randBetween(1, 3);
        switch (i) {
            case (1) -> maleGender.click();
            case (2) -> femaleGender.click();
            case (3) -> otherGender.click();
        }
    }

    @Step ("Ввод случайного номера")
    public void inputPhoneNumber() {
        waitUntilVisible(driver, mobileNumber);
        mobileNumber.sendKeys(GenerateRandomData.generatePhoneNumber());
    }

    @Step ("Выбор случайного хобби")
    public void selectHobies() {
        int i = GenerateRandomData.randBetween(1, 3);
        switch (i) {
            case (1) -> sportHobbies.click();
            case (2) -> readingHobbies.click();
            case (3) -> musicHobbies.click();
        }
    }

    @Step ("Ввод случайного дня рождения")
    public void inputBirthDate() {
        birthdayDateInput.click();
        waitUntilVisible(driver,yearSelect);
        yearSelect.click();
        int y =GenerateRandomData.generateRandomYear();
        String y1 = Integer.toString(y);
        yearSelect.sendKeys(y1);
        yearSelect.click();
        waitUntilVisible(driver,monthSelect);
        monthSelect.click();
        int m = GenerateRandomData.generateRandomMonth();
        String m1 = Month.of(m).toString();
        monthSelect.sendKeys(m1);
        monthSelect.click();
        String day = Integer.toString(GenerateRandomData.generateRandomDay(y,m));
        String dayXpath = "//*[@class='react-datepicker__week']//*[text()='" + day + "']";
        WebElement selectDate = driver.findElement(By.xpath(dayXpath));
        selectDate.click();
    }
    @Step ("Ввод случайного subjects")
    public void inputSubjects(){subjects.click();subjects.sendKeys(GenerateRandomData.generateRandomText());}

    @Step (" Загрузка случайной картинки")
    public void uploadPicture() {
        waitToBeClickable(driver, upload);
        int i = GenerateRandomData.randBetween(1, 2);
        switch (i) {
            case (1) -> upload.sendKeys("C:/Users/Николай/Downloads/1.jpg");
            case (2) ->  upload.sendKeys("C:/Users/Николай/Downloads/2.png");
        }
    }
    @Step ("Ввод случайного текста в поле Current Address")
    public void inputCurrentAddress(){waitUntilVisible(driver,currentAddress);currentAddress.sendKeys(GenerateRandomData.generateRandomText());}
    @Step ("Вобор State и City")
    public void selectStateAndCity(){
        waitToBeClickable(driver,state);state.sendKeys("NCR");
        waitToBeClickable(driver,reactSelect);reactSelect.click();
        waitToBeClickable(driver,city);city.sendKeys("Noida");
        waitToBeClickable(driver,reactSelect);reactSelect.click();
    }
    @Step ("Нажатие кнопки Submit")
    public void pressSubmitButton(){submitButton.click();}
}



