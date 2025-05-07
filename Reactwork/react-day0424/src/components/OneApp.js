import React, {useState} from 'react';
import {Alert} from "@mui/material";
import OneRowItem from "./OneRowItem";
import OneWriteForm from "./OneWriteForm";

const OneApp = () => {
    const [dataArray, setDataArray] = useState([
        {
            irum:"이혀리",
            blood:"A",
            photo:"30.jpg",
            today:new Date()
        },
        {
            irum:"김코인",
            blood:"B",
            photo:"20.jpg",
            today:new Date()
        },
        {
            irum:"유재석",
            blood:"C",
            photo:"28.jpg",
            today:new Date()
        }
    ]);
    const dataAddEvent = (data)=>{
        setDataArray(dataArray.concat({
            ...data,
            today:new Date() //date 는 따로줘야하기 때문에 if data 가 없으면 concat(data) 하면 됨
        }))
    }

    const deleteDataEvent = (idx)=>{
        setDataArray(dataArray.filter((d,i)=>idx!==i));
    }

    return (
        <div style={{width:'500px'}}>
            <Alert severity='success'>OneApp</Alert>
            <OneWriteForm onSave={dataAddEvent}/>

            <table className='table table-bordered'>
                <thead>
                    <tr className='table-danger'>
                        <th width="50">번호</th>
                        <th width="150">이름</th>
                        <th width="60">혈액형</th>
                        <th width="120">등록일</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                {
                    dataArray.map((row, idx) =>
                        <OneRowItem key={idx} row={row} idx={idx}/>)
                }
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;