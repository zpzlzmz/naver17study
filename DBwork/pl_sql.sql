--pl-sql 이란 SQL언어의 절차적 언어 요소를 추가해서 프로그래밍 한것을 PL/SQL 이라고 함 
-- 형식 
-- declare 
--      변수, 커서 선언
-- BEGIN
--      SQL 구문이나 PL/SQL 구문 코딩
--END
--/(실행)


--스크립트 출력창에 결과가 출력되도록 한번만 설정 해주면됨 


SET SERVEROUTPUT ON -- 켜기
set serveroutput off -- 끄기
--예제 1
DECLARE 
    v_no number(4,1); -- 변수 선언 ,4자리 수에 소숫점 이하 1자리 수 라는 의미.
begin
    v_no:=12.7; -- 값 대입 (오라클에서 = 은 비교연산자, := 는 대입 연산자)
    dbms_output.put_line(v_no); -- 콘솔창에 출력
end;
/

--예제 2
declare
    vscode varchar2(20);
    vsprice number(10);
    vsanpum varchar2(30);
begin
    vscode := 'A300';
    
    
    --vscode 값에 해당하는 상품 데이터 가져오기 
    select sangprice,sangname
    into vsprice,vsanpum
    from shop
    where sangcode = vscode;
    
    dbms_output.put_line('상품명: '||vsanpum);
    dbms_output.put_line('가격: '||vsprice||'원');
    dbms_output.put_line('코드번호: '||vscode);
end;
/

-- 예제 3 if문 -> 년도에 따라 띠를 구해보자
-- 쥐,소,호랑이,토끼,용,뱀,말,양,원숭이,닭,개,돼지

declare
    v_year number(4):= 2025;
    v_mod number(2):= mod(v_year,12);--서기 1년은 닭띠 12년이 원숭이띠
    v_ddi varchar2(20); --띠 저장할 곳 
begin
    if v_mod=0 then v_ddi:='원숭이띠';
    elsif v_mod=1 then v_ddi:='닭띠';
    elsif v_mod=2 then v_ddi:='개띠';
    elsif v_mod=3 then v_ddi:='돼지띠';
    elsif v_mod=4 then v_ddi:='쥐띠';
    elsif v_mod=5 then v_ddi:='소띠';
    elsif v_mod=6 then v_ddi:='호랑이띠';
    elsif v_mod=7 then v_ddi:='토끼띠';
    elsif v_mod=8 then v_ddi:='용띠';
    elsif v_mod=9 then v_ddi:='뱀띠';
    elsif v_mod=10 then v_ddi:='말띠';
    elsif v_mod=11 then v_ddi:='양띠';
    end if;
    
    dbms_output.put_line(v_year||'년도는 '||v_ddi||'해 입니다');    
end;
/



--- accept 를 이용해 년도를 직접 입력 받아 결과를 출력해보자 
accept year prompt '년도를 입력해 주세요:';


declare
    v_year number(4):=&year; --입력받은 year값 가져오기
    v_mod number(2):= mod(v_year,12);--서기 1년은 닭띠 12년이 원숭이띠
    v_ddi varchar2(20); --띠 저장할 곳 
begin
    if v_mod=0 then v_ddi:='원숭이띠';
    elsif v_mod=1 then v_ddi:='닭띠';
    elsif v_mod=2 then v_ddi:='개띠';
    elsif v_mod=3 then v_ddi:='돼지띠';
    elsif v_mod=4 then v_ddi:='쥐띠';
    elsif v_mod=5 then v_ddi:='소띠';
    elsif v_mod=6 then v_ddi:='호랑이띠';
    elsif v_mod=7 then v_ddi:='토끼띠';
    elsif v_mod=8 then v_ddi:='용띠';
    elsif v_mod=9 then v_ddi:='뱀띠';
    elsif v_mod=10 then v_ddi:='말띠';
    elsif v_mod=11 then v_ddi:='양띠';
    end if;
    
    dbms_output.put_line(v_year||'년도는 '||v_ddi||'해 입니다');    
end;
/

---예제 4 (상품코드, 상품명, 가격을 입력 받아 shop 테이블에 추가해보자)
accept scode prompt 'A로 시작하는 상품코드를 입력하세요';
accept ssang prompt '상품명을 입력하세요';
accept sprice prompt '가격을 입력하세요';


