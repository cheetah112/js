import React from 'react'

function ProductItem({title, count, price}) {
  return (
    <>
    <div>
    {title} : {price}
    <br></br>
    <button>-</button>
    {count}
    <button>+</button>
    <br></br>
    <button>Xoa</button>
    </div>
    </>
  )
}

export default ProductItem