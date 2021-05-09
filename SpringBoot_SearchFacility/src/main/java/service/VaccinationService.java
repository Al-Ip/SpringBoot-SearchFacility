/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Vaccinations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VaccinationRepository;

/**
 *
 * @author alexi
 */
@Service
public class VaccinationService {
        
    @Autowired
    private VaccinationRepository vaccinationRepo;
    
    public Vaccinations findOne(Long id){
        return vaccinationRepo.findById(id).get();
    }
    
    public List<Vaccinations> findAll(){
        return (List<Vaccinations>) vaccinationRepo.findAll();
    }
    
    public long count(){
        return vaccinationRepo.count();
    }
    
    public void deleteByID(long vaccID){
        vaccinationRepo.deleteById(vaccID);
    }
    
    public void saveVaccination(Vaccinations b){
        vaccinationRepo.save(b);
    }
    
    public List<Vaccinations> findVaccinationByISO(String iso){
        return vaccinationRepo.getVaccinactionThatContainsISO(iso);
    }
    
    public List<Vaccinations> findVaccinationByID(long id){
        return vaccinationRepo.getVaccinactionsByID(id);
    }
   
     
}


