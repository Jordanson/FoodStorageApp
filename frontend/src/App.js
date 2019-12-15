import React from 'react';
import { Route, Switch } from 'react-router-dom'
import AddFoodForm from './components/forms/AddFoodForm';
import ListFood from './components/ListFood';
import ListContainers from './components/ListContainers';


const App = () => {
  return (
      <div>
        <Switch>
          <Route path="/listfood/:id" component={ListFood}/>
          <Route path="/listfood" component={ListFood}/>
          <Route path="/addfood" exact component={AddFoodForm}/>
          <Route path="/showcontainers" exact component={ListContainers}/>
        </Switch>
    
      </div>
  );
}

export default App;
