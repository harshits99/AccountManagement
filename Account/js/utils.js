function validateLogin() {
    var uname = document.getElementById("loginName");
    var upass = document.getElementById("loginPass");

    if (uname.value.trim() == "" || upass.value.trim() == "") {
        alert("Please fill the form properly");
        return false;
    } else {
        // alert("Successful");
        return true;
    }
}

function validateSignup() {
    console.log("here");

    var sname = document.getElementById("uname");
    var spass = document.getElementById("upass");
    var spass2 = document.getElementById("upass2");

    if (
        sname.value.trim() == "" ||
        spass.value.trim() == "" ||
        spass2.value.trim() == ""
    ) {
        alert("Please fill the form properly");
        return false;
    } else if (spass.value != spass2.value) {
        alert("Passwords are not matching");
        return false;
    } else {
        // alert("Successful");
        return true;
    }
}

function validateAccount() {
    var acc = document.getElementById("acc2");

    if (acc.value.trim() == "") {
        alert("Please fill the form properly");
        return false;
    } else {
        // alert("Successful");
        return true;
    }
}

function validateDeposit() {
    var depo = document.getElementById("depo");

    if (depo.value.trim() == "") {
        alert("Please fill the form properly");
        return false;
    } else {
        // alert("Successful");
        return true;
    }
}

function validateWithdraw() {
    var draw = document.getElementById("wdraw");
    // console.log(draw);
    if (draw.value.trim() == "") {
        alert("Please fill the form properly");
        return false;
    } else {
        // alert("Successful");
        return true;
    }
}

function validateTransfer() {
    var uname = document.getElementById("transferaccount");
    var upass = document.getElementById("transferamount");

    if (uname.value.trim() == "" || upass.value.trim() == "") {
        alert("Please fill the form properly");
        return false;
    } else {
        alert("Successful");
        return true;
    }
}
