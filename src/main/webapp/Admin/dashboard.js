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