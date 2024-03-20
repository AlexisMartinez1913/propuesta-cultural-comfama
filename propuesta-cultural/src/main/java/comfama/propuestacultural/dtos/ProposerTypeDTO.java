package comfama.propuestacultural.dtos;

public class ProposerTypeDTO {
    private Integer id_proposer_type;
    private String proposer_type;

    public ProposerTypeDTO() {

    }

    public ProposerTypeDTO(Integer id_proposer_type, String proposer_type) {
        this.id_proposer_type = id_proposer_type;
        this.proposer_type = proposer_type;
    }

    public Integer getId_proposer_type() {
        return id_proposer_type;
    }

    public void setId_proposer_type(Integer id_proposer_type) {
        this.id_proposer_type = id_proposer_type;
    }

    public String getProposer_type() {
        return proposer_type;
    }

    public void setProposer_type(String proposer_type) {
        this.proposer_type = proposer_type;
    }
}
