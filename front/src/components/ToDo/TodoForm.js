import React, { useContext, useRef, useState } from "react";
import { Store } from "../../stateManagement/store/StoreProvider";
import { HOST_API } from "../../App";

//Mapea del formulario
const TodoForm = () => {
  const formRef = useRef(null);
  const inputRef = useRef("");
  const {
    dispatch,
    state: { todo },
  } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: null,
      completed: false,
    };

    if (inputRef.current.value === "") {
      alert("Ingrese la tarea");
    } else {
      fetch(HOST_API + "/todo", {
        method: "POST",
        body: JSON.stringify(request),
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((response) => response.json())
        .then((todo) => {
          dispatch({ type: "add-item", item: todo });
          setState({ name: "" });
          formRef.current.reset();
        });
    }
  };

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted,
    };

    if (inputRef.current.value === "") {
      alert("Ingrese la tarea");
    } else if (inputRef.current.value === item.name) {
      alert("Ya existe una tarea con ese nombre");
    } else {
      fetch(HOST_API + "/todo", {
        method: "PUT",
        body: JSON.stringify(request),
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((response) => response.json())
        .then((todo) => {
          dispatch({ type: "update-item", item: todo });
          setState({ name: "" });
          formRef.current.reset();
        })
        .catch(() => {
          alert("Error 325 ");
        });
    }
  };

  return (
    <form ref={formRef}>
      <div className="input-group">
        <input
          type="text"
          name="name"
          ref={inputRef}
          className="form-control"
          placeholder="¿Qué piensas hacer hoy?"
          defaultValue={item.name}
          onChange={(event) => {
            setState({ ...state, name: event.target.value });
          }}
        ></input>
        {item.id && (
          <button className="btn btn-primary" onClick={onEdit}>
            Actualizar
          </button>
        )}
        {!item.id && (
          <button className="btn btn-success" onClick={onAdd}>
            Crear
          </button>
        )}
      </div>
    </form>
  );
};
export default TodoForm;
