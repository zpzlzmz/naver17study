--join table 연습 -> on delete cascade 로 자식 테이블 생성 

--=부모테이블인 shop을 만들어보자 --상품을 등록하는 테이블 

create table shop(
    sangcode varchar2(10) CONSTRAINT pk_shop_songcode PRIMARY key,
    sangname varchar2(30),
    sangprice number(7)
);


--shop의 상품코드를 참조해 cart 에 담을 수 있도록 테이블 생성
-- 상품을 지우면 cart 의 데이터도 자동으로 지워지도록 on delete cascade 를 설정해서 생성하기
--on delete cascade를 하면 자식 테이블에서 지워지지않던것을 지울 수 있음 
create table cart(
    cartnum number(3) CONSTRAINT pk_cart_cartnum PRIMARY key,
    sangcode varchar2(10),
    cntnum number(3) default 1,
    cartday date,
    CONSTRAINT fk_cart_sangcode FOREIGN key(sangcode) REFERENCES shop(sangcode) on delete cascade
);


--cart  에 들 seqence 생성
create sequence seqcart nocache;

--상품등록을 하자
insert into shop values ('A100', '체크블라우스',23000);

insert into shop values ('A200', '브이넥티셔츠',19000);

insert into shop values ('A300', '레이스블라우스',34000);

insert into shop values ('A400', '블랙진바지',56000);

insert into shop values ('A500', '실프스카프',12000);
insert into shop values ('A600', '패딩',112000);
insert into shop values ('A700', '코카콜라마싯다',99000);
insert into shop values ('A800', '후드집업',20000);
insert into shop values ('A900', '맨투맨',43200);
commit;
select * from shop;
select * from cart;
--cart 에 원하는 상품을 담아보자 

insert into cart (cartnum,sangcode,cartday) values (seqcart.nextval,'A500',sysdate);
insert into cart (cartnum,sangcode,cartday) values (seqcart.nextval,'A700',sysdate);
insert into cart (cartnum,sangcode,cntnum,cartday) values (seqcart.nextval,'A800',3,sysdate);
insert into cart (cartnum,sangcode,cntnum,cartday) values (seqcart.nextval,'A100',2,sysdate);
insert into cart (cartnum,sangcode,cntnum,cartday) values (seqcart.nextval,'A500',1,sysdate);
insert into cart (cartnum,sangcode,cntnum,cartday) values (seqcart.nextval,'A900',6,sysdate);
rollback;
commit;

--join sql 문을 이용해 다음 순서로 출력해보시오 
--cartnum,sangcode, snagname, sangprice,cntnum,cartday(yyyy-mm-dd hh:mm 이렇게 나오게)
select c.cartnum,s.sangcode,s.sangname, s.sangprice,c.cntnum,
    to_char(cartday,'yyyy-mm-dd hh24:mi') cartday 
from  shop s, cart c
where s.sangcode = c.sangcode;


-- outer join 을 이용해 아무도  cart에 담지 않은 상품을 알아보자 !!

select c.cartnum,s.sangcode,s.sangname, s.sangprice,c.cntnum,
    to_char(cartday,'yyyy-mm-dd hh24:mi') cartday 
from  shop s, cart c
where s.sangcode = c.sangcode(+) AND cartnum is null; -- 부모(데이터가 많은쪽)에 +를 붙혀주면 Null 값이 들어간 컬럼들이 나옴(null상품중 아무도 카트에  담지 않은 것들을 출력)



--on delete cascade 로 생성한 경우 카트에 담긴 데이터도 부모테이블인 shop 에서 삭제 가능
-- 이때 상품 삭제시 카트에 담긴 상품은 자동 삭제됨 


--shop에서 A500 을 제거 해보자
delete from shop where sangcode='A500';
--다시 조인으로 확인해보기
select c.cartnum,s.sangcode,s.sangname, s.sangprice,c.cntnum,
    to_char(cartday,'yyyy-mm-dd hh24:mi') cartday 
from  shop s, cart c
where s.sangcode = c.sangcode;
 -- A500 데이터가 사라진 것을 확인 가능 

