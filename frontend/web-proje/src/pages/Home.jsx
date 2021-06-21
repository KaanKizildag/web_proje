import React, { useState, useEffect } from 'react'
import ProductService from '../services/productService'
import { FaSearch } from 'react-icons/fa';
import { Button, Card, FormControl, InputGroup } from 'react-bootstrap'
import { useHistory } from 'react-router-dom'
export default function Home() {

    const [products, setProducts] = useState([])

    useEffect(() => {
        let productService = new ProductService();
        productService.getAll().then(result => setProducts(result.data))
    }, [])

    const history = useHistory()
    const colors = [
        'Primary text-light',
        'Secondary text-light',
        'Success text-light',
        'Danger text-light',
        'Warning',
        'Info',
        'Light',
        'dark text-light',
    ]

    function showUsersPage() {
        history.push("/users")
    }

    function showLoginPage(){
        history.push("/")
    }

    return (
        <div class="w-75 mx-auto">
            <div>
                {/* Ürün arama çubuğu */}

                <InputGroup className="mb-3">
                    <FormControl
                        id="productName"
                        placeholder="Arayın"
                        aria-describedby="basic-addon1"
                    />

                    <Button variant="secondary">
                        <FaSearch />
                    </Button>
                </InputGroup>
            </div>
            <div class = "m-1">
                <Button variant="warning" onClick={() => showUsersPage()}>Kullanıcıları göster</Button>
                <Button variant="danger" onClick={() => showLoginPage()}>Çıkış yap</Button>
            </div>
            <div class="row mt-5">
                {
                    products.map(product => (
                        <Card
                            bg={colors[product.category.categoryId -1].toLowerCase()}
                            style={{ width: '20rem' }}
                            className="m-2"
                        >
                            <Card.Header>{product.category.categoryName}</Card.Header>
                            <Card.Body>
                                <Card.Title>{product.name}</Card.Title>
                                <Card.Text>
                                    {product.price} ₺
                                </Card.Text>
                            </Card.Body>

                        </Card>

                    ))
                }
            </div>
        </div>
    )
}
