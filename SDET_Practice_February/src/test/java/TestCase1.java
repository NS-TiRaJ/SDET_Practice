import org.testng.annotations.Test;
import pages.PracticeFormPage;

public class TestCase1 extends BaseTest{

    @Test
    public void test()  {
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.inputFirstName();
        practiceFormPage.inputLastName();
        practiceFormPage.inputEmail();
        practiceFormPage.selectGender();
        practiceFormPage.inputPhoneNumber();
        practiceFormPage.inputBirthDate();
        practiceFormPage.inputSubjects();
        practiceFormPage.selectHobies();
        practiceFormPage.uploadPicture();
        practiceFormPage.inputCurrentAddress();
        practiceFormPage.selectStateAndCity();
        practiceFormPage.pressSubmitButton();
    }
}
