package comfama.propuestacultural.services;

import comfama.propuestacultural.dtos.DocumentTypeDTO;
import comfama.propuestacultural.maps.IDocumentTypeMap;
import comfama.propuestacultural.models.DocumentType;
import comfama.propuestacultural.repositories.IDocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService {
    @Autowired
    IDocumentTypeRepository iDocumentTypeRepository;
    @Autowired
    IDocumentTypeMap iDocumentTypeMap;

    public DocumentTypeDTO addDocumentType(DocumentType documentTypeData) throws Exception {
        try {
            return this.iDocumentTypeMap.documentTypeToDTO(this.iDocumentTypeRepository.save(documentTypeData));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //RUTINA PARA BUSCAR UN ELEMENTO DENTRO BD POR ID
    public DocumentTypeDTO searchDocumentTypeById(Integer id) throws Exception {
        try{
            if(this.iDocumentTypeRepository.findById(id).isPresent()){
                //devuelvalo
                return this.iDocumentTypeMap.documentTypeToDTO(this
                        .iDocumentTypeRepository.findById(id).get());
            }else{
                //diga que no esta
                throw new Exception("User no found");

            }
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<DocumentTypeDTO> searchAllTypesDocuments() throws Exception {
        try{
            return this.iDocumentTypeMap.toDtoList(iDocumentTypeRepository.findAll());

        }catch(Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public DocumentTypeDTO modifyDocumentType(Integer id, DocumentType documentType) throws Exception {
        try{
            if(this.iDocumentTypeRepository.findById(id).isPresent()){
                //cambielo
                DocumentType objectFound= this.iDocumentTypeRepository.findById(id).get();
                objectFound.setType_document(documentType.getType_document());
                return this.iDocumentTypeMap.documentTypeToDTO(iDocumentTypeRepository.save(objectFound));
            }else {
                //diga que no esta
                throw new Exception("User no found");
            }


        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
