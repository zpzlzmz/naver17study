import React, {useEffect, useState} from 'react';
import {Alert} from "@mui/material";
import FourWriteShop from "./FourWriteShop";
import Axios from "axios";
import FourRowItem from "./FourRowItem";
import axios from "axios";

const FourApp = () => {
    const [shoplist, setShoplist] = useState([]);
    const addurl="/react/addshop" //package.json 에서 proxy 설정할때는 이렇게
    //const addurl = "http://localhost:8090/react/addshop
    //추가하는 함수
    const addShopEvent =(shopdata)=>{
        Axios.post(addurl,shopdata)
            .then(res=>{

                alert(res);
                //추가 성공 후 목록 다시 출력
                list();
            }).catch(error=>console.log(error));
    }

    //삭제
    const onDelete=(num)=>{
        let deleteurl="/react/shopdelete?num="+num
        axios.delete(deleteurl)
            .then(res=>list())//삭제 성공 후 목록 다시 출력
    }

    //db에서 데이터를 가져오는 함수
    const list=()=>{
        Axios.get("/react/shoplist").then(res=>setShoplist(res.data));
    }

    //처음 시작시 딱 한번만 list 호출
    useEffect(()=>{
        list();
    },[])

    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>FourApp - AXIOS 통신(jpa shop db)</Alert>
            <FourWriteShop onSave={addShopEvent}/>
            <hr/>
            <h5>총 {shoplist.length} 개의 상품이 있습니다</h5>
            <table className='table table-bordered' style={{width:'500px'}}>
                <tbody>
                {
                    shoplist //주는이유 -> 비동기 통신 특성상 약간의 시간을 두고 불러와지는경우 가끔 오류가 발생할수도 있음
                    &&
                    shoplist.map((row,idx)=>
                        <FourRowItem key={idx} row={row} OnDelete={onDelete}/>
                    )
                }
                </tbody>
            </table>
        </div>
    );
};

export default FourApp;