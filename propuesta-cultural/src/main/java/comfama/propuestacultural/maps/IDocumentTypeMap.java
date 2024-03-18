package comfama.propuestacultural.maps;

import comfama.propuestacultural.dtos.DocumentTypeDTO;
import comfama.propuestacultural.models.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDocumentTypeMap {

    @Mappings(
            {
                    @Mapping(source = "id_type_document", target = "id"),
                    @Mapping(source = "type_document", target = "typeDocument")
            }
    )

    DocumentTypeDTO documentTypeToDTO(DocumentType documentType);
    List<DocumentTypeDTO> toDtoList(List<DocumentType> documentTypeList);


}
