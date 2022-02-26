import React, { Component } from "react";
import TodoForm from "./TodoForm";
import TodoView from "./TodoView";

class ToDoContainer extends Component {
  render() {
    return (
        <div className="col-sm-12 ">
          <TodoForm />
          <TodoView />
        </div>
    );
  }
}

export default ToDoContainer;