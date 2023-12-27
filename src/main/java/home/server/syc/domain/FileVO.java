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
    private String data;

    public static String fileSize(long size) {
        if(size <= 0) return "0";


        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB", "PB"};


        int digitGroups = (int) (Math.log10(size)/Math.log10(1024));


        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

}
