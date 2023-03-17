import React, { useState } from 'react'
import ProductItem from './ProductItem'

function ProductList() {
    const [count, setCount] = useState(1);
  return (
    <>
    <div>ProductList</div>
    <ProductItem title = "Lớp học Spring Boot" count = {count} price = {9000000}/>
    <ProductItem title = "Lớp học python" count = {count} price = {8000000}/>
    </>
  )
}

export default ProductList