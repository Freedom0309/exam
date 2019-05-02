package com.jcohy.exam.service;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.DeliveryRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeliveryRecordService {

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<DeliveryRecord> findAll(Pageable pageable);

    /**
     *  查询
     * @return
     */
    List<DeliveryRecord> findAll();


    /**
     *  查询
     * @return
     */
    List<DeliveryRecord> findListByNum(Integer num);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    DeliveryRecord findById(Integer id);

    /**
     * 根据num查询
     * @param num
     * @return
     */
    DeliveryRecord findByNum(Integer num);

    /**
     * 新增或者更新投递记录
     * @param deliveryRecord
     * @return
     */
    DeliveryRecord saveOrUpdate(DeliveryRecord deliveryRecord) throws ServiceException;

    /**
     * 删除投递记录
     * @param id
     */
    void delete(Integer id);

    void changeStatus(Integer id,String type);

    List<DeliveryRecord> findByStatus(Integer status);

    List<DeliveryRecord> findByStatusBetween(int max, int min);
}
