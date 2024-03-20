package comfama.propuestacultural.dtos;

public class AttachedDocumentDTO {

    private String name_document;
    private String url;

    public AttachedDocumentDTO() {
    }

    public AttachedDocumentDTO(String name_document, String url) {
        this.name_document = name_document;
        this.url = url;
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
