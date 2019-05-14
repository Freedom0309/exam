package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Profession;
import com.jcohy.exam.respository.ProfessionRepository;
import com.jcohy.exam.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    @Autowired
    private ProfessionRepository professionRepository;

    @Override
    public Page<Profession> findAll(Pageable pageable) {
        return professionRepository.findAll(pageable);
    }

    @Override
    public List<Profession> findAll() {
        return professionRepository.findAll();
    }

    @Override
    public Profession findById(Integer id) {
        return professionRepository.findById(id).get();
    }

    @Override
    public Profession findByName(String name) {
        return professionRepository.findByName(name);
    }

    /**
     * 保存或更新专业
     * @param profession
     * @return
     * @throws ServiceException
     */
    @Override
    public Profession saveOrUpdate(Profession profession) throws ServiceException {
        Profession dbProfession = null;
        if(profession.getId() != null){
            dbProfession = findById(profession.getId());
            if(profession.getName() != null) dbProfession.setName(profession.getName());
            if(profession.getDescription() != null) dbProfession.setDescription(profession.getDescription());
            if(profession.getFuture() != null) dbProfession.setFuture(profession.getFuture());
            if(profession.getCompensation() != null) dbProfession.setCompensation(profession.getCompensation());
        }else{
            dbProfession = profession;
        }
        return professionRepository.save(dbProfession);
    }

    @Override
    public void delete(Integer id) {
        professionRepository.deleteById(id);
    }

    @Override
    public List<Profession> findByNameIsLike(String name) {
        return professionRepository.findByNameIsLike(name);
    }

    @Override
    public List<Object[]> findProfession(String city, String arts, Integer score) {
        return professionRepository.findProfession(city, arts, score);
    }


}
