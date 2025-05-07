import React, {useReducer, useState} from 'react';
import Student from "./Student";

//reducer 설정시 초기값으로 미리 지정
const initialstate={
    count:1,
    students:[
        {
            id:new Date(),
            name:'이영자',
            isHere:false
        }
    ]
}

const reducer=(state,action)=>{
    console.log(state,action);
    switch(action.type){
        case 'add-student':
            const name=action.payload.name;
            //추가할 학생정보
            const addStudent={
                id:new Date(),
                //name:name이지만 같을 경우 한번만 사용 가능
                name,
                isHere:false
            }
            const data={
                count:state.count+1,
                students:[
                    ...state.students,
                    addStudent
                ]
            }
            return data;
        case 'delete-student':
            return {
                count:state.count-1,//인원수 1 줄이기
                students:state.students.filter(s=>s.id!==action.payload.id) //payload 를 통해서 전달된 id를 찾아서 filter로 제거
            };
        case 'mark-student': //해당 이름의 ishere를 true로 바꿈
            return {
                count:state.count,
                students:state.students.map(s=>{
                    if(s.id===action.payload.id) {
                        return {...s, isHere: !s.isHere};
                    }
                    return s;
                })
            }
        default:
            return state;
    }
}

const ReducerComp2 = () => {
    const [name, setName] = useState('');
    const [studentInfo,dispatch] = useReducer(reducer,initialstate);

    return (
        <div>
            <h5>useReducer 예제 #2</h5>
            <h2>학생 관리 Reducer</h2>
            <div className={'input-group'} style={{width:'200px'}}>
                <input type={'text'} className={'form-control'} value={name} onChange={(e) => setName(e.target.value)}/>

                &nbsp;
                <button type={'button'} className={'btn btn-sm btn-info'} onClick={()=> {
                    dispatch({'type': 'add-student', payload: {name}});
                    setName('');

                }}>추가</button>
                <br/><br/>
                {
                    studentInfo.students.map((stu,idx)=>
                    <Student key={idx} stu={stu} dispatch={dispatch}/>)
                }
            </div>
        </div>
    );
};

export default ReducerComp2;