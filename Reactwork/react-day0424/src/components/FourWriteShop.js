import React, {useState} from 'react';
import {Button} from "@mui/material";
import axios from "axios";

const FourWriteShop = ({onSave}) => {

    const [sangpum, setSangpum] = useState('');
    const [color, setColor] = useState('#ccffcc');
    const [price, setPrice] = useState(0);
    const [sangguip, setSangguip] = useState('2025-01-01');

    //업로드하기
    const [photo,setPhoto] = useState('');
    //네이버 스토리지의 url 필요
    const shoppath = process.env.REACT_APP_SHOPPATH;

    const addShopEvent = () => {
        onSave({sangpum, color, price, sangguip});

        setSangguip('2025-01-01');
        setSangpum('');
        setPrice(0);
        setPhoto('');
    }
    const photoUploadEvent=(e)=>{
        const imageFile=new FormData();
        const uploadFile =e.target.files[0];
        imageFile.append("upload",uploadFile);

        axios({
           method:"POST",
           url:"/react/upload",
            data:imageFile,

        }).then(res=>setPhoto(res.data));
    }

    return (
        <div style={{width:'500px'}}>
            <input type='file' onChange={photoUploadEvent}/>
            <img alt='' src={shoppath+photo} style={{width:'120px'}}/>

            <input type='text' placeholder='상품명' value={sangpum} onChange={(e) => setSangpum(e.target.value)}/>&nbsp;&nbsp;
            <input type='color' value={color} onChange={(e) => setColor(e.target.value)}/>&nbsp;&nbsp;
            <input type='text' placeholder='상품가격' style={{width:'70px'}} value={price} onChange={(e) => setPrice(e.target.value)}/>&nbsp;&nbsp;
            <input type='date' value={sangguip} onChange={(e) => setSangguip(e.target.value)}/>

            <Button color='success' variant='contained' style={{margin:'10px 160px'}} onClick={addShopEvent}>추가</Button>
        </div>
    );
};

export default FourWriteShop;