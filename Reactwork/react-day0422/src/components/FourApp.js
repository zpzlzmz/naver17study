import React from 'react';
import styled from "styled-components";
import {Apple, Phone, Smartphone} from '@mui/icons-material';

/*
https://styled-components.com/docs/basics#getting-started
# with npm
npm install styled-components

# with yarn
yarn add styled-components
 */
const FourApp = () => {
    const Title = styled.h2`
        color: orange;
        font-size: 1.5em;
        background-color: yellow;
        width: 300px;
        text-align: center;
    `;
    const MyBtn = styled.button`
        color: #61dafb;
        background-color: azure;
        border: 2px inset green;
        width: 130px;
    `
    const TomatoBtn = styled(MyBtn)`
        color: tomato;
        border-color: tomato;
    `
    return (
        <div>
            <h3 className={'alert alert-success'}>FourApp</h3>
            <Title>Hello React!!!</Title>
            <Title>ㅎㅇ ㅋㅋ</Title>
            <button type='button'>기본 버튼 모양</button>
            <br/>
            <MyBtn>MyBtn 모양</MyBtn>
            <br/>
            <TomatoBtn>틈메이러 버튼</TomatoBtn>
            <h5>Material Icons</h5>
            <Phone/>
            <Apple style={{color:'red',fontSize:'10em'}}/>
            <Smartphone/>
        </div>
    );
};

export default FourApp;