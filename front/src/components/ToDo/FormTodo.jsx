import React, { useState, useContext, useRef } from "react";
import { Store } from "../../stateManagement/store/StoreProvider";
import { HOST_API } from "../../App";

const FormTodo = ({ todoListId }) => {
  const formRef = useRef(null);
  const {
    state: { todo },
    dispatch,
  } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);
  const [errorEmpty, setErrorEmpty] = useState(false);
  var pattern = new RegExp(/^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$/);

  const onAdd = (event) => {
    setErrorEmpty(false);
    event.preventDefault();
    const request = {
      name: state.name,
      id: null,
      completed: false,
      todoListId: todoListId,
    };

    state.name !== undefined && pattern.test(state.name)
      ? fetch(HOST_API + "/todo", {
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
          })
      : setErrorEmpty(true);
  };

  const onEdit = (event) => {
    event.preventDefault();
    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted,
      todoListId: todoListId,
    };

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
      });
  };

  return (
    <form className="form-todo" ref={formRef}>
      <div>
        <input
          type="text"
          name="name"
          placeholder="Escribe una tarea aquí"
          defaultValue={todoListId === item.todoListId ? item.name : null}
          onChange={(event) => {
            setState({ ...state, name: event.target.value });
          }}
        ></input>
      </div>
      <button className="update-todo-button" type="button" onClick={onEdit}>
        Actualizar
      </button>
      <button className="create-todo-button" type="button" onClick={onAdd}>
        Crear
      </button>

      <span className={errorEmpty ? "error-on-empty" : "error-off-empty"}>
        Verifica que los carácteres son válidos 
      </span>
    </form>
  );
};

export default FormTodo;
