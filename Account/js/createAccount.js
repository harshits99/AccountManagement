document.getElementById("createAccountButton").onclick = (event) => {
    event.preventDefault();
    console.log("Clicked");
    if (validateAccount()) createAccountAPI();
};
