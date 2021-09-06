document.getElementById("signupButton").onclick = (event) => {
    event.preventDefault();
    console.log("CLicked");
    if (validateSignup()) verifyUsernameAPI();
};
