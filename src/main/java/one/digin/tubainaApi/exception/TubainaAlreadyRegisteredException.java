package one.digin.tubainaApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TubainaAlreadyRegisteredException extends Exception{

    public TubainaAlreadyRegisteredException(String beerName) {
        super(String.format("Tubaina with name %s already registered in the system.", beerName));
    }
}
