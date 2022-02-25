import React from 'react'
import { useContext, useEffect } from "react"
import Store from '../storeProvider'
import todoList from '../todo/todoList'
import todoForm from '../todo/todoForm'

const HOST_API = "http://localhost:8080/api";

const catalogueList = () => {

    const { dispatch, state: { catalogue } } = useContext(Store);
    const currentList = catalogue.list;

    useEffect(() => {
        fetch(`${HOST_API}/catalogue`)
            .then(response => response.json())
            .then((list) => {
                console.log(list)
                const action = { type: "update-list-catalogue", list }
                dispatch(action)
            })
    }, [dispatch]);


    const onDelete = (id) => {
        fetch(`${HOST_API}/${id}/catalogue`, {
            method: "DELETE"
        }).then((list) => {
            dispatch({ type: "delete-catalogue", id })
        })
    };


    return currentList.map((catalogue) => {
        return <div key = {catalogue.id} className = "container p-4 catalogue-div">
           <div><span className = "title">{catalogue.name} </span><button className="btn btn-danger"
            onClick={() => onDelete(catalogue.id)}>Eliminar</button> </div> 
           
           <br />         
            <todoForm catalogue_id = {catalogue.id}/>
            <todoList catalogue_id = {catalogue.id}/>
            <hr />
        </div>
    })
}

export default catalogueList;