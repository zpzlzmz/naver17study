import React from 'react';
import {Alert} from "@mui/material";
import {Routes, Route, useNavigate} from "react-router-dom";
import {ShopDetail, ShopForm, ShopList} from "../shopcomponents";
import axios from "axios";
import UpdateForm from "../shopcomponents/UpdateForm";


const FiveApp = () => {

    const navi = useNavigate();
    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>FiveApp</Alert>
            <div style={{margin:'20px'}}>
                <button type='button' className='btn btn-sm btn-outline-secondary' onClick={()=>navi("/five/list")}>Shop 목록</button>
                <button type='button' className='btn btn-sm btn-outline-secondary' onClick={()=>navi("/five/form")}>Shop 추가</button>
                <br/>
                <br/>
                <Routes>
                    <Route path='/' element={<ShopList/>}/>
                    <Route path='list' element={<ShopList/>}/>
                    <Route path='form' element={<ShopForm/>}/>
                    <Route path='detail/:num' element={<ShopDetail/>}/>
                    <Route path='updateform/:num' element={<UpdateForm/>}/>

                </Routes>
            </div>
        </div>
    );
};

export default FiveApp;