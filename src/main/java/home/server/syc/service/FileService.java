package home.server.syc.service;

import home.server.syc.domain.FileVO;

import java.util.List;

public interface FileService {
    List<FileVO> readFileList() throws Exception;
}
