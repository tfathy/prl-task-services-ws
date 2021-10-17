package org.dhaman.prl.service;

import java.util.List;

import org.dhaman.prl.entity.Member;



public interface MemberService {
	
	public List<Member> findAll();

	public Member findById(Integer id);

	public Member create(Member entity);

	public Member update(Member entity, Integer id);

	public String delete(Integer id);

}
