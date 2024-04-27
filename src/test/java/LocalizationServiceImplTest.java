import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {
    @Test
    @DisplayName("метод locale(Country country)")
    public void testLocale() {
        //Arrange
        Country country = Country.RUSSIA;
        LocalizationService localizationService = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        //Act
        String actual = localizationService.locale(country);

        //Assert
        assertEquals(expected, actual);
    }
}
