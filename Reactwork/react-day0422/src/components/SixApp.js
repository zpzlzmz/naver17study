import React, {useEffect, useState} from 'react';
import {Switch} from "@mui/material";


const SixApp = () => {
    //style을 이용해 이미지 보이기 / 숨기기
    const [visible, setVisible] = useState('visible')
    const [count, setCount] = useState(1);
    const [number, setNumber] = useState(100);
    /*useEffect(() => {
        console.log("처음에도 호출되고, State변수가 변경될때마다 호출된다")
    });*/

   /* useEffect(() => {
        console.log("처음 로딩시 딱 한번만 실행")
    },[]);

    useEffect(() => {
        console.log("count가 변경될 떄 처리할 코드를 넣어주세요")
    },[count]);

    useEffect(() => {
        console.log("number가 변경될 때 처리할 코드르 넣어주세요")
    },[number]);*/
    useEffect(() => {
        console.log("count 와 number를 변경할 때 처리할 코드")
    },[count, number]);

    //const [visible, setVisible] = useState('hidden');
    return (
        <div>
           <h3 className='alert alert-success'>SixApp-MUI Switch, require 이미지 가져오기</h3>

            <br/>
            <Switch defaultChecked color="secondary"
                    onChange={(e)=>setVisible(e.target.checked?'visible':'hidden')}/>
            <br/>
            <img src={require('../image2/12.jpg')} style={{width:'200px',visibility:visible}}/>
            <hr/>
            <h1>Count:{count}</h1>
            <h1>number:{number}</h1>
            
            <button onClick={()=>setCount(count+1)}>count 1 증가</button>
            <br/>
            <button onClick={()=>setNumber(number+10)}>Number 10 증가</button>
            <br/>
            <button onClick={()=>{setCount(count+2);
            setNumber(number+5);}}>count와 number모두 증가</button>
        </div>
    );
};

export default SixApp;