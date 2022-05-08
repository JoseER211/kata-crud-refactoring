import React, { Component } from "react";
import StoreProvider from "./stateManagement/store/StoreProvider";
import "bootstrap/dist/css/bootstrap.css";
import ListFormTodo from "./components/ToDo/ListFormTodo";
import List from "./components/ToDo/List";
export const HOST_API = "http://localhost:8080/api";

/**
 * Representa la interfaz de la página.
 *
 * @author Jose David Echavarria Ruiz.
 */
class App extends Component {
  render() {
    return (
      <StoreProvider>
        <ListFormTodo></ListFormTodo>
        <List></List>
      </StoreProvider>
    );
  }
}

export default App;
