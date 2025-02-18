package shop.data;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.db.ConnectionManager;

public class ShopDao {
	ConnectionManager connectionManager=ConnectionManager.getInstance();
	
	SqlSession session;
	String nameSpace="shop.data.ShopDao.";
	
	private SqlSession getSession()
	{
		session=connectionManager.openSession();
		return session;
	}
	
	//shop 의 전체 갯수를 반환하는 메서드
	public int getTotalCount()
	{
		session=this.getSession();
		//nameSpace는 생략이 가능하기는 하나, 다른곳에 같은 아이디가 존재할겨우
		//오류가 발생하므로 오류방지를 위해서 넣어주는것이 좋다
		int tc=session.selectOne(nameSpace+"totalCount");
		session.close();
		return tc;
	}
	
	//전체 데이타 반환
	public List<ShopDto> getAllDatas()
	{
		session=getSession();
		List<ShopDto> list=session.selectList(nameSpace+"selectAllList");
		session.close();
		return list;
	}
	
	//insert
	public void insertShop(ShopDto dto)
	{
		session=getSession();
		session.insert(nameSpace+"insertShop", dto);
		session.close();
	}
	
	public ShopDto getSangpum(int num)
	{
		session=getSession();
		ShopDto dto=session.selectOne(nameSpace+"selectOneByNum", num);
		session.close();
		return dto;
	}
	
	public void updateShop(ShopDto dto)
	{
		session=getSession();
		session.update(nameSpace+"updateShop", dto);
		session.close();
	}
	
	public void deleteShop(int num)
	{
		session=getSession();
		session.update(nameSpace+"deleteShop", num);
		session.close();
	}
}






















