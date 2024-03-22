package comfama.propuestacultural.services;

import comfama.propuestacultural.dtos.AttachedDocumentDTO;
import comfama.propuestacultural.models.AttachedDocument;
import comfama.propuestacultural.repositories.IAttachedDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttachedDocumentService {
    @Autowired
    IAttachedDocumentRepository IAttachedDocumentRepository;

    public AttachedDocumentDTO addAttachedDocument(AttachedDocumentDTO attachedDocumentDTO) throws Exception {
        try {
            AttachedDocument attachedDocument = new AttachedDocument();
            attachedDocument.setName_document(attachedDocumentDTO.getName_document());
            attachedDocument.setUrl(attachedDocumentDTO.getUrl());

            AttachedDocument savedAttachedDocument = IAttachedDocumentRepository.save(attachedDocument);
            return convertToDTO(savedAttachedDocument);
        } catch (Exception error) {
            throw new Exception("Error al guardar el documento adjunto: " + error.getMessage());
        }
    }

    public List<AttachedDocumentDTO> getAllAttachedDocuments() throws Exception {
        try {
            List<AttachedDocument> attachedDocuments = IAttachedDocumentRepository.findAll();
            return convertToDTOList(attachedDocuments);
        } catch (Exception error) {
            throw new Exception("Error to get attached documents: " + error.getMessage());
        }
    }

    public AttachedDocumentDTO searchAttachedDocumentById(Integer id) throws Exception {
        try {
            Optional<AttachedDocument> attachedDocumentOptional = IAttachedDocumentRepository.findById(id);
            if (attachedDocumentOptional.isPresent()) {
                AttachedDocument attachedDocument1 = attachedDocumentOptional.get();
                return convertToDTO(attachedDocument1);
            } else {
                throw new Exception("Attached document not found");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public AttachedDocumentDTO modifyAttachedDocument(Integer id, AttachedDocument attachedDocument) throws Exception {
        try {
            Optional<AttachedDocument> optionalAttachedDocument = IAttachedDocumentRepository.findById(id);
            if (optionalAttachedDocument.isPresent()) {
                AttachedDocument existingAttachedDocument = optionalAttachedDocument.get();
                existingAttachedDocument.setName_document(attachedDocument.getName_document());
                AttachedDocument modifiedAttachedDocument = IAttachedDocumentRepository.save(existingAttachedDocument);
                return convertToDTO(modifiedAttachedDocument);
            } else {
                throw new Exception("Attached Document not found");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }




    private AttachedDocumentDTO convertToDTO(AttachedDocument attachedDocument) {
        AttachedDocumentDTO dto = new AttachedDocumentDTO();
        dto.setName_document(attachedDocument.getName_document());
        dto.setUrl(attachedDocument.getUrl());
        return dto;
    }

    private List<AttachedDocumentDTO> convertToDTOList(List<AttachedDocument> attachedDocumentList) {
        return attachedDocumentList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
