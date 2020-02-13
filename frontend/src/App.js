import React from 'react'
import { Route, Switch } from 'react-router-dom'
import AddFoodForm from './components/foodcomponents/AddFoodForm'
import ListFood from './components/foodcomponents/ListFood'
// import ListContainers from './components/containercomponents/ListContainers'
import HomePage from './components/HomePage'
import NavBar from './components/Navbar'
import CreateContainer from './components/containercomponents/CreateContainer'
import ContainerMain from './components/containercomponents/ContainerMain'



const App = () => {
  return (
      <div>
        <NavBar />
        <Switch>
          <Route path="/" exact component={HomePage}/>
          <Route path="/listfood/:id" component={ListFood}/>
          <Route path="/listfood" component={ListFood}/>
          <Route path="/addfood" exact component={AddFoodForm}/>
          <Route path="/showcontainers" exact component={ContainerMain}/>
          <Route path="/createcontainer" exact component={CreateContainer}/>
        </Switch>
      </div>
  );
}

export default App;
