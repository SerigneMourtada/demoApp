package BackenProject.controller;

import BackenProject.dto.CentreDTO;
import BackenProject.service.centreService.CentreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/centres")
@CrossOrigin("*")
@AllArgsConstructor

public class CentreController {
    private CentreService centreService;

    @Operation(summary = "Read Centre by Id", description = "Read an centre by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CentreDTO> readCarnets(){
        return centreService.getAllCentre();
    }

    @Operation(summary = "Centre", description = "Create centre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public CentreDTO saveCentre(@Validated @RequestBody CentreDTO centreDTO){
        return centreService.saveCentreVaccination(centreDTO);
    }



    @Operation(summary = "Read Centre by Id", description = "Read an Centre by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{centreId}")
    @ResponseStatus(HttpStatus.OK)
    public CentreDTO readCentreById(@Parameter(description = "Centre identifier", name = "centreId", required = true) @PathVariable("carnetId") Long centreId) {
        return centreService.getCentreById(centreId);
    }



    @Operation(summary = "Delete Centre ", description = "Delete Centre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{centreId}")
    public void deleteCarnet(@PathVariable("centreId") Long centreId){

        centreService.deleteCentre(centreId);
    }

    @Operation(summary = "Update Centre", description = "Update Centre")
            @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping("/{centreId}")
    public CentreDTO updateCentre(@Validated @RequestBody CentreDTO centreDTO,
                                  @PathVariable("centreId") Long centreId){
        centreDTO.setId(centreId);

        return centreService.updateCentre(centreDTO);
    }


}
