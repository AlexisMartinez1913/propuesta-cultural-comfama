package comfama.propuestacultural.dtos;

import java.time.LocalDate;
import java.util.UUID;

public class ProposalDTO {

    private String name_proposal;
    private String description_activities;
    private String description_proposal;
    private LocalDate date_presentation;
    private String state_proposal;

    private UUID proponent_id;

    public ProposalDTO() {

    }

    public ProposalDTO(String name_proposal, String description_activities, String description_proposal, LocalDate date_presentation, String state_proposal, UUID proponent_id) {
        this.name_proposal = name_proposal;
        this.description_activities = description_activities;
        this.description_proposal = description_proposal;
        this.date_presentation = date_presentation;
        this.state_proposal = state_proposal;
        this.proponent_id = proponent_id;
    }

    public String getName_proposal() {
        return name_proposal;
    }

    public void setName_proposal(String name_proposal) {
        this.name_proposal = name_proposal;
    }

    public String getDescription_activities() {
        return description_activities;
    }

    public void setDescription_activities(String description_activities) {
        this.description_activities = description_activities;
    }

    public String getDescription_proposal() {
        return description_proposal;
    }

    public void setDescription_proposal(String description_proposal) {
        this.description_proposal = description_proposal;
    }

    public LocalDate getDate_presentation() {
        return date_presentation;
    }

    public void setDate_presentation(LocalDate date_presentation) {
        this.date_presentation = date_presentation;
    }

    public String getState_proposal() {
        return state_proposal;
    }

    public void setState_proposal(String state_proposal) {
        this.state_proposal = state_proposal;
    }

    public UUID getProponent_id() {
        return proponent_id;
    }

    public void setProponent_id(UUID proponent_id) {
        this.proponent_id = proponent_id;
    }


}
