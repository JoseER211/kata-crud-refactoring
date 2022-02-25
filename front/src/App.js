import React from 'react'
import catalogueForm from './catalogueComponents/catalogueForm'

import { StoreProvider } from './storeProvider'
import catalogueList from './catalogueComponents/catalogueList'


function App() {
  return <StoreProvider>
    <catalogueForm />
    <hr />
    <catalogueList />
  </StoreProvider>;
}

export default App;