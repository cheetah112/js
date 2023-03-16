import React from 'react'

function Item(props) {
  console.log(props);
    return (
      <>
      <li>{props.title}</li>
      </>

  )
}

export default Item