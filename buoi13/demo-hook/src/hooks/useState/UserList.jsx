import React, { useEffect, useState } from 'react'

function UserList() {
    const [list, setList] = useState([]);
    const [deps,setDeps] = useState(true);
    const Delete = (id) => {
        fetch(`http://localhost:8080/api/v1/users/${id}`,{method : 'DELETE',})
        .then(res => {
            if(res.ok) {
                console.log("Xóa thành công")

            }else{
                throw new Error("Xóa thất bại");
            }
            setDeps((deps)=> !deps);
        })
        .catch(err => {
            console.error("Xóa thất b", err)
        });
    }

    useEffect(() => {
    const fetchData = async () =>{
        const data = await fetch("http://localhost:8080/api/v1/users");
        const dataJson = await data.json();
        console.log(dataJson);

        setList(dataJson);

    };

    fetchData();
    console.log("useeffect");
    
  },[deps]);


    return (
    <div className="container mt-5 mb-5">
        <h2 className="text-center text-uppercase">Danh sách user</h2>

        <div className="row justify-content-center">
            <div className="col-md-10">

                <div className="d-flex justify-content-between align-items-center mt-5 mb-4">
                    <a href="./create.html" className="btn btn-warning">Tạo user</a>
                    <input type="text" id="search" className="form-control w-50" placeholder="Tìm kiếm user" />
                </div>

                <div className="bg-light p-4">
                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Address</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            {list.map((item,index) => (
                                <tr key = {index}>                                
                                <td>{item.id}</td>
                                <td>{item.name}</td>
                                <td>{item.email}</td>
                                <td>{item.phone}</td>
                                <td>{item.address}</td>
                                <td>
                                    <a href="./detail.html?id=2" className="btn btn-success">Xem chi tiết</a>
                                    <button className="btn btn-danger" onClick={() => {Delete(item.id)}}>Xóa</button>
                                </td>
                            </tr>
                            ))}
                        </tbody>
                    </table>

                    <p className="message d-none"></p>
                </div>
            </div>
        </div>
    </div>
  )
}

export default UserList