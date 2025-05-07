import React, {useState} from 'react';
import {Alert} from "@mui/material";

const SevenApp = () => {

    const [starArray, setStarArray] = useState([
        {
            starName: '김우빈',
            starAge: '22',
            starPhoto: '2.jpg',
            starAddress: '서울시 영등포구',
            starPhone: '010-0000-0001'
        },
        {
            starName: '설현',
            starAge: '32',
            starPhoto: '15.jpg',
            starAddress: '서울시 마포구',
            starPhone: '010-0000-0002'
        },
        {
            starName: '신민아',
            starAge: '42',
            starPhoto: '17.jpg',
            starAddress: '서울시 강남구',
            starPhone: '010-0000-0003'
        },
        {
            starName: '신세경',
            starAge: '52',
            starPhoto: '18.jpg',
            starAddress: '서울시 강북구',
            starPhone: '010-0000-0004'
        },
        {
            starName: '수지',
            starAge: '62',
            starPhoto: '19.jpg',
            starAddress: '서울시 강동구',
            starPhone: '010-0000-0005'
        }
    ])

    return (
        <div>
            <Alert severity='success'>SevenApp - 배열 데이터 출력</Alert>
            <table className='table table-bordered' style={{width: '430px'}}>
                <tbody>
                {
                    starArray.map((row,idx)=>
                    <>
                    <tr>
                        <td rowSpan={4}>
                            <img alt="" src={require(`../star/${row.starPhoto}`)} style={{width:'200px',height:'230px'}}/>
                        </td>
                        <td>이름 : {row.starName}</td>
                    </tr>
                        <tr>
                            <td>나이 : {row.starAge} 세</td>
                        </tr>
                        <tr>
                            <td>핸드폰 : {row.starPhone}</td>
                        </tr>
                        <tr>
                            <td>주소 : {row.starAddress}</td>
                        </tr>
                    </>)
                }
                </tbody>
            </table>
        </div>
    );
};

export default SevenApp;