package ru.netology.geo;

import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImpl implements GeoService {

    public static final String LOCALHOST = "127.0.0.1";
    public static final String MOSCOW_IP = "172.0.32.11";
    public static final String NEW_YORK_IP = "96.44.183.149";
    public static final String GERMANY_IP = "91.0.0.1";
    public static final String BRAZIL_IP = "177.79.44.34";


    /**
     * Метод определяет локацию по ip
     */
    public Location byIp(String ip) {
        if (ip.startsWith("172.")) {
            return new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        } else if (ip.startsWith("96.")) {
            return new Location("New York", Country.USA, "10th Avenue", 32);
        } else if (ip.startsWith("91.")) {
            return new Location("Berlin", Country.GERMANY, "Augustaanlage", 17);
        } else if (ip.startsWith("177.")) {
            return new Location("Via Costeira", Country.BRAZIL, "Via Costeira", 57);
        }
        return null;
    }

    /**
     * Метод определяет локацию по координатам
     */
    public Location byCoordinates(double latitude, double longitude) {
        throw new RuntimeException("Not implemented");
    }
}

