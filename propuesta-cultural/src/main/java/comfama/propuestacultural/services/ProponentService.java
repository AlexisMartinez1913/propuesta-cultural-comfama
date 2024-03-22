package comfama.propuestacultural.services;

import comfama.propuestacultural.dtos.ProponentDTO;
import comfama.propuestacultural.models.Proponent;
import comfama.propuestacultural.models.ProposerType;
import comfama.propuestacultural.repositories.IProponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProponentService {
    @Autowired
    IProponentRepository IProponentRepository;

    public ProponentDTO addProponent(ProponentDTO proponentDTO) throws Exception {
        try {
            Proponent proponent = new Proponent();
            proponent.setName_proponent(proponentDTO.getName_proponent());
            proponent.setTrajectory(proponentDTO.getTrajectory());

            ProposerType proposerType = new ProposerType();
            proposerType.setIdProposerType(proponentDTO.getType_proponent());
            proponent.setProposerType(proposerType);

            Proponent savedProponent = IProponentRepository.save(proponent);
            return convertToDTO(savedProponent);
        } catch (Exception error) {
            throw new Exception("Error to save the proponent: " + error.getMessage());
        }
    }

    public List<ProponentDTO> getAllProponents() throws Exception {
        try {
            List<Proponent> proponents = IProponentRepository.findAll();
            return convertToDTOList(proponents);
        } catch (Exception error) {
            throw new Exception("Error to get the proponents: " + error.getMessage());
        }
    }

    public ProponentDTO searchProponentById(UUID id) throws Exception {
        try {
            Optional<Proponent> proponentOptional = IProponentRepository.findById(id);
            if (proponentOptional.isPresent()) {
                Proponent proponent = proponentOptional.get();
                return convertToDTO(proponent);
            } else {
                throw new Exception("Proponent not found");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public ProponentDTO updateProponent(UUID id, ProponentDTO proponentDTO) throws Exception {
        try {
            Optional<Proponent> optionalProponent = IProponentRepository.findById(id);
            if (optionalProponent.isPresent()) {
                Proponent existingProponent = optionalProponent.get();
                existingProponent.setName_proponent(proponentDTO.getName_proponent());
                existingProponent.setTrajectory(proponentDTO.getTrajectory());
                ProposerType proposerType = new ProposerType();
                existingProponent.setProposerType(proposerType);

                Proponent updatedProponent = IProponentRepository.save(existingProponent);
                return convertToDTO(updatedProponent);
            } else {
                throw new Exception("Proponent no found");
            }
        } catch (Exception error) {
            throw new Exception("Error to update the proponent: " + error.getMessage());
        }
    }






    private ProponentDTO convertToDTO(Proponent proponent) {
        ProponentDTO dto = new ProponentDTO();
        dto.setName_proponent(proponent.getName_proponent());
        dto.setTrajectory(proponent.getTrajectory());
        dto.setType_proponent(proponent.getProposerType().getIdProposerType());
        return dto;
    }

    private List<ProponentDTO> convertToDTOList(List<Proponent> proponentList) {
        return proponentList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
