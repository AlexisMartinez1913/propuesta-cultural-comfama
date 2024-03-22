package comfama.propuestacultural.services;

import comfama.propuestacultural.dtos.ProposedValueDTO;
import comfama.propuestacultural.models.ProposedValue;

import comfama.propuestacultural.repositories.IProposedValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProposedValueService {
    @Autowired
    IProposedValueRepository IProposedValueRepository;

    public ProposedValueDTO addProposedValue(ProposedValue proposedValueData) throws Exception {
        try {
            ProposedValue savedProposedValue =  IProposedValueRepository.save(proposedValueData);
            return convertToDTO(savedProposedValue);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public ProposedValueDTO searchProposedValueById(Integer id) throws Exception {
        try {
            Optional<ProposedValue> proposedValueOptional = IProposedValueRepository.findById(id);
            if (proposedValueOptional.isPresent()) {
                ProposedValue proposedValue = proposedValueOptional.get();
                return convertToDTO(proposedValue);
            } else {
                throw new Exception("Proposed Value not found");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public List<ProposedValueDTO> searchAllProposedValues() throws Exception {
        try {
            List<ProposedValue> proposedValueList = IProposedValueRepository.findAll();
            return convertToDTOList(proposedValueList);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public ProposedValueDTO modifyProposedValue(Integer id, ProposedValue proposedValue) throws Exception {
        Optional<ProposedValue> optionalProposedValue = IProposedValueRepository.findById(id);
        if (optionalProposedValue.isPresent()) {
            ProposedValue existingProposedValue = optionalProposedValue.get();
            // Actualizar
            existingProposedValue.setTotal_proposal_amount(proposedValue.getTotal_proposal_amount());
            existingProposedValue.setComfama_contribution(proposedValue.getComfama_contribution());
            existingProposedValue.setProposal(proposedValue.getProposal());


            ProposedValue modifiedProposedValue = IProposedValueRepository.save(existingProposedValue);
            return convertToDTO(modifiedProposedValue);
        } else {
            throw new Exception("Representative not found");
        }
    }
    //logica eliminar
    public void deleteProposedValue(Integer id) throws Exception {
        Optional<ProposedValue> proposedValueOptional = IProposedValueRepository.findById(id);
        if (proposedValueOptional.isPresent()) {
            IProposedValueRepository.deleteById(id);
        } else {
            throw new Exception("Representative not found");
        }
    }


    private ProposedValueDTO convertToDTO(ProposedValue proposedValue) {
        ProposedValueDTO dto = new ProposedValueDTO();
        dto.setTotal_proposal_amount(proposedValue.getTotal_proposal_amount());
        dto.setComfama_contribution(proposedValue.getComfama_contribution());

        if (proposedValue.getProposal() != null) {
            dto.setProposal_id(proposedValue.getProposal().getId());
        }

        return dto;
    }


    private List<ProposedValueDTO> convertToDTOList(List<ProposedValue> proposedValueList) {
        return proposedValueList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
