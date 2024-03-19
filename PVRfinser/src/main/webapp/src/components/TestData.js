import './Testimonial.css';

function TestData(props){
	return(
		<div className="test-card">
			<h4>{props.heading}</h4>
			<p>{props.text}</p>
		</div>
	);
}

export default TestData;