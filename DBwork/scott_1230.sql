--commit; --dml 은 commit 을 해줘야함 
--emp table 로 연습할 예정 
--job 컬럼의 데이터중 중복되는 데이터는 한번만 출력해보자 ( distinct ) 
select distinct job from emp;

select distinct job, ename from emp; -- 다른 컬럼하고 같이 쓸경우 적용이 안되거나 오류가 날 가능성이 생김 중복제거를 하고 보고싶으면 해당 컬럼만 보는게 좋음 

select * from emp;--전체 컬럼 조회(emp)

select ename,job from emp ; --ename과 job(일부 컬럼)만 찾기

select ename,job from emp order by ename ; -- ename 의 오름차순 조회(asc인 경우는 생략) A부터
select ename,job from emp order by ename DESC; -- ename 의 내림차순 조회 Z부터 


select job,ename from emp order by job,ename desc; --같은 직업일때 이름을 내림차순으로 . if 둘다 오름차순으로 하고싶다면 ? 
select job,ename from emp order by job,ename; --이렇게 하기.


-- 순서를 정할때 컬럼명 대신  컬럼 번호로 해도 된다(첫번재 컬럼은 0이 아니라 1임) 유남쌩 ?
select job,ename from emp order by 1,2; -- job(1),ename(2) 가 됨 ㅇㅋ ? 

-- sal 의 오름차순 정렬 을 하고싶다면 ? 
select * from emp order by 6 ; --* (모든 컬럼을 출력했기때문에 컬럼 번호로 하는게 맞음) 위에처럼 특정 컬럼을 따로 뽑아 쓸때는 앞에 select 로 선언한 순서로 해야함 .

-- empno 의 오름차순 조회
select ename,sal,comm,job,empno from emp order by 5;
select ename,sal,comm,job,empno from emp order by empno;

--ename 의 내림차순 
select ename,sal,comm,job,empno from emp order by 1 desc;
select ename,sal,comm,job,empno from emp order by ename desc;

-- where 조건문 사용
select ename,job,sal,comm from emp where ename = 'ALLEN'; -- 데이터는 대 소문자 정확하게 구분해서 써야함 ; 졸라 귀찮음 

--Ename 이 A로 시작하는데이터 조회
select ename,job,sal,comm from emp where ename like 'A%';
--ENAME에 A가 포함된 이름을 출력 
select ename,job,sal,comm from emp where ename like '%A%';

--Ename 에 A로 시작하거나 S로 시작하는 데이터 조회
select ename,job,sal,comm from emp where ename like 'A%' or ename like 'S%';

--ENAME 에 A와S를 모두 포함
select ename,job,sal,comm from emp where ename like '%A%' and ename like '%S%';

--ENAME 에서 두번째 글자가 A인 사람만 조회

select ename,sal,comm,job,empno from emp where ename like '_A%';
--ename 의 두번째 글자가 A이거나 3번째 글자가 A인 사람 출력 
select ename,sal,comm,job,empno from emp where ename like '_A%' or ename like '__A%';

--ename 이 n이나 k 로 끝나느 사람만 조회
select ename,sal,comm,job,empno from emp where ename like '%N' or ename like '%K';

--job이 analyst 이면서 연봉이(sal) 1500 이상인 사람을 출력
select ename,sal,comm,job,empno from emp where job like'ANALYST' and sal >=1500;

--sal 1200-2000 사이값 조회

select ename,sal,comm,job,empno from emp where sal>1200 and sal <=2000; -- 방법 1
select ename,sal,comm,job,empno from emp where sal BETWEEN 1200 and 2000; -- 방법 

--job이 manager , salesman, analyst 이 3가지 직업의 사람을 조회
select ename,sal,comm,job,empno from emp where job='MANAGER' or job='SALESMAN' or job='ANALYST'; --방법 1
select ename, sal,comm,job, empno from emp where job in('MANAGER','SALESMAN','ANALYST'); -- 방법 2
--그 이외의 사람들 출력 
select ename, sal,comm,job, empno from emp where job not in('MANAGER','SALESMAN','ANALYST');

--empno가 7654.7788.7844.7902인 사람만 조회
select ename,sal,comm,job,empno from emp where empno in(7654,7788,7844,7902);

--comm이 null 인 데이터 만 출력  
select ename, sal,comm,job, empno from emp where comm is null;
--comm이 null 이 아닌 데이터만 출력 
select ename, sal,comm,job, empno from emp where comm is not null;

--mgr이 null이 아닌 경우면 조회
select * from emp where mgr is not null;

--comm 이 Null인 경우 0으로 만드는 것 
 select ename, sal,NVL(comm,0),job, empno,NVL(mgr,100) from emp;
 
 -- Null과 숫자를 더하면 NULL 이 출력 
 --위의 경우 sal+comm이 Null 인 경우 0으로 출력
 select sal,comm,NVL(sal+comm,0) from emp; 