package com.hypeboy.HoTalking.domain.image;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    private final ImageHandler imageHandler;

    public Image addImage(Image image, List<MultipartFile> files) throws Exception{
        // 파일을 저장하고 그 Board 에 대한 list 를 가지고 있는다
        List<Image> list = imageHandler.parseFileInfo(image.getId(), files);

        if (list.isEmpty()){
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            List<Image> pictureBeans = new ArrayList<>();
            for (Image boards : list) {
                pictureBeans.add(imageRepository.save(boards));
            }
        }

        return imageRepository.save(image);
    }

    public List<Image> findBoards() {
        return imageRepository.findAll();
    }

    public Optional<Image> findBoard(Long id) {
        return imageRepository.findById(id);
    }
}
