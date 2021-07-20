package one.digin.tubainaApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import one.digin.tubainaApi.dto.TubainaDTO;
import one.digin.tubainaApi.entity.Tubaina;
import one.digin.tubainaApi.exception.TubainaAlreadyRegisteredException;
import one.digin.tubainaApi.exception.TubainaNotFoundException;
import one.digin.tubainaApi.exception.TubainaStockExceededException;
import one.digin.tubainaApi.mapper.TubainaMapper;
import one.digin.tubainaApi.repository.TubainaRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TubainaService {

    private final TubainaRepository tubainaRepository;
    private final TubainaMapper tubainaMapper = TubainaMapper.INSTANCE;

    public TubainaDTO createTubaina(TubainaDTO tubainaDTO) throws TubainaAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(tubainaDTO.getName());
        Tubaina tubaina = tubainaMapper.toModel(tubainaDTO);
        Tubaina savedTubaina = tubainaRepository.save(tubaina);
        return tubainaMapper.toDTO(savedTubaina);
    }

    public TubainaDTO findByName(String name) throws TubainaNotFoundException {
        Tubaina foundTubaina = tubainaRepository.findByName(name)
                .orElseThrow(() -> new TubainaNotFoundException(name));
        return tubainaMapper.toDTO(foundTubaina);
    }

    public List<TubainaDTO> listAll() {
        return tubainaRepository.findAll()
                .stream()
                .map(tubainaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws TubainaNotFoundException {
        verifyIfExists(id);
        tubainaRepository.deleteById(id);
    }

    private void verifyIfIsAlreadyRegistered(String name) throws TubainaAlreadyRegisteredException {
        Optional<Tubaina> optSavedTubaina = tubainaRepository.findByName(name);
        if (optSavedTubaina.isPresent()) {
            throw new TubainaAlreadyRegisteredException(name);
        }
    }

    private Tubaina verifyIfExists(Long id) throws TubainaNotFoundException {
        return tubainaRepository.findById(id)
                .orElseThrow(() -> new TubainaNotFoundException(id));
    }

    public TubainaDTO increment(Long id, int quantityToIncrement) throws TubainaNotFoundException, TubainaStockExceededException {
        Tubaina tubainaToIncrementStock = verifyIfExists(id);
        int quantityAfterIncrement = quantityToIncrement + tubainaToIncrementStock.getQuantity();
        if (quantityAfterIncrement <= tubainaToIncrementStock.getMax()) {
            tubainaToIncrementStock.setQuantity(tubainaToIncrementStock.getQuantity() + quantityToIncrement);
            Tubaina incrementedTubainaStock = tubainaRepository.save(tubainaToIncrementStock);
            return tubainaMapper.toDTO(incrementedTubainaStock);
        }
        throw new TubainaStockExceededException(id, quantityToIncrement);
    }
}