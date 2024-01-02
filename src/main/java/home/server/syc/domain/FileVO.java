package home.server.syc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {
    private String fileName;
    private long size;
    private String type;
    private String date;





}
