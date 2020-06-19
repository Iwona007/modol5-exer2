package pl.iwona.modol5ex2.service;


import pl.iwona.modol5ex2.model.WeatherFirst;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

  public final static String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
  public final static String API_KEY = "82236e5edad3e6fe2626ae93f4e4b3aa";
  private String city = "Wroclaw";
  public final static String NEW_URL = "&appid=" + API_KEY;
  public final static String ICON_URL = "http://openweathermap.org/img/wn/";

  public WeatherFirst getWeatherInfo() {
    RestTemplate restTemplate = new RestTemplate();
    WeatherFirst weather = restTemplate
            .getForObject(BASE_URL + getCity() + NEW_URL, WeatherFirst.class);
    System.out.println(weather);
    return weather;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getImage() {
    String icon = getWeatherInfo().getWeather().get(0).getIcon();
    return ICON_URL + icon + "@2x.png";
  }
}

