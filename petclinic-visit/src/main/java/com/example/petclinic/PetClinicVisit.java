package com.example.petclinic;

import com.example.petclinic.controller.VisitController;
import com.example.petclinic.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Date;

@SpringBootApplication
public class PetClinicVisit {

    private static ConfigurableApplicationContext context;
    private static VisitController visitController;

    public static void main(String[] args) {

        context = SpringApplication.run(PetClinicVisit.class, args);

        // Need a reference to the OwnerController to run our tests.
        // We use the context to retrieve managed beans by name.
        // The name of the bean is the type of bean (it's name) in camelcase, with the first letter lowercase (by default).
        visitController = (VisitController) context.getBean("visitController");

        // Create Visit
        Visit visit1 = Visit.builder().withDateOfVisit(new Date()).withDescription("Nice Visit!").build();
        Visit visit2 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").build();
        Visit visit3 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").build();
        Visit visit4 = Visit.builder().withDateOfVisit(new Date()).withDescription("Bad Visit!").build();

        visitController.add(visit1);
        visitController.add(visit2);
        visitController.add(visit3);
        visitController.add(visit4);

        // ***** Vet *****
        Vet vet1 = Vet.builder().withName("SuperVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withVisit(visit1).build();
        Vet vet2 = Vet.builder().withName("SuperDuperVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withSpeciality(Speciality.RADIOLOGY).withVisit(visit1).build();
        Vet vet3 = Vet.builder().withName("OutstandingVet").withSpeciality(Speciality.DENTISTRY).withSpeciality(Speciality.SURGERY).withVisit(visit4).withVisit(visit3).withVisit(visit2).build();

        visitController.modify(visit1);
        visitController.modify(visit2);
        visitController.modify(visit3);
        visitController.modify(visit4);
    }
}
