import React, {useRef, useState} from 'react';
import {Alert, Button} from "@mui/material";

const FiveApp = () => {
    const [result, setResult]=useState('');
    const nameRef=useRef('');
    const javaRef=useRef(0);
    const reactRef=useRef(0);


    const btnResultEvent=()=>{
    //입력값 가져오기
        let name= nameRef.current.value();
        let java= javaRef.current.value();
        let react = reactRef.current.value();

        //점수가 숫자가 아닐경우 종료
        if(isNaN(java)){
            alert("자바점수는 숫자로만 입력해주세요");
            return;
        }
        if(isNaN(react)){
            alert("react 점수는 숫자로만 입력해주세요");
            return;
        }
        //총점 평균 구하기
        let tot=Number(java)+Number(react);
        let avg=tot/2;

        let s=`
            이름: ${name}
            자바점수: ${java}
            React점수: ${react}
            총점 : ${tot}
            평균 : ${avg}
        `;
        setResult(s);

        //값 초기화
        nameRef.current.value='';
        javaRef.current.value="";
        reactRef.current.value="";
        nameRef.current.focus();
    }

    return (
        <div>
            <Alert severity='success'>FiveApp - useRef 응용</Alert>
            <table className={'table table-bordered'} style={{width:'300px'}}>
                <thead>
                    <tr>
                        <th className='table-success' width="100">이름</th>
                        <th>
                            <input type='text' className='form-control' ref={nameRef}/>
                        </th>
                    </tr>
                    <tr>
                        <th className='table-success' width="100">Java Score</th>
                        <th>
                            <input type='text' className='form-control' ref={javaRef}/>
                        </th>
                    </tr>
                    <tr>
                        <th className='table-success' width="100">React Score</th>
                        <th>
                            <input type='text' className='form-control' ref={reactRef}/>
                        </th>
                    </tr>
                <tr>
                    <td colspan={2} align='center'>
                        <Button variant='outlioned' color="warning" onClick={btnResultEvent}>결과보기</Button>
                    </td>
                </tr>
                </thead>

            </table>
            <div style={{whiteSpace:'pre-line',marginLeft:'30px'}}>
                {result}
            </div>
        </div>
    );
};

export default FiveApp;