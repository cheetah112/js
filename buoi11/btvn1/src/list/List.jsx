import React, { useState } from 'react'
import Item from "./Item"

function List() {
    const [textIp, setTextIp] = useState("");
    const [itemList, setItemList] = useState(["item 1", "item 2", "item 3"])
    const [hiden, setHiden] = useState("Hide");
    const [show, setShow] = useState(true);
    const add = () => {
      if(textIp == ""){
        alert("Noi dung khong duoc de trong")
      }else{
      const newList = [...itemList];
      newList.push(textIp);
      setItemList(newList);
      setTextIp("");
      }
    }

    const remove = () => {
      const newList = [...itemList];
      newList.pop();
      setItemList(newList);
    }

    const hide = () => {
      setShow(!show);
      if(show == true){
        setHiden("Show")
      }else{
        setHiden("Hide")
      }
    }

    return(
  <>   
   <div>List</div>
   <input onChange={e => setTextIp(e.target.value)} type = 'text' placeholder='Enter text ...' value = {textIp}/>
   <br></br>
   <button onClick={add}>Add</button>
   <button onClick={remove}>Remove</button>
   <button onClick={hide}>{hiden}</button>

    {show && itemList.map((item,index) => (
      <Item key = {index} title = {item}/>
    ))}

  </>
  )
}

export default List