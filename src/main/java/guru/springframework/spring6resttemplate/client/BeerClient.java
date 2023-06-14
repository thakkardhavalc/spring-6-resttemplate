package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import org.springframework.data.domain.Page;

/**
 * Created By dhaval on 2023-06-14
 */
public interface BeerClient {

    Page<BeerDTO> listBeers();
}
