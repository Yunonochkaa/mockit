package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    @Test
    public void testLocale_Russia() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String message = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals("Добро пожаловать", message);
    }

    @Test
    public void testLocale_Usa() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String message = localizationService.locale(Country.USA);

        Assertions.assertEquals("Welcome", message);
    }

    @Test
    public void testLocale_Germany() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String message = localizationService.locale(Country.GERMANY);

        Assertions.assertEquals("Willkommen", message);
    }

    @Test
    public void testLocale_Brazil() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String message = localizationService.locale(Country.BRAZIL);

        Assertions.assertEquals("Saudacao", message);
    }
}

