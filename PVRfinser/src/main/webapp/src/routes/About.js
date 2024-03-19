import Footer from "../components/Footer.js";
import pic1 from "../images/a.jpeg";
import pic2 from "../images/b.jpeg";
import pic3 from "../images/c.jpeg";
import "./About.css";
 
function About(){
    return (
    <>
       <section className="about-page">
    <div className="about-heading">
        <h1>About Us</h1>
    </div>
    <div className="about-container">
        <div className="about-content"> 
          <h2>Welcome to PVR Financial Services</h2>
          <p>PVR financial services is a platform for financial analysis and information,
             aimed at empowering both seasoned traders and newcomers. Founded by 
             passionate investors and market experts, it provides reliable news,
              in-depth analysis, and educational resources. The team of analysts
               researches and interprets market trends, breaking down complex
                concepts into practical insights. We prioritize transparency 
                and integrity, delivering unbiased, quality content for informed
                 investment decisions. Join our community of investors, traders,
                  and financial enthusiasts, and embark on a journey towards financial empowerment with PVR 
                  financial sevices. Let's navigate the markets together, turning knowledge into opportunities and 
                  empowering your financial future.</p>
                    <a href="/contact"><button className="about-btn"> Contact us</button> </a>
                </div>
    </div>
</section>
<section className="mvc">  
   <div className="mvv-container">
    <div className="mvv-block">
       <div className="about-image">
        <img src={pic1} alt="first"/> 
      </div>
       <div className="about-content"> 
        <h5 className="names">Our Mission</h5>
          <p>
          Our mission is to empower individuals with the knowledge and skills
           needed to navigate the complexities of the stock market successfully.
            We aim to provide comprehensive and accessible stock market classes that cater to both beginners and experienced investors,
           fostering financial literacy and independence.
          </p>
       </div>
    </div>
    <div className="mvv-block">
      <div className="about-image">
       <img src={pic2} alt=""/>
      </div>
      <div className="about-content"> 
       <h5 className="names">Our Vision</h5>
       <p>
        Our vision is to be a leading provider of stock market education,
         recognized for our commitment to excellence, innovation, and 
         inclusivity. We aspire to create a community of informed and 
         confident investors who can make sound financial decisions, build
          wealth, and achieve their long-term financial goals through a deep
           understanding of the stock market.
       </p>
      </div>
   </div>
   <div className="mvv-block">
    <div class="about-image">
     <img src={pic3} alt=""/> 
    </div>
    <div className="about-content"> 
     <h5 className="names">Our Values</h5>
     <p>
      Our vision is to be a leading provider of stock market education,
       recognized for our commitment to excellence, innovation, and 
       inclusivity. We aspire to create a community of informed and 
       confident investors who can make sound financial decisions, build
        wealth, and achieve their long-term financial goals through a deep
         understanding of the stock market.
     </p>
    </div>
 </div>
   </div>
  </section>
<section className="about-zero">
    <div className="about-row">
       <h1>Our Team</h1>
    </div>
    <div className="about-row">
        <div className="about-column">
         <div className="about-card">
                <div class="about-img-container">
                   <img src="images/bg20.jfif" alt=""/> 
                </div>
                  <h3>Luna Turner</h3>
                  <p>Founder</p>

                  <div className="about-icons">
                      <a href="#">
                        <i className="fa-brands fa-square-x-twitter"></i>
                      </a>

                      <a href="#">
                        <i className="fa-brands fa-square-instagram"></i>
                      </a>

                      <a href="#">
                        <i className="fa-brands fa-facebook"></i>
                      </a>
                  </div>
            </div>
        </div>
         <div className="about-column">
            <div className="about-card">
                   <div className="about-img-container">
                      <img src="images/bg11.jfif" alt=""/>
                   </div>
                     <h3>Steve Rogers</h3>
                     <p> Developer</p>

                     <div className="about-icons">
                         <a href="#">
                           <i className="fa-brands fa-square-x-twitter"></i>
                         </a>

                         <a href="#">
                           <i className="fa-brands fa-square-instagram"></i>
                         </a>

                         <a href="#">
                           <i className="fa-brands fa-facebook"></i>
                         </a>
                     </div>
               </div>
           </div>
         <div className="about-column">
            <div className="about-card">
                   <div className="about-img-container">
                      <img src="images/bg16.jfif" alt=""/>
                   </div>
                     <h3>Steve Rogers</h3>
                     <p> Developer</p>

                     <div className="about-icons">
                         <a href="#">
                           <i className="fa-brands fa-square-x-twitter"></i>
                         </a>

                         <a href="#">
                           <i className="fa-brands fa-square-instagram"></i>
                         </a>

                         <a href="#">
                           <i className="fa-brands fa-facebook"></i>
                         </a>
                     </div>
               </div>
           </div>
    </div>
</section>   
   <Footer />    
    </>
    );
}

export default About;