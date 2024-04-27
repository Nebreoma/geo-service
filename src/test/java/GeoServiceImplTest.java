import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTest {
    @Test
    @DisplayName("метод byIp(String ip)")
    public void TestByIp() {
        //Arrange
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        //Act
        Location actual = geoService.byIp("172.0.32.11");
        //Assert
        assertEquals(expected.getCity(), actual.getCity());
        assertEquals(expected.getCountry(), actual.getCountry());
        assertEquals(expected.getStreet(), actual.getStreet());
        assertEquals(expected.getBuiling(), actual.getBuiling());
    }
}
