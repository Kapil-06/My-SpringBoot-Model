import Navbar from "../components/Navbar.js";
import Footer from "../components/Footer.js";
import "./Blogs.css";
import pic2 from "../images/b.jpeg";
import pic3 from "../images/c.jpeg";

const Blogs = () => {
    return (
    <>
       <Navbar />
       <div className="blog">
       <h2>Our Blogs</h2>
       <div className="projcard-container">
    
  <div className="projcard projcard-blue">
    <div className="projcard-innerbox">
      <img className="projcard-img" src={pic2} />
      <div className="projcard-textbox">
        <div className="projcard-title">Card Title</div>
        <div className="projcard-bar"></div>
        <div className="projcard-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</div>
      </div>
    </div>
  </div>
  
  <div className="projcard projcard-red">
    <div className="projcard-innerbox">
      <img className="projcard-img" src={pic3} />
      <div className="projcard-textbox">
        <div className="projcard-title">Card Title</div>
        <div className="projcard-bar"></div>
        <div className="projcard-description">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
      </div>
    </div>
  </div>
  </div>
</div>
       <Footer />
    </>
    );
};

export default Blogs;