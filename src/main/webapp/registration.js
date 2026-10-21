    let password = document.getElementById("password")
    let username = document.getElementById("username")
    let fullName = document.getElementById("fullName")
    let button = document.getElementById("submit")

    button.addEventListener("click", function (event) {
        event.preventDefault();

        let fullNameH = fullName.value
        let usernameH = username.value
        let passwordH = password.value;
        if (fullNameH === "" || usernameH === "" || passwordH === "") {
            alert("Please Fill All Of Fields");
            return;
        }
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


        }).then(response => {
            if (!response.ok) {
                throw new Error("Some Problem Has Been Detected In Registration Servlet");
            }
            return response.json();
        }).then(data => {
            document.getElementById("resultMessage").innerText = data;
            setTimeout(() => {
                window.location.href = "profile.jsp";
            }, 1500);
        })        .catch(error => {
            document.getElementById("resultMessage").innerText = error.message;
        });
    })