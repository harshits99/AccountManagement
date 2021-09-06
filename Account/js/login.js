document.getElementById("loginButton").onclick = (event) => {
    event.preventDefault();
    console.log("CLicked");
    if (validateLogin()) loginAPI();
};
