import React, {useMemo, useRef} from 'react';
import {Alert} from "@mui/material";
import cate from '../data/CateData.json';
import './mystyle.css';

const TwoApp = () => {
    const navData = cate.navData;
    const cateData = cate.categoryData;
    const mainPhotoRef = useRef(null);
    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>TwoApp - json data 출력 </Alert>
            <div className={'nav_container'}>
                <ul className='nav_category'>
                    {
                        navData.map((item,i)=>
                            <li key={i}>
                                <div>
                                    <img alt='' src={item.img} className={'imgcategory'} onClick={(e)=>mainPhotoRef.current.src=e.target.src}/>
                                </div>
                                <div>{item.title}</div>
                            </li>)
                    }
                </ul>
            </div>
            <div className={'nav_container'}>
                <ul className='nav_category'>
                    {
                        cateData.map((item,i)=>
                            <li key={i}>
                                <div>
                                    <img alt='' src={item.img} className={'imgcategory'} onClick={(e)=>mainPhotoRef.current.src=e.target.src}/>
                                </div>
                                <div>{item.title}</div>
                            </li>)
                    }
                </ul>
            </div>
            <div>
                <img src="" alt="" style={{width:'300px',height:'300px',border:'5px solid gray',margin:'10px 300px'}}
                ref={mainPhotoRef}/>
            </div>

        </div>
    );
};

export default TwoApp;