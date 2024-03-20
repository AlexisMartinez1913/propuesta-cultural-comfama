package comfama.propuestacultural.dtos;

public class ProponentDTO {
    private String name_proponent;
    private String trajectory;
    private Integer type_proponent;

    public ProponentDTO() {
    }

    public ProponentDTO(String name_proponent, String trajectory, Integer type_proponent) {
        this.name_proponent = name_proponent;
        this.trajectory = trajectory;
        this.type_proponent = type_proponent;
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

    public Integer getType_proponent() {
        return type_proponent;
    }

    public void setType_proponent(Integer type_proponent) {
        this.type_proponent = type_proponent;
    }
}
