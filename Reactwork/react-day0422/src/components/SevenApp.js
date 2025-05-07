import React, {useEffect, useState} from 'react';
import img1 from '../image2/19.jpg';
import {Button} from "@mui/material";

const SevenApp = () => {

    const [count,setCount]=useState(1);
    const [show,setShow]=useState(true);

    useEffect(()=>{
        count%3==0?setShow(false):setShow(true)
    },[count])

    return (
        <div>
           <h3 className='alert alert-success'>SevenApp-UseEffect</h3>
           <h5>Count 가 3의 배수일때마다 사진 숨기기</h5>
            <Button variant='outlined' color="success" onClick={()=> {
                setCount(count+1);
                //비동기 특성상 순서대로 진행이 안됨
                //count%3==0?setShow(false):setShow(true)
            }}>count 증가</Button>
            <br/>
            <b style={{fontSize:'4em',color:'red'}}>{count}</b>
            <br/><br/>
                {show &&
                    <img alt='' src={img1} style={{width:'300px'}}/>
            }
        </div>
    );
};

export default SevenApp;