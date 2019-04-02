package dao;

import org.springframework.jdbc.core.JdbcTemplate;
import utilities.Environment;

import java.util.List;
import java.util.Map;

public class CoreDaoImpl implements ICoreDao {

    private JdbcTemplate jdbcTemplate;

    public CoreDaoImpl(){
        this.jdbcTemplate = Environment.dataSources.getCoreJdbcTemplate();
    }

    //override methods go here
}
