package io.day14;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FileSelectTest {
    //GUI : Graphic User Interface
    // java.awt 와 java.swing 에서 제공합니다.
    public static void main(String[] args) {
        fileDialog();
    }
    
    
    public static Map<String,String> fileDialog(){
        JFrame jf = new JFrame();
        jf.setVisible(false);
        
        FileDialog fd = new FileDialog(jf,"파일선택",FileDialog.LOAD);
        fd.setVisible(true);
        // System.out.println("선택한 폴더 : " + fd.getDirectory());
        // System.out.println("선택한 파일 : " + fd.getFile());
        // System.out.println("경로"+fd.getDirectory().replace("\\", "\\\\")+fd.getFile());

        Map<String,String> map = new HashMap<>();
        map.put("folder",fd.getDirectory().replace("\\", "\\\\"));
        map.put("filename",fd.getFile());
        return map;
    }
}
