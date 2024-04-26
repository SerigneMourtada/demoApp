package BackenProject.controller;

import BackenProject.dto.VaccinDTO;
import BackenProject.dto.VaccinationCreationRequest;
import BackenProject.dto.VaccinationDTO;
import BackenProject.service.vaccinationService.VaccinationService;
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

@RequestMapping("/vaccinations")
@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class VaccinationController {
    private VaccinationService vaccinationService;

    @Operation(summary = "Read Vaccination by Id", description = "Read Vaccination by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VaccinationDTO> readVaccinations(){
        return vaccinationService.readVaccinations();
    }





    @Operation(summary = "Vaccin", description = "Create Vaccin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public VaccinationDTO saveVaccination(@Validated @RequestBody VaccinationCreationRequest vaccinationCreationRequest){
        return vaccinationService.createVaccination(vaccinationCreationRequest);
    }





    @Operation(summary = "Read Vaccination by Id", description = "Read an Vaccination by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })

    @GetMapping("/{vaccinationId}")
    @ResponseStatus(HttpStatus.OK)
    public VaccinationDTO readVaccinationById(@Parameter(description = "Vaccin identifier", name = "vaccinationId", required = true) @PathVariable("vaccinationId") Long vaccinationId) {
        return vaccinationService.getVaccinationById(vaccinationId);
    }


    @Operation(summary = "Read Vaccination by Id", description = "Read an Vaccination by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })

    @GetMapping("/carnet/{carnetId}")
    @ResponseStatus(HttpStatus.OK)
    public List<VaccinationDTO> getVaccinationsByCarnetId(@Parameter(description = "Vaccin identifier", name = "vaccinationId", required = true) @PathVariable("carnetId") Long carnetId) {
        return vaccinationService.getVaccinationByIdCarnet(carnetId);
    }





    @Operation(summary = "Delete Vaccination", description = "Delete Vaccination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{vaccinationId}")
    public void deleteVaccination(@PathVariable("vaccinationId") Long vaccinationId){

        vaccinationService.deleteVaccination(vaccinationId);
    }


    @Operation(summary = "Update Vaccin", description = "Update Vaccin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping("/{vaccinationId}")
    public VaccinationDTO updateVaccination(@Validated @RequestBody VaccinationDTO vaccinationDTO,
                                  @PathVariable("vaccinationId") Long vaccinationId){
        vaccinationDTO.setId(vaccinationId);

        return vaccinationService.updateVaccination(vaccinationDTO);
    }
}
