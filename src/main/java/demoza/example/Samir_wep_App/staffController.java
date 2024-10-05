package demoza.example.Samir_wep_App;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;



@Controller
public class staffController {
    
    List <staff> AllStaff = new ArrayList<>();

    @GetMapping("/")
    public String addNewStaff(Model model , @RequestParam(required = false) String id){
        staff myStaff = new staff();
        int index = getStaffIndex(id);
        model.addAttribute("addNewStaff", index == Constants.not_found ? myStaff : AllStaff.get(index)) ;
        return "addNewStaff";
    }

    public int getStaffIndex(String id ){
        for(int i=0; i<AllStaff.size();i++){
            if(AllStaff.get(i).getId().equals(id)){
                return i ;
            }
        }
        return Constants.not_found ;
    }



    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("addNewStaff") staff staff , BindingResult result ){
            
            if(result.hasErrors() ) return "addNewStaff" ;

            int index = getStaffIndex(staff.getId());
            if (index == Constants.not_found) {
                AllStaff.add(staff);
            }
            else{
                AllStaff.set(index, staff);
            }
            
            return "redirect:/StaffDetails" ;
    }

    @GetMapping("/StaffDetails")
    public String getStaffDetails(Model model){

        model.addAttribute("allStaff", AllStaff);
        return "StaffDetails";

    }
}
