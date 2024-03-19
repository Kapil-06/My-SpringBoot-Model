import './Testimonial.css';
import TestData from './TestData.js';


function Test(){
   return(
      <>
      <div className="testimo">
         <h1>Testimonials</h1>
         <p>See what our clients say</p>
      </div>
      <div className="test-round">
            <div className="test1">
               <img className="test-img" />
                <h5 className="test-t">video</h5>
            </div>

            <div className="test2">
               <img className="test-img"/>
                <h5 className="test-t">video</h5>
            </div>
      </div>
      <div className="test-round2">
            <div className="test3">
               <img className="test-img"/>
                <h5 className="test-t">photo</h5>
            </div>

            <div className="test4">
               <img className="test-img"/>
                <h5 className="test-t">photo</h5>
            </div>
      </div>
        </>
   );
}


export default Test;