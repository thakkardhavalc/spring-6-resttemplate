package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By dhaval on 2023-06-14
 */
@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void testUpdateBeer() {
        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs 2")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("1234567890")
                .build();

        BeerDTO beerDTO = beerClient.createBeer(newDto);

        final String newName = "Mango Bobs 3";
        beerDTO.setBeerName(newName);
        BeerDTO updateBeer = beerClient.updateBeer(beerDTO);

        assertThat(updateBeer.getBeerName()).isEqualTo(newName);
    }

    @Test
    void testCreateBeer() {

        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("123456789987")
                .build();

        BeerDTO savedDto = beerClient.createBeer(newDto);
        assertThat(savedDto).isNotNull();
    }

    @Test
    void getBeerById() {

        Page<BeerDTO> beerDTOS = beerClient.listBeers();

        BeerDTO dto = beerDTOS.getContent().get(0);

        BeerDTO byId = beerClient.getBeerById(dto.getId());

        assertThat(byId).isNotNull();
    }

    @Test
    void listBeersNoBeerName() {

        beerClient.listBeers(null, null, null, null, null);
    }

    @Test
    void listBeers() {

        beerClient.listBeers("ALE", null, null, null, null);
    }
}