import React, { Component } from "react";

//Mapea el Navbar
export class Navbar extends Component {
  render() {
    return (
      <nav className="navbar navbar-dark bg-info ">
        <div className="container-fluid " >
          <div className="navbar-brand input-group ">
            <h1>To-Do List</h1>
          </div>
        </div>
      </nav>
    );
  }
}

export default Navbar;