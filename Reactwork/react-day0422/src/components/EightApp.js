import React, {useState} from 'react';
import {Alert} from "@mui/material";


const EightApp = () => {
    const names = ['이효리', '강호동', '이영자', '손나은', '변우석'];
    //방법1
    const nameList = names.map((irum, idx) => <h5 key={idx}>{idx}:{irum}</h5>);


    return (
        <div>
            <h3 className='alert alert-success'>EightApp-Map반복문</h3>

            {
                [...new Array(10)].map((a, idx) => <b>{idx + 1}&nbsp;</b>)
            }
            <hr/>
            <h5>mycar 폴더에 mycar 이미지를 넣고1부터 15까지 이미지 출력하기</h5>
            {
                [...new Array(15)].map((b, idx) => <b>{idx + 1}:<img alt=''
                                                                     src={require(`../mycar/mycar${idx + 1}.png`)} style={{width:'100px'}}/></b>)
            }
            {nameList}

            {
                names.map((irum,idx)=><Alert key={idx}
                severity="warning">{idx}:{irum}<img alt='' src={require(`../image/${idx+1}.jpg`)} style={{width:'100px'}}/></Alert>
                )
            }
        </div>
    );
};

export default EightApp;