import React, { useState } from 'react'
import Box from './Box'

function Boxes() {
    const [colors, setColors] = useState([
        '#3498db',
        '#9b59b6',
        '#e74c3c',
        '#2c3e50',
        '#d35400',
    ])
    const coloradd = [
    '#3498db',
    '#9b59b6',
    '#e74c3c',
    '#2c3e50',
    '#d35400',]
    const add = () =>{
        const newColors = [...colors,...coloradd];
        setColors(newColors);
    }
    const Delete = ()=>{

    }
    const handleDelete = (index) =>{
        const newColors = colors.filter((color, ind) => ind !== index);
        setColors(newColors);
    }

  return (
    <>
    <div>Boxes</div>
    <div>Point: {colors.length}</div>
    <button onClick={add}>Add</button>
    <br></br>
    {colors.map((color,index) => (
    <Box key = {index} value = {color} index = {index} onDelete = {handleDelete}/>
    ))}
    </>
  )
}

export default Boxes