import React, {  useEffect } from 'react';

const ContainerContents = (props) => {
    //const { id } = props.match.params;

    useEffect(() => {
    console.log("hello")
  }, [])
  
      
  



  return (
    

    <div>
        <h1>{props.history.location.state.container.name}</h1>
      <h1>hello</h1>
    </div>
  )
}

export default ContainerContents;
