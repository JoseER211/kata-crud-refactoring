function todoReducer(state, action) {
    switch (action.type) {
        case 'update-item':
            const todoUpItem = state.todo;
            const listUpdateEdit = todoUpItem.list.map((item) => {
                if (item.id === action.item.id) {
                    return action.item;
                }
                return item;
            });
            todoUpItem.list = listUpdateEdit;
            todoUpItem.item = {};
            return { ...state, todo: todoUpItem }
            
        case 'delete-item':
            const todoUpDelete = state.todo;
            const listUpdate = todoUpDelete.list.filter((item) => {
                return item.id !== action.id;
            });
            todoUpDelete.list = listUpdate;
            return { ...state, todo: todoUpDelete }

        case 'update-list':
            console.log(state.todo)
            const todoUpList = state.todo;
            todoUpList.list = action.list;
            return { ...state, todo: todoUpList }

        case 'edit-item':
            const todoUpEdit = state.todo;
            todoUpEdit.item = action.item;
            return { ...state, todo: todoUpEdit }

        case 'add-item':
            const todoUp = state.todo.list;
            todoUp.push(action.item);
            return { ...state, todo: { list: todoUp, item: {} } }

        case 'delete-catalogue':
            const catalogueUpDelete = state.catalogue;
            const catalogueUpdate = catalogueUpDelete.list.filter((item) => {
                return item.id !== action.id;
            });
            catalogueUpDelete.list = catalogueUpdate;
            return { ...state, catalogue: catalogueUpDelete }

        case 'update-list-category':
            const catalogueUpList = state.catalogue;
            catalogueUpList.list = action.list;
            return { ...state, catalogue: catalogueUpList }

        case 'add-catalogue':
            const catalogueUp = state.catalogue.list;
            catalogueUp.push(action.item);
            return { ...state, catalogue: { list: catalogueUp } }

        default:
            return state;
    }
}

export default todoReducer;