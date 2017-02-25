package com.example.controller;

import com.example.Responses;
import com.example.model.Pet;
import com.example.repository.PetRepository;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author: mike
 * @since: 2017/2/25
 */
@RestController
@RequestMapping("/pets")
@Api(value = "/pets", tags = "Pets", description = "Operations about pets")
public class PetsController {

    PetRepository petData = new PetRepository();

    @RequestMapping(value = "/{petId}", method = GET)
    @ApiOperation( value = "find a pet by ID", notes = "Returns a pet when ID < 10. ID > 10 or nonintegers will simulate API error conditions")
    @ApiResponses( value =
            {
                    @ApiResponse(code = 400, message = "Invalid ID supplied"),
                    @ApiResponse(code = 404, message = "Pet not found")
            }
    )

    public Pet getPetById(@ApiParam(value = "ID of pet that needs to be fetched", allowableValues = "range[1,5]", required = true, defaultValue = "1")
                              @PathVariable long petId) throws NotFoundException{

        Pet pet = petData.get(petId);
        if (null != pet) {
            return pet;
        } else {
            throw new NotFoundException(404, "Pet not found");
        }
    }

    @RequestMapping(method = POST)
    @ApiOperation(value = "Add a new pet to the store")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input")})
    public ResponseEntity<String> addPet(
            @ApiParam(value = "Pet object that needs to be added to the store", required = true) @RequestBody Pet pet) {
        petData.add(pet);
        return Responses.ok("SUCCESS");
    }

    @RequestMapping(method = PUT)
    @ApiOperation(value = "Update an existing pet",
            authorizations = @Authorization(value = "petstore_auth", scopes = {
                    @AuthorizationScope(scope = "write_pets", description = ""),
                    @AuthorizationScope(scope = "read_pets", description = "")
            }))
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Pet not found"),
            @ApiResponse(code = 405, message = "Validation exception")})
    public ResponseEntity<String> updatePet(
            @ApiParam(value = "Pet object that needs to be added to the store", required = true) @RequestBody Pet pet) {
        petData.add(pet);
        return Responses.ok("SUCCESS");
    }

    @RequestMapping(value = "/{petId}",method = DELETE)
    @ApiOperation( value = "delte a pet by ID", notes = "Delete a pet from the store")
    public ResponseEntity<String> deletePetById(
            @ApiParam(value = "ID of pet that needs to be fetched", required = true, defaultValue = "1")
            @PathVariable long petId){
        petData.delete(petId);
        return Responses.ok("SUCCESS");
    }
}
