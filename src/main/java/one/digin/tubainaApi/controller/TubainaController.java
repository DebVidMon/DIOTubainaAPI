package one.digin.tubainaApi.controller;

import org.springframework.web.bind.annotation.*;
import lombok.*;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import one.digin.tubainaApi.dto.QuantityDTO;
import one.digin.tubainaApi.dto.TubainaDTO;
import one.digin.tubainaApi.exception.TubainaAlreadyRegisteredException;
import one.digin.tubainaApi.exception.TubainaNotFoundException;
import one.digin.tubainaApi.exception.TubainaStockExceededException;
import one.digin.tubainaApi.service.TubainaService;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TubainaController implements TubainaControllerDocs {

    private final TubainaService tubainaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TubainaDTO createTubaina(@RequestBody @Valid TubainaDTO tubainaDTO) throws TubainaAlreadyRegisteredException {
        return tubainaService.createTubaina(tubainaDTO);
    }

    @GetMapping("/{name}")
    public TubainaDTO findByName(@PathVariable String name) throws TubainaNotFoundException {
        return tubainaService.findByName(name);
    }

    @GetMapping
    public List<TubainaDTO> listTubainas() {
        return tubainaService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws TubainaNotFoundException {
        tubainaService.deleteById(id);
    }

    @PatchMapping("/{id}/increment")
    public TubainaDTO increment(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws TubainaNotFoundException, TubainaStockExceededException {
        return tubainaService.increment(id, quantityDTO.getQuantity());
    }
}
