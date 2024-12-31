-- equi join or inner join 
--방법 1
select 
    e.Ename, e.job, e.sal, d.Dname, d.Loc
from EMP e, DEPT d
where E.DEPTNO = D.DEPTNO;

--방법 2 조인할 테이블에 컬럼명이 겹치지 않은경우는 테이블 명이나 별칭을 붙이지 않아도 된다 
select
    e.deptno, ename,job,sal,dname,loc
    from emp e,dept d
    where e.deptno = d.deptno;


--DECODE 함수 -> 다중 IF 문 같은 함수 

select ENAME, DEPTNO, DECODE(DEPTNO,10,'홍보부',20,'교육부',30,'인사부') 부서명 FROM EMP;