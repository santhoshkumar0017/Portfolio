import React,{useEffect, useState} from 'react'
import { deleteEmployee, listEmployees } from '../Service/EmployeeService'
import {useNavigate} from "react-router-dom"
function ListofEmployees() {

  const[employee,setEmployee]=useState([]);
  const navigator=useNavigate();

   

  useEffect(() =>{
   getAllEmployee();
  },[])

  function getAllEmployee(){
     listEmployees().then((respone) =>{
        setEmployee(respone.data)
    }).catch(err =>{
        console.log(err);    
    })
  }

  function addNewEmployee(){
    navigator('/add-employee');
  }

  function updateEmployee(id){
    navigator(`/update-employees/${id}`)
  }
 
  function removeEmployee(id){
    console.log(id)
    deleteEmployee(id).then((response) =>{
    getAllEmployee();
    }).catch(error => {
      console.error(error)
    })
  }
  
  return (
    <div className='container'>
        <h2>List of Employees</h2>
         <button className='btn btn-primary mb-2'onClick={addNewEmployee}>Add Employee</button>
        <table className='table table-striped table-bordered'>

            <thead>
                <tr>
                  <th>Employee ID</th>
                  <th>Employee first_name</th>
                  <th>Employee last_name</th>
                  <th>Employee email</th>
                  <th>Action</th>
                  
                </tr>
            </thead>
             
             <tbody>
                 {
                    employee.map(employee =>
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td>
                            <button className='btn btn-info' onClick={() =>updateEmployee(employee.id)}> Update</button>

                            <button className='btn btn-danger' onClick={() =>removeEmployee(employee.id)} style={{marginLeft:'10px'}}> 
                              Delete</button>
                            </td>
                        </tr>
                    )
                 }
             </tbody>

        </table>
    </div>
  )
}

export default ListofEmployees