package comfama.propuestacultural.models;

import jakarta.persistence.*;

@Entity
@Table(name = "proposed_value")
public class ProposedValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Proposal proposal;
    @Column(name="total_proposal_amount")
    private Double total_proposal_amount;

    @Column(name="comfama_contribution")
    private Double comfama_contribution;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    public Double getTotal_proposal_amount() {
        return total_proposal_amount;
    }

    public void setTotal_proposal_amount(Double total_proposal_amount) {
        this.total_proposal_amount = total_proposal_amount;
    }

    public Double getComfama_contribution() {
        return comfama_contribution;
    }

    public void setComfama_contribution(Double comfama_contribution) {
        this.comfama_contribution = comfama_contribution;
    }
}
