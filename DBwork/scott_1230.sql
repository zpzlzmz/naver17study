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
 
 --컬럼 제목에 별칭(alias)
 select ename as "사원명",sal as "월급여" from emp;
 select ename "사원명", sal "월급여" from emp; -- as 생략하고 alias 지정하는 방법
 select ename 사원명, sal 월급여 from emp; -- alias 에 공백이 없는 경우 "" 도 생략가능
 select ename "사원 이름", sal 월급여 from emp; --이처럼 (사원 이름)제목에 공백이 들어가면 "" 생략 불가능 -> 공백이 있는경우 "" 를 반드시 써주기
 
 --총 레코드 개수 (총 데이터 개수)
 select count(*) from emp;
 select count(*) count from emp; -- 이경우 컬럼명이 count 
 select count(*) 총갯수 from emp;
 
 select sal,comm,sal+NVL(comm,0) sum from emp;
 select sal 월급여,NVL(comm,0) 커미션,sal+NVL(comm,0) 총금액 from emp;
 --문자열을 컬럼에 추가시 || 연산자 사용.
 select '내이름은 ' ||ename||' 입니다' 자기소개 from emp;
 select '내 직업은 ' || job ||' 이고 내 월급은 '|| sal || '$입니다.  요로시구 오네가이시마스' 자기소개 from emp;
 
select * from emp where sal between 1500 and 2000;
select * from emp where sal not between 1500 and 2000;

--not in 을 사용해 job이 sales man , clerk 이 아닌 것만 출력 ? 
select * from emp where job not in('SALESMAN','CLERK');

--group 함수(count sum avg max min) 등이 있음
select count(*) from emp;
select sum(sal) from emp;
select round(avg(sal),2) from emp; -- avg 는 보통 소숫점이 엄청 길기 때문에 round 함수를 함께 사용해 (ex) 2번째 자리 까지 구한다.
select max(sal) from emp;
select min(sal) from emp;

-- 평균 급여 보다sal 이 더 높은 사람을 조회하시오 
select ename from emp where sal> (select round(avg(sal))from emp);

--scott 과 같은 직업을 가진 사람을 구하시오
select * from emp where  job = (select job from emp where ename = 'SCOTT');
select * from emp where  mgr = (select mgr from emp where ename='SCOTT');

-- group by
select job from emp group by job;

-- job 의 그룹별로 인원수를 구해보자 
select job,count(*) 인원 from emp group by job;

--제목에 별칭을 부여
select job 직업,count(*) 인원 from emp group by job;
select job 직업,count(*) 인원 from emp group by job having count(job)>=3;
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3 order by 2; -- or 인원수 

--직업별 인원수 최저연봉, 최고연봉, 평균 연봉 (소수점 이하 없이)을 구하시오 
select job 직업, count(*) 인원수,max(sal) 최고연봉, min(sal) 최저연봉, round(avg(sal)) 평균연봉 from emp group by job order by job;


--- 48 page number function 
select abs(-5), abs(5) from dual; -- 절대값

select round(3.6,0),CEIL(3.6), Floor(3.6) from dual;--round 반올림 ceil 무조건 올림, floor 무조건 내림

select round(328947,-2) from dual ; -- 328900 반올림 하는거임 해당 자리 까지 

select round(avg(sal),0), ceil(avg(sal)),floor(avg(sal)) from emp;

--power(M,n): m의n승값을 구합
--mod(m,n) : m을n으로 나눈 나머지 값
select power(3,3), mod(10,3) from dual; -- 27,1 3의 3제곱 and 10/3의 나머지 1

--문자 함수 CONCAT(문자연결),LOWER(소문자 변환),UPPER(대문자 변환),INITCAP(첫글자만 대문자로)
Select ename, concat(ename,'님'),lower(ename),upper(ename), initcap(ename) from emp;

--lpad 왼쪽부터 지정한 문자로 변경하는것 
select LPAD(sal,10,'*') from emp;
--rpad lpad 반대 
select rpad(sal,10,'*') from emp;

select substr('Happy day',7,3) from dual; -- 7번 글자부터 3글자 추출 
select substr('Happy day',-7,3) from dual; -- 뒤에서 부터 7번째 글자부터 3글자 추출 p p y

select RPAD(substr(ename,1,3),7,'*') from emp;

--length 길이 구하기, 
select ename 이름, length(ename) 이름길이 from emp;

--replace happy를 good 으로 변경해서 출력 
select replace('Happy day','Happy','Good') from dual;

--trim 앞 뒤 공백 제거
select '*'||' Lee Su GEE  '||'*' from dual;
select trim('    Lee Su GEE    ') from dual;--앞 뒤 공백 제거됨 

--현재 날짜 를 나타내는 sysdate 
select sysdate from dual;
select sysdate+7 from dual;
select sysdate+1 "내일 날짜" from dual;

--to char 함수를 이용해 원하는 날짜 모양으로 출력 
select to_char(sysdate,'yyyy-mm-dd') from dual;
--mm:월 mi:분 hh:12시간 표시 am또는 pm: 오잔이나 오후 표시
select to_char(sysdate,'yyyy-mm-dd am hh:mi') from dual;
select to_char(sysdate,'yyyy-mm-dd hh24:mi') from dual;

select to_char(sysdate,'month') from dual ;--지역에 따라 그 해당 언어로 나오기 때문에 에러가 발생할 수 있어 잘 사용하지 않는다.

--년
select to_char(sysdate, 'yyyy') from dual ;
--월
select to_char(sysdate, 'mm') from dual ;
select to_char(to_date('2024-5-10'),'mm') from dual;
--일
select to_char(sysdate, 'dd') from dual;
-- 요일
select to_char(sysdate, 'dy') from dual;

--emp의 hiredate 는 날짜타입
select to_char(hiredate,'yyyy-mm-dd') 입사일 from emp;



