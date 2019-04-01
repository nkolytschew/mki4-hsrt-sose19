package com.github.nkolytschew.helloreutlingen.mvc;


import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

  /**
   * use Spring-Expression Language to create Map from JSON-like structure
   */
  @Value("#{${application.tmp.rest.response.map}}")
  private Map<String, String> responseModelMap;

  @Value("${application.tmp.rest.welcome.message}")
  private String welcomeMessage;

  @Value("${application.tmp.rest.pause.message}")
  private String pauseMessage;


  /**
   * default response
   */
  @RequestMapping("/")
  public ResponseModel getGreeting() {
    return new ResponseModel(welcomeMessage);
  }

  /**
   * if you had enough!
   */
  @RequestMapping("/pause")
  public ResponseModel getPause() {
    return new ResponseModel(pauseMessage);
  }

  /**
   * get response from Map for a specific ID, which is passed als Variable into this request
   */
  @GetMapping("/response/{id}")
  public ResponseModel getResponseMapById(@PathVariable String id) {
    return new ResponseModel(responseModelMap.get(id));
  }

  @GetMapping("/response")
  public Map<String, String> getResponseMap() {
    return responseModelMap;
  }

  @PostMapping("/response/{id}")
  public ResponseModel createNewResponseById(@PathVariable String id, @RequestBody String body) throws IllegalAccessException {
    if (responseModelMap.containsKey(id)) {
      throw new IllegalAccessException("Update not supported in POST!");
    }
    return new ResponseModel(responseModelMap.put(id, body));
  }

  @DeleteMapping("/response/{id}")
  public ResponseModel deleteResponseById(@PathVariable String id) {
    return new ResponseModel(responseModelMap.remove(id));
  }

  @PutMapping("/response/{id}")
  public ResponseModel updateResponseById(@PathVariable String id, @RequestBody String body) throws IllegalAccessException {
    if (responseModelMap.containsKey(id)) {
      return new ResponseModel(responseModelMap.put(id, body));
    } else {
      throw new IllegalAccessException("Create not supported in PUT!");
    }
  }
}
