let username = document.getElementById("username");
let password = document.getElementById("password");

let button = document.getElementById("login");

button.addEventListener("click", function (event) {
    event.preventDefault();

    let usernameN = username.value;
    let passwordN = password.value;

    fetch("login", {
        method: "post",
        credentials: "include",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username: usernameN,
            password: passwordN
        })
    }).then(response => {
        if (!response.ok) {
            throw new Error("Username or Password Or Both Are Wronged");
        }
        return response.json();
    })
        .then(data => {
            document.getElementById("resultMessageLogin").innerText = data;
            setTimeout(() => {
                window.location.href = "profile.jsp";
            }, 1500);
        })
        .catch(error => {
            document.getElementById("resultMessageLogin").innerText = error.message;
        });
});
