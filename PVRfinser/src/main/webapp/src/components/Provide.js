import React from 'react';
import './Provide.css';
import adam from "../images/adam.jpg"


function Provide(){
    return (
    <>
      <div className="q3">
         <div className="qoute3">
            <img className="qouteimg3" src={adam} alt="w"/>
            <h2 className="qoutetext3">"Becoming a successful investor in future should be effortless when you undertand and let the market do the work for you."</h2>
            <h4 className="name3">-Adam Messina</h4>
         </div>
       <div className="exp">
         <h2 className="provide">What We Provide</h2>
         <div className="p1p2">
         <div className="p1">
            <ul>
            <li>Guidance</li>
            <li>Guidance</li>
            <li>Guidance</li>
            <li>Guidance</li>
            </ul>
         </div>
         <div className="p2">
            <ul>
            <li>Guidance</li>
            <li>Guidance</li>
            <li>Guidance</li>
            <li>Guidance</li>
            </ul>
         </div>
         </div>
       </div>
       
        </div>
    </>
    );
}

export default Provide;