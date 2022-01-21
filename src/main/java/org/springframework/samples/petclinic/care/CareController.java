package org.springframework.samples.petclinic.care;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visit/{visitId}/care")
public class CareController {
    
	@Autowired
	private CareService careService;
	
	private static final String VIEWS_CARES_CREATE_OR_UPDATE_FORM = "care/createOrUpdateProvidedCareForm";
	
	@GetMapping(path = "/create")
	public String initCreationForm(ModelMap modelMap) {
		String view = VIEWS_CARES_CREATE_OR_UPDATE_FORM;
		modelMap.addAttribute("cares", new Care());
		modelMap.addAttribute("providedCare", careService.getAllCaresProvided());
		return view;
	}
	
	
}
