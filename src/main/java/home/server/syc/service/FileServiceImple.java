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
import java.util.stream.Stream;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@Service
public class FileServiceImple implements FileService{
    private final Logger logger = LoggerFactory.getLogger(FileServiceImple.class);

    private final Path rootLocation;

    public FileServiceImple() {
        this.rootLocation = Paths.get("C:\\Users\\goott3\\Pictures");
    }

    public List<FileVO> readFileList() throws Exception {
        Path dirPath = rootLocation.resolve(path).normalize().toAbsolutePath();
        if (!dirPath.startsWith(rootLocation)) {
            throw new SecurityException("Access is denied");
        }

        try (Stream<Path> stream = Files.walk(dirPath, 1)) {
            return stream
                    .filter(Files::isRegularFile)
                    .map(this::pathToFileVO)
                    .collect(Collectors.toList());
        }

    }

    private FileVO pathToFileVO(Path path) {
        try {
            FileVO metaData = new FileVO();
            metaData.setFileName(path.getFileName().toString());
            metaData.setType(Files.probeContentType(path));
            long size = Files.size(path);
            metaData.setSize(size); // 변경된 메소드 사용
            metaData.setDate(Files.getLastModifiedTime(path).toString());
            return metaData;
        } catch (IOException e) {
            logger.error("Failed to access file " + path, e);
            throw new RuntimeException("Failed to access file " + path, e);
        }
    }
    
}
