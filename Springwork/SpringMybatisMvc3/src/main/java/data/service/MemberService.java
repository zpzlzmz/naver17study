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
		return memberMapper.getAllMember();
	}
	
	public void deleteMember(int num) {
		memberMapper.deleteMember(num);
	}
	
	public boolean loginCheck(String loginid, String loginpass) {
		return memberMapper.loginCheck(loginid, loginpass) == 1?true:false;
	}
	
	public MemberDto getSelectByNum(int num) {
		return memberMapper.getSelectByNum(num);
	}
	
	public MemberDto getSelectByMyid(String myid) {
		return memberMapper.getSelectByMyid(myid);
	}
	
	public void changePhoto(int num, String mphoto) {
		memberMapper.changePhoto(mphoto, num);
	}
	
	public void updateMember(MemberDto dto) {
		memberMapper.updateMember(dto);
	}
}
