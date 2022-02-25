function catalogueReducer(state, action) {
    switch (action.type) {
        case 'delete-catalogue':
            const todoUpDelete = state.catalogue;
            const listUpdate = todoUpDelete.list.filter((item) => {
                return item.id !== action.id;
            });
            todoUpDelete.list = listUpdate;
            return { ...state, catalogue: todoUpDelete }
        case 'update-list-catalogue':
            const todoUpList = state.catalogue;
            todoUpList.list = action.list;
            return { ...state, catalogue: todoUpList }
        case 'add-catalogue':
            const todoUp = state.catalogue.list;
            todoUp.push(action.item);
            return { ...state, catalogue: { list: todoUp} }
        default:
            return state;
    }
}

export default catalogueReducer;