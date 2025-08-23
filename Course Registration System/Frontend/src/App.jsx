import { useState } from 'react'

import HeaderComponent from './Components/HeaderComponent'
import {BrowserRouter,Route,Routes} from "react-router-dom"
import FooterComponent from './Components/FooterComponent'
import  './App.css';
import ListOfCourses from './Components/ListOfCourses';
import StudentCompontent from './Components/StudentCompontent';
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
       <BrowserRouter>
        <HeaderComponent/>
       <Routes>

        <Route path='/' element={<ListOfCourses/>}></Route>
        

        <Route path='/add-student/:id' element={<StudentCompontent/>}></Route>

       </Routes>
       
      

       </BrowserRouter>
    </>
  )
}

export default App
