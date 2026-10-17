    let registrationForm = document.getElementById("registrationForm")
    let password = document.getElementById("password")
    let username = document.getElementById("username")
    let fullName = document.getElementById("fullName")
    let button = document.getElementById("submit")

    button.addEventListener("click", function (event) {
        event.preventDefault();

        let fullNameH = fullName.value
        let usernameH = username.value


        let passwordH = password.value;
        fetch("http://localhost:8080/Ali_RafiBeyk_HW31_Maktab146_war_exploded/registration", {
            method: "post",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                fullName: fullNameH,
                username: usernameH,
                password: passwordH
            })
        }).then(response => response.json())
            .then(response => {
                if (!response.ok) {
                    throw new Error("Some Problem Has Been Detected");
                }
                return response.json();
            }).then(data => {
            document.getElementById("resultMessage").innerText = data;
            // window.location.href = "login.jsp";
        })
    })