  // Select elements
  const addSkillButton = document.getElementById('addSkillButton');
  const skillsInput = document.getElementById('skillsInput');
  const skillsList = document.getElementById('skillsList');

  // Add event listener to the Add Skills button
  addSkillButton.addEventListener('click', () => {
    const skill = skillsInput.value.trim();

    // Ensure the input is not empty
    if (skill !== '') {
      // Create a new div for the skill tag
      const skillTag = document.createElement('div');
      skillTag.classList.add('skill-tag');
      skillTag.innerHTML = `${skill} <span class="remove-btn" onclick="removeSkill(this)">&#10005;</span>`;

      // Append the skill tag to the list
      skillsList.appendChild(skillTag);

      // Clear the input field after adding the skill
      skillsInput.value = '';
    }
  });

  // Function to remove a skill
  function removeSkill(element) {
    const skillTag = element.parentElement;
    skillTag.remove();
  }