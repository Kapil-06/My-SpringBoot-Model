import React from 'react';
import kiyo from "../../images/kiyo.png"
import "./Quote.css";

function Quote4(){
    return (
    <>
        <div className="Q4">
        <div className="q4">
         <div className="qoute4">
            <img className="qouteimg4" src={kiyo} alt="w"/>
            <h2 className="qoutetext4">"It's not how much money you make, but how much money you keep, how hard
             it works for you, and how many generations you keep it for."</h2>
            <h4 className="name4">-Robert Kiyosaki</h4>
         </div>
         </div>
         </div>
        </>
    );
}

export default Quote4;