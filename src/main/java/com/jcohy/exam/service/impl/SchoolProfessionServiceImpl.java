package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Profession;
import com.jcohy.exam.model.SchoolProfession;
import com.jcohy.exam.respository.SchoolProfessionRepository;
import com.jcohy.exam.service.SchoolProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SchoolProfessionServiceImpl implements SchoolProfessionService {

    @Autowired
    private SchoolProfessionRepository schoolProfessionRepository;

    @Override
    public Page<SchoolProfession> findAll(Pageable pageable) {
        return schoolProfessionRepository.findAll(pageable);
    }

    @Override
    public List<SchoolProfession> findAll() {
        return schoolProfessionRepository.findAll();
    }

    @Override
    public SchoolProfession findById(Integer id) {
        return schoolProfessionRepository.findById(id).get();
    }

    @Override
    public List<SchoolProfession> findBySchoolId(Integer schoolId) {
        return schoolProfessionRepository.findAllBySchoolId(schoolId);
    }

    @Override
    public SchoolProfession saveOrUpdate(SchoolProfession schoolProfession) throws ServiceException {
        SchoolProfession dbPro = null;
        if (schoolProfession.getId() != null) {
            dbPro = findById(schoolProfession.getId());
            if (schoolProfession.getProfessionId() != null)
                dbPro.setProfessionId(schoolProfession.getProfessionId());
            if (schoolProfession.getSchoolId() != null)
                dbPro.setSchoolId(schoolProfession.getSchoolId());
        } else {
            dbPro = schoolProfession;
        }
        return schoolProfessionRepository.save(dbPro);
    }

    public List<SchoolProfession> batchSave(List<SchoolProfession> professions){

        return schoolProfessionRepository.saveAll(professions);
    }

    public List<Object[]> findProfessionBySchool(Integer schoolId){
        return schoolProfessionRepository.findProfessionBySchool(schoolId);
    }

    @Override
    public void deleteBySchoolId(Integer schoolId) {
        schoolProfessionRepository.deleteBySchoolId(schoolId);
    }

    @Override
    public void deleteBySchoolIdAndProfessionId(Integer schoolId, Integer professionId) {
        schoolProfessionRepository.deleteBySchoolIdAndProfessionId(schoolId, professionId);
    }

    @Override
    public SchoolProfession findBySchoolIdAndProfessionId(Integer schoolId, Integer professionId) {
        return schoolProfessionRepository.findBySchoolIdAndProfessionId(schoolId, professionId);
    }

    @Override
    public boolean checkProfession(Integer professionId) {
       SchoolProfession schoolProfession =  schoolProfessionRepository.findSchoolProfessionByProfessionId(professionId);
        return schoolProfession != null;
    }


    @Override
    public void delete(Integer id) {
        if (id == null) {
            throw new ServiceException("主键不能为空");
        }
        schoolProfessionRepository.deleteById(id);
    }

    @Override
    public void deleteInBatch(List<SchoolProfession> schoolProfessions) {
        schoolProfessionRepository.deleteInBatch(schoolProfessions);
    }

}
