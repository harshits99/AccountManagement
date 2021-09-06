const config = {
    BASE_URL: "http://localhost:8080",
};

const loginAPI = async () => {
    const credentials = {
        username: document.getElementById("loginName").value,
        password: document.getElementById("loginPass").value,
    };

    let url = config.BASE_URL + `/user/login`;

    let response = await fetch(url, {
        method: "POST", // or 'PUT'
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(credentials),
    });

    let data = await response.json();
    if (data) {
        window.location.href = "/accountHome.html";
        window.localStorage.setItem("username", credentials.username);
        window.localStorage.setItem("password", credentials.password);
        // window.localStorage.getItem("username");
    } else {
        alert("Login failed!");
    }
    console.log("response : ", data);
};

const verifyUsernameAPI = async () => {
    const credentials = {
        username: document.getElementById("uname").value,
        password: document.getElementById("upass").value,
    };
    let url = config.BASE_URL + `/user/${credentials.username}`;

    let response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
    });

    let data = await response.json();
    console.log("check user : ", data);
    if (data) {
        alert("Username already exists! Please try a different one.");
    } else {
        let isRegistered = signupAPI(credentials);
        if (isRegistered) window.location.href = "./login.html";
        else alert("Could not register, Some error occured");
    }
};

const signupAPI = async (credentials) => {
    let url = config.BASE_URL + `/user/`;
    let response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(credentials),
    });
    let data = await response.json();
    console.log(data);
    return data;
};

const createAccountAPI = async () => {
    const credentials = {
        accountNumber: document.getElementById("acc2").value,
        user: {
            username: window.localStorage.getItem("username"),
            password: window.localStorage.getItem("password"),
        },
        balance: 0,
    };
    console.log(credentials);

    let url = config.BASE_URL + `/account/`;

    let response = await fetch(url, {
        method: "POST", // or 'PUT'
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(credentials),
    });

    let data = await response.json();
    if (data) {
        window.location.href = "./transaction.html";
        window.localStorage.setItem("accountNumber", credentials.accountNumber);
        window.localStorage.setItem("balance", credentials.balance);
    } else {
        alert("Failed!");
    }
    console.log("response : ", data);
};

const depositAPI = async () => {
    const deposit = {
        transactionID: 1,
        amount: document.getElementById("depo").value,
        primaryAccount: {
            accountNumber: window.localStorage.getItem("accountNumber"),
        },
    };
    console.log(deposit);

    let url = config.BASE_URL + `/transaction/deposit`;

    let response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(deposit),
    });

    let data = await response.json();
    if (data) {
        window.location.href = "./transaction.html";
    } else {
        alert("Failed");
    }
    console.log("response : ", data);
};

const withdrawAPI = async () => {
    const withdraw = {
        transactionID: 1,
        amount: document.getElementById("wdraw").value,
        primaryAccount: {
            accountNumber: window.localStorage.getItem("accountNumber"),
        },
    };
    console.log(withdraw);

    let url = config.BASE_URL + `/transaction/withdraw`;

    let response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(withdraw),
    });

    let data = await response.json();
    if (data) {
        window.location.href = "./transaction.html";
    } else {
        alert("Failed");
    }
    console.log("response : ", data);
};

const transferAPI = async () => {
    const transfer = {
        transactionID: 1,
        amount: document.getElementById("transferamount").value,
        primaryAccount: {
            accountNumber: window.localStorage.getItem("accountNumber"),
        },
        receiverAccount: {
            accountNumber: document.getElementById("transferaccount").value,
        },
    };
    console.log(transfer);

    let url = config.BASE_URL + `/transaction/transfer`;

    let response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(transfer),
    });

    let data = await response.json();
    // if (data) {
    //     window.location.href = "./transaction.html";
    // } else {
    //     alert("Failed");
    // }
    console.log("response: ", data);
};

const checkBalanceAPI = async () => {
    let url =
        config.BASE_URL +
        `/transaction/${window.localStorage.getItem("accountNumber")}`;

    let response = await fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
    });

    let data = await response.json();
    // if (data) {
    //     window.location.href = "./transaction.html";
    // } else {
    //     alert("Failed");
    // }
    console.log("response: ", data);
};
