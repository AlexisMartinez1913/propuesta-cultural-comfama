package comfama.propuestacultural.services;

import comfama.propuestacultural.dtos.ProposalDTO;
import comfama.propuestacultural.helpers.State;
import comfama.propuestacultural.models.Proponent;
import comfama.propuestacultural.models.Proposal;
import comfama.propuestacultural.repositories.IProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProposalService {
    @Autowired
    IProposalRepository IProposalRepository;

    public ProposalDTO addProposal(ProposalDTO proposalDTO) throws Exception {
        try {
            Proposal proposal = new Proposal();
            // Aquí puedes asignar los valores del DTO al objeto Proposal
            proposal.setName_proposal(proposalDTO.getName_proposal());
            proposal.setDescription_activities(proposalDTO.getDescription_activities());
            proposal.setDescription_proposal(proposalDTO.getDescription_proposal());
            proposal.setDate_presentation(proposalDTO.getDate_presentation());

            proposal.setState_proposal(State.valueOf(proposalDTO.getState_proposal()));


            Proponent proponent = new Proponent();
            proponent.setId_proponent(proposalDTO.getProponent_id());

            Proposal savedProposal = IProposalRepository.save(proposal);
            return convertToDTO(savedProposal);
        } catch (Exception error) {
            throw new Exception("Error to save the proposal: " + error.getMessage());
        }
    }

    public List<ProposalDTO> getAllProposals() throws Exception {
        try {
            List<Proposal> proposals = IProposalRepository.findAll();
            return convertToDTOList(proposals);
        } catch (Exception error) {
            throw new Exception("Error to get the proposals: " + error.getMessage());
        }
    }

    public ProposalDTO searchProposaltById(Integer id) throws Exception {
        try {
            Optional<Proposal> proposalOptional = IProposalRepository.findById(id);
            if (proposalOptional.isPresent()) {
                Proposal proposal = proposalOptional.get();
                return convertToDTO(proposal);
            } else {
                throw new Exception("Proponent not found");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public ProposalDTO updateProposal(Integer id, ProposalDTO proposalDTO) throws Exception {
        try {
            Optional<Proposal> optionalProposal = IProposalRepository.findById(id);
            if (optionalProposal.isPresent()) {
                Proposal existingProposal = optionalProposal.get();
                existingProposal.setName_proposal(proposalDTO.getName_proposal());
                existingProposal.setDescription_activities(proposalDTO.getDescription_activities());
                existingProposal.setDescription_proposal(proposalDTO.getDescription_proposal());
                existingProposal.setDate_presentation(proposalDTO.getDate_presentation());
                existingProposal.setState_proposal(State.valueOf(proposalDTO.getState_proposal()));

                Proponent proponent = new Proponent();
                proponent.setId_proponent(proposalDTO.getProponent_id());
                existingProposal.setProponent(proponent);

                Proposal updatedProposal = IProposalRepository.save(existingProposal);
                return convertToDTO(updatedProposal);
            } else {
                throw new Exception("Proponent not found");
            }
        } catch (Exception error) {
            throw new Exception("Error to update the proponent: " + error.getMessage());
        }
    }



    private ProposalDTO convertToDTO(Proposal proposal) {
        ProposalDTO dto = new ProposalDTO();
        dto.setName_proposal(proposal.getName_proposal());
        dto.setDescription_activities(proposal.getDescription_activities());
        dto.setDescription_proposal(proposal.getDescription_proposal());
        dto.setDate_presentation(proposal.getDate_presentation());

        if (proposal.getProponent() != null) {
            dto.setProponent_id(proposal.getProponent().getId_proponent());
        }

        dto.setState_proposal(proposal.getState_proposal().toString());



        return dto;
    }

    private List<ProposalDTO> convertToDTOList(List<Proposal> proposalList) {
        return proposalList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
