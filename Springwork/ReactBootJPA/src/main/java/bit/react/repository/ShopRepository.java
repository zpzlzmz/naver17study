package bit.react.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import bit.react.data.ShopEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ShopRepository extends JpaRepository<ShopEntity,Integer>{

    @Query(value = """
            update jpashop set sangpum=:#{#entity.sangpum},price=:#{#entity.price},
                        color=:#{#entity.color},sangguip=:#{#entity.sangguip} where num=:#{#entity.num}
            """,nativeQuery = true)
    @Modifying //insert, update, delete  뿐만 아니라 DDL 구문을 사용할 때 표기
    @Transactional //Update, delete 를 할 때 표기해줘야 정상 실행
    public void updateShopNoPhoto(@Param("entity") ShopEntity shopEntity);
	
}
