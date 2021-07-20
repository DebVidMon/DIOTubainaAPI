package one.digin.tubainaApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TubainaNotFoundException extends Exception {

    public TubainaNotFoundException(String beerName) {
        super(String.format("Tubaina with name %s not found in the system.", beerName));
    }

    public TubainaNotFoundException(Long id) {
        super(String.format("Tubaina with id %s not found in the system.", id));
    }
}
