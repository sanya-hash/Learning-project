package com.learning.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.learning.entity.Video;


import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//@Service
//public class VideoService {
//   private static final String UPLOAD_FOLDER = "D://videos";
//   public void uploadVideo(MultipartFile file) throws IOException {
//       byte[] bytes = file.getBytes();
//       Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
//       Files.write(path, bytes);
//   }
//   public Video getVideo(String videoName) throws IOException {
//       Path path = Paths.get(UPLOAD_FOLDER + videoName);
//       byte[] data = Files.readAllBytes(path);
//       Video video = new Video();
//       video.setName(videoName);
//       video.setContent(data);
//       return video;
//   }
//}

@Service
public class VideoService {
   private static final String UPLOAD_FOLDER = "D://videos";
   
   
   public List<String> getAllVideoNames() throws IOException {
       List<String> videoNames = new ArrayList<>();
       Path videosPath = Paths.get(UPLOAD_FOLDER);

       try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(videosPath)) {
           for (Path path : directoryStream) {
               if (Files.isRegularFile(path)) {
                   videoNames.add(path.getFileName().toString());
               }
           }
       }

       return videoNames;
   }

   public void uploadVideo(MultipartFile file) throws IOException {
       byte[] bytes = file.getBytes();
       Path path = Paths.get(UPLOAD_FOLDER + File.separator + file.getOriginalFilename());
       Files.write(path, bytes);
   }

   public byte[] getVideo(String videoName) throws IOException {
       Path path = Paths.get(UPLOAD_FOLDER + File.separator + videoName);

       if (!Files.exists(path)) {
           throw new IOException("File not found");
       }

       byte[] data = Files.readAllBytes(path);
//       VideoDto video = new VideoDto();
//       video.setContent(data);
//       return video;
       return data;
       
   }

   
}
