import React from 'react'
import './Box.css'

function Box(props) {
    console.log(props);
    const handleDelete = () => {
        props.onDelete(props.index)
    }
  return (
    <div className='box' style={{backgroundColor : props.value}} onClick={handleDelete}></div>
  )
}

export default Box