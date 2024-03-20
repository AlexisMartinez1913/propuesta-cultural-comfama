package comfama.propuestacultural.models;

import jakarta.persistence.*;

@Entity
@Table(name = "proposers_types")
public class ProposerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProposerType;

    @Column(name = "proposer_type")
    private String proposer_type;

    public Integer getIdProposerType() {
        return idProposerType;
    }

    public void setIdProposerType(Integer idProposerType) {
        this.idProposerType = idProposerType;
    }

    public String getProposer_type() {
        return proposer_type;
    }

    public void setProposer_type(String proposer_type) {
        this.proposer_type = proposer_type;
    }
}
