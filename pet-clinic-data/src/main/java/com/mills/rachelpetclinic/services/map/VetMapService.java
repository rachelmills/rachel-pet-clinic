package com.mills.rachelpetclinic.services.map;

import com.mills.rachelpetclinic.model.Vet;
import com.mills.rachelpetclinic.services.CrudService;

import java.util.Set;

/**
 * Created by rachelmills on 23/6/19.
 */
public class VetMapService extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long>{
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet Vet) {
        return super.save(Vet.getId(), Vet);
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
