package data.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FilenameChange {

	static public String getDateChangeFileName(String originalName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		String fileName=originalName.split("\\.")[0];
		String extName=originalName.split("\\.")[1];
		
		String uploadFileName=fileName+"_"+sdf.format(new Date())+"."+extName;
				
		return uploadFileName;
		
	}
	
	static public String getRandomChangeFileName(String originalName) {
		
		
		//확장자만 구하기
		String extName=originalName.split("\\.")[1];
		
		String uploadFileName=UUID.randomUUID()+"."+extName;
				
		return uploadFileName;
		
	}
	
	
}
