package one.digin.tubainaApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TubainaStockExceededException extends Exception {

    public TubainaStockExceededException(Long id, int quantityToIncrement) {
        super(String.format("Beers with %s ID to increment informed exceeds the max stock capacity: %s", id, quantityToIncrement));
    }
}
