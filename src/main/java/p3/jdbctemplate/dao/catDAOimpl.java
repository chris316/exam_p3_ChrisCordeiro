package p3.jdbctemplate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import p3.jdbctemplate.model.Cat;
import p3.jdbctemplate.model.CatRowMapper;

@Repository
@Transactional
public class catDAOimpl implements CatDAO {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Cat> findAll(){
	String sql="SELECT c.id, c.name, c.type FROM cats c";
	RowMapper<Cat> rowMapper=new BeanPropertyRowMapper<Cat>(Cat.class);
	return jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public Optional<Cat> findById(Long id) {

		Optional<Cat> oCat = Optional.ofNullable(null);
		String sql = "SELECT c.id, c.name, c.type FROM cats c WHERE c.id = ?";

		if (id != null) {
			RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<Cat>(Cat.class);
			Cat cat = jdbcTemplate.queryForObject(sql, rowMapper, id);
			oCat = Optional.ofNullable(cat);
		}
		return oCat;
	}

	@Override
	public Optional<List<Cat>> findByType(String type) {
		Optional<List<Cat>> oCat=Optional.ofNullable(null);
		List<Cat> cats=new ArrayList<Cat>();
		String sql="SELECT c.id, c.name, c.type FROM cats c WHERE c.type=?";
		if(type != null) {
			RowMapper<Cat> rowMapper=new CatRowMapper();
			cats = jdbcTemplate.query(sql,rowMapper,type);
			oCat=Optional.ofNullable(cats);
		}
		return oCat;
	}

	@Override
	public boolean deleteById(Long id) {
		String sql="DELETE FROM cats c WHERE c.id=?";
		jdbcTemplate.update(sql,id);
		return true;
	}
}
