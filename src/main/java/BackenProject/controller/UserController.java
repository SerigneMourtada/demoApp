package BackenProject.controller;

import BackenProject.dto.CentreDTO;
import BackenProject.dto.UserDTO;
import BackenProject.service.userService.UserService;
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
@RequestMapping(value = "/users")
@AllArgsConstructor
@CrossOrigin("*")

public class UserController {

    private UserService utilisateurService;

    @Operation(summary = "Read Utilisateur by Id", description = "Read an utilisateur by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> readUtilisateurs(){
        return utilisateurService.readUtilisateurs();
    }


    @Operation(summary = "Utilisateur", description = "Create utiisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public UserDTO createUser(@Validated @RequestBody UserDTO utilisateurDTO){
        return utilisateurService.createUser(utilisateurDTO);
    }

    @Operation(summary = "Read Utilisateur by Id", description = "Read an Utilisateur by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{utilisateurId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO readUtilisateurById(@Parameter(description = "Utilisateur identifier", name = "utilisateurId", required = true) @PathVariable("utilisateurId") Long utilisateurId) {
        return utilisateurService.getUtilisateurById(utilisateurId);
    }





    @Operation(summary = "Delete Utilisateur", description = "Delete Utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{utilisateurId}")
    public void deleteUtilisateur(@PathVariable("utilisateurId") Long utilisateurId){
        utilisateurService.deleteUtilisateur(utilisateurId);
    }


    @Operation(summary = "Update Centre", description = "Update Centre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping("/{userId}")
    public UserDTO updateCentre(@Validated @RequestBody UserDTO userDTO,
                                  @PathVariable("userId") Long userId){
        userDTO.setId(userId);

        return utilisateurService.updateUtilisateur(userDTO);
    }



}
