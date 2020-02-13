import React, { useState, useEffect } from 'react';

const ListFood = (props) => {
  const [food, setFood] = useState([]);

  useEffect(() => {
    const fetchFood = async () => { 
      console.log("value of id: " + props.match.params.id)

      const { id } = props.match.params;
      let url = "";

      id === undefined ? url = `/api/food` : url = `/api/food/containers/${id}`
  
      await fetch(url)
        .then(response => response.json())
        .then(response => setFood(response))
        .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"))
  }

  fetchFood();   
      
  }, [props.match.params]);



  return (
    

    <div>
      <ul>
        {food.map(item => (
          <li key={item.id}>
            <h1>{item.name}</h1>
          </li>
        ))}
      </ul>  
    </div>
  );
}

export default ListFood;
