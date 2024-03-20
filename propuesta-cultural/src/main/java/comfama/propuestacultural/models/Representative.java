package comfama.propuestacultural.models;

import jakarta.persistence.*;

@Entity
@Table(name = "representatives")
public class Representative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_representative;

    @ManyToOne
    @JoinColumn(name = "id_type_document", referencedColumnName = "id_type_document")
    private DocumentType documentType;

    @Column(name = "document_number")
    private String document_number;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "first_last_name")
    private String first_last_name;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "cell_phone_number")
    private String cell_phone_number;
    @Column(name = "email")
    private String email;

    public Integer getId_representative() {
        return id_representative;
    }

    public void setId_representative(Integer id_representative) {
        this.id_representative = id_representative;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_last_name() {
        return first_last_name;
    }

    public void setFirst_last_name(String first_last_name) {
        this.first_last_name = first_last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCell_phone_number() {
        return cell_phone_number;
    }

    public void setCell_phone_number(String cell_phone_number) {
        this.cell_phone_number = cell_phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
