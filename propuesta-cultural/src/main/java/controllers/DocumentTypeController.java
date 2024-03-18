package controllers;

import comfama.propuestacultural.dtos.errorsDTO.DocumentTypeErrorDTO;
import comfama.propuestacultural.models.DocumentType;
import comfama.propuestacultural.services.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/document")
public class DocumentTypeController {
    @Autowired
    DocumentTypeService documentTypeService;

    @PostMapping
    public ResponseEntity<?> saveDocument(@RequestBody DocumentType data) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(this.documentTypeService.addDocumentType(data));
        } catch (Exception error) {
            DocumentTypeErrorDTO errorDTO = new DocumentTypeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO.getErrorMessage());

        }
    }

    @GetMapping
    public ResponseEntity<?> searchDocuments() {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.documentTypeService.searchAllTypesDocuments());
        } catch( Exception error){

            DocumentTypeErrorDTO errorDTO = new DocumentTypeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorDTO.getErrorMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchDocument(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.documentTypeService.searchDocumentTypeById(id));
        }catch( Exception error){

            DocumentTypeErrorDTO errorDTO = new DocumentTypeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorDTO.getErrorMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyDocument (@RequestBody DocumentType data, Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.documentTypeService.modifyDocumentType(id, data));
        }catch( Exception error){

            DocumentTypeErrorDTO errorDTO = new DocumentTypeErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDTO.getErrorMessage());
        }
    }


}
