package pl.iwona.modol5ex2.model;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "speed",
        "deg"
})
public class Wind {
  public Wind(Double speed, Integer deg, Map<String, Object> additionalProperties) {
    this.speed = speed;
    this.deg = deg;
    this.additionalProperties = additionalProperties;
  }

  public Wind() {
  }

  @JsonProperty("speed")
  private Double speed;
  @JsonProperty("deg")
  private Integer deg;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("speed")
  public Double getSpeed() {
    return speed;
  }

  @JsonProperty("speed")
  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  @JsonProperty("deg")
  public Integer getDeg() {
    return deg;
  }

  @JsonProperty("deg")
  public void setDeg(Integer deg) {
    this.deg = deg;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    return "Wind{"
               + "speed=" + speed
               + ", deg=" + deg
               + ", additionalProperties=" + additionalProperties
               + '}';
  }
}
