package com.example.udacity.repository;

import com.example.udacity.entity.CandyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CandyDAOImpl implements CandyDAO {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    private static final String selectAllCandys = "select * from candy";
    private static final String getCandyForDelivery="select c.* from candy c" +
            "join candy_delivery cd on c.id=cd.candy_id " +
            "where cd.delivery_id=:deliveryid";
    private static final String addCandyForDelivery="insert into candy_delivery " +
            "values (:candyid,:deliveryid)";
    private static final BeanPropertyRowMapper<CandyData> candyDataBeanPropertyRowMapper=new BeanPropertyRowMapper<>(CandyData.class);

    @Transactional
    public List<CandyData> getCandyList1() {

        return jdbcTemplate.query(selectAllCandys,new MapSqlParameterSource(),
                resultSet->{
            List<CandyData> candyList=new ArrayList<>();
            int row=0;
            while(resultSet.next()){
                candyList.add(candyDataBeanPropertyRowMapper.mapRow(resultSet,row++));
            }
            return candyList;
                });
    }

    @Override
    public List<CandyData> getCandyList() {
        return jdbcTemplate.query(selectAllCandys,candyDataBeanPropertyRowMapper);
    }

    @Override
    @Transactional
    public void addCandyToDelivery(Long deliveryId, Long candyId) {
        jdbcTemplate.update(addCandyForDelivery,
                new MapSqlParameterSource()
                        .addValue("candyid",candyId)
                        .addValue("deliveryId",deliveryId));
    }

    @Override
    @Transactional
    public List<CandyData> getCandyForDelivery(Long deliveryId) {

        return jdbcTemplate.query(getCandyForDelivery,
                new MapSqlParameterSource().addValue("deliveryid",deliveryId),
                candyDataBeanPropertyRowMapper);
    }
}
