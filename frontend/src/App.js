import React, { useState } from 'react'
import { Route, Switch } from 'react-router-dom'
import AddFoodForm from './components/foodcomponents/AddFoodForm'
import ListFood from './components/foodcomponents/ListFood'
import HomePage from './components/HomePage'
import NavBar from './components/Navbar'
import CreateContainer from './components/containercomponents/CreateContainer'
import ContainerContents from './components/containercomponents/ContainerContents'



const App = () => {

  return (
      <div>
        <NavBar />
        <Switch>
          <Route path="/" exact component={HomePage}/>
          <Route path="/addfood" exact component={AddFoodForm}/>
          <Route path="/showfood/:id" component={ListFood}/>
          <Route path="/showfood" component={ListFood}/>
          <Route path="/containercontents/:id" component={ContainerContents}/>
          <Route path="/createcontainer" exact component={CreateContainer}/>
        </Switch>
      </div>
  );
}

export default App;
