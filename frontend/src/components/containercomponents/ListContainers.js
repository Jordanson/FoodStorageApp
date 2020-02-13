import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'

const ListContainers = (props) => {
  const [containers, setContainers] = useState([]);
  
  const fetchContainers = async () => {
    const url = "/api/containers";    

    await fetch(url)
      .then(response => response.json())
      .then(response => setContainers(response))
      .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"))
  }

  useEffect(() => {
    fetchContainers();  
  }, []);

  return (
    <div>
      <strong>MY FOOD CONTAINERS</strong>
      <br></br><br></br>

      <ul>
        {containers.map(container => (
          <li key={container.id}>
            <div>
              <button onClick={props.deleteContainer(container.id)} className="button is-rounded is-danger">Delete</button>
              <Link to={`/listfood/${container.id}`}>{container.name}</Link>
            </div>
          </li>
        ))}
      </ul>  
      
      
    </div>
  );
}

export default ListContainers;



