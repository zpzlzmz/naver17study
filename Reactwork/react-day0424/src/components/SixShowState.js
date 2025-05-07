import React, {useMemo} from 'react';

const getNumber = (number) => {
    console.log("숫자가 변동되었습니다.");
    return number;
}
const getText = (text) =>{
    console.log("text가 변동되었습니다")
    return text;
}

const SixShowState = ({number,text}) => {
    //숫자가 바뀌어도 모든 함수가 호출되고
    //글자가 수정되어도 모든 함수가 호출됨
    //이부분을 숫자 바뀌면 숫자 관련 함수만 호출되고, 문자가 바뀌면 문자 관련 함수만 호출되도록 변경하기
    /*const showNumber = getNumber(number);
    const showText = getText(text);*/

    const showNumber=useMemo(()=>getNumber(number),[number]);
    const showText=useMemo(()=>getText(text),[text]);


    return (
        <div>
            <div style={{fontSize:'20px',margin:'20px'}}>
                {showText}
                <br/><br/>
                {showNumber}
            </div>
        </div>
    );
};

export default SixShowState;