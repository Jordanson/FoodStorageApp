import React, { useState, useEffect } from 'react'
import { Link, Route, useHistory } from 'react-router-dom'
import ContainerContents from './ContainerContents';

const ContainerMain = (props) => {
  const [containers, setContainers] = useState([]);
  // const [showContainerContents, setShowContainerContents] = useState(false);
  // const [selectedContainerId, setSelectedContainerId] = useState();
  const history = useHistory();
  
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


  // const onButtonClick = (containerId) => {
  //   setShowContainerContents(true)
  //   setSelectedContainerId(containerId)
  // }

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
              <button onClick={() => history.push(`/containercontents/${container.id}`, {container: container})} className="button is-primary">{container.name}</button>
              

              {/* <Route 
              path="/ContainerContents" component={HomePage}/> */}

              {/* <Link to={`/containercontents/${container.id}`}>{container.name}</Link> */}
              {/* <Link to={{
                  pathname: `/containercontents/${container.name}`,
                  state: {container: container}
                }}>{container.name}
              </Link> */}
            </div>
          </li>
        ))}
      </ul>  

   
      {/* {showContainerContents ? <ContainerContents containerId={selectedContainerId}  /> : null}   */}
      
      
    </div>
  );
}

export default ContainerMain;



