package comfama.propuestacultural.controllers;

import comfama.propuestacultural.dtos.ProposalDTO;
import comfama.propuestacultural.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/proposals")
public class ProposalController {

    @Autowired
    ProposalService proposalService;

    @PostMapping
    public ResponseEntity<?> addProposal(@RequestBody ProposalDTO proposalDTO) {
        try {
            ProposalDTO addedProposal = proposalService.addProposal(proposalDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedProposal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProposals() {
        try {
            List<ProposalDTO> proposals = proposalService.getAllProposals();
            return ResponseEntity.status(HttpStatus.OK).body(proposals);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProposalById(@PathVariable Integer id) {
        try {
            ProposalDTO proposal = proposalService.searchProposaltById(id);
            return ResponseEntity.status(HttpStatus.OK).body(proposal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProposal(@PathVariable Integer id, @RequestBody ProposalDTO proposalDTO) {
        try {
            ProposalDTO updatedProposal = proposalService.updateProposal(id, proposalDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProposal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
