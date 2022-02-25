import todoForm from './todoForm'
import todoList from './todoList'

const todoContainer = () => {

    return <div  className = "container-md p-5">
        <todoForm>
        </todoForm>
        <todoList>
        </todoList>
    </div>
}

export default todoContainer