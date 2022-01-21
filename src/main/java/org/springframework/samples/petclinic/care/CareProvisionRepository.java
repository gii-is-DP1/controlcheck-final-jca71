package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer>{
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
    
    @Query("SELECT c FROM Care c")
	List<Care> findAllCares();
    
    @Query("SELECT c FROM CareProvision c")
    List<CareProvision> findAllCaresProvided();
    
    @Query("SELECT c FROM Care c WHERE c.name =?1")
    List<Care> findCompatibleCares(String petTypeName);
    
    @Query("SELECT c FROM Care c WHERE c.name =:name")
    Care findCareByName(String name);
    
    @Query("SELECT c FROM CareProvision c WHERE c.visit =:visitId")
    List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
}
