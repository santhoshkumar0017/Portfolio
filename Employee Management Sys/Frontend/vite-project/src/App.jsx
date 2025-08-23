import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ListofEmployees from './Components/ListofEmployees'
import HeaderComponent from './Components/HeaderComponent'
import FooterComponent from './Components/FooterComponent'
import {BrowserRouter, Route, Routes} from "react-router-dom"
import EmployeeComponent from './Components/EmployeeComponent'
function App() {
  

  return (
    <> 
    <BrowserRouter>
       <HeaderComponent/>

       <Routes>
         
       <Route path='/' element={<ListofEmployees/>}></Route>

       <Route path='/employees' element={<ListofEmployees/>}></Route>

       <Route path='/add-employee' element={<EmployeeComponent/>}></Route>

       <Route path='/update-employees/:id' element={<EmployeeComponent/>}></Route>

       </Routes>

       <FooterComponent/>
       
    </BrowserRouter>
    
    </>
  )
}

export default App
