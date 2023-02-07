package com.hypeboy.HoTalking.domain.image;

import com.hypeboy.HoTalking.domain.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ImageService {

    private final ImageRepository imageRepository;

    private final ImageHandler imageHandler;

    @Transactional
    public void addImage(Image image, List<MultipartFile> files, Post post) throws Exception{
        // 파일을 저장하고 그 Image 에 대한 list 를 가지고 있는다
        List<Image> list = imageHandler.parseFileInfo(image.getId(), files);
        if (list == null || list.isEmpty()) {
            throw new RuntimeException();
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            log.info("else");
            for (Image images : list) {
                post.addImage(imageRepository.save(images));
            }
        }
    }

    public List<Image> findBoards() {
        return imageRepository.findAll();
    }

    public Optional<Image> findBoard(Long id) {
        return imageRepository.findById(id);
    }
}
