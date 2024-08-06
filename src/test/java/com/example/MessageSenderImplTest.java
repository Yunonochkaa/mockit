package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class MessageSenderImplTest {

    @Test
    public void testSend_RussiaIp() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        when(geoService.byIp(anyString())).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        String message = messageSender.send(headers);
        Assertions.assertEquals("Добро пожаловать", message);
    }

    @Test
    public void testSend_UsaIp() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        when(geoService.byIp(anyString())).thenReturn(new Location("New York", Country.USA, "10th Avenue", 32));
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String message = messageSender.send(headers);
        Assertions.assertEquals("Welcome", message);
    }

    @Test
    public void testSend_GermanyIp() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        when(geoService.byIp(anyString())).thenReturn(new Location("Berlin", Country.GERMANY, "Augustaanlage", 17));
        when(localizationService.locale(Country.GERMANY)).thenReturn("Willkommen");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "91.0.0.1");

        String message = messageSender.send(headers);
        Assertions.assertEquals("Willkommen", message);
    }

    @Test
    public void testSend_BrazilIp() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        when(geoService.byIp(anyString())).thenReturn(new Location("Brazilia", Country.BRAZIL, "Via Costeira", 57));
        when(localizationService.locale(Country.BRAZIL)).thenReturn("Saudacao");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "177.79.44.34");

        String message = messageSender.send(headers);
        Assertions.assertEquals("Saudacao", message);
    }
}

