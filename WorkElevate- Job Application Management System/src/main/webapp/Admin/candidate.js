document.addEventListener("DOMContentLoaded", function () {
    const modal = document.getElementById("crud-modal");
    const openBtn = document.querySelector("[data-modal-toggle='crud-modal']");
    const closeBtn = modal.querySelector("[data-modal-toggle='crud-modal']");

    openBtn.addEventListener("click", function () {
        modal.classList.remove("hidden");
        modal.classList.add("flex");
    });

    closeBtn.addEventListener("click", function () {
        modal.classList.add("hidden");
        modal.classList.remove("flex");
    });

    // Close modal on clicking outside content
    modal.addEventListener("click", function (event) {
        if (event.target === modal) {
            modal.classList.add("hidden");
            modal.classList.remove("flex");
        }
    });
});

