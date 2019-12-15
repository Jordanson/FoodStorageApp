import React, { useState } from 'react'


const AddFoodForm = () => {
  const [food, setFood] = useState("");

  const handleInputChange = event => {
    console.log(food);
    
    const result = event.target.value;
    setFood(result);
  }

  const handleSubmit = event => {
    event.preventDefault();
    postdata(food);
  }

  const postdata = async (newFood) => {
    // let food = {
    //   name: 'biscuits',
    //   type: 'fluff'
    // };
    
    let response = await fetch('/api/food/2', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify(newFood)
    });
    
    let result = await response.json();
    console.log(result);
  }

  //useEffect(() => {postdata()}, []);
  
  return (
    <form onSubmit={handleSubmit}>
      <label>Name</label>
      <input type="text" name="name" value={food.name} onChange={handleInputChange}/>
      <button>Add food</button>
    </form>
  )
}

export default AddFoodForm

