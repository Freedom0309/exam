package com.jcohy.exam.service.impl;

import com.jcohy.exam.exception.ServiceException;
import com.jcohy.exam.model.DeliveryRecord;
import com.jcohy.exam.respository.DeliveryRecordRepository;
import com.jcohy.exam.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {


    @Autowired
    private DeliveryRecordRepository deliveryRecordRepository;

    @Override
    public Page<DeliveryRecord> findAll(Pageable pageable) {
        return deliveryRecordRepository.findAll(pageable);
    }

    @Override
    public List<DeliveryRecord> findAll() {
        return deliveryRecordRepository.findAll();
    }

    @Override
    public List<DeliveryRecord> findListByNum(Integer num) {
        return deliveryRecordRepository.findDeliveryListRecordByNum(num);
    }

    @Override
    public DeliveryRecord findById(Integer id) {
        return deliveryRecordRepository.findById(id).get();
    }

    @Override
    public DeliveryRecord findByNum(Integer num) {
        return deliveryRecordRepository.findDeliveryRecordByNum(num);
    }

    @Override
    public DeliveryRecord saveOrUpdate(DeliveryRecord deliveryRecord) throws ServiceException {
        if(deliveryRecord.getId() == null){
            deliveryRecord.setStatus(0);
        }
        return deliveryRecordRepository.save(deliveryRecord);
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            throw new ServiceException("主键不能为空");
        }
        deliveryRecordRepository.deleteById(id);
    }

    @Override
    public void changeStatus(Integer id,String type) {
        DeliveryRecord deliveryRecord = findById(id);
        deliveryRecord.setStatus(Integer.parseInt(type));
        deliveryRecordRepository.save(deliveryRecord);
    }

    @Override
    public List<DeliveryRecord> findByStatus(Integer status) {
        if(status>2){
            return deliveryRecordRepository.findAllByStatusGreaterThanEqual(status);
        }else{
            return findByStatusBetween(status,2);
        }
    }

    @Override
    public List<DeliveryRecord> findByStatusBetween(int min, int max) {
        return deliveryRecordRepository.findAllByStatusBetween(min,max);
    }
}
