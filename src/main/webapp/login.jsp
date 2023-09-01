<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#userId").blur(function () {
                // implementasi On click userId show Student Name as popup
                var userId = $(this).val();
                alert("Student Name: " + userId);
            });
            // Implementasi  "Do mandatory field validation with jQuery"
            $("form").submit(function (event) {
                var userId = $("#userId").val();
                var password = $("#password").val();

                // Periksa apakah "User ID" atau "Password" kosong
                if (userId === "" || password === "") {
                    alert("Isi semua bidang.");
                    event.preventDefault();
                }
            });
        });
    </script>
</head>
<body>
<div class="container">
    <h2>Login Page</h2>
    <form action="LoginServlet" method="post">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
    <% if (request.getParameter("error") != null) { %>
    <p style="color: red;">Invalid credentials. Please try again.</p>
    <% } %>
</div>
</body>
</html>
