package beautyhair.main.dao;

import java.util.List;

import beautyhair.main.entity.Partner;

public interface PartnerDAO {

	
	public List<Partner> getPartnerList();
	
	public List<Partner> getFourImportantPartnersForIndex();
	
	public List<Partner> getSixPartnersForFooter();
	
	public void saveOrUpdatePartner(Partner partner);
	
	public void deletePartner(int id);
	
	public Partner getPartner(int id);
}
