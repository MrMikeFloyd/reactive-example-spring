package de.maik.reactiverestclient;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.assertj.core.api.Assertions.assertThat;

class WebClientStockClientTest {

    @Test
    void shouldRetrieveFiveStockPricesFromServer() {
        // Given
        WebClientStockClient webClientStockClient = new WebClientStockClient(WebClient.builder().build());
        // When
        Flux<StockPrice> prices = webClientStockClient.pricesFor("SYMBOL");
        // Then
        assertThat(prices).isNotNull();
        Flux<StockPrice> fivePrices = prices.take(5);
        assertThat(fivePrices.count().block()).isEqualTo(5);
        assertThat(fivePrices.blockFirst().getSymbol()).isEqualTo("SYMBOL");
    }

}