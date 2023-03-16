import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import Boxes from './assets/boxes/Boxes'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <Boxes/>
    </div>
  )
}

export default App
