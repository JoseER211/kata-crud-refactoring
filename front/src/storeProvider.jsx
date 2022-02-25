import React, { createContext, useReducer } from 'react';
import todoReducer from './todoComponents/todoReducer'


const initialState = {
    catalogue: { list: [] },
    todo: { list: [], item: {} },
    error: ""
}

const Store = createContext(initialState);

export const StoreProvider = ({ children }) => {

    const [state, dispatch] = useReducer(todoReducer, initialState);

    return <Store.Provider value = {{ state, dispatch }} className="centered">
        {children}
    </Store.Provider>

}

export default Store;