package demoza.example.Samir_wep_App.service;

import java.util.List;

import org.springframework.stereotype.Service;

import demoza.example.Samir_wep_App.Constants;
import demoza.example.Samir_wep_App.staff;
import demoza.example.Samir_wep_App.repository.staffRepository;

@Service
public class staffService {

    staffRepository staffRepository ;

    public staff getStaffByIndex (int index){
        return staffRepository.getStaffByIndex(index);
    } 

    public staff getStaffById (String id){
        int index = getStaffIndex(id) ;
        return index == Constants.not_found ? new staff() :getStaffByIndex(index);
    } 

    public void submitStaff(staff staff){
        int index =getStaffIndex(staff.getId());
        if (index == Constants.not_found) {
            addStaff(staff);
        }
        else{
            updateStaff(staff, index);
        }
    }


    public void addStaff (staff staff){
       staffRepository.addStaff(staff);;
    }

    public void updateStaff (staff staff,int index){
        staffRepository.updateStaff(staff, index);
    }

    public List<staff> getAllStaff(){
        return staffRepository.getAllStaff();
    }
    
    public int getStaffIndex(String id ){
        for(int i=0; i<getAllStaff().size();i++){
            if(getStaffByIndex(i).getId().equals(id)){
                return i ;
            }
        }
        return Constants.not_found ;
    }

}
