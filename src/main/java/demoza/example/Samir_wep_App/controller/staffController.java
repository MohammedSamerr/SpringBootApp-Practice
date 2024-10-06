package demoza.example.Samir_wep_App.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demoza.example.Samir_wep_App.staff;
import demoza.example.Samir_wep_App.service.staffService;
import jakarta.validation.Valid;



@Controller
public class staffController {
    
    staffService staffService = new staffService();

    @GetMapping("/")
    public String addNewStaff(Model model , @RequestParam(required = false) String id){
        
        model.addAttribute("addNewStaff", staffService.getStaffById(id)) ;
        return "addNewStaff";
    }

    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("addNewStaff") staff staff , BindingResult result ){
            
            if(result.hasErrors() ) return "addNewStaff" ;

            staffService.submitStaff(staff);
            
            return "redirect:/StaffDetails" ;
    }

    @GetMapping("/StaffDetails")
    public String getStaffDetails(Model model){

        model.addAttribute("allStaff", staffService.getAllStaff());
        return "StaffDetails";

    }
}
