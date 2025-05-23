import React from 'react';

const Student = (props) => {
    const {stu,dispatch} = props;

    return (
        <div className={'input-group'} style={{width:'300px', margin:'5px 20px'}}>
            <div style={{textDecoration:stu.isHere?'line-through':'none',width:'100px',cursor:'pointer',color:stu.isHere?'gray':'black'}}
                 onClick={()=>dispatch({type:'mark-student',payload:{id:stu.id}})}>
                {stu.name}
            </div>
            &nbsp;&nbsp;
            <button type={'button'} className={'btn btn-sm btn-danger'} onClick={()=>dispatch({ type: 'delete-student', payload:{id:stu.id}})}>삭제</button>
        </div>
    );
};

export default Student;