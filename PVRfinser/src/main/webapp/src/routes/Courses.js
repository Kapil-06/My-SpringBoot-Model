import Footer from "../components/Footer.js";
import "./Courses.css";
import pic1 from "../images/a.jpeg";
import pic2 from "../images/b.jpeg";
import pic3 from "../images/c.jpeg";
import pic4 from "../images/d.jpeg";

function Courses (){
    return (
    <>
    <div className="grad1">
        <h1>About Our Courses</h1>
        <p>lorem ipsum</p>
    </div>
    <div className="grad2">
        <div className="course-row1">
        <div className="course-box">
          <img src={pic1} alt="Course 1" />
          <h3>Course Title 1</h3>
          <p>
            Description of course 1. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
          </p>
        </div>
        <div className="course-box">
          <img src={pic2} alt="Course 2" />
          <h3>Course Title 2</h3>
          <p>
            Description of course 2. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.
          </p>
        </div>
        <div className="course-box">
          <img src={pic3} alt="Course 2" />
          <h3>Course Title 2</h3>
          <p>
            Description of course 2. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.
          </p>
        </div>
        <div className="course-box">
          <img src={pic4} alt="Course 2" />
          <h3>Course Title 2</h3>
          <p>
            Description of course 2. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.
          </p>
        </div>
        </div>

        <div className="course-row2">
        <div className="course-box">
          <img src={pic4} alt="Course 1" />
          <h3>Course Title 1</h3>
          <p>
            Description of course 1. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
          </p>
        </div>
        <div className="course-box">
          <img src={pic3} alt="Course 2" />
          <h3>Course Title 2</h3>
          <p>
            Description of course 2. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.
          </p>
        </div>
        <div className="course-box">
          <img src={pic2} alt="Course 2" />
          <h3>Course Title 2</h3>
          <p>
            Description of course 2. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.
          </p>
        </div>
        <div className="course-box">
          <img src={pic1} alt="Course 2" />
          <h3>Course Title 2</h3>
          <p>
            Description of course 2. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.
          </p>
        </div>
        </div>
    </div> 
    <div className="grad3">
            <div className="explore-course1">
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
            
         </div>
    <div className="facility">
        <h2>Facilities that we Provide</h2>
        <p>We have some exclusive ebooks and videos just for you to
        get started on your financial journey! 
        Click below to access them</p>
    </div>

    <div className="faculty">
        <h2>Our Faculties</h2>
    </div>
       <Footer />
    </>
    );
}

    
        
export default Courses;