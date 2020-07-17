import React from 'react';
import { Link } from 'react-router-dom'
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
                        <button className="button is-rounded is-success"><Link to={`/createcontainer`}>Add a Container</Link></button>
                    </div>
                </div>
            </div>
        </div>
    );
  }

  export default HomePage;