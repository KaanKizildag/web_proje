import axios from "axios";

export default class UserService {

    getUsers() {
        return axios.get("http://localhost:8080/users/getAll")
    }

    login(email, password) {
        return axios.get(
            `http://localhost:8080/users/getByEmailAndPassword?email=${email}&password=${password}`)
    }

    registerBookKeeper(bookKeeper) {
        return axios.post(`http://localhost:8080/users/addBookKeeper`, bookKeeper).then(res => {
            console.log(res)
        })
    }
    registerCustomer(customer) {
        return axios.post(`http://localhost:8080/users/addCustomer`, customer).then(res => {
            console.log(res)
        })
    }

    removeUser(user){
        axios.post(`http://localhost:8080/users/delete?id=${user.id}`)
    }

}