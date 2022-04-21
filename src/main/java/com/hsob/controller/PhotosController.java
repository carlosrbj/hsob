package com.hsob.controller;

import com.hsob.model.photos.Photo;
import com.hsob.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/photos")

public class PhotosController {
    @Autowired
    protected PhotoService photoService;


    @PostMapping("save-photo")
    public ResponseEntity savePhoto(@RequestBody List<Photo> photos){
        try {
            photoService.saveNewPhoto(photos);
            return ResponseEntity.ok("Photos saved");
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping("get-photo")
    public ResponseEntity getPhotoByDescription(@RequestParam String description){
        try {
            Photo photo = photoService.getPhotoByDescription(description);
            return ResponseEntity.ok(photo);
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @GetMapping("get-photo-list")
    public ResponseEntity getPhotoByDescription(){
        try {
            List<Photo> photos = photoService.getPhotoList();
            return ResponseEntity.ok(photos);
        } catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }



}
