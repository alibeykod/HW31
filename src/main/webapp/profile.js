function loadUserPosts() {
    fetch("profile", {
        method: "GET",
        credentials: "include"
    })
        .then(res => {
            if (!res.ok) {
                throw new Error("HTTP error " + res.status);
            }
            return res.json();
        })
        .then(posts => {
            console.log("All posts", posts);

            const container = document.getElementById("postsContainer");
            if (!container) return;

            container.innerHTML = "";

            posts.forEach(post => {
                const postDiv = document.createElement("div");
                postDiv.style.border = "1px solid #ccc";
                postDiv.style.margin = "10px 0";
                postDiv.style.padding = "10px";
                postDiv.style.borderRadius = "5px";
                postDiv.innerHTML = ` 
                    <h3> <strong>Title :</strong> ${post.title}</h3>
                    <p>Text Of Post ${post.textOfPost}</p>
                    <small>Id Of Post: ${post.id}</small>
                `;
                container.appendChild(postDiv);
            });
        })
        .catch(err => console.error("Error Detected In Receive Posts From Server Response !", err));
}

window.addEventListener("DOMContentLoaded", loadUserPosts);


const titleInput = document.getElementById("title");
const textInput = document.getElementById("textOfPost");
const uploadBtn = document.getElementById("Upload");
const resultMsg = document.getElementById("profileWelcome");

uploadBtn.addEventListener("click", function (event) {
    console.log("Press Button Has Been Clicked");

    const title = titleInput.value.trim();
    const textOfPost = textInput.value.trim();

    if (!title || !textOfPost) {
        resultMsg.innerText = "Please Enter Title And Text Of Posts";
        resultMsg.style.color = "red";
        return;
    }

    fetch("profile", {
        method: "POST",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            title: title,
            textOfPost: textOfPost
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Error In Create New Post Detected !");
            }
            return response.json();
        })
        .then(data => {
            resultMsg.innerText = "Post Upload Successfully";
            resultMsg.style.color = "green";

            titleInput.value = "";
            textInput.value = "";

            loadUserPosts();
        })
        .catch(err => {
            console.error(err);
            resultMsg.innerText = err.message;
            resultMsg.style.color = "red";
        });
});
