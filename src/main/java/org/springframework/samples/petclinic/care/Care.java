package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "care")
public class Care extends BaseEntity{
	
	@NotEmpty
    @Size(min = 5, max = 30)
    @Column(name = "name", unique = true)
    String name;
	
	@NotEmpty
    String description;
	
	@NotEmpty
	@JoinColumn(name = "pet_type_id")
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<PetType> compatiblePetTypes;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Care> incompatibleCares;
	
}
