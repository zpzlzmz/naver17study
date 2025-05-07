import React from 'react';
import { DeleteForeverOutlined } from "@mui/icons-material";

const OneRowItem = (props) => {
    let {row,idx} = props;

    return (
        <tr>
            <td>{idx+1}</td>
            <td>
                <img alt="" src={require(`../shop/${row.photo}`)}
                     style={{width:'30px',height:'30px',marginRight:'5px'}}/>{row.irum}
            </td>
            <td>{row.blood}</td>
            <td>{row.today.toLocaleDateString("ko-KR")}</td>
            <td>
                <DeleteForeverOutlined style={{fontSize:'1.5em',color:'red',cursor:'pointer'}} onClick={()=>{
                    let a=window.confirm("Are you sure you want to delete?");
                    if(!a) return;
                }} />
            </td>
        </tr>
    );
};

export default OneRowItem;