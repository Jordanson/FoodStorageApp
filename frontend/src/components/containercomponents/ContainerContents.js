import React, { useEffect, useState } from 'react';

const ContainerContents = (props) => {
  const [container, setContainer] = useState({});

  useEffect(() => {
    const fetchContainer = async () => { 
      const { id } = props.match.params;

      console.log("This is the id: " + id)

      let url = `/api/containers/${id}`;
  
      await fetch(url)
        .then(response => response.json())
        .then(response => setContainer(response))
        .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"))
  }

  fetchContainer();   
      
  }, [props.match.params]);


  
  return (
    <div>
         <h1>{props.location.state.container.name}</h1> 
         <h1>{container.name}</h1> 
    </div>
  )
}

export default ContainerContents;
