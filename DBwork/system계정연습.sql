-- system에 등록된 table 들 확인하기

select * from tab;

-- 등록된 user (계정)들 확인
select username from dba_users; --dba_users 테이블에서 username이라는 컬럼만 확인


--dba_users 라는 테이블에는 어떤 컬럼이 있을까 ?
desc dba_users; --기본 구조만 확인(안에 데이터는 확인x)
select username,account_status from dba_users; --계정과 lock 상태 알아보기

--scott 계정에 비번은 tiger(oracle 은 알파벳으로 시작해야함)로 생성해보자
create user scott IDENTIFIED by tiger; -- 오류가 발생함(12버전 부터)

--12 버전 부터는 user명에 공통문자열 c##이 들어가야 된다
 --일딴 C##scott / 비번은 tiger로 
 create user c##scott IDENTIFIED by tiger; 
 --c##scott 계정을 삭제 후 공통문자열을 안넣고도 생성하는 방법으로 다시 생성 해보자
 
 drop user c##scott;
 
 alter session set "_ORACLE_SCRIPT" = true;
 
 create user scott IDENTIFIED by tiger;
 
 CREATE user angel IDENTIFIED by a1234;
 
 select username,account_status from dba_users;
 
 --계정 lock 설정 하기
  alter user angel ACCOUNT lock;
  select username,account_status from dba_users;
 alter user angel ACCOUNT unlock;
 
 --scott과  angel 계정에 기본 권한 주기
--connect: 접속 할 수 있는 권환
--resource : 데이터 관리를 할 수 있는 권한 
grant connect, resource to angel;
grant connect, resource to scott;


--생성된 계정에서 테이블을 생성하고 데이터를 추가하려고 하면 table space 에 대한 오류가 발생
--table space 를  unlimit 으로 설정(system계정에서만 가능)
alter user angel default TABLESPACE users quota unlimited on users;
alter user scott default TABLESPACE users quota unlimited on users; 

-- angel 의 비밀번호를 a1234에서 pw1234 로 변경해보자
alter user angel IDENTIFIED by pw1234;


show user;




