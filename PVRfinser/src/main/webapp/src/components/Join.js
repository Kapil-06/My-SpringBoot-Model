import React from 'react';
import "./Join.css";

function Join(){
    return (
    <>
      <div className="join">
      <div className="join-us">
            <h2 className="title">Who can join our courses?</h2>
            <div className="row">
            <div class="row1">
                <div class="column1"><i class="fa-solid fa-gavel"/>Lawyers</div>
                <div class="column2"><i class="fa-solid fa-receipt" />CA/CSs</div>
                <div class="column3"><i class="fa-solid fa-handshake" />Entrepreneurs</div>
                <div class="column4"><i class="fa-solid fa-business-time" />Business Owners</div>
            </div>
            <div class="row2">
                <div class="column5"><i class="fa-solid fa-user-group" />Freelancers</div>
                <div class="column6"><i class="fa-solid fa-school" />Teachers/Professors</div>
                <div class="column7"><i class="fa-solid fa-dollar-sign" />Investors</div>
                <div class="column8"><i class="fa-solid fa-person-dress" />Housewives</div>
            </div>
            <div class="row3">
                <div class="column9"><i class="fa-solid fa-money-bill-trend-up" />Investors</div>
                <div class="column10"><i class="fa-solid fa-book-atlas"/>Experienced Traders</div>
                <div class="column11"><i class="fa-solid fa-user-doctor"/>Professionals</div>
                <div class="column12"><i class="fa-solid fa-graduation-cap" />Students</div>
            </div>
            </div>
        </div>
        </div>
    </>
    );
}

export default Join;
