package helper;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadHelper {
	private final static    String upload_dir= "D:\\eclipse-workspace\\BookSpringBootProject\\src\\main\\resources\\static";
	 
	public static   boolean uploadFile(MultipartFile f) {
		boolean b = false;
		try {
//		InputStream is = f.getInputStream();
//		byte data[]= new byte [is.available()];
//		is.read(data);
//		FileOutputStream fos =new  FileOutputStream(upload_dir+"\\"+f.getOriginalFilename());
//		 fos.flush();
//		fos.close();
			 Files.copy(f.getInputStream(), Paths.get(upload_dir+File.separator+f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
//			Files.copy(f.getInputStream(),Paths.get(upload_dir+File.separator+f.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		b=true;
		
	 
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;

}
}

	 
