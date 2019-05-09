package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.Profession;
import com.jcohy.exam.model.SchoolProfession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolProfessionService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<SchoolProfession> findAll(Pageable pageable);


    /**
     *  查询
     * @return
     */
    List<SchoolProfession> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    SchoolProfession findById(Integer id);

    /**
     * 查询学校的专业
     * @param schoolId
     * @return
     */
    List<SchoolProfession> findBySchoolId(Integer schoolId);

    /**
     * 新增或者更新学院
     * @param schoolProfession
     * @return
     */
    SchoolProfession saveOrUpdate(SchoolProfession schoolProfession) throws ServiceException;

    /**
     * 批量新增专业
     * @param professions
     * @return
     */
    List<SchoolProfession> batchSave(List<SchoolProfession> professions);
    /**
     * 检查专业是否存在
     * @param professionId 专业id
     * @return
     */
    boolean checkProfession(Integer professionId);

    /**
     * 删除学校下的专业
     * @param id
     */
    void delete(Integer id);

    /**
     * 批量删除学校下专业
     */
    void deleteInBatch(List<SchoolProfession> schoolProfessions);

    /**
     * 查询学校下的专业
     * @param schoolId
     * @return
     */
    List<Object[]> findProfessionBySchool(Integer schoolId);

    /**
     * 查找学校和专业的关系
     * @param schoolId
     * @param professionId
     * @return
     */
    SchoolProfession findBySchoolIdAndProfessionId(Integer schoolId, Integer professionId);

    /**
     * 删除学校下的专业
     * @param schoolId
     * @param professionId
     */
    void deleteBySchoolIdAndProfessionId(Integer schoolId, Integer professionId);

    /**
     * 删除学校下的所有专业
     * @param schoolId
     */
    void deleteBySchoolId(Integer schoolId);

}
