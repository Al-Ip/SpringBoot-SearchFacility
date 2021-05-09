/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Vaccinations;
import model.Vaccines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/vacc")
public class VaccinationController {
    
    @Autowired
    VaccinationService vaccinationService;
    
    @Autowired
    VaccineService vaccineService;
    
    @GetMapping("/search")
    public ModelAndView showSearchForm(Vaccinations vacc) {
        return new ModelAndView("/search", "vacc", new Vaccinations());
    }
    
    @PostMapping("/searchVaccinationByISO")
    public ModelAndView searchVaccinationByISO(@ModelAttribute("vaccinations") Vaccinations b, BindingResult result) {
       //display success page
       return new ModelAndView("/search_result", "vaccs", vaccinationService.findVaccinationByISO(b.getIso_code()));
    }
     
    @GetMapping("/searchDrilldown")
    public ModelAndView drilldownOnSearchResult(
            @RequestParam(name="id") long vaccinationID,
            @RequestParam(name="vaccineID") String vaccineID,
            Vaccines vaccine, Vaccinations vaccination) {
        
        // Removing Commas from string
        String str = vaccineID.replace(","," ");
        //str = str.replaceAll("\\s+","");
        
        // Storing strings into integer list 
        List<Long> vaccNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(str);
        while (scanner.hasNextInt()) {
            vaccNumbers.add(scanner.nextLong());
        }
        
        Map<String, List> model = new HashMap<>();
        model.put("vacc", vaccinationService.findVaccinationByID(vaccinationID));
        model.put("vaccines", vaccineService.findVaccinesByID(vaccNumbers));
        
       //display success page
       return new ModelAndView("/search_drilldown", "model", model);
    }
    
    
    
}
