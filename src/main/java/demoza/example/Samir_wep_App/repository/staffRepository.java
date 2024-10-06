package demoza.example.Samir_wep_App.repository;

import demoza.example.Samir_wep_App.staff;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class staffRepository {
    private List <staff> AllStaff = new ArrayList<>();

    public staff getStaffByIndex (int index){
        return AllStaff.get(index);
    } 

    public void addStaff (staff staff){
        AllStaff.add(staff);
    }

    public void updateStaff (staff staff,int index){
        AllStaff.set(index,staff);
    }

    public List<staff> getAllStaff(){
        return AllStaff;
    }
}
