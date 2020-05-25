package com.zwk.detection.service;

import com.zwk.detection.dao.TrashDao;
import com.zwk.detection.entity.TrashEntity;
import com.zwk.detection.model.TrashDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("trashDescriptionService")
public class TrashDescriptionServiceImpl implements TrashDescriptionService {

    private final TrashDao trashDao;

    @Autowired
    TrashDescriptionServiceImpl(TrashDao trashDao){
        this.trashDao=trashDao;
    }

    @Override
    public TrashEntity getTrashDescription(Long id) {
        TrashEntity resp = null;
        try {
            resp = this.trashDao.getById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resp;
    }
}
