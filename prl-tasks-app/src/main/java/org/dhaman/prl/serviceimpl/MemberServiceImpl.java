package org.dhaman.prl.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.dhaman.prl.entity.Member;
import org.dhaman.prl.repos.MemberRepos;
import org.dhaman.prl.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepos repos;

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public Member findById(Integer id) {
		Optional<Member> result = repos.findById(id);
		Member entity = null;
		if (result.isPresent()) {
			entity = result.get();
		}
		return entity;
	}

	@Override
	public Member create(Member entity) {
		return repos.save(entity);
	}

	@Override
	public Member update(Member entity, Integer id) {
		entity.setId(id);
		return repos.save(entity);
	}

	@Override
	public String delete(Integer id) {
		String output = "Record has been deleted";
		Member entity = findById(id);
		if (entity == null) {
			return "Record not found";
		}
		repos.deleteById(id);
		return output;

	}

}
