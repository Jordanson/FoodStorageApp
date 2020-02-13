import React, { useState } from 'react'


const CreateContainer = () => {
  const initialFormState = { name: "", description: "" };
  const [container, setContainer] = useState(initialFormState);

  const handleInputChange = event => {  
    console.log(container);
    
    const { value, name } = event.target; 
    setContainer({ ...container, [name] : value });
  }

  const handleSubmit = event => {
    event.preventDefault();
    postContainer(container);
  }

  const postContainer = async (newContainer) => {
    let response = await fetch('/api/containers', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=utf-8'
      },
      body: JSON.stringify(newContainer)
    });
    
    let result = await response.json();
    console.log(result);
  }
  
  return (
    <form onSubmit={handleSubmit}>
      <label>Name</label>
      <input type="text" name="name" value={container.name} onChange={handleInputChange}/>

      <label>Description</label>
      <input type="text" name="description" value={container.description} onChange={handleInputChange}/>
      <button className="button is-primary is-light">CreateContainer</button>
    </form>
  )
}

export default CreateContainer

