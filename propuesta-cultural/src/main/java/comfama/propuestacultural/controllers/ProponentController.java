package comfama.propuestacultural.controllers;

import comfama.propuestacultural.dtos.ProponentDTO;
import comfama.propuestacultural.services.ProponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/proponent")
public class ProponentController {
    @Autowired
    ProponentService proponentService;

    @PostMapping
    public ResponseEntity<?> addProponent(@RequestBody ProponentDTO proponentDTO) {
        try {
            ProponentDTO addedProponent = proponentService.addProponent(proponentDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedProponent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProponents() {
        try {
            List<ProponentDTO> proponents = proponentService.getAllProponents();
            return ResponseEntity.status(HttpStatus.OK).body(proponents);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProponentById(@PathVariable UUID id) {
        try {
            ProponentDTO proponent = proponentService.searchProponentById(id);
            return ResponseEntity.status(HttpStatus.OK).body(proponent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProponent(@PathVariable UUID id, @RequestBody ProponentDTO proponentDTO) {
        try {
            ProponentDTO updatedProponent = proponentService.updateProponent(id, proponentDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProponent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
