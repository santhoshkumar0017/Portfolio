import axios from 'axios'

const REST_API_URL='http://localhost:8080';

const COURSE_API_URL='http://localhost:8080/course'

export const ListOfCourse=() =>axios.get(COURSE_API_URL+'-getAll');

export const getCourse=(id) => axios.get(COURSE_API_URL+'-get/'+id)

export const createStudent=(student) => axios.post(REST_API_URL+'/add',student);