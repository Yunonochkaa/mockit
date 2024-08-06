package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    @Test
    public void testByIp_RussiaIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("172.0.32.11");

        Assertions.assertNotNull(location);
        Assertions.assertEquals(Country.RUSSIA, location.getCountry());
    }

    @Test
    public void testByIp_UsaIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("96.44.183.149");

        Assertions.assertNotNull(location);
        Assertions.assertEquals(Country.USA, location.getCountry());
    }

    @Test
    public void testByIp_GermanyIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("91.0.0.1");

        Assertions.assertNotNull(location);
        Assertions.assertEquals(Country.GERMANY, location.getCountry());
    }

    @Test
    public void testByIp_BrazilIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("177.79.44.34");

        Assertions.assertNotNull(location);
        Assertions.assertEquals(Country.BRAZIL, location.getCountry());
    }
}
