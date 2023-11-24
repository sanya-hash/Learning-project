package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.learning.service.VideoService;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/videos")
public class VideoController {
   @Autowired
   private VideoService videoService;
   
   @GetMapping("/all")
   public ResponseEntity<List<String>> getAllVideoNames() {
       try {
           List<String> videoNames = videoService.getAllVideoNames();
           return ResponseEntity.ok(videoNames);
       } catch (IOException e) {
           return ResponseEntity.status(500).body(null);
       }
   }
   
 
   @PostMapping("/upload")
   public ResponseEntity<String> uploadVideo(@RequestPart("file") MultipartFile file) {
       try {
           videoService.uploadVideo(file);
           return ResponseEntity.ok("Video uploaded successfully!");
       } catch (IOException e) {
           return ResponseEntity.status(500).body("Failed to upload video");
       }
//	   System.out.println("Received file: " + file.getOriginalFilename());
//       return ResponseEntity.ok("File uploaded successfully");
   }
   @GetMapping("/{videoName}")
   public ResponseEntity<byte[]> getVideo(@PathVariable String videoName) {
   	 System.out.print("gdkadhl");
       try {
       	
           byte[] data = videoService.getVideo(videoName);
           return ResponseEntity.ok(data);
       } catch (IOException e) {
       	System.out.print("gdkadhl");
           return ResponseEntity.status(404).body(null);
       }
   }
}

