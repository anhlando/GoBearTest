package services.dataServices;

import dao.CoreDaoImpl;
import dao.ICoreDao;

public class DbDataService implements IDataService {

    private static ICoreDao bslDao = new CoreDaoImpl();


}

