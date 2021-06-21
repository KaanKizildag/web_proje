import React, { useState } from 'react'
import UserService from '../services/userService'
import { InputGroup, FormControl, Alert, Button } from 'react-bootstrap'
import { useHistory } from 'react-router-dom'
export default function Login() {


    const [isLoggedIn, setIsLoggedIn] = useState([])
    const history = useHistory()


    
    function login() {
        let _email = document.getElementById("email").value
        let _password = document.getElementById("password").value
        let userService = new UserService()
        userService.login(_email, _password).then(result => setIsLoggedIn(result.data))
        if (isLoggedIn === true) {            
            console.log('giriş başarılı')
            history.push('/Home')
            
        } else {
        }
    }

    function register() {
        history.push('/Register')
    }

    return (
        <div >
            <div class="mx-auto w-25">
                <Alert variant="success">Giriş yap</Alert>
                <InputGroup className="mb-3">
                    <FormControl
                        id="email"
                        placeholder="E-Posta"
                        aria-describedby="basic-addon1"
                    />
                </InputGroup>

                <InputGroup className="mb-3">

                    <FormControl
                        id="password"
                        placeholder="Parola"
                        aria-describedby="basic-addon1"
                    />
                </InputGroup>
                <div class="col-sm-12 text-center">
                    <Button variant="btn btn-outline-success" onClick={() => login()}>Giriş yap</Button>
                    <Button variant="btn btn-outline-primary m-3" onClick={() => register()}>Kaydol</Button>
                </div>
            </div>          
        </div>
    )
}
