package comfama.propuestacultural.controllers;

import comfama.propuestacultural.dtos.ProposedValueDTO;
import comfama.propuestacultural.dtos.errorsDTO.ProposedValueErrorDTO;
import comfama.propuestacultural.models.ProposedValue;
import comfama.propuestacultural.services.ProposedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/proposed-value")
public class ProposedValueController {
    @Autowired
    ProposedValueService proposedValueService;

    @PostMapping()
    public ResponseEntity<?> saveProposedValue(@RequestBody ProposedValue data) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(this.proposedValueService.addProposedValue(data));
        } catch (Exception error) {
            ProposedValueErrorDTO errorDTO = new ProposedValueErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO.getErrorMessage());

        }
    }

    @GetMapping
    public ResponseEntity<?> searchProposedValue() {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.proposedValueService.searchAllProposedValues());
        } catch( Exception error){

            ProposedValueErrorDTO errorDTO = new ProposedValueErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorDTO.getErrorMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchProposedValueById(@PathVariable Integer id) {
        try {
            ProposedValueDTO proposedValueDTO = proposedValueService.searchProposedValueById(id);
            return ResponseEntity.status(HttpStatus.OK).body(proposedValueDTO);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyProposedValue (@RequestBody ProposedValue data, @PathVariable Integer id) {
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.proposedValueService.modifyProposedValue(id, data));
        }catch( Exception error){

            ProposedValueErrorDTO errorDTO = new ProposedValueErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDTO.getErrorMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProposedValue(@PathVariable Integer id) {
        try {
            proposedValueService.deleteProposedValue(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }
}
