package comfama.propuestacultural.models;

import jakarta.persistence.*;

@Entity
@Table(name = "types_documents")
public class DocumentType {
    @Id
    @Column(name = "id_type_document")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_type_document;

    @Column(name = "type_document")
    private String type_document;

    public Integer getId_type_document() {
        return id_type_document;
    }

    public void setId_type_document(Integer id_type_document) {
        this.id_type_document = id_type_document;
    }

    public String getType_document() {
        return type_document;
    }

    public void setType_document(String type_document) {
        this.type_document = type_document;
    }
}
