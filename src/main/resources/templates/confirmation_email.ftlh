<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Sending Email with Freemarker HTML Template Example</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="https://vk.com/doc99916294_544375194?hash=95387212d283c779ae&dl=5a14e7c33c020bf2fa">
    <style>
        body {
            font-family: 'Montserrat', sans-serif;
            font-size: 48px;
        }
        .button {
            text-decoration: none;
            outline: none;
            display: inline-block;
            width: 200px;
            height: 45px;
            line-height: 45px;
            font-family: 'Montserrat', sans-serif;
            font-size: 14px;
            text-transform: capitalize;
            text-align: center;
            letter-spacing: 1px;
            font-weight: 600;
            color: #ffffff;
            background: black;
            transition: .3s;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="black" style="padding: 10px 0 5px 0;">
            <p style="font-size: 30px; color: white;"><b>Thanks for joining us!</b></p>
        </td>
    </tr>
    <tr>
        <td bgcolor="#f7f7f7" style="padding: 40px 30px 40px 30px;">
            <p>Dear, ${name} </p>
            <p>Please click the following button to confirm your email</p>
            </br>
            <div style="text-align: center;">
                <a type="button" class="button" href="http://localhost:8080/confirming?token=${token}&login=${name}" style="background-color: black; color: white">Confirm</a>
            </div>
        </td>
    </tr>
</table>

</body>
</html>