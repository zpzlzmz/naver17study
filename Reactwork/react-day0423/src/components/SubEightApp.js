import React from 'react';
import "./mystyle.css";

//방법 1
/*const SubEightApp = (props) => {
    return (
        <div className="border1">
            <h6>이름 : {props.name}</h6>
            <h6>나이 : {props.name}세</h6>
            <button type='button' className='btn btn-sm btn-danger' onClick={props.countHandler}>방문</button>
        </div>
    );
}*/

//방법1
/*const SubEightApp = (props) => {
    const {name,age,countHandler}=props;
    return (
        <div className="border1">
            <h6>이름 : {name}</h6>
            <h6>나이 : {age}세</h6>
            <button type='button' className='btn btn-sm btn-danger' onClick={countHandler}>방문</button>
        </div>
    );
};*/

//방법3
const SubEightApp = ({name,age,countHandler,decreCountHandler}) => {
    return (
        <div className="border1">
            <h6>이름 : {name}</h6>
            <h6>나이 : {age}세</h6>
            <button type='button' className='btn btn-sm btn-danger' onClick={countHandler}>방문</button>
            <button type='button' className='btn btn-sm btn-danger' onClick={()=>decreCountHandler(3)}>탈퇴</button>
        </div>
    );
};


export default SubEightApp;