import React, { useContext, useEffect } from "react";
import { Store } from "../../stateManagement/store/StoreProvider";
import { HOST_API } from "../../App";

/**
 * Representa la vista y el manejo de los Todos.
 * @returns Vista de los Todos.
 */
const TodoView = () => {
  const {
    dispatch,
    state: { todo },
  } = useContext(Store);
  const currentList = todo.list;

  useEffect(() => {
    fetch(HOST_API + "/todos")
      .then((response) => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [dispatch]);

  const onDelete = (id) => {
    if (window.confirm("¿Está seguro de eliminar la tarea?")) {
      fetch(HOST_API + "/" + id + "/todo", {
        method: "DELETE",
      }).then((list) => {
        dispatch({ type: "delete-item", id });
      });
    }
  };

  const onEdit = (todo) => {
    dispatch({ type: "edit-item", item: todo });
  };

  const onChange = (event, todo) => {
    const request = {
      name: todo.name,
      id: todo.id,
      completed: event.target.checked,
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
      });
  };

  const decorationDone = {
    textDecoration: "line-through",
  };
  return (
    <div className="todoList ">
      <table className="table-todo table table-secondary table-hover border border-dark shadow-lg rounded">
        <thead className="head-table ">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Tarea</th>
            <th scope="col">¿Completado?</th>
            <th colSpan="2">Acciones</th>
          </tr>
        </thead>
        <tbody className="body-table ">
          {currentList.map((todo) => {
            return (
              <tr
                className="tr-table"
                key={todo.id}
                style={todo.completed ? decorationDone : {}}
              >
                <td>{todo.id}</td>
                <td>{todo.name}</td>
                <td>
                  <input
                    type="checkbox"
                    defaultChecked={todo.completed}
                    onChange={(event) => onChange(event, todo)}
                  ></input>
                </td>
                <td id="td-actions">
                  <button
                    className="btn btn-primary"
                    onClick={() => onEdit(todo)}
                  >
                    Editar
                  </button>
                </td>
                <td id="td-actions">
                  <button
                    className="btn btn-danger"
                    onClick={() => onDelete(todo.id)}
                  >
                    Eliminar
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default TodoView;
