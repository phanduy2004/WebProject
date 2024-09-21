<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Elegant Login Form</title>
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

        .login-container {
            width: 100%;
            max-width: 380px;
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
            margin-bottom: 25px;
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

        .login-button {
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

        .login-button:hover {
            background-color: #2980b9;
        }

        .form-group p {
            margin-top: 15px;
            font-size: 14px;
            color: #7f8c8d;
        }

        .form-group p a {
            text-decoration: none;
            color: #3498db;
            transition: color 0.3s;
        }

        .form-group p a:hover {
            color: #2980b9;
        }

        /* Styles for the remember me checkbox and label */
        .remember-container {
            display: flex;
            align-items: center;
            margin-bottom: 25px;
        }

        .remember-container input {
            margin-right: 10px;
        }

        .footer {
            margin-top: 30px;
            font-size: 14px;
            color: #bdc3c7;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Log In</h2>
    <form action="login" method="post">
        <div class="form-group">
            <input type="text" name="uname" id="uname" placeholder="Enter Username" required>
        </div>
        <div class="form-group">
            <input type="password" name="psw" id="psw" placeholder="Enter Password" required>
        </div>
        <div class="remember-container">
            <input type="checkbox" checked="checked" name="remember" id="remember">
            <label for="remember">Remember me</label>
        </div>
        <button type="submit" class="login-button">Login</button>
    </form>
    <div class="form-group">
        <p><a href="registerForm.jsp">Register?</a></p>
        <p><a href="forgotPass.jsp">Forgot password?</a></p>
    </div>
    <div class="footer">
        <p> <p> <u>DuyHong Technology Corporation</u></p></p>
    </div>
</div>

</body>
</html>
