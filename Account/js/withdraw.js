document.getElementById("withdrawButton").onclick = (event) => {
    event.preventDefault();
    console.log("Clicked");
    if (validateWithdraw()) withdrawAPI();
};
