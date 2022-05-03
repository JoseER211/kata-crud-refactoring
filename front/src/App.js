import React, { Component } from "react";
import StoreProvider from "./stateManagement/store/StoreProvider";
import "bootstrap/dist/css/bootstrap.css";
import ToDoContainer from "./components/ToDo/ToDoContainer";

export const HOST_API = "http://localhost:8080/api";
/**<div className="col-md-12 text-center ">
          <button className="btn btn-success ">
            Nueva lista
          </button>
        </div>*/
class App extends Component {
  render() {
    return (
      <StoreProvider>
        <div>
          <ToDoContainer />
        </div>
      </StoreProvider>
    );
  }
}

export default App;
