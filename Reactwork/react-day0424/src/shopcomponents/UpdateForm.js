import {Alert, Button} from '@mui/material';
import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from 'react-router-dom';
import noimage from '../image/noimage.png';
import axios from 'axios';

const UpdateForm = () => {
    const [shopData, setshopData] = useState('');
    const {num} = useParams();

    //업로드한 사진을 저장하기 위한 변수
    const [photo, setPhoto] = useState(null);
    const navi = useNavigate();
    //사진출력할 url
    const photourl = process.env.REACT_APP_PHOTO_URL;

    //파일 업로드 이벤트
    const photoUploadEvent = (e) => {
        const imageFile = new FormData();
        const uploadFile = e.target.files[0];
        imageFile.append("upload", uploadFile);

        axios({
            method: 'post',
            url: "/react/upload",
            data: imageFile
        }).then(res => setPhoto(res.data));
    }

    //처음 시작시 스프링으로 부터 데이터 가져오기
    const getSelectData = () => {
        let url = "/react/detail?num=" + num;
        axios.get(url)
            .then(res => {
                setshopData(res.data);
                setPhoto(res.data.photo)
            })
    }

    useEffect(() => {
        getSelectData()
    }, [])

    //입력시 호출
    const shopDataChange = (e) => {
        const {name, value} = e.target;
        setshopData({
            ...shopData,
            [name]: value //보낼 데이터랑 똑같이 줘야함
        });
    }

    //submit 발생시 호출
    const onSubmit = (e) => {
        e.preventDefault(); //기본 이벤트를 무효화 하는 것(Action 호출 무효화)
        //수정
        axios.post("/react/shopupdate", shopData)
            .then(res => {
                //수정 성공 후 상세보기 페이지로 이동
                navi(`/five/detail/${num}`);
            });
    }

    return (
        <div>
            <Alert severity='info' style={{width: '500px'}}>상품 등록</Alert>
            <form onSubmit={onSubmit}> {/*Submit 만들면 이런식으로 호츌 가능 */}
                <table className='table table-bordered' style={{width: '500px'}}>
                    <tbody>
                    <tr>
                        <td rowSpan={5} width={200} align='center'>
                            <img alt='' src={photo ? photourl + photo : noimage}
                                 style={{width: '180px'}}/>
                        </td>
                        <td width="100">사진</td>
                        <td>
                            <input type='file' onChange={photoUploadEvent}
                                   style={{width: '200px'}}/>
                        </td>
                    </tr>
                    <tr>
                        <td>상품명</td>
                        <td>
                            <input type='text'
                                   value={shopData.sangpum} className='form-control'
                                   name={"sangpum"} onChange={shopDataChange}/>
                        </td>
                    </tr>
                    <tr>
                        <td>가격</td>
                        <td>
                            <input type='text'
                                   value={shopData.price} className='form-control'
                                   name={"price"} onChange={shopDataChange}/>
                        </td>
                    </tr>
                    <tr>
                        <td>색상</td>
                        <td>
                            <input type='color'
                                   value={shopData.color} className='form-control'
                                   name={"color"} onChange={shopDataChange}/>
                        </td>
                    </tr>
                    <tr>
                        <td>구입일</td>
                        <td>
                            <input type='date'
                                   value={shopData.sangguip} className='form-control'
                                   name="sangguip" onChange={shopDataChange}/>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={3} align='center'>
                            <Button color='success' variant='contained'
                                    style={{margin: '10px 160px', width: '100px'}}
                                    type={'submit'}>상품 수정</Button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    );
};

export default UpdateForm;