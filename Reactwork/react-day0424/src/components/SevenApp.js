import React from 'react';
import {Alert} from "@mui/material";
import SevenSmartHome from "./SevenSmartHome";

const SevenApp = () => {
    return (
        <div>
            <Alert severity='success' style={{fontSize:'25px'}}>SevenApp - useCallBack</Alert>

            <div style={{position:'absolute',top:'50%',left:'50%'}}>
                <SevenSmartHome/>
            </div>
        </div>
    );
};

export default SevenApp;