package ar.com.indexer.bo;

import ar.com.indexer.dao.BcpDAO;
import ar.com.indexer.dto.BcpDTO;

public class BcpBO {
	
	private BcpDAO bcpDAO;

	public void guardarBcp(BcpDTO bcpDTO) {

		bcpDAO.saveBcp(bcpDTO);
		
		
	}

	public BcpDAO getBcpDAO() {
		return bcpDAO;
	}

	public void setBcpDAO(BcpDAO bcpDAO) {
		this.bcpDAO = bcpDAO;
	}
	
	

}
