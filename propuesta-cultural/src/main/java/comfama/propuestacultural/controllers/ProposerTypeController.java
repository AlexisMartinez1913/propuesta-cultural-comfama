package comfama.propuestacultural.controllers;


import comfama.propuestacultural.dtos.errorsDTO.ProposerTypeErrorDTO;
import comfama.propuestacultural.models.ProposerType;
import comfama.propuestacultural.services.ProposerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/proposertype")
public class ProposerTypeController {

    @Autowired
    ProposerTypeService proposerTypeService;

    @PostMapping()
    public ResponseEntity<?> saveProposerType(@RequestBody ProposerType data) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(this.proposerTypeService.addProposerType(data));
        } catch (Exception error) {
            ProposerTypeErrorDTO errorDTO = new ProposerTypeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO.getErrorMessage());

        }
    }

    @GetMapping
    public ResponseEntity<?> searchProposersTypes() {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.proposerTypeService.searchAllProposersTypes());
        } catch( Exception error){

            ProposerTypeErrorDTO errorDTO = new ProposerTypeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorDTO.getErrorMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchProposerTypeById(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.proposerTypeService.searchProposerTypeById(id));
        }catch( Exception error){

            ProposerTypeErrorDTO errorDTO = new ProposerTypeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorDTO.getErrorMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyProposerType (@RequestBody ProposerType data, @PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.proposerTypeService.modifyProposerType(id, data));
        }catch( Exception error){

            ProposerTypeErrorDTO errorDTO = new ProposerTypeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDTO.getErrorMessage());
        }
    }
}
