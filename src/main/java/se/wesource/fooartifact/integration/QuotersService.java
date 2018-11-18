package se.wesource.fooartifact.integration;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.wesource.fooartifact.integration.dto.Quote;

@Service
@Slf4j
public class QuotersService {

    public String getQuote() {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
       log.info(quote.toString());
        return quote.toString();
    }
}
