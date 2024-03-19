import Navbar from "../components/Navbar.js";
import Footer from "../components/Footer.js";
import c1 from "../images/c1.jpg";
import "./Contact.css";
import axios from 'axios';


function Contact(){

    const submitHandler = (event) => {
        event.preventDefault();
        const firstname = event.target.firstname.value;
        const lastname = event.target.lastname.value;
        const email = event.target.email.value;
        const phone = event.target.phone.value;
        const message = event.target.message.value;
        const data = { firstname, lastname, email, phone, message };
        axios.post("http://localhost:8080/cont/user/add", data)
    .then((response) => {
        console.log(response);
        event.target.reset();
        alert("User added successfully");
    })
    .catch((error) => {
        console.error(error);
        alert("Failed to add user");
    });

    };
    
    return (     
    <>
  <div>
<section className="contact-section">
    <div className="contact-bg">
        <h2> Contact Us</h2>
        <p className="text"> We are professional price action traders 
            from Nagpur, passionate about investing and trading. Our team members have a 
            strong enthusiasm for trading in Indian markets.
             Our team is a skilled price action trading team in equity, commodity and currency markets.</p>
    </div>
    <div className="contact-body">
        <div className="contact-info">
            <div>
                <span> <i className="fas fa-mobile-alt"></i></span>
                <span> Phone No.</span>
                <span className="text">+91-9373080942</span>
                <span className="text"></span>
            </div>
            <div>
                <span> <i className="fas fa-envelope-open "></i></span>
                <span> Email</span>
                <span className="text">mail@company.com</span>
            </div>
            <div>
                <span> <i className="fas fa-map-marker-alt"></i></span>
                <span> Address</span>
                <span className="text">Plot No.95 Aaradhana Colony, Nara Road 
                    Near Nirmal colony behind Alisha lawn, Jaripatka, Nagpur-14</span>
            </div>
            <div>
                <span> <i className="fas fa-clock"></i></span>
                <span>Opening Hours</span>
                <span className="text">Monday - Saturday </span>
                <span className="text">(8:00 AM to 9:PM)</span>
            </div>
        </div>
      </div>
        <div className="contact-form">
            <form onSubmit={submitHandler}>

                <div className="enquire">
                    <h2>Enquire now for more details</h2>
                </div>
                <div>
                    <input type="text" name="firstname" className="form-control" placeholder="First Name"/> 
                    <input type="text" name="lastname" className="form-control" placeholder="Last Nmae"/>
                </div>
                <div>
                    <input type = "email"name="email" className = "form-control" placeholder="E-mail"/>
                    <input type = "text" name="phone" className= "form-control" placeholder="Phone"/>
                  </div>
                <textarea rows="3"  name="message" placeholder="Message" className="form-control"></textarea>
                <input type="submit" className="send-btn" value="Submit"/> 
            </form>
            <div>
                <img src={c1} alt=""/>
            </div>
        </div>
    

    <div className = "map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7622.3959593891495!2d79.08390564090713!3d21.196955098746184!2
        m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bd4c1397d6e1e15%3A0x4e9ff400d2165ea2!2sPVR%20FINANCIAL%20SERVICES%20%7C%20Share
        %20Market%20Classes%20in%20Nagpur!5e0!3m2!1sen!2sin!4v1700558888892!5m2!1sen!2sin"  width="60%" height="300"
         allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"/>
      </div>
    
</section>

</div>
<Footer />
 </>
    );
}

export default Contact;