package data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dto.MemberDto;
import data.mapper.MemberMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	
	public boolean isMyidCheck(String myid) {
		return memberMapper.checkMyid(myid)==1?true:false;
	}
	
	public void insertMember(MemberDto dto) {
		
		memberMapper.insertMember(dto);
	} 
	
	public List<MemberDto> getAllMember(){
		return memberMapper.getgetAllMember();
	}
}
