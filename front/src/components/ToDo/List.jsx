import React, { useContext, useEffect } from "react";
import { Store } from "../../stateManagement/store/StoreProvider";
import { HOST_API } from "../../App";
import TodoForm from "./TodoForm";
import TodoView from "./TodoView";

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
                className="btn btn-danger "
                type="button"
                onClick={() => onDelete(todoList.id)}
              >
                Eliminar
              </button>
            </div>
            <TodoForm></TodoForm>
            <TodoView></TodoView>
          </div>
        );
      })}
    </div>
  );
};

export default List;
