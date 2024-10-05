package demoza.example.Samir_wep_App;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class staff {
    @NotBlank(message = "Staff Name can not be blank")
    private String staffName;

    @NotBlank(message = "Staff Title can not be blank")
    private String staffTitle;
    private double staffSallary;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // public staff(String staffName,String staffTitle, double staffSallary){
    //     this.staffName = staffName;
    //     this.staffTitle= staffTitle;
    //     this.staffSallary =staffSallary;
    // }

    public staff(){
        this.id = UUID.randomUUID().toString();
    }

    public String getStaffName() {
        return this.staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffTitle() {
        return this.staffTitle;
    }

    public void setStaffTitle(String staffTitle) {
        this.staffTitle = staffTitle;
    }

    public double getStaffSallary() {
        return this.staffSallary;
    }

    public void setStaffSallary(double staffSallary) {
        this.staffSallary = staffSallary;
    }


}
