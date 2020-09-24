package beautyhair.main.dao;

import java.util.List;

import beautyhair.main.entity.Picture;

public interface PictureDAO {

	public List<Picture> getPictureList();
	
	public List<Picture> getAllVisiblePictures();
	
	public List<Picture> getThreeImportantPicturesForIndex();
	
	public Picture getPicture(int id);

	public void saveOrUpdatePicture(Picture picture);
	
	public void deletePicture(int id);
	
	public void changePictureVisibleStatus(int id);
	
	public void changePictureImportantStatus(int id);
	
}
