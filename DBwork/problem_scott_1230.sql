-- 12월 30일 oracle 문제 

--1.어떤 종류의 직업이 있는지 job을 한번씩만 출려갛는데 직업의 오룸차순
select distinct job from emp order by job asc;

--2.ename에 대소문자 상관없이 s를 포함하고 있는데이터 출력
select ename,job,sal from emp where lower(ename) like '%s%';

--3.ename의 3번째 글자가 L인 사람 조회
select ename,job,sal from emp where ename like '__L%';

--4.comm이 NULL이 아닌사람중에 sal이 1500 이상인 사람들 
select ename,sal,comm from emp where sal>=1500 and comm is not null;

--5. hiredate 입사일이 5월인 사람은 모두 출력(컬럼:ename,hiredate,sal)?
select ename,hiredate,sal from emp where to_char(hiredate,'mm') = 05;

--6. hiredate 입사일이 1985-01-01 이후에 입사한사람 출력(컬럼: ename,hiredate,sal)
select ename,hiredate,sal from emp where hiredate>='1985-01-01';

--7 sal이 1500-3000 사이인 사람을 출력하는데 관계연산자 and 를 이용해서 출력
select ename,sal from emp where sal>=1500 and sal <=3000;

--8 7번의 결과를 between 을 이용해서 출력( ename,sal,mgr)
select ename,sal from emp where sal between 1500 and 3000;

--9 in 을 이용해 job이 clerk,president,manager인 사람의 전체 컬럼을 모두 출력
select * from emp where job in('CLERK','PRESIDENT','MANAGER') order by job;

--10 ename, sal, comm,sal*comm 을 출려ㅛㄱ하는데 comm이 null 인경우 1로 변경해서 출력 하고 계산
select ename,sal,NVL(comm,1),NVL(sal+comm,sal) from emp;

--11 ename 이 ADAMS인 사람의 SAL 보다 더 많이 받는 사람 출력 (ename,job,sal)
select ename,job,sal from emp where sal>(select sal from emp where ename = 'ADAMS') order by ename;

--12 평균 SAL보다 작은 사람의 젙체 컬럼 출력
select * from emp where sal<(select round(avg(sal)) from emp);

--13 ename 이 a나 s나 m으로 시작하는 모든 사람 출력(컬럼: ENAME,job,sal)
select ename,job,sal from emp where  ename like 'A%' or ename like 'S%' or ename like 'M%';

--14 MGR을 GROUP로 인원수와 평균 SAL을 구하시오(평균SAL은 무조건 올림으로(무조건 올림은 ELIM인가 그거임 )) 무조건 올림 뭐더라 ; 
select mgr,count(*) 인원수, round(avg(sal),-1) 평균 from emp where mgr is not null group by mgr; 

--15 SCOTT의 sal 과 같은 sal 을 받는 사람을 조회(ename,sal)
select ename,sal from emp where sal = (select sal from emp where ename like 'SCOTT');

--16 ENAME의 글자길이가 4글자인 사람만 조회(ename,job)
select ename,job from emp where length(ename)=4;

--17 ename의 3번째 글자가 R이거나 A인 사람 조회
select ename,job from emp where ename like '__R%' or ename like '__A%';

--18 Job 직업별로 인원수와 최고연봉을 출력하는데 직업의 오름차순으로 출력
select job 직업, count(*) 인원수, max(sal) 최고연봉 from emp group by job order by job ;

--19 ||연산자를 이용하여 다음과 같이 하나의 컬럼으로 출력하시오
-- 예) Scott의 직업은 CLERK이며 입사년도는 1989년 05월 입니다.

select ename||'의 직업은 '||job||'이며 입사년도는 '||to_char(hiredate,'yyyy')||'년 '||to_char(hiredate,'mm')||'월 입니다.' 자기소개 from emp;


