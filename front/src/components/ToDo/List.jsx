import React, { useContext, useEffect } from "react";
import { Store } from "../../stateManagement/store/StoreProvider";
import FormTodo from "./FormTodo";
import ListTodo from "./ListTodo";
import { HOST_API } from "../../App";
import TodoView from "./TodoView";
import ToDoContainer from "./ToDoContainer";

const List = () => {
  const {
    state: { todoList },
    dispatch,
  } = useContext(Store);
  const currentList = todoList.list;

  useEffect(() => {
    fetch(HOST_API + "/listAllTodo")
      .then((response) => response.json())
      .then((list) => {
        dispatch({ type: "update-list-todoList", list });
      });
  }, [dispatch]);

  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/deleteTodoList", {
      method: "DELETE",
    }).then((todoList) => {
      dispatch({ type: "delete-todoList", id });
    });
  };

  return (
    <div className="principal-container">
      {currentList.map((todoList, index) => {
        return (
          <div key={todoList.id}>
            <div>
              <h4>{todoList.name ? todoList.name.toUpperCase() : ""}</h4>
              <button
                className="delete-button"
                type="button"
                onClick={() => onDelete(todoList.id)}
              >
                Eliminar
              </button>
            </div>
            <ToDoContainer></ToDoContainer>
          </div>
        );
      })}
    </div>
  );
};

export default List;
