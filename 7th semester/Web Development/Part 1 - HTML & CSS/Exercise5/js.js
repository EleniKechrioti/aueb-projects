const passwordField  = document.getElementById("sign-up-password");
const passwordConfirmField = document.getElementById("sign-up-password-2nd");
const birthdateField = document.getElementById("sign-up-birthdate");


const signUpButton = document.getElementById("sign-up-button");

let slideNumber = 1;
showSlide(slideNumber);

const next = document.getElementsByClassName("next");
const prev = document.getElementsByClassName("prev");

next.onclick = () =>{
    nextSlide();
}
prev.onclick = () =>{
    prevSlide();
}

signUpButton.onclick = () => {
    checkPasswords();
    checkBirthDate();
}

// Checks if the two password fields are equal.
function checkPasswords() {
    let errorMsg = "";

    if(passwordField.value !== passwordConfirmField.value){
        errorMsg = "Passwords must match";
    }

    passwordField.setCustomValidity(errorMsg);
    passwordConfirmField.setCustomValidity(errorMsg);
}

function checkBirthDate() {
    let birthdate = new Date(birthdateField.value);
    let todaysDate = new Date();
    let errorMsg = "";

    if(birthdate >= todaysDate) {
        errorMsg = "Please enter a valid date";
    } else if (calculateAge(birthdate) < 18) {
        errorMsg = "You have to be 18+ to register"
    }
    console.log(errorMsg);
    birthdateField.setCustomValidity(errorMsg);
}

function calculateAge(birthday) {
    let ageDifMs = Date.now() - birthday;
    let ageDate = new Date(ageDifMs);
    return Math.abs(ageDate.getUTCFullYear() - 1970);
}

/*for rental house 1243 */


// Next/previous controls
function nextSlide() {
    slideNumber += 1;
  showSlide(slideNumber);
}
function prevSlide(){
    slideNumber -=1;
    showSlide(slideNumber);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlide(slideNumber = n);
  console.log("well doee");
}

function showSlide(n) {
  let i;
  let slide = document.getElementsByClassName("slide");
  let dots = document.getElementsByClassName("dot");
  if (n > slide.length) {slideNumber = 1}
  if (n < 1) {slideNumber = slide.length}
  for (i = 0; i < slide.length; i++) {
    slide[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slide[slideNumber-1].style.display = "block";
  dots[slideNumber-1].className += " active";
}