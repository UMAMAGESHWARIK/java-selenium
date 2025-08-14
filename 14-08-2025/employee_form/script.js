const form = document.getElementById('employeeForm');
const result = document.getElementById('result');

// Optional: don't allow future DOB
(function setMaxDOB() {
  const dob = document.getElementById('dob');
  const today = new Date().toISOString().split('T')[0];
  dob.max = today;
})();

// Common “blank field” message
const EMPTY_MSG = 'You cannot leave any field blank';

// Add friendly messages per field
['empId','empName','email','dob','address','mobile'].forEach(id => {
  const el = document.getElementById(id);

  // Clear message while typing
  el.addEventListener('input', () => el.setCustomValidity(''));

  // Custom messages on invalid
  el.addEventListener('invalid', () => {
    if (el.validity.valueMissing) {
      el.setCustomValidity(EMPTY_MSG);
      return;
    }
    if (id === 'empId' && el.validity.patternMismatch) {
      el.setCustomValidity('Employee ID must contain digits only');
      return;
    }
    if (id === 'empName' && el.validity.patternMismatch) {
      el.setCustomValidity('Name can include only letters and spaces');
      return;
    }
    if (id === 'email' && el.validity.typeMismatch) {
      el.setCustomValidity('Please enter a valid email address');
      return;
    }
    if (id === 'address' && el.validity.patternMismatch) {
      el.setCustomValidity('Address: only letters, numbers, spaces, and , . - / #');
      return;
    }
    if (id === 'mobile' && el.validity.patternMismatch) {
      el.setCustomValidity('Mobile must be exactly 10 digits');
      return;
    }
    el.setCustomValidity('Please check this field');
  });
});

// Submit handler: validate, then retrieve values
form.addEventListener('submit', (e) => {
  e.preventDefault(); // keep page from reloading

  if (!form.checkValidity()) {
    form.reportValidity(); // show browser messages
    return;
  }

  // Retrieve all form values
  const data = Object.fromEntries(new FormData(form).entries());

  // Show values on the page and in console
  result.textContent = JSON.stringify(data, null, 2);
  console.log('Form values:', data);
});
