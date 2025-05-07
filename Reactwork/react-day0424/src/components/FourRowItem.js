import React from 'react';
import {Alert} from "@mui/material";
import noimage from "../image/noimage.png";
import {DeleteForeverSharp} from "@mui/icons-material";

const FourRowItem = ({row,OnDelete}) => {

    const shoppath = process.env.REACT_APP_SHOPPATH;

    const shopDeleteEvent=(num)=>{
        let a=window.confirm("Are you sure you want to delete?");
        if(!a)
            return;
        OnDelete(num);
    }

    return (
        <tr>
            <td width="160">
                <img alt='' src={row.photo?shoppath+row.photo:noimage} style={{width:'140px',height:'180px',border:'3px solid gray'}}
                     onError={(e)=>e.target.src=noimage} />
            </td>
            <td style={{marginLeft:'10px'}} valign="middle">
                <h6>상품명 : {row.sangpum}
                <DeleteForeverSharp style={{float:'right',cursor:'pointer'}} onClick={()=>shopDeleteEvent(row.num)}/></h6>
                <h6 style={{backgroundColor:row.color}}>색상 : {row.color}</h6>
                <h6>단가 : {row.price}</h6>
                <h6>구입일 : {row.sangguip}</h6>
                <h6>등록일 : {row.writeday}</h6>
            </td>
        </tr>
    );
};

export default FourRowItem;