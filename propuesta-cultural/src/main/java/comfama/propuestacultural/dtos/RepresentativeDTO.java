package comfama.propuestacultural.dtos;

public class RepresentativeDTO {
    private Integer id_representative;
    private Integer id_document_type;
    private String document_number;
    private String first_name;
    private String first_last_name;
    private String phone_number;
    private String cell_phone_number;
    private String email;

    public RepresentativeDTO() {
    }

    public RepresentativeDTO(Integer id_representative, Integer id_document_type, String document_number, String first_name, String first_last_name, String phone_number, String cell_phone_number, String email) {
        this.id_representative = id_representative;
        this.id_document_type = id_document_type;
        this.document_number = document_number;
        this.first_name = first_name;
        this.first_last_name = first_last_name;
        this.phone_number = phone_number;
        this.cell_phone_number = cell_phone_number;
        this.email = email;
    }

    public Integer getId_representative() {
        return id_representative;
    }

    public void setId_representative(Integer id_representative) {
        this.id_representative = id_representative;
    }

    public Integer getId_document_type() {
        return id_document_type;
    }

    public void setId_document_type(Integer id_document_type) {
        this.id_document_type = id_document_type;
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
