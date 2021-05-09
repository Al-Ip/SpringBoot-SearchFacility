/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import java.util.Map;
import model.Vaccinations;
import model.Vaccines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import service.VaccinationService;
import service.VaccineService;

/**
 *
 * @author alexi
 */
@RestController
@RequestMapping("/vaccines")
public class VaccinesController {
    
    @Autowired
    VaccineService vService;
    
    @Autowired
    VaccinationService vaccService;
    
    @GetMapping("/clickVaccine")
    public ModelAndView clickedVaccineImage(
            @RequestParam(name="vaccineID") long vaccineID,
            @RequestParam(name="vaccinationID") long vaccinationID,
            Vaccines vaccine, Vaccinations vaccination) {
        
        Map<String, Object> model = new HashMap<>();
        model.put("vaccine", vService.findOne(vaccineID));
        model.put("vacc", vaccService.findOne(vaccinationID));
        
       //display success page
       return new ModelAndView("/search_drilldown", "model", model);
   }
    
}
