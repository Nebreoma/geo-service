import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MessageSenderImplTest {
    @Test
    @DisplayName("отправляет только русский текст")
    public void testSendRussian() {
        //Arrange
        Map<String, String> map = new HashMap<>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER,"172.0.32.11");
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoService mockGeoService = Mockito.mock(GeoService.class);
        Mockito.when(mockGeoService.byIp("172.0.32.11")).thenReturn(location);
        LocalizationService mockLocalizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(mockLocalizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        MessageSender messageSenderImpl = new MessageSenderImpl (mockGeoService, mockLocalizationService);
        String expected = "Добро пожаловать";
        //Act
        String actual = messageSenderImpl.send(map);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("отправляет только английский текст")
    public void testSendEnglish() {
        //Arrange
        Map<String, String> map = new HashMap<>();
        map.put(MessageSenderImpl.IP_ADDRESS_HEADER,"96.44.183.149");
        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        GeoService mockGeoService = Mockito.mock(GeoService.class);
        Mockito.when(mockGeoService.byIp("96.44.183.149")).thenReturn(location);
        LocalizationService mockLocalizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(mockLocalizationService.locale(Country.USA)).thenReturn("Welcome");
        MessageSender messageSenderImpl = new MessageSenderImpl (mockGeoService, mockLocalizationService);
        String expected = "Welcome";
        //Act
        String actual = messageSenderImpl.send(map);
        //Assert
        assertEquals(expected, actual);
    }

}
