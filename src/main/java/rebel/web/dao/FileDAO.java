package rebel.web.dao;

import rebel.web.model.UploadFile;

public interface FileDAO {
public abstract void uploadFile(UploadFile file);
	
	public abstract UploadFile getFile(String username);

}
