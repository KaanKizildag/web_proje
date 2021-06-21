import axios from 'axios'

export default class ProductService {

    getAll(){
        return axios.get(`http://localhost:8080/products/getAll`);
    }

    getByNameConstains(name){
        return axios.get(`http://localhost:8080/products/getByNameConstains?name=${name}`)
    }

    getById(id){
        return axios.get(`http://localhost:8080/products/getById?id=${id}`);
    }

    getByCustomerId(customerId){
        return axios.get(
            `http://localhost:8080/products/getByCustomer_Id?customerId=${customerId}`
            );
    }

    add(product){
        axios.post(
            "http://localhost:8080/products/add",
            product
            )
    }

}