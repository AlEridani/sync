package home.server.syc.controller;

import home.server.syc.domain.FileVO;
import home.server.syc.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileRestController {
    private final Logger logger = LoggerFactory.getLogger(FileRestController.class);

    @Autowired
    private FileService service;

    @GetMapping("/api/file-list")
    public ResponseEntity<List<FileVO>> fileList() {
        logger.info("fileList() called");
        ResponseEntity<List<FileVO>> entity = null;
        try {
            entity = new ResponseEntity<>(service.readAll(), HttpStatus.OK);
        } catch (Exception e) {
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
