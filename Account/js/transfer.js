document.getElementById("transferButton").onclick = (event) => {
    event.preventDefault();
    console.log("Clicked");
    if (validateTransfer) transferAPI();
};
