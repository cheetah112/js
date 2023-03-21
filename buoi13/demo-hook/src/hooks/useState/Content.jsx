import React, { useState } from 'react'

function Content() {
    const [user, setUser] = useState({
        id: 1,
        name: "Nguyen Van A",
        email: "a@gmail.com"
    })
    const randomName = () => {
        const rdName = `New name ${Math.floor(Math.random()*1000)}`;
        setUser({...user, name: rdName});
    }
  return (
    <>
        <h2>User</h2>
        <p>
            {user.id} - {user.name} - {user.email}
        </p>
        <button onClick={randomName}>RandomName</button>
    </>
  );
}

export default Content