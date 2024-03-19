import React from 'react';
import './Free.css';
import tom from "../images/tom.jpg"

function Free(){
    return (
    <>
        <div className="grad">
            <div className="explore-course">
            <h2>Free Resources</h2>
            </div>
            <div className="align-course">
            <div className="c4">
                <h5 className="c-t">video</h5>
                <p className="course-text"> We have some exclusive ebooks and videos just for you to
                 get started on your financial journey! Click below to access them</p>
            </div>

            <div className="c3">
                <h5 className="c-t">video</h5>
                <p className="course-text">We have some exclusive ebooks and videos just for you to
                 get started on your financial journey! Click below to access them</p>
            </div>

            <div className="c2">
                <h5 className="c-t">ebook</h5>
                <p className="course-text">We have some exclusive ebooks and videos just for you to
                 get started on your financial journey! Click below to access them</p>
            </div>

            <div className="c1">
                <h5 className="c-t">ebook</h5>
                <p className="course-text">We have some exclusive ebooks and videos just for you to
                 get started on your financial journey! Click below to access them</p>
            </div>
            </div>
            <div className="q2">
            <div className="qoute2">
            <img className="qouteimg2" src={tom} alt="w"/>
            <h2 className="qoutetext2">"Life is like a stock market. Some days you're up.
             Some days you're down. And some days you feel like something the bull left behind"</h2>
            <h4 className="name2">-Tom Wilson</h4>
         </div>
         </div>
         </div>
    </>
    );
}

export default Free;