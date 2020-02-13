import React, { useState } from 'react'


const AddFoodForm = () => {
  const initialFormState = { name: "", description: "" };
  const [food, setFood] = useState(initialFormState);

  const handleInputChange = event => {  
    console.log(food);
    
    const { value, name } = event.target; 
    setFood({ ...food, [name] : value });
  }

  const handleSubmit = event => {
    event.preventDefault();
    postFood(food);
  }

  const postFood = async (newFood) => {
    let response = await fetch(`/api/food/${5}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify(newFood)
    });
    
    let result = await response.json();
    console.log(result);
  }
  
  return (
    <form onSubmit={handleSubmit}>
      <label>Name</label>
      <input type="text" name="name" value={food.name} onChange={handleInputChange}/>

      <label>Description</label>
      <input type="text" name="description" value={food.description} onChange={handleInputChange}/>
      <button className="button is-primary is-light">Add food</button>
    </form>
  )
}

export default AddFoodForm

