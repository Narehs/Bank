package com.neovision.bank.currencyConvert

import com.neovision.bank.currencyConvert.config.ExchangeConfig
import com.neovision.bank.utils.NumberUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Component
class CurrencyExchange {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders headers;

    BigDecimal getRate(String from, String to) {
        HttpEntity<?> entity = new HttpEntity<>(headers)
        String uRI = buildURI(from, to)
        ResponseEntity<String> responseEntity
        responseEntity = restTemplate.exchange(uRI, HttpMethod.GET, entity, String.class)
        return BigDecimal.valueOf(NumberUtils.toDouble(responseEntity.getBody()))
    }

    private static String buildURI(String from, String to) {
        UriComponentsBuilder builder = new UriComponentsBuilder()
        builder.scheme(ExchangeConfig.exchangeScheme)
        builder.host(ExchangeConfig.exchangeHost)
        builder.path(ExchangeConfig.exchangePath)
        builder.queryParam("q", ExchangeConfig.exchangeQ)
        builder.queryParam("from", from)
        builder.queryParam("to", to)
        return builder.build().toUriString()
    }
}
