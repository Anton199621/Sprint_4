import org.junit.Rule;
import org.junit.Test;
import pages.homePage;

import static org.junit.Assert.assertEquals;

public class ScooterButtonTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void scooterButtonTest() { //Поле
        homePage objHomePage = new homePage(driverFactory.getDriver());
        String url = objHomePage.clickScooterButton();
        assertEquals("https://qa-scooter.praktikum-services.ru/", url);
    }
}