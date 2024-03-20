package comfama.propuestacultural.services;

import comfama.propuestacultural.dtos.ProposerTypeDTO;

import comfama.propuestacultural.models.ProposerType;
import comfama.propuestacultural.repositories.IProposerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProposerTypeService {

    @Autowired
    IProposerTypeRepository iProposerTypeRepository;

    public ProposerTypeDTO addProposerType(ProposerType proposerTypeData) throws Exception {
        try {
            ProposerType savedProposerType = iProposerTypeRepository.save(proposerTypeData);
            return convertToDTO(savedProposerType);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public ProposerTypeDTO searchProposerTypeById(Integer id) throws Exception {
        Optional<ProposerType> proposerTypeOptional = iProposerTypeRepository.findById(id);
        if (proposerTypeOptional.isPresent()) {
            ProposerType proposerType = proposerTypeOptional.get();
            return convertToDTO(proposerType);
        } else {
            throw new Exception("Proposer Type not found");
        }
    }

    public List<ProposerTypeDTO> searchAllProposersTypes() throws Exception {
        List<ProposerType> proposerTypeList = iProposerTypeRepository.findAll();
        return convertToDTOList(proposerTypeList);
    }

    public ProposerTypeDTO modifyProposerType(Integer id, ProposerType proposerType) throws Exception {
        Optional<ProposerType> optionalProposerType = iProposerTypeRepository.findById(id);
        if (optionalProposerType.isPresent()) {
            ProposerType existingProposerType = optionalProposerType.get();
            existingProposerType.setProposer_type(proposerType.getProposer_type());
            ProposerType modifiedProposerType = iProposerTypeRepository.save(existingProposerType);
            return convertToDTO(modifiedProposerType);
        } else {
            throw new Exception("Proposer Type not found");
        }
    }

    // convertir de entidad a DTO
    private ProposerTypeDTO convertToDTO(ProposerType proposerType) {
        ProposerTypeDTO dto = new ProposerTypeDTO ();
        dto.setId_proposer_type(proposerType.getIdProposerType());
        dto.setProposer_type(proposerType.getProposer_type());
        return dto;
    }

    private List<ProposerTypeDTO> convertToDTOList(List<ProposerType> proposerTypeList) {
        return proposerTypeList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
