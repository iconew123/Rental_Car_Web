function toggleContent(element) {
    var content = element.parentNode.querySelector(".board-item");
    if (content.style.display === "none" || content.style.display === "") {
        content.style.display = "block";
    } else {
        content.style.display = "none";
    }
}

const writeBtns = document.querySelectorAll(".writeBtn");
const modalWraps = document.querySelectorAll(".modalWrap");
const closeBtns = document.querySelectorAll(".closeBtn");

writeBtns.forEach((btn, index) => {
    btn.onclick = function () {
        modalWraps[index].style.display = "block";
    };
});

closeBtns.forEach((closeBtn, index) => {
    closeBtn.onclick = function () {
        modalWraps[index].style.display = "none";
    };
});

onclick = function (event) {
    modalWraps.forEach((modal) => {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
};

function showRating(selectElement) {
    var ratingContainer = selectElement.parentNode.querySelector(".ratingContainer");
    if (selectElement.value === "리뷰글") {
        ratingContainer.style.display = "block";
    } else {
        ratingContainer.style.display = "none";
    }
}
