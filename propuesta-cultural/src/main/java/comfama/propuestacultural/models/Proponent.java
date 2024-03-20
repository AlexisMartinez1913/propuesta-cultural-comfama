package comfama.propuestacultural.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "proponent")
public class Proponent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_proponent;

    @Column(name = "name_proponent")
    private String name_proponent;

    @Column(name = "trajectory")
    private String trajectory;

    @ManyToOne
    @JoinColumn(name = "id_representative", referencedColumnName = "id_representative")
    private Representative representative;

    @ManyToOne
    @JoinColumn(name = "idProposerType", referencedColumnName = "idProposerType")
    private ProposerType proposerType;

    public UUID getId_proponent() {
        return id_proponent;
    }

    public void setId_proponent(UUID id_proponent) {
        this.id_proponent = id_proponent;
    }

    public String getName_proponent() {
        return name_proponent;
    }

    public void setName_proponent(String name_proponent) {
        this.name_proponent = name_proponent;
    }

    public String getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(String trajectory) {
        this.trajectory = trajectory;
    }

    public Representative getRepresentative() {
        return representative;
    }

    public void setRepresentative(Representative representative) {
        this.representative = representative;
    }

    public ProposerType getProposerType() {
        return proposerType;
    }

    public void setProposerType(ProposerType proposerType) {
        this.proposerType = proposerType;
    }
}
