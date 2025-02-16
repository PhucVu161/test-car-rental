function showLogin() {
    document.getElementById("intro").style.display = "none";
    document.getElementById("login").style.display = "block";
    document.getElementById("nav_sign").style.display = "none";
    document.getElementById("nav_log").style.display = "none";
    document.getElementById("nav_user").style.display = "block";
}



function showLogout() {
    document.getElementById("intro").style.display = "block";
    document.getElementById("login").style.display = "none";
    document.getElementById("nav_sign").style.display = "block";
    document.getElementById("nav_log").style.display = "block";
    document.getElementById("nav_user").style.display = "none";
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
