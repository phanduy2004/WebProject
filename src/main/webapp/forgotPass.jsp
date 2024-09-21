<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên Mật Khẩu</title>
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

        .container {
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

        .submit-button {
            width: 100%;
            padding: 14px;
            background-color:#32a8a2;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        .submit-button:hover {
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
<div class="container">
    <h2>Forgot Password</h2>
    <form action="resetpassword" method="POST">
        <div class="form-group">
            <input type="email" id="email" name="email" placeholder="Enter your email" required>
        </div>
        <button type="submit" class="submit-button">Submit</button>
    </form>
    <div class="footer">
        <p> <p> <u>DuyHong Technology Corporation</u></p></p>
    </div>
</div>
</body>
</html>
