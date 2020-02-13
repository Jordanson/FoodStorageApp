import React from 'react';
import { Link } from 'react-router-dom'
//import ListContainers from './containercomponents/ListContainers' 
import ContainerMain from './containercomponents/ContainerMain';


const HomePage = () => {
    
    return (
        <div className="columns is-centered">
            <div className="column is-two-thirds"> 
            {/* if i remove this^^^ the content will be centered */}
                <div className="notification">

                    <br></br>
                    
                    <ContainerMain />

                    

                    <br></br><br></br>
                    <div>
                        <button className="button is-rounded is-success"><Link to={`/createcontainer`}>Create</Link></button>
                    </div>
                </div>
            </div>
        </div>
    );
  }

  export default HomePage;