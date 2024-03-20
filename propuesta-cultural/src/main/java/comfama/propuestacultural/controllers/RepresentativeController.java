package comfama.propuestacultural.controllers;

import comfama.propuestacultural.dtos.RepresentativeDTO;
import comfama.propuestacultural.dtos.errorsDTO.DocumentTypeErrorDTO;
import comfama.propuestacultural.dtos.errorsDTO.RepresentativeErrorDTO;
import comfama.propuestacultural.models.DocumentType;
import comfama.propuestacultural.models.Representative;
import comfama.propuestacultural.services.RepresentativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/representatives")
public class RepresentativeController {
    @Autowired
    RepresentativeService representativeService;


    @PostMapping()
    public ResponseEntity<?> saveRepresentative(@RequestBody Representative data) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(this.representativeService.addRepresentative(data));
        } catch (Exception error) {
            RepresentativeErrorDTO errorDTO = new RepresentativeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO.getErrorMessage());

        }
    }

    @GetMapping
    public ResponseEntity<?> searchRepresentatives() {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.representativeService.searchAllRepresentatives());
        } catch( Exception error){

            RepresentativeErrorDTO errorDTO = new RepresentativeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorDTO.getErrorMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchRepresentativeById(@PathVariable Integer id) {
        try {
            RepresentativeDTO representativeDTO = representativeService.searchRepresentativeById(id);
            return ResponseEntity.status(HttpStatus.OK).body(representativeDTO);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyRepresentative (@RequestBody Representative data, @PathVariable Integer id) {
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.representativeService.modifyRepresentative(id, data));
        }catch( Exception error){

            RepresentativeErrorDTO errorDTO = new RepresentativeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDTO.getErrorMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRepresentative(@PathVariable Integer id) {
        try {
            representativeService.deleteRepresentative(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }
}
