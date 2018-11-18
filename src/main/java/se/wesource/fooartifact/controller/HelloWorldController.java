package se.wesource.fooartifact.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.wesource.fooartifact.integration.QuotersService;
import se.wesource.fooartifact.model.Greeting;

@RestController
public class HelloWorldController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

  @Autowired
    private QuotersService quotersService;



  @GetMapping("/hello-world")
	public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}


  @GetMapping("/quote")
  public String getQuote() {
    return quotersService.getQuote();
  }

  @GetMapping("/null")
  public String getNullpointer() {
    throw new NullPointerException();
  }
}
