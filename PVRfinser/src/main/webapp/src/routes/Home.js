import Navbar from "../components/Navbar.js";
import Footer from "../components/Footer.js";
//import ParticlesBg from 'particles-bg';
import React, { useEffect, useState } from 'react';
import './Home.css';
import Quote from "../components/Quotes/Quote.js";
import Quote4 from "../components/Quotes/Quote4.js";
import Free from "../components/Free.js"
import Course from "../components/Course.js";
import Provide from "../components/Provide.js";
import Join from "../components/Join.js";
import Quote5 from "../components/Quotes/Quote5.js";
import Testimonial from "../components/Testimonial.js";
import { useNavigate } from 'react-router-dom';
//import Typewriter from 'typewriter-effect/dist/core';


function Home(props){
   
const [imageFadeIn, setImageFadeIn] = useState(false);
const [textFadeIn, setTextFadeIn] = useState(false);

  useEffect(() => {
    const imageTimer = setTimeout(() => {
      setImageFadeIn(true);
    }, 1000);

    const textTimer = setTimeout(() => {
      setTextFadeIn(true);
    }, 800); // Adjust the delay for the text fade-in after the image

    return () => {
      clearTimeout(imageTimer);
      clearTimeout(textTimer);
    };
  }, []);

  const navi = useNavigate();
  const redirectToAnotherPage = () => {
    navi.push('/courses'); // Redirect to '/another-page' route
  };

    return (
        <> 
         <Navbar />
        <div className="gradient">
          <div className={`hero-text ${textFadeIn ? 'fade-in':'' }`}>
            <h1 >PVR Financial Sevices</h1>
            <p >Grow Together</p>
          </div>
            <div className={`freebook ${imageFadeIn ? 'fade-in':'' }`}>
                <h5 className="card-title">Free Resources</h5>
                <p className="card-text">We have some exclusive ebooks and videos just for you to
                 get started on your financial journey! Click below to access them</p>
                <button onClick={redirectToAnotherPage} className="freeclick">
                    Free Resources
                </button>
            </div>
        </div>
           <Quote />
           <Course />
           <Free />
           <Provide />
           <Quote4 />
           <Join />
           <Quote5 />
           <Testimonial />
      <Footer />
      </>
    );
}

export default Home;


