document.getElementById("depositButton").onclick = (event) => {
    event.preventDefault();
    console.log("Clicked");
    if (validateDeposit()) depositAPI();
};
