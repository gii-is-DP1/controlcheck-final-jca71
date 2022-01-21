package org.springframework.samples.petclinic.care;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CareService {    
	
	@Autowired
	CareProvisionRepository cpr;

    public List<Care> getAllCares(){
        return cpr.findAllCares();
    }

    public List<Care> getAllCompatibleCares(String petTypeName){
        return cpr.findCompatibleCares(petTypeName);
    }

    public Care getCare(String careName) {
        return cpr.findCareByName(careName);
    }

    
    public CareProvision save(CareProvision p) throws NonCompatibleCaresException, UnfeasibleCareException {
        return null;   
    }

    public List<CareProvision> getAllCaresProvided(){
        return cpr.findAll();
    }

    public List<CareProvision> getCaresProvided(Integer visitId){
        return cpr.findCaresProvidedByVisitId(visitId);

    }
    
}
