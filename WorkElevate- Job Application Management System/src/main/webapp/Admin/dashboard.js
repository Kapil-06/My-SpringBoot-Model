const toggleButton = document.getElementById('toggle-sidebar');
    const closeSidebar = document.getElementById('close-sidebar');
    const sidebar = document.getElementById('sidebar');

    toggleButton.addEventListener('click', () => {
      if (sidebar.classList.contains('-translate-x-full')) {
        sidebar.classList.remove('-translate-x-full');
      } else {
        sidebar.classList.add('-translate-x-full');
      }
    });

    closeSidebar.addEventListener('click', () => {
      sidebar.classList.add('-translate-x-full');
    });

    const dropdownButton = document.getElementById('pagesDropdownButton');
    const dropdownMenu = document.getElementById('pagesDropdownMenu');

    // Toggle dropdown visibility on click
    dropdownButton.addEventListener('click', function(event) {
        event.preventDefault(); // Prevent default action (e.g., navigation)
        dropdownMenu.classList.toggle('hidden'); // Toggle the hidden class to show/hide dropdown
    });

    // Optional: Close the dropdown when clicking outside of it
    document.addEventListener('click', function(event) {
        if (!dropdownButton.contains(event.target) && !dropdownMenu.contains(event.target)) {
            dropdownMenu.classList.add('hidden'); // Hide dropdown if clicking outside
        }
    });