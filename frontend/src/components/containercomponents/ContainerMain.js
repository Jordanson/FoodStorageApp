import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'

const ContainerMain = (props) => {
  const [containers, setContainers] = useState([]);
  
  const getContainers = async () => {
    const url = "/api/containers";    

    await fetch(url)
      .then(response => response.json())
      .then(response => setContainers(response))
      .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"))
  }

  const deleteContainer = async (containerId) => {
    let result = window.confirm("Are you sure you want to delete your " + containers.find(container => container.id === containerId).name + "?");
    if (result) {
        setContainers(containers.filter(container => container.id !== containerId))

        fetch(`api/containers/${containerId}`, {
             method: 'DELETE',
        })
        .then(res => res.json()) // or res.json()
        .then(res => console.log(res))
    } 
    else {
        return
    }
  }

  useEffect(() => {
    getContainers();  
  }, []);

  return (
    <div>
      <strong>MY FOOD CONTAINERS</strong>
      <br></br><br></br>

      <ul>
        {containers.map(container => (
          <li key={container.id}>
            <div>
              <button onClick={() => deleteContainer(container.id)} className="button is-rounded is-danger">Delete</button>
              {/* <Link to={`/containercontents/${container.id}`}>{container.name}</Link> */}
              <Link to={{
                  pathname: `/containercontents/${container.name}`,
                  state: {container: container}
                }}>{container.name}
              </Link>
            </div>
          </li>
        ))}
      </ul>  
      
    </div>
  );
}

export default ContainerMain;



