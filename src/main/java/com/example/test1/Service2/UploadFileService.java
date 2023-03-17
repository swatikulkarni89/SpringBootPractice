package com.example.test1.Service2;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;



@Service
public class UploadFileService {
/*@Autowired
private Storage storage;*/
@Value("${gcp.bucket.name}")
private String bucketName;
private static Storage storage = StorageOptions.getDefaultInstance().getService();
    public String uploadFile() throws IOException {

        BlobId id=BlobId.of(bucketName,"D:\\projects\\spring_boot\\test1\\test1\\output.txt");
       /* BlobInfo info= BlobInfo.newBuilder(id).build();*/

        File file= new File("D:\\projects\\spring_boot\\test1\\test1","output.txt");
        BlobInfo blobInfo = BlobInfo.newBuilder(id).
                setContentType(Files.probeContentType(file.toPath())).build();
        byte[]arr= Files.readAllBytes(Paths.get(file.toURI()));

        storage.create(blobInfo,arr);


        return "file has been succsessfully added to bucket";
    }

    }

