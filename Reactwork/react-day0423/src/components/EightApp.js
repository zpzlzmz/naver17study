import React, {useState} from 'react';
import {Alert} from "@mui/material";
import SubEightApp from "./SubEightApp";

const EightApp = () => {
    const [count, setCount] = useState(10);
    const increCountEvent=()=>{
        setCount(count + 1);
    }

    const decreCountEvent=(num)=>{
        setCount(count-num);
    }
    return (
        <div>
            <Alert severity='success'>EightApp - 부모 자식 컴포턴ㄴ트간 통신</Alert>
            <hr/>
                <h2>총 방문 횟수는 {count}회 입니다</h2>
            <hr/>
            <SubEightApp name={'이영자'} age={21} countHandler={increCountEvent} decreCountHandler={decreCountEvent}/>
            <SubEightApp name={'유재석'} age={34} countHandler={increCountEvent} decreCountHandler={decreCountEvent}/>
            <SubEightApp name={'강호동'} age={35} countHandler={increCountEvent} decreCountHandler={decreCountEvent}/>

        </div>
    );
};

export default EightApp;