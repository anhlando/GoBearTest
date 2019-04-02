package utilities;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Properties;

public class JdbcSources {
    private Properties settings;
    public JdbcTemplate coreJdbcTemplate;

    public JdbcSources(Properties settings) {
        this.settings = settings;

        //instantiate the coreJdbcTemplate
        BasicDataSource dsCore = new BasicDataSource();
        dsCore.setDriverClassName(settings.getProperty("db.driver"));
        dsCore.setUrl(settings.getProperty("db.url"));
        dsCore.setUsername(settings.getProperty("db.username"));
        dsCore.setPassword(settings.getProperty("db.password"));
        this.coreJdbcTemplate = new JdbcTemplate(dsCore);
        Log.info("Jdbc template has been instantiated: " + this.coreJdbcTemplate.getDataSource().toString());

        //can be extended for more JdbcTemplate for other databases

    }

    public JdbcTemplate getCoreJdbcTemplate() {
        return coreJdbcTemplate;
    }

    public void setCoreJdbcTemplate(JdbcTemplate coreJdbcTemplate) {
        this.coreJdbcTemplate = coreJdbcTemplate;
    }

}
