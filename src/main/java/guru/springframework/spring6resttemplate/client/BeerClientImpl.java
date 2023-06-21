package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created By dhaval on 2023-06-14
 */
@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;

    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public BeerDTOPageImpl listBeers() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        ResponseEntity<BeerDTOPageImpl> stringResponse =
                restTemplate.getForEntity(uriComponentsBuilder.toUriString() , BeerDTOPageImpl.class);


        return stringResponse.getBody();
    }
}
