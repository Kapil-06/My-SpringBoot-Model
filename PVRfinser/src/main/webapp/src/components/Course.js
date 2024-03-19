import React from 'react';
import "./Course.css";
import pic1 from "../images/a.jpeg";
import pic2 from "../images/b.jpeg";
import pic3 from "../images/c.jpeg";
import pic4 from "../images/d.jpeg";

function Course(){
    return (
    <>
       <div className="explore">
        </div>
         <div className="list">
            <h2 className="c-title">Explore Our Courses</h2>
        </div>
        <div className="free-stuff">
            <div className="course1">
                <img className="cour-image" src={pic1}/>
                <h5 className="free-title">Stock Market Overview</h5>
                 <ul className="free-list">
                 <li>What is Stock Market?</li>
                 <li>Stock Building Process</li>
                 <li>Volume, Fluctuations,Price</li>
                 <li>What is SEBI,BSE-NSE?</li>
                 </ul>
                 <button className="but-course">Learn More</button>
            </div>

            <div className="course2">
                <img className="cour-image" src={pic2}/>
                <h5 className="free-title">Fundamental Analysis</h5>
                <ul className="free-list">
                 <li>Currency Building Process</li>
                 <li>RBI Interest Rate Policies</li>
                 <li>Indian Banking System</li>
                 <li>Budget and Taxation</li>
                 </ul>
                 <button className="but-course">Learn More</button>
            </div>

            <div className="course3">
                <img className="cour-image" src={pic3}/>
                <h5 className="free-title">Technical Analysis</h5>
                <ul className="free-list">
                 <li>Candles and Formation</li>
                 <li>Support Resistance</li>
                 <li>DBR,RBR,RBD,DBD</li>
                 <li>Trading Score</li>
                 </ul>
                 <button className="but-course">Learn More</button>
            </div>

            <div className="course4">
                <img className="cour-image" src={pic4}/>
                <h5 className="free-title">Futures and Options</h5>
               <ul className="free-list">
                 <li>What is Option?</li>
                 <li>Contract for Specific Time</li>
                 <li>Hedging with Futures </li>
                 <li>Risk Mitigation Strategies </li>
                 </ul>
                 <button className="but-course">Learn More</button>
            </div>
        </div>
         
    </>
    );
}

export default Course;

