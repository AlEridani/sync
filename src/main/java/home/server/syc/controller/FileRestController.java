package home.server.syc.controller;

import home.server.syc.domain.FileVO;
import home.server.syc.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class FileRestController {
    private final Logger logger = LoggerFactory.getLogger(FileRestController.class);

    @Autowired
    private FileService service;

    List<String> fileNames = new ArrayList<>();


    @GetMapping("/api/file-list")
    public List<FileVO> listFiles() {
          logger.info("listFiles");
          List<FileVO> fileVOList = new ArrayList<>();
          try {
                fileVOList = service.readFileList();
          } catch (Exception e) {
                e.printStackTrace();
          }
          return fileVOList;
    }
}
