package comfama.propuestacultural.dtos;

public class ProposedValueDTO {

    private Double total_proposal_amount;
    private Double comfama_contribution;
    private Integer proposal_id;

    public ProposedValueDTO() {

    }

    public ProposedValueDTO(Double total_proposal_amount, Double comfama_contribution, Integer proposal_id) {
        this.total_proposal_amount = total_proposal_amount;
        this.comfama_contribution = comfama_contribution;
        this.proposal_id = proposal_id;
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

    public Integer getProposal_id() {
        return proposal_id;
    }

    public void setProposal_id(Integer proposal_id) {
        this.proposal_id = proposal_id;
    }
}
