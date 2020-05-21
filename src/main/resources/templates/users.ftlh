<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>User Profile</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.login}</td>
            <td>${user.email}</td>
            <td><a href="/other_profile?login=${user.login}">user profile</a> </td>
        </tr>
    </#list>
</table>
<button onclick="location.href='/'">Back to main</button>

</body>
</html>
