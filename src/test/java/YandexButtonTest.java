import org.junit.Rule;
import org.junit.Test;
import pages.homePage;

import static org.junit.Assert.assertEquals;

public class YandexButtonTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void yandexButtonTest() { //Поле
        homePage objHomePage = new homePage(driverFactory.getDriver());
        String url = objHomePage.clickYandexButton();
        System.out.println(url);
        assertEquals("https://dzen.ru/?yredirect=true", url);
    }
}