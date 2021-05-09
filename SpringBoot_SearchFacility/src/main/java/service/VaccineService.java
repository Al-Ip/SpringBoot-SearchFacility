/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Vaccines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VaccineRepository;

/**
 *
 * @author alexi
 */
@Service
public class VaccineService {
    
    @Autowired
    private VaccineRepository vaccineRepo;
    
    public Vaccines findOne(Long id){
        return vaccineRepo.findById(id).get();
    }
    
    public List<Vaccines> findAll(){
        return (List<Vaccines>) vaccineRepo.findAll();
    }
    
    public long count(){
        return vaccineRepo.count();
    }
    
    public void deleteByID(long vaccID){
        vaccineRepo.deleteById(vaccID);
    }
    
    public void saveVaccination(Vaccines b){
        vaccineRepo.save(b);
    }
    
    public List<Vaccines> findVaccinesByID(List<Long> ids){
        return vaccineRepo.getVaccinesByID(ids);
    }
    
}