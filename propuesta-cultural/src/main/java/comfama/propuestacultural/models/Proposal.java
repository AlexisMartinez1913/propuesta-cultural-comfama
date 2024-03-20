package comfama.propuestacultural.models;

import comfama.propuestacultural.helpers.State;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "proposals")
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_proponent", referencedColumnName = "id_proponent")
    private Proponent proponent;
    @Column(name = "name_proposal")
    private String name_proposal;
    @Column(name = "description_activities")
    private String description_activities;

    @Column(name = "description_proposal")
    private String description_proposal;

    @Column(name = "date_presentation")
    private LocalDate date_presentation;

    @Column(name="public_beneficiary")
    private String public_beneficiary;

    @Column(name = "allied_companies")
    private String allied_companies;

    //enum
    private State state_proposal = State.INITIAL;

    @Column(name="event_start_date")
    private LocalDate event_start_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proponent getProponent() {
        return proponent;
    }

    public void setProponent(Proponent proponent) {
        this.proponent = proponent;
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

    public String getPublic_beneficiary() {
        return public_beneficiary;
    }

    public void setPublic_beneficiary(String public_beneficiary) {
        this.public_beneficiary = public_beneficiary;
    }

    public String getAllied_companies() {
        return allied_companies;
    }

    public void setAllied_companies(String allied_companies) {
        this.allied_companies = allied_companies;
    }

    public State getState_proposal() {
        return state_proposal;
    }

    public void setState_proposal(State state_proposal) {
        this.state_proposal = state_proposal;
    }

    public LocalDate getEvent_start_date() {
        return event_start_date;
    }

    public void setEvent_start_date(LocalDate event_start_date) {
        this.event_start_date = event_start_date;
    }
}
