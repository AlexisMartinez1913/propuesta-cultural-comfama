package comfama.propuestacultural.controllers;

import comfama.propuestacultural.dtos.AttachedDocumentDTO;
import comfama.propuestacultural.dtos.errorsDTO.AttachedDocumentErrorDTO;
import comfama.propuestacultural.dtos.errorsDTO.DocumentTypeErrorDTO;
import comfama.propuestacultural.models.AttachedDocument;
import comfama.propuestacultural.models.DocumentType;
import comfama.propuestacultural.services.AttachedDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/attached-documents")
public class AttachedDocumentController {

    @Autowired
    AttachedDocumentService attachedDocumentService;

    @PostMapping
    public ResponseEntity<?> addAttachedDocument(@RequestBody AttachedDocumentDTO attachedDocumentDTO) {
        try {
            AttachedDocumentDTO savedDocument = attachedDocumentService.addAttachedDocument(attachedDocumentDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDocument);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllAttachedDocuments() {
        try {
            List<AttachedDocumentDTO> documents = attachedDocumentService.getAllAttachedDocuments();
            return ResponseEntity.status(HttpStatus.OK).body(documents);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttachedDocumentById(@PathVariable Integer id) {
        try {
            AttachedDocumentDTO document = attachedDocumentService.searchAttachedDocumentById(id);
            return ResponseEntity.status(HttpStatus.OK).body(document);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modifyDocument (@RequestBody AttachedDocument data, @PathVariable Integer id) {
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.attachedDocumentService.modifyAttachedDocument(id, data));
        }catch( Exception error){

            AttachedDocumentErrorDTO errorDTO = new AttachedDocumentErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDTO.getErrorMessage());
        }
    }
}
