/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import model.Vaccines;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexi
 */
@Repository
public interface VaccineRepository extends CrudRepository<Vaccines, Long>{
    
    //List<Vaccines> findByVaccineIDIn(List<Integer> ids); 
    
    @Query("SELECT v FROM Vaccines v WHERE v.id IN (:ids)")
    public List<Vaccines> getVaccinesByID(@Param("ids") List<Long> ids);
    
}
