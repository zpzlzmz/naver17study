import React from 'react';
import Menu from './Menu';
import Home from '../components/Home'
import {Routes,Route} from "react-router-dom";
import {EightApp, FiveApp, FourApp, OneApp, SevenApp, SixApp, ThreeApp, TwoApp} from "../components";



const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <br style={{clear:"both"}}/>
            <div style={{margin:'10px'}}>
                <Routes>
                    <Route path={'/'} element={<Home/>}/>
                    <Route path={'/one'} element={<OneApp/>}/>
                    <Route path={'/two'} element={<TwoApp/>}/>
                    <Route path={'/three'} element={<ThreeApp/>}/>
                    <Route path={'/four'} element={<FourApp/>}/>
                    <Route path={'/five/*'} element={<FiveApp/>}/>
                    <Route path={'/six'} element={<SixApp/>}/>
                    <Route path={'/seven'} element={<SevenApp/>}/>
                    <Route path={'/eight/*'} element={<EightApp/>}/>
                </Routes>
            </div>
        </div>
    );
};

export default RouterMain;