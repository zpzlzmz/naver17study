import React, {useMemo, useState} from 'react';

const getAverage = (numbers) => {
    console.log("평균값 계산준")
    const sum=numbers.reduce((sum,n)=>sum+n);
    const avg=sum/numbers.length
    return avg.toFixed(2);
}

const SixAverage = () => {

    const [list, setList] = useState([]);
    const [number, setNumber] = useState('');
    //평균값 구하는 함수를 최적화 시켜보자 , list 변경시에만 호출
    const avg = useMemo(()=>getAverage(list),[list]);

    return (
        <div>
            <div>
                <h5>숫자를 입력하면 입력한 숫자에 대한 평균 구하기</h5>
                <input type={'text'} value={number} onChange={(e) => setNumber(e.target.value)}/>

                <button onClick={() => {
                    setList(list.concat(Number(number)));
                    setNumber('');
                }}>등록</button>
                <br/><br/>
                <ul>
                {
                    list.map((num,idx)=>
                    <li key={idx}>{num}</li>)
                }
                </ul>
                <div style={{fontSize:'2em',margin:'10px'}}>평균 : {avg}</div>
            </div>
        </div>
    );
};

export default SixAverage;