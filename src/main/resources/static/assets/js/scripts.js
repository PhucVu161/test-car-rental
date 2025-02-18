
function loginUser() {
    event.preventDefault();

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    fetch("/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success && data.data.role === "car owner"){
            document.getElementById("message").textContent = "Đăng nhập thành công!";
            location.reload();
            //window.location.href = "homecarowner.html";
            console.log("thành công");
            document.getElementById("loginForm").reset();
        }
        else if (data.success) {
            document.getElementById("message").textContent = "Đăng nhập thành công!";
            location.reload();
            //window.location.href = "home.html";
            console.log("thành công");
            document.getElementById("loginForm").reset();
        } else {
            document.getElementById("message").textContent = "Sai tài khoản hoặc mật khẩu!";
            console.log("thất bại");
        }
    })
    .catch(error => console.error("Lỗi:", error));
}

function toggleMenu(event) {
    event.preventDefault(); // Prevent default link behavior
    var menu = document.getElementById("userMenu");
    menu.style.display = (menu.style.display === "block") ? "none" : "block";
}

document.addEventListener("DOMContentLoaded", function () {
    var toggleBtn = document.getElementById("toggleMenu");
    var menu = document.getElementById("userMenu");

    if (toggleBtn && menu) {
        toggleBtn.addEventListener("click", function (event) {
            event.preventDefault(); // Ngăn chặn load lại trang khi click
            menu.classList.toggle("d-block"); // Hiện/ẩn menu
        });
    }
});
