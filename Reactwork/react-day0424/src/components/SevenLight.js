import React from 'react';


const SevenLight = ({room,on,toggle}) => {
    console.log(room,on);
    return (
        <div>
            <button onClick={toggle}>
                {room} {on ? "💡" : "⬛"}
            </button>
        </div>
    );
};
//memo -> useCallBack 쓸때 여기도 이런식으로 고쳐줘야함 왜 ? 나중ㅇ ㅔ찾아보기
export default React.memo(SevenLight);