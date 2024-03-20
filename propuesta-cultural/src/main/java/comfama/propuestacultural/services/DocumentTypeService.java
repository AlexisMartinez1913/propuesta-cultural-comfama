package comfama.propuestacultural.services;

import comfama.propuestacultural.dtos.DocumentTypeDTO;
import comfama.propuestacultural.models.DocumentType;
import comfama.propuestacultural.repositories.IDocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DocumentTypeService {
    @Autowired
    IDocumentTypeRepository iDocumentTypeRepository;


    public DocumentTypeDTO addDocumentType(DocumentType documentTypeData) throws Exception {
        try {
            DocumentType savedDocumentType = iDocumentTypeRepository.save(documentTypeData);
            return convertToDTO(savedDocumentType);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public DocumentTypeDTO searchDocumentTypeById(Integer id) throws Exception {
        try {
            Optional<DocumentType> documentTypeOptional = iDocumentTypeRepository.findById(id);
            if (documentTypeOptional.isPresent()) {
                DocumentType documentType = documentTypeOptional.get();
                return convertToDTO(documentType);
            } else {
                throw new Exception("User not found");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public List<DocumentTypeDTO> searchAllTypesDocuments() throws Exception {
        try {
            List<DocumentType> documentTypeList = iDocumentTypeRepository.findAll();
            return convertToDTOList(documentTypeList);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public DocumentTypeDTO modifyDocumentType(Integer id, DocumentType documentType) throws Exception {
        Optional<DocumentType> optionalDocumentType = iDocumentTypeRepository.findById(id);
        if (optionalDocumentType.isPresent()) {
            DocumentType existingDocumentType = optionalDocumentType.get();
            existingDocumentType.setType_document(documentType.getType_document());
            DocumentType modifiedDocumentType = iDocumentTypeRepository.save(existingDocumentType);
            return convertToDTO(modifiedDocumentType);
        } else {
            throw new Exception("User not found");
        }
    }

    // convertir de entidad a DTO
    private DocumentTypeDTO convertToDTO(DocumentType documentType) {
        DocumentTypeDTO dto = new DocumentTypeDTO();
        dto.setId(documentType.getId_type_document());
        dto.setTypeDocument(documentType.getType_document());
        return dto;
    }

    private List<DocumentTypeDTO> convertToDTOList(List<DocumentType> documentTypeList) {
        return documentTypeList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


}
