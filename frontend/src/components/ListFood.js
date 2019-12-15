import React, { useState, useEffect } from 'react';

const ListFood = (props) => {
  const [food, setFood] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const { id } = props.match.params;
      let url = "";

      // if (id === undefined) {
      //   url = `/api/food`
      // } else {
      //   url = `/api/food/containers/${id}`
      // }

      id === undefined ? url = `/api/food` : url = `/api/food/containers/${id}`
  
      await fetch(url)
        .then(response => response.json())
        .then(response => setFood(response))
        .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"))
    }

    fetchData();   
      
  }, [props.match.params]);



  return (
    <div>
      <div>
        <ul>
          {food.map(item => (
            <li key={item.id}>
              <h1>{item.name}</h1>
            </li>
          ))}
        </ul>  
      </div>
    </div>
  );
}

export default ListFood;
