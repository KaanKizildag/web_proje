import React from 'react'
import { InputGroup, FormControl, Alert, Button } from 'react-bootstrap'
import UserService from '../services/userService'
import { toast } from 'react-toastify';



function registerBookKeeper() {
    let _email = document.getElementById("bk_email").value
    let _password = document.getElementById("bk_password").value
    let _name = document.getElementById("bk_username").value
    let userService = new UserService();
    userService.registerBookKeeper({
        email: _email,
        employeeNumber: '#',
        name: _name,
        password: _password,
        salary: 0
    })

    toast("Muhasebeci kaydedildi");
}

function registerCustomer() {
    
    let _email = document.getElementById("customer_email").value
    let _password = document.getElementById("customer_password").value
    let _address = document.getElementById("customer_address").value
    let _name = document.getElementById("customer_name").value
    let userService = new UserService();
    userService.registerCustomer({
        address:_address,
        debt:0,
        email:_email,
        name:_name,
        password: _password
    })
    toast("Müşteri kaydedildi");
}

export default function Register() {
    return (
        <div class="row mx-auto">
            <div class="mx-auto w-25">
                <Alert variant="success">Müşteri Kaydı</Alert>
                <InputGroup className="mb-3">
                    <FormControl
                        id="customer_name"
                        placeholder="İsim"
                        aria-describedby="basic-addon1"
                    />
                </InputGroup>
                <InputGroup className="mb-3">
                    <FormControl
                        id="customer_email"
                        placeholder="E-Posta"
                        aria-describedby="basic-addon1"
                    />
                </InputGroup>

                <InputGroup className="mb-3">
                    <FormControl
                        id="customer_password"
                        placeholder="Parola"
                        aria-describedby="basic-addon1"
                    />
                </InputGroup>
                <InputGroup className="mb-3">
                    <FormControl
                        id="customer_address"
                        placeholder="Adres"
                        aria-describedby="basic-addon1"
                    />
                </InputGroup>

                <Button variant="outline-success" onClick={() => registerCustomer()}>Kaydol</Button>
            </div>

            <div class="mx-auto w-25">

                <Alert variant="primary">Muhasebeci Kaydı</Alert>

                <InputGroup className="mb-3">
                    <FormControl
                        id="bk_username"
                        placeholder="Kullanıcı Adı"
                        aria-describedby="basic-addon1"
                    />
                </InputGroup>
                <InputGroup className="mb-3">
                    <FormControl
                        id="bk_email"
                        placeholder="E-Posta"
                        aria-describedby="basic-addon1"
                    />
                </InputGroup>

                <InputGroup className="mb-3">

                    <FormControl
                        id="bk_password"
                        placeholder="Parola"
                        aria-describedby="basic-addon1"
                    />
                </InputGroup>

                <Button variant="outline-success" onClick={() => registerBookKeeper()}>Kaydol</Button>
            </div>
        </div>
    )
}
