<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Registration</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      font-family: 'Helvetica Neue', Arial, sans-serif;
      background-color: #f8f9fa;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      color: #333;
    }

    .register-container {
      width: 100%;
      max-width: 400px;
      padding: 40px;
      background-color: #ffffff;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
      text-align: center;
    }

    h2 {
      font-size: 26px;
      margin-bottom: 30px;
      font-weight: 600;
      color: #2c3e50;
    }

    .form-group {
      margin-bottom: 20px;
      position: relative;
    }

    .form-group input {
      width: 100%;
      padding: 12px 15px;
      font-size: 16px;
      border: 1px solid #dfe6e9;
      border-radius: 6px;
      background-color: #f1f2f6;
      transition: all 0.3s;
    }

    .form-group input:focus {
      background-color: #ffffff;
      border-color: #3498db;
      outline: none;
      box-shadow: 0 0 8px rgba(52, 152, 219, 0.3);
    }

    .register-button {
      width: 100%;
      padding: 14px;
      background-color: #32a8a2;
      color: white;
      border: none;
      border-radius: 6px;
      font-size: 16px;
      font-weight: bold;
      cursor: pointer;
      transition: background-color 0.3s ease-in-out;
    }

    .register-button:hover {
      background-color: #2980b9;
    }

    .footer {
      margin-top: 30px;
      font-size: 14px;
      color: #bdc3c7;
    }
  </style>
</head>
<body>

<div class="register-container">
  <h2>Create Your Account</h2>
  <form action="register" method="post">
    <!-- Hidden ID field -->
    <input type="hidden" name="id" id="id">

    <div class="form-group">
      <input type="text" name="name" id="name" placeholder="Enter Username" required>
    </div>
    <div class="form-group">
      <input type="email" name="email" id="email" placeholder="Enter Email" required>
    </div>
    <div class="form-group">
      <input type="text" name="fullname" id="fullname" placeholder="Enter Full Name" required>
    </div>
    <div class="form-group">
      <input type="password" name="password" id="password" placeholder="Enter Password" required>
    </div>
    <div class="form-group">
      <input type="password" name="confirm_password" id="confirm_password" placeholder="Confirm Password" required>
    </div>
    <div class="form-group">
      <input type="number" name="roleid" id="roleid" placeholder="Role ID" required>
    </div>
    <div class="form-group">
      <input type="text" name="phone" id="phone" placeholder="Enter Phone Number" required>
    </div>
    <button type="submit" class="register-button">Register</button>
  </form>
<br>
  <% if (request.getAttribute("successMessage") != null) { %>
  <div class="alert alert-success">
    <%= request.getAttribute("successMessage") %>
  </div>
  <% } %>

  <% if (request.getAttribute("errorMessage") != null) { %>
  <div class="alert alert-danger">
    <%= request.getAttribute("errorMessage") %>
  </div>
  <% } %>
  <div class="footer">
    <p> <p> <u>DuyHong Technology Corporation</u></p></p>
  </div>

</div>

</body>
</html>
