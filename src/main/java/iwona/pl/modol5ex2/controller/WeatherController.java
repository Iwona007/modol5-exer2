package iwona.pl.modol5ex2.controller;


import iwona.pl.modol5ex2.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weatherCity")
public class WeatherController {

  private WeatherService weatherService;

  @Autowired
  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping
  public String getWeather(Model model) {
    model.addAttribute("weatherCity", weatherService.getWeatherInfo());
    model.addAttribute("iconForWeather", weatherService.getImage());
    model.addAttribute("city", new WeatherService());
    return "weather";
  }

  @PostMapping("/city")
   public String chooseCity(@RequestParam String city) {
    weatherService.setCity(city);
    return "redirect:/weatherCity";
  }
}
