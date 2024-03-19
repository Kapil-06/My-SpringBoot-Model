import { Component } from "react";
import { Link } from "react-router-dom";
import { MenuItems } from "../MenuItems.js";
import logo from "../images/logo.jpeg";
import "./NavbarStyles.css";

class Navbar extends Component {
  state = {clicked: false};
  handleClick = () => {
    this.setState({ clicked: !this.state.clicked })
  }
  render(){
  return (
      <nav className="navbarItems">
          <div>
              <img className="nav-img" src={logo}/>
          </div>
            <h1 className="navbar-logo">
                PVR
            </h1>

            <div className="menu-icons" onClick={this.handleClick}>
              <i className={this.state.clicked ? 
                "fas fa-times" : "fas fa-bars"}></i>
            </div>

            <ul className={this.state.clicked ?
                "nav-menu active" : "nav-menu"}>
            { MenuItems.map((item,index) => {
              return (
                <li key={index}>
                  <Link className="cName nav-links" to={item.url}> {item.title}
                  </Link>
                </li>
              );
            })}    
            </ul>
          <div className="what">
          <i className="fa-brands fa-whatsapp"></i>
          </div>
      </nav>
        );
    }
}

export default Navbar;