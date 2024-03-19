import React from 'react';
import rob from "../../images/rob.png"
import "./Quote.css";

function Quote5(){
    return (
    <>
        <div className="q5">
         <div className="qoute5">
            <img className="qouteimg5" src={rob} alt="w"/>
            <h2 className="qoutetext5">"In investing, what is comfortable is rarely profitable."</h2>
            <h4 className="name5">-Robert Arnot</h4>
         </div>
         </div>
        </>
    );
}

export default Quote5;