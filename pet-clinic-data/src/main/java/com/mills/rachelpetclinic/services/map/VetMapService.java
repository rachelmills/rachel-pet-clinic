package com.mills.rachelpetclinic.services.map;

import com.mills.rachelpetclinic.model.Speciality;
import com.mills.rachelpetclinic.model.Vet;
import com.mills.rachelpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    public VetMapService(SpecialityMapService specialityMapService) {
        this.specialityMapService = specialityMapService;
    }

    private SpecialityMapService specialityMapService;

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet.getSpecialities().size() > 0) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityMapService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void delete(Vet Vet) {
        super.delete(Vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