declare
    v_code varchar2(20) :='&scode';
    v_sang varchar2(30) := '&ssang';
    v_price number(10) :='&sprice';
    
begin
    insert into shop (sangcode, sangname,sangprice) values (v_code, v_sang,v_price);
    dbms_output.put_line(v_sang||' 상품정보를 테이블에 추가했습니다.');
end;
/


--예제 5 cursor 와 for문을 이용하여 shop의 데이터들을 읽어오자 (2줄 이상 읽을떄 cursor 가 필요합)

declare
    --커서 객체의 select sql 문을 이용해 여러 데이터를 넣기 
    CURSOR s1
    is 
    select * from shop;
    
begin
    dbms_output.put_line('============================================================');
    for s in s1 loop --record 단위로 s 가 가져온다 (s는 레코드 단위)
        dbms_output.put_line(s.sangcode||'  '||s.sangname||'       '||s.sangprice);
        exit when s1%notfound; -- 더이상 데이터가 없으면 for문을 빠져나가라는 의미.
    end loop;
end;
/
--응용 1 join sql 문을 이용해 cartnum,sangcode, sangname, sangprice, cntnum,cartday를 출력하시오 

declare
    --커서 객체의 select sql 문을 이용해 여러 데이터를 넣기 
    CURSOR s1
    is 
    select 
    c.cartnum, s.sangcode, s.sangname, s.sangprice,c.cntnum,
    to_char(cartday,'yyyy-mm-dd') cartday
    from shop s, cart c
    where s.sangcode = c.sangcode;
    
begin
    dbms_output.put_line('============================================================');
    for s in s1 loop --record 단위로 s 가 가져온다 (s는 레코드 단위)
        dbms_output.put_line(s.cartnum||'  '||s.sangcode||'  '||s.sangname||'   '||s.sangprice||'   '||s.cntnum||'   '||s.cartday);
        exit when s1%notfound; -- 더이상 데이터가 없으면 for문을 빠져나가라는 의미.
    end loop;
end;
/
--.상품코드 와 상품명 가격을 accept를 이용해 입력 후 shop에 해당 상품 코드가 존재 할 경우 업데이트로 수정을 하고 존재하지 않을 경우 insert 추가 함
accept acode prompt '상품코드를 입력하세요';
accept asang prompt '상품명을 입력하세요';
accept aprice prompt '상품 가격을 입력하세요';
declare
    s_code varchar2(10):='&acode';
    s_sang varchar2(30) :='&asang';
    s_price number(10):='&aprice';
    s_cnt number(2); --count 값을 가져올 변수 
begin
    select count(*) into s_cnt
    from shop where sangcode = s_code; -- 존재하면 1 존재하지 않으면 0
    
    if s_cnt =1 then 
        update shop set sangcode = s_code,snagname = s_sang,sangsangprice = s_price
        where sangcode = s_code;
        commit;
        dbms_output.put_line(s_code||'의 상품 정보가 수정되었습니다');
    else
        insert into shop (sangcode,sangname,sangprice) values (s_code,s_sang,s_price);
        commit;
        dbms_output.put_line(s_code||'의 상품 정보가 추가 되었습니다');
    
    end if;
    
end;
/

--상품명을 입력하면 shop 테이블에서 그 이름을 포함하고 있는 데이터들을 모두 출력
accept sangpum prompt '상품명을 입력해주세요';
 declare
    v_sangpum varchar2(20) := '&sangpum';
    cursor s1
    is select * from shop where sangname like '%'||v_sangpum||'%';
    
    --갯수를 얻어올 변수 
    v_cnt number(2);
begin
    --입력한 상품명을 포함한 레코드의 갯수를 얻어보자 
    select count(*) into v_cnt
    from shop where sangname like '%'||v_sangpum||'%';
    if v_cnt = 0 then
        dbms_output.put_line(v_sangpum||'상품은 존재하지 않습니다.');
    else
        dbms_output.put_line('상품코드      상품명      상품가격');
        dbms_output.put_line('=================================');
        for s in s1 loop
            dbms_output.put_line(s.sangcode||'  '||s.sangname||'  '||s.sangprice);
            exit when s1%notfound;
        end loop;
    end if;
end;
/

