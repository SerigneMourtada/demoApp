package BackenProject.controller;

import BackenProject.dto.ConsultationDTO;
import BackenProject.service.consultationService.ConsultationService;
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
@RequestMapping("/consultations")
@CrossOrigin("*")
@AllArgsConstructor
public class ConsultationController {

    private ConsultationService consultationServ;

    @Operation(summary = "Read Consultation by Id", description = "Read an consultation by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ConsultationDTO> readConsultations(){
        return consultationServ.readConsultations();
    }


    @Operation(summary = "Consultation", description = "Create consultation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public ConsultationDTO saveConsultation(@Validated @RequestBody ConsultationDTO consultationDTO){
        return consultationServ.createConsultation(consultationDTO);
    }


    @Operation(summary = "Read Consultation by Id", description = "Read an Consultation by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{consultationId}")
    @ResponseStatus(HttpStatus.OK)
    public ConsultationDTO readConsultationById(@Parameter(description = "Consultation identifier", name = "consultationId", required = true) @PathVariable("consultationId") Long consultationId) {
        return consultationServ.getConsultationById(consultationId);
    }

    @Operation(summary = "Delete Consultation", description = "Delete Consultation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{consultationId}")
    public void deleteCarnet(@PathVariable("consultationId") Long consultationId){
        consultationServ.deleteConsultation(consultationId);
    }


    @Operation(summary = "Update Consultation", description = "Update Consultation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping("/{consultationId}")
    public ConsultationDTO updateConsultation(@Validated @RequestBody ConsultationDTO consultationDTO,
                                              @PathVariable("consultationId") Long consultationId){
        consultationDTO.setId(consultationId);

        return consultationServ.updateConsultation(consultationDTO);
    }
}
