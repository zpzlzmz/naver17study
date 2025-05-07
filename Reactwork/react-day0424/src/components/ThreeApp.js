import React from 'react';
import {Alert} from "@mui/material";
import posting from '../data/PostingData.json';
import './mystyle.css';

const ThreeApp = () => {
    const deal = posting.deal;
    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>ThreeApp - Jason data 출력</Alert>
            <div className='maindiv'>
                <h5><b>오늘의 딜</b></h5>
                {
                    deal.map((item,i)=>
                    <div key={i} className='photodiv'>
                        <img src={item.img} className='photo' alt="" />
                        <br/>
                        <div style={{color:'gray',fontSize:'14px'}}>{item.company}</div>
                        <div style={{color:'gray',fontSize:'16px'}}>[오늘의 딜]{item.title}</div>
                        <span style={{color:'#00ffff'}}>{item.sale}</span>
                        <span stlye={{marginLeft:'5px'}}>{item.price}</span>

                    </div>
                    )
                }
            </div>
        </div>
    );
};

export default ThreeApp;