package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
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
    public List<SchoolProfession> batchSave(List<SchoolProfession> professions);
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
     * 查询学校下的专业
     * @param schoolId
     * @return
     */
    List<Object> findProfessionBySchool(Integer schoolId);

}
