package home.server.syc.service;

import home.server.syc.domain.FileVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImple implements FileService{
    private final Logger logger = LoggerFactory.getLogger(FileServiceImple.class);
    public List<FileVO> readAll() throws Exception {
        logger.info("readAll() called");
        Path dirPath = Paths.get("C:\\Users\\goott3\\Pictures");
        List<FileVO> fileList;

        try {
            Collectors Collectors = null;
            fileList = Files.list(dirPath)
                    .map(path -> {
                        // FileVO에 맞게 파일 정보를 매핑
                        FileVO fileVO = new FileVO();
                        fileVO.setFileName(path.getFileName().toString());
                        try {
                            fileVO.setSize(Files.size(path));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        fileVO.setType(Files.isDirectory(path) ? "Folder" : "File");
                        // 파일 생성 날짜 등 추가 정보 설정
                        // ...
                        return fileVO;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw e;
        }

        return fileList;
    }
}
