package comfama.propuestacultural.models;

import jakarta.persistence.*;

@Entity
@Table(name = "attached_documents")
public class AttachedDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_attached_document;

    @Column(name = "name_document")
    private String name_document;

    @Column(name = "url")
    private String url;

    public Integer getId_attached_document() {
        return id_attached_document;
    }

    public void setId_attached_document(Integer id_attached_document) {
        this.id_attached_document = id_attached_document;
    }

    public String getName_document() {
        return name_document;
    }

    public void setName_document(String name_document) {
        this.name_document = name_document;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
