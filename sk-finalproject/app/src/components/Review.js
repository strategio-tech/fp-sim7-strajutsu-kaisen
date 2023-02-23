import { useState } from 'react';


function Review() {

  const [name, setName] = useState('');
  const [review, setReview] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    await fetch('/review/create', {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name,
                review: review
            })});
    setName("");
    setReview("");
  }

  return (
    <div>
    <form onSubmit={handleSubmit}>
        <div class="form-group">
            <label>Name
                <input type="text" value={name} onChange={e => setName(e.target.value)} class="form-control"/>
            </label>
        </div>
        <div class="form-group">
            <label>Review
                <input type="text" value={review} onChange={e => setReview(e.target.value)} class="form-control"/>
            </label>
        </div>
        <div class="form-group mt-2">
            <button type="submit" value="Create Event" class="btn btn-success">Create Event</button>
        </div>
    </form>
    </div>
  );
}

export default Review;