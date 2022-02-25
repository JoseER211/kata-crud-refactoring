import React, { useRef, useContext, useState } from 'react';
import Store from '../storeProvider'


const HOST_API = "http://localhost:8080/api";

const catalogueForm = () => {

    const formRef = useRef(null);
    const { dispatch, state: { catalogue } } = useContext(Store);

    const [state, setState] = useState();

    const onAdd = (event) => {
        event.preventDefault();

        const request = {
            name: state.name,
            id: null,
        };


        fetch(`${HOST_API}/catalogue`, {
            method: "POST",
            body: JSON.stringify(request),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then((catalogue) => {
                dispatch({ type: "add-catalogue", item: catalogue });
                setState({ name: "" });
                formRef.current.reset();
            });
    }


    return <div><h2>Nuevo catálogo</h2>
    <form ref={formRef} className="row g-2 form-centered">
        <div className="col-auto">
            <input type="text" className="form-control" name="name"
             placeholder="Nuevo catálogo" onChange={(event) => {
                setState({ ...state, name: event.target.value })
            }}>
            </input>
        </div>
        <div className="col-auto">
            <button className="btn btn-primary" onClick={onAdd}>Crear</button>
        </div>
    </form>
    </div>
}

export default catalogueForm;