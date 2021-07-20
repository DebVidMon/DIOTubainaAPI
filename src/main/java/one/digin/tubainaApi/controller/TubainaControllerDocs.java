package one.digin.tubainaApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import one.digin.tubainaApi.dto.TubainaDTO;
import one.digin.tubainaApi.exception.TubainaAlreadyRegisteredException;
import one.digin.tubainaApi.exception.TubainaNotFoundException;

@Api("Manages tubaina stock")
public interface TubainaControllerDocs {

    @ApiOperation(value = "Tubaina creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success beer creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    TubainaDTO createTubaina(TubainaDTO tubainaDTO) throws TubainaAlreadyRegisteredException;

    @ApiOperation(value = "Returns tubaina found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success tubaina found in the system"),
            @ApiResponse(code = 404, message = "Tubaina with given name not found.")
    })
    TubainaDTO findByName(@PathVariable String name) throws TubainaNotFoundException;

    @ApiOperation(value = "Returns a list of all tubainas registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all tubainas registered in the system"),
    })
    List<TubainaDTO> listTubainas();

    @ApiOperation(value = "Delete a tubaina found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success tubaina deleted in the system"),
            @ApiResponse(code = 404, message = "Tubaina with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws TubainaNotFoundException;
}