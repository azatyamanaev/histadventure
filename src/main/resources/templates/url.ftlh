<!doctype html>
<#import "spring.ftl" as spring />
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Image</title>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="black" style="padding: 10px 0 5px 0;">
            <p style="font-size: 30px; color: white"><b>Your image uploaded successfully!</b></p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#f7f7f7" style="padding: 40px 30px 40px 30px;">
            <p>Dear ${login},</p>
            <p>Here is <a href="http://localhost:8080/files/${url}">link</a> to your image</p>
        </td>
    </tr>
</table>

</body>
</html>