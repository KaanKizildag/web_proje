import React, { useState, useEffect } from 'react'
import { Table, Button } from 'react-bootstrap'
import UserService from '../services/userService'
 

function updateUser(user){
    console.log(`${user.email} güncellendi`)
}

function deleteUser(user){
    console.log(`${user.name} silindi`)
    let userService = new UserService();
    userService.removeUser(user)
    window.location.reload();
}

export default function UsersPage() {
    const [users, setUsers] = useState([])

    useEffect(() => {
         let userService = new UserService()
         userService.getUsers().then(result => setUsers(result.data))
     }, [])
    
    return (
        <div class = "w-75 mx-auto">
            <Table striped bordered hover>
                <thead class = "bg-secondary">
                    <tr>
                        <th>İsim</th>
                        <th>Email</th>
                        <th>İşlemler</th>
                    </tr>
                </thead>
                <tbody>{
                    users.map(user => (
                        <tr key={user.id}>
                            <td>{user.name}</td>
                            <td>{user.email}</td>
                            <td>
                                <Button variant="danger" onClick={()=> deleteUser(user)}>Sil</Button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </Table>
        </div>
    )
}
