import React, { useEffect, useState } from 'react'

function TodoList() {
    const [list,setList] = useState([]);
    const [bl,setBl] = useState(true);
    useEffect(() => {
        const fetchData = async () => {
            const data = await fetch("http://localhost:8080/api/todos");
            const dataJson = await data.json();
            setList(dataJson);
        };

        fetchData();
    },[bl]);
    const [inputValue, setInputValue] = useState('');
    let input = '';
    const Add = () => {
        const todo = {title : inputValue};
        fetch("http://localhost:8080/api/todos",{
            method: 'POST', 
            headers: {'Content-Type': 'application/json'}, 
            body: JSON.stringify(todo)})
            .then(res => res.json())
            .then((data) => {
                setList([...list, data]);
                setInputValue('');
                console.log(input);    
            })
            .catch(err => console.log(err));
    }
    const Edit = (id) => {
        const editText = prompt("Điền nội dung công việc được thay đổi:");
        if(editText !== null && editText !== ""){
            const todo = {title: editText, status: false};
            fetch(`http://localhost:8080/api/todos/${id}`,{
                method: 'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(todo)})
            .then(res => res.json())
            .then((data) => {
                setBl(bl => !bl);
            })
            .catch(err => console.log(err.title))
        }else{
                alert("Không được để trống!!!");
            };   
    }
    const Delete = (id) => {
        fetch(`http://localhost:8080/api/todos/${id}`, {
            method: 'DELETE'
        });
        const newList = list.filter(item => item.id != id);
        setList(newList);
    }
    return (
    <>
    <h2>TodoList App</h2>
    <hr/>
        <input type = 'text' value={inputValue} onChange={(e)=>{
            setInputValue(e.target.value);
        }} placeholder='Enter todo title'></input>
        <button onClick = {(Add)}>Add</button>
    <ul>
        {list.map((item,index) => {
            return(<li key={index}>
                <input type='checkbox'></input>
                {item.title}
                <button onClick = {() => {Edit(item.id)}}>Edit</button>
                <button onClick = {() => {Delete(item.id)}}>Delete</button>
                </li>)
        })}
    </ul>
    <br/>
    </>
  )
}

export default TodoList