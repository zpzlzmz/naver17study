import React, {useState} from 'react';
import {Button} from "@mui/material";

const OneWriteForm = ({onSave}) => {
    const [irum, setIrum] = useState('');
    const [blood, setBlood] = useState('O');
    const [photo,setPhoto] = useState('13.jpg');

    const addEvent =()=> {
        onSave({irum,photo,blood});
        //입력값 초기화 작업
        setIrum("");
        setBlood('O');
        setPhoto('13.jpg');
    }
    return (
        <div className='input-group'>

            <input type='text' className='form-control' placeholder='이름' value={irum} onChange={(e)=>setIrum(e.target.value)} />
            <select className='form-select' onChange={(e)=>setPhoto(e.target.value)}>
                {
                    [...new Array(10)].map((_,idx)=>
                        <option key={idx}>{idx+13}.jpg</option>)
                }

            </select>
            <select name="" className='form-select' id="" onChange={(e)=>setBlood(e.target.value)}>
                <option>O</option>
                <option>A</option>
                <option>B</option>
                <option>AB</option>
            </select>
            <Button color='success' variant='contained' onClick={addEvent}>추가</Button>
        </div>
    );
};

export default OneWriteForm;