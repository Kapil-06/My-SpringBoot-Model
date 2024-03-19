import "./Footer.css";
import React,{ useState } from 'react';
import { Link } from "react-router-dom";
import ReactDOM from 'react-dom/client';

const Footer = () => {
	const [course, setCourse] = useState('0');

	const handleChange = (event) => {
		setCourse(event.target.value)
	}

	return(
		<>
		<footer className="footer">
		 <div className="column">
        <h4 className="column-title">Join Our Webinar</h4>
        <form className="join-webinar-form">
          <input type="text" placeholder="Name" />
          <input type="text" placeholder="Phone Number" />
          <input type="email" placeholder="Email" />
          <button type="submit">Join</button>
        </form>
      </div>
      <div className="column">
        <h4 className="column-title">Quick Links</h4>
        <ul className="quick-links">
          <li><a href="/">Home</a></li>
          <li><a href="/courses">Courses</a></li>
          <li><a href="/blogs">Blogs</a></li>
          <li><a href="/about">About Us</a></li>
          <li><a href="/contact">Contact Us</a></li>
        </ul>
      </div>
      <div className="column">
        <h4 className="column-title">Social Media</h4>
        <ul className="social-media-links">
          <li><a href="https://twitter.com"><i className="fa-brands fa-facebook-square"></i>Facebook</a></li>
          <li><a href="https://facebook.com"><i className="fa-brands fa-instagram-square"></i>Instagram</a></li>
          <li><a href="https://instagram.com"><i className="fa-brands fa-twitter-square"></i>Twitter</a></li>
        </ul>
      </div>
      <div className="column">
        <h4 className="column-title">About Us</h4>
        <p className="about-paragraph">
         At PVR, we pride ourselves on 
			offering comprehensive and accessible financial 
			education, particularly in stock market analysis, 
			investment strategies, and diverse financial 
			instruments. Our seasoned experts bring decades of
			 experience, delivering hands-on workshops, 
			 seminars, and personalized mentoring sessions.
         </p>
      </div>
    </footer>
	<div className='company'>
        © 2023 Copyright: MTP Solutions
    </div>
	</>

	);
}


export default Footer;

{/*
	<div className="top">
			<h1>Free Webinar</h1>	
			<div className="social">
				<a href="/">
					<i className="fa-brands fa-facebook-square"></i>
				</a>
				<a href="/">
					<i className="fa-brands fa-instagram-square"></i>
				</a>
				<a href="/">
					<i className="fa-brands fa-twitter-square"></i>
				</a>
			</div>
		</div>
	<div className="bottom">
	<form className="form">
      <label >Name</label>
      <input 
      type="text"
      placeholder="name"
      />
      <label >Phone No</label>
      <input 
      type="number"
      placeholder="number"
      />
      <label >Email</label>
     	<input 
     	type="email"
     	placeholder="email"
     	/>
      <div className="sub">
      <button className="subb">Send</button>
      </div>
    </form>

    
    <div className="cour">
    <p className="pp">Our Courses</p>
   	<ul className="core">
   	<li >
        <Link>Stock Market Overview</Link>
    </li>
    <li >
        <Link>Fundamental Analysis</Link>
    </li>
    <li >
        <Link>Technical Analysis</Link>
    </li>
    <li >
        <Link>Futures and Options</Link>
    </li>
    </ul>
    </div>

    <div className="about">
    <p>At PVR, we pride ourselves on 
			offering comprehensive and accessible financial 
			education, particularly in stock market analysis, 
			investment strategies, and diverse financial 
			instruments. Our seasoned experts bring decades of
			 experience, delivering hands-on workshops, 
			 seminars, and personalized mentoring sessions.
	</p>
    </div>
*/}