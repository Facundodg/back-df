package Api.Gateway.globalFilters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class GlobalFilter implements org.springframework.cloud.gateway.filter.GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("ejemplo de filtro pre GLOBAL");

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {

            log.info("ejemplo de filtro post GLOBAL");

            exchange.getResponse().getCookies().add("color", ResponseCookie.from("color","rojo").build());
            //exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);

        }));

    }

    @Override
    public int getOrder() {
        return 1;
    }
}
