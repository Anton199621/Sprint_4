import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;
import pages.homePage;
import pages.orderPage;

@RunWith(Parameterized.class)
public class OrderTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();
    private final String name;
    private final String family;
    private final String data;
    private final String number;
    private final String adres;
    private final String period;
    private final String buttonChoose;
    private final int metroPoint;

    public OrderTest(String buttonChoose, String name, String family, String adres, int metroPoint, String number, String data, String period) {
        this.buttonChoose = buttonChoose;
        this.name = name;
        this.adres = adres;
        this.metroPoint = metroPoint;
        this.data = data;
        this.family = family;
        this.number = number;
        this.period = period;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {"Up","Дима", "Смирнов", "Тимирязевская 10", 4, "+79265553303", "28", "двое суток"},
                {"Down", "Сергей", "Силкин", "Тишинка 5", 9, "+79995139642", "04", "сутки"},
        };
    }
@Test
    public void orderTest() {
        OrderPage objOrderPage = new OrderPage(driverFactory.getDriver());
        HomePage objHomePage = new HomePage(driverFactory.getDriver());

    OrderDirection orderDirection = OrderDirection.valueOf(buttonChoose.toUpperCase());
    if (orderDirection == OrderDirection.UP) {
        objHomePage.clickOrderUpButton();
    } else {
        objHomePage.clickOrderDownButton();
    }

        objOrderPage.order(name, family, adres, metroPoint, number, data, period);

        MatcherAssert.assertThat(objOrderPage.headerOrderConfirm(), containsString("Заказ оформлен"));
    }