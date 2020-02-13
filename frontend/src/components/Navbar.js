import React from 'react';
import { Link } from 'react-router-dom'



const NavBar = () => {
    return (
        // <div>
        //     <ul>
        //         <li><Link to="/">Home</Link></li>
        //         <li><Link to="/listfood">All Food</Link></li>
        //     </ul>
        // </div>
        <div>
        <nav className="navbar is-warning" role="navigation" aria-label="main navigation">
            <div className="navbar-brand">
                <a className="navbar-item" href="https://bulma.io">
                    <img src="../../public/images/fridge.png" alt="PantryPal" width="112" height="28"/>
                </a>

                <a role="button" className="navbar-burger burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample" href="/#">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>

            <div id="navbarBasicExample" className="navbar-menu">
                <div className="navbar-start">
                    <div className="navbar-item">
                        <Link to="/">Home</Link>
                    </div>
                    <div className="navbar-item">
                        <Link to="/listfood">MyFood</Link>
                    </div>
                    <div className="navbar-item">
                        <Link to="/">Shopping List</Link>
                    </div>

                    {/* <div className="navbar-item has-dropdown is-hoverable">
                        <a className="navbar-link">More</a>

                        <div className="navbar-dropdown">
                            <a className="navbar-item">About</a>
                            <a className="navbar-item">Jobs</a>
                            <a className="navbar-item">Contact</a>

                            <hr className="navbar-divider"/>

                            <a className="navbar-item">Report an issue</a>
                        </div>
                    </div> */}
                </div>

                {/* <div className="navbar-end">
                    <div className="navbar-item">
                        <div className="buttons">
                        <a className="button is-primary"><strong>Sign up</strong></a>
                        <a className="button is-light">Log in</a>
                        </div>
                    </div>
                </div> */}
            </div>
        </nav>
        </div>
    )
}

  export default NavBar;