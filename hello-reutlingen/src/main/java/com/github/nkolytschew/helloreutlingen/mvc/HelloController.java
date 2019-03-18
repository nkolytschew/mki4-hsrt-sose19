package com.github.nkolytschew.helloreutlingen.mvc;


import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final Map<String, ResponseModel> responseModelMap;

  /**
   * initialize and populate Map for Example
   */
  public HelloController() {
    this.responseModelMap = new HashMap<>();
    responseModelMap.put("1", new ResponseModel("Resposne mit Message 1"));
    responseModelMap.put("2", new ResponseModel("Resposne mit Message 2"));
    responseModelMap.put("3", new ResponseModel("Resposne mit Message 3"));
    responseModelMap.put("4", new ResponseModel("Resposne mit Message 4"));
    responseModelMap.put("5", new ResponseModel("Resposne mit Message 5"));
    responseModelMap.put("6", new ResponseModel("Resposne mit Message 6"));
    responseModelMap.put("7", new ResponseModel("Resposne mit Message 7"));
    responseModelMap.put("8", new ResponseModel("Resposne mit Message 7"));
    responseModelMap.put("9", new ResponseModel("Resposne mit Message 8"));
  }

  /**
   * default response
   */
  @RequestMapping("/")
  public ResponseModel getGreeting() {
    return new ResponseModel("hello reutlingen");
  }

  /**
   * if you had enough!
   */
  @RequestMapping("/pause")
  public ResponseModel getPause() {
    return new ResponseModel("alter mach ma pause!");
  }

  /**
   * get response from Map for a specific ID, which is passed als Variable into this request
   */
  @GetMapping("/response/{id}")
  public ResponseModel getResponseMapById(@PathVariable String id) {
    return responseModelMap.get(id);
  }

  // post, delete, put follows
  // analog to GetMapping
}
