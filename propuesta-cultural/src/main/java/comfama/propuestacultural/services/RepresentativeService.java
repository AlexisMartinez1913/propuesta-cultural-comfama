package comfama.propuestacultural.services;

import comfama.propuestacultural.dtos.RepresentativeDTO;
import comfama.propuestacultural.models.Representative;
import comfama.propuestacultural.repositories.IRepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RepresentativeService {
    @Autowired
    IRepresentativeRepository iRepresentativeRepository;

    public RepresentativeDTO addRepresentative(Representative representativeData) throws Exception {
        try {
            Representative savedRepresentative = iRepresentativeRepository.save(representativeData);
            return convertToDTO(savedRepresentative);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public RepresentativeDTO searchRepresentativeById(Integer id) throws Exception {
        try {
            Optional<Representative> representativeOptional = iRepresentativeRepository.findById(id);
            if (representativeOptional.isPresent()) {
                Representative representative = representativeOptional.get();
                return convertToDTO(representative);
            } else {
                throw new Exception("Representative not found");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public List<RepresentativeDTO> searchAllRepresentatives() throws Exception {
        try {
            List<Representative> representativeList = iRepresentativeRepository.findAll();
            return convertToDTOList(representativeList);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public RepresentativeDTO modifyRepresentative(Integer id, Representative representative) throws Exception {
        Optional<Representative> optionalRepresentative = iRepresentativeRepository.findById(id);
        if (optionalRepresentative.isPresent()) {
            Representative existingRepresentative = optionalRepresentative.get();
            // Actualizar
            existingRepresentative.setDocumentType(representative.getDocumentType());
            existingRepresentative.setDocument_number(representative.getDocument_number());
            existingRepresentative.setFirst_name(representative.getFirst_name());
            existingRepresentative.setFirst_last_name(representative.getFirst_last_name());
            existingRepresentative.setPhone_number(representative.getPhone_number());
            existingRepresentative.setCell_phone_number(representative.getCell_phone_number());
            existingRepresentative.setEmail(representative.getEmail());
            Representative modifiedRepresentative = iRepresentativeRepository.save(existingRepresentative);
            return convertToDTO(modifiedRepresentative);
        } else {
            throw new Exception("Representative not found");
        }
    }
    //logica eliminar
    public void deleteRepresentative(Integer id) throws Exception {
        Optional<Representative> representativeOptional = iRepresentativeRepository.findById(id);
        if (representativeOptional.isPresent()) {
            iRepresentativeRepository.deleteById(id);
        } else {
            throw new Exception("Representative not found");
        }
    }

    // Métodos para convertir de entidad a DTO
    private RepresentativeDTO convertToDTO(Representative representative) {
        RepresentativeDTO dto = new RepresentativeDTO();
        dto.setId_representative(representative.getId_representative());

        if (representative.getDocumentType() != null) {
            dto.setId_document_type(representative.getDocumentType().getId_type_document());
        }

        dto.setDocument_number(representative.getDocument_number());
        dto.setFirst_name(representative.getFirst_name());
        dto.setFirst_last_name(representative.getFirst_last_name());
        dto.setPhone_number(representative.getPhone_number());
        dto.setCell_phone_number(representative.getCell_phone_number());
        dto.setEmail(representative.getEmail());

        return dto;
    }


    private List<RepresentativeDTO> convertToDTOList(List<Representative> representativeList) {
        return representativeList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
