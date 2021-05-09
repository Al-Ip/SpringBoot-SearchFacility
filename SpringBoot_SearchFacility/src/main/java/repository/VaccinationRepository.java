/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import model.Vaccinations;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexi
 */
@Repository
public interface VaccinationRepository extends CrudRepository<Vaccinations, Long>{
    
    @Query("SELECT v FROM Vaccinations v WHERE v.iso_code = :isoCode")
    public List<Vaccinations> getVaccinactionThatContainsISO(@Param("isoCode") String iso);
    
    @Query("SELECT v FROM Vaccinations v WHERE v.id = :id")
    public List<Vaccinations> getVaccinactionsByID(@Param("id") long id);
    
    
}


