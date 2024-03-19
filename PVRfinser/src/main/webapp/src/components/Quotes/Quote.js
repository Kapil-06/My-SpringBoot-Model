import React from 'react';
import warren from "../../images/warren.jpg";

function Qoute(){
    return (
    <>
         <div className="qoute">
            <img className="qouteimg" src={warren} alt="w"/>
            <h2 className="qoutetext">"If you don't feel comfortable owning a stock for 10 years,
             you should not own it for 10 minutes"</h2>
            <h4 className="name">-Warren Buffett</h4>
         </div>
        </>
    );
}

export default Qoute;