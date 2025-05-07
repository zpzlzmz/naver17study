import React from 'react';
import {Alert, Button} from "@mui/material";
import {NavLink, Routes, Route, useNavigate} from "react-router-dom";
import HomeSub1 from "./HomeSub1";
import HomeSub2 from "./HomeSub2";
import HomeSub3 from "./HomeSub3";

const Home = () => {
    const navi = useNavigate();
    return (
        <div>
            <Alert severity='success' style={{fontSize:'20px'}}>Home 컴포넌트</Alert>
            <button className='btn btn-sm btn-danger' onClick={()=>navi("/food")} type='button'>Food로 이동</button>&nbsp;&nbsp;
            <button className='btn btn-sm btn-danger' onClick={()=>navi("food/5")} type='button'>Food2로 이동</button>&nbsp;&nbsp;
            <button className='btn btn-sm btn-danger' onClick={()=>navi("food/12/5")} type='button'>Food3로 이동</button>&nbsp;&nbsp;
            <button className='btn btn-sm btn-danger' onClick={()=>navi("/about/네이버")} type='button'>About로 이동</button>&nbsp;&nbsp;
            <div style={{marginTop:'30px'}}>
                <NavLink to={"/home/sub1"}>경치1</NavLink>
                &nbsp;&nbsp;&nbsp;
                <NavLink to={"/home/sub2"}>경치2</NavLink>
                &nbsp;&nbsp;&nbsp;
                <NavLink to={"/home/sub3"}>경치3</NavLink>

                <Routes>
                    <Route path='sub1' element={<HomeSub1/>}/>
                    <Route path='sub2' element={<HomeSub2/>}/>
                    <Route path='sub3' element={<HomeSub3/>}/>
                </Routes>


            </div>
        </div>
    );
};

export default Home;