package iwona.pl.modol5ex2.service;


import iwona.pl.modol5ex2.model.WeatherFirst;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

//  public final static String BASEURL = "https://api.openweathermap.org/data/2.5/weather?q=";
    public final static String APIKEY = "82236e5edad3e6fe2626ae93f4e4b3aa";
    private String city = "Wroclaw";
// public String newUrl = BASEURL + getCity() + "&appid=" + APIKEY; - w ten sposób nie aktualizują się dane
// public String iconUrl= "http://openweathermap.org/img/wn/" + getImage();

    public WeatherFirst getWeatherInfo() {
        RestTemplate restTemplate = new RestTemplate();
        WeatherFirst weather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q="+getCity()+"&appid=" + APIKEY,
                 WeatherFirst.class);
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
        return "http://openweathermap.org/img/wn/" + icon + "@2x.png";
    }
}

