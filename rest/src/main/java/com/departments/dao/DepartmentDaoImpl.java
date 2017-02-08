package com.departments.dao;

import com.departments.model.Department;
import com.departments.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 8.2.17.
 */
public class DepartmentDaoImpl implements DepartmentDao,InitializingBean {
    private static final Logger log= LoggerFactory.getLogger(DepartmentDaoImpl.class);
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String SQL_FIND_DEPARTMENT_BY_ID="SELECT * FROM department WHERE id =:id";
    private static final String SQL_FIND_ALL_DEPARTMENTS="SELECT * FROM department";
    private static final String SQL_SAVE_DEPARTMENT="INSERT into department(name_department) VALUES (:name_department)";
    private static final String SQL_UPDATE_DEPARTMENT="UPDATE department SET name_department=:name_department WHERE id=:id ";
    private static final String SQL_DELETE_DEPARTMENT="DELETE FROM  department WHERE id =:id";

    public DepartmentDaoImpl(DataSource dataSource) {
        this.dataSource=dataSource;
        this.jdbcTemplate=new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource==null){
            throw  new BeanCreationException("Must set dataSource !!!");
        }
        if (jdbcTemplate==null){
            throw new BeanCreationException("jdbcTemplate is null!!!");
        }
        if (namedParameterJdbcTemplate==null){
            throw new BeanCreationException("namedParameterJdbcTemplate is null!!!");
        }
    }
    @Override
    public Department findDepartmentById(Long id) {
        log.info("Find contact by id={} ",id);
        Map<String,Object> namedParameters=new HashMap<>();
        namedParameters.put("id",id);
        return namedParameterJdbcTemplate.queryForObject(SQL_FIND_DEPARTMENT_BY_ID,namedParameters,new DepartmentRowMapper());
    }

    @Override
    public List<Department> findAllDepartment() {
        log.info("Find all contacts ");
        return namedParameterJdbcTemplate.query(SQL_FIND_ALL_DEPARTMENTS,new DepartmentRowMapper());
    }

    @Override
    public Long save(Department department) {
        log.info("Save new employee ={} ",department);
        KeyHolder keyHolder=new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_SAVE_DEPARTMENT, mapSqlParameterSource(department),keyHolder,new String[]{"id"});
        Long id=keyHolder.getKey().longValue();
        department.setId(id);
        return id;
    }

    @Override
    public void delete(Long id) {
        log.info("Delete  contact with id ={} ",id);
        Map<String,Object> parameters=new HashMap<>();
        parameters.put("id",id);
        namedParameterJdbcTemplate.update(SQL_DELETE_DEPARTMENT,parameters);
    }

    @Override
    public void update(Department department) {
        log.info("Update  contact ={} ",department);
        namedParameterJdbcTemplate.update(SQL_UPDATE_DEPARTMENT,mapSqlParameterSource(department));
    }

    private static final class DepartmentRowMapper implements RowMapper<Department> {
        @Override
        public Department mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department=new Department();
            department.setId(resultSet.getLong("id"));
            department.setNameDepartment(resultSet.getString("name_department"));
            return department;
        }
    }

    private MapSqlParameterSource mapSqlParameterSource(Department department) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", department.getId());
        parameterSource.addValue("name_department",department.getNameDepartment());
        return parameterSource;
    }
}



