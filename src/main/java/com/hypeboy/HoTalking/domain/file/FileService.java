package com.hypeboy.HoTalking.domain.file;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;


    private String location = "/home/hypeboy/files";

    private String dateFormatMonth = "yyyyMM";

    public com.hypeboy.HoTalking.domain.file.File registerFile(MultipartFile multipartFile) throws Exception {

        String originalFileName = multipartFile.getOriginalFilename();
        String contentType = multipartFile.getContentType();
        long size = multipartFile.getSize();

        java.io.File file = new File(getDirectory(), UUID.randomUUID() + "_" + originalFileName);

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new Exception("Cannot save file");
        }

        com.hypeboy.HoTalking.domain.file.File uploadedFile = com.hypeboy.HoTalking.domain.file.File
                .builder()
                .originalFileName(originalFileName)
                .storedFileName(multipartFile.getName())
                .fileSize(size)
                .build();

         fileRepository.save(uploadedFile);

         return uploadedFile;

    }

    private String getDirectory() {
        return getDirectory(new Date());
    }

    private String getDirectory(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatMonth);

        File directory = new File(location, dateFormat.format(date));
        if (!directory.exists()) {
            directory.mkdirs();
        }

        return directory.getAbsolutePath();
    }


}
