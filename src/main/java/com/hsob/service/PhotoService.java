package com.hsob.service;

import com.hsob.model.photos.Photo;
import com.hsob.repository.DAO;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService extends DAO {

    public void saveNewPhoto(List<Photo> photos) {
        for (Photo photo : photos){
            hsobdb.save(photo);
        }

    }

    public Photo getPhotoByDescription(String description) {
        Criteria criteria = Criteria.where("description").is(description);
        Query query = new Query(criteria);
        return hsobdb.findOne(query, Photo.class);
    }

    public List<Photo> getPhotoList() {
        return hsobdb.findAll(Photo.class);
    }
}
