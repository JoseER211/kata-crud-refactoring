import React, { useReducer, createContext } from "react";
import todoReducer from "../reducer/todoReducer";

//Conecta componentes
const initialState = {
  todo: { list: [], item: {} },
  todoList: { list: [], item: {} },
};

export const Store = createContext(initialState);

const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(todoReducer, initialState);

  return (
    <Store.Provider value={{ state, dispatch }}>{children}</Store.Provider>
  );
};

export default StoreProvider;
