import React, { useContext, useRef, useState } from "react";
import { Store } from "../../stateManagement/store/StoreProvider";
import { HOST_API } from "../../App";

const ListFormTodo = () => {
  const formRef = useRef(null);
  const {
    state: { todoList },
    dispatch,
  } = useContext(Store);
  const item = todoList.item;
  const [state, setState] = useState(item);
  const [errorEmpty, setErrorEmpty] = useState(false);
  var pattern = new RegExp(/^[A-Za-zÁÉÍÓÚáéíóúñÑ ]+$/);

  const onAdd = (event) => {
    setErrorEmpty(false);
    event.preventDefault();
    const request = {
      name: state.name,
      id: null,
    };

    state.name !== undefined && pattern.test(state.name)
      ? fetch(HOST_API + "/saveTodoList", {
          method: "POST",
          body: JSON.stringify(request),
          headers: {
            "Content-Type": "application/json",
          },
        })
          .then((response) => response.json())
          .then((todoList) => {
            dispatch({ type: "add-todoList", item: todoList });
            setState({ name: "" });
            formRef.current.reset();
          })
      : setErrorEmpty(true);
  };

  return (
    <div className="create-list-div">
      <form ref={formRef}>
        <div>
          <input
            type="text"
            name="name"
            placeholder="Escribe el nombre de la lista"
            defaultValue={item.name}
            onChange={(event) => {
              setState({ ...state, name: event.target.value });
            }}
          ></input>
        </div>
        <button type="button" onClick={onAdd}>
          Nueva lista
        </button>
        <span className={errorEmpty ? "error-on-empty" : "error-off-empty"}>
        Verifica que los carácteres son válidos 
        </span>
      </form>
    </div>
  );
};

export default ListFormTodo;
