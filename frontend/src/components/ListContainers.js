import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom'

const ListContainers = () => {
  const [containers, setContainers] = useState([]);
  
  const fetchData = async () => {
    const url = "/api/containers";

    await fetch(url)
      .then(response => response.json())
      .then(response => setContainers(response))
      .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"))
  }

  useEffect(() => {
    fetchData();     
  }, []);

  return (
    <div>
      <div>
        <ul>
          {containers.map(container => (
            <li key={container.id}>
                <button><Link to={`/listfood/${container.id}`}>{container.name}</Link></button>
            </li>
          ))}
        </ul>  
      </div>
    </div>
  );
}

export default ListContainers;
