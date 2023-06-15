package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

/**
 * Created By dhaval on 2023-06-14
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;

    private static final String BASE_URL = "http://localhost:8080";

    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<String> stringResponse = restTemplate.getForEntity
                (BASE_URL + GET_BEER_PATH, String.class);

        ResponseEntity<Map> mapResponse = restTemplate.getForEntity
                (BASE_URL + GET_BEER_PATH, Map.class);

        log.info(stringResponse.getBody());

        log.info(Objects.requireNonNull(mapResponse.getBody()).toString());

        return null;
    }
}
