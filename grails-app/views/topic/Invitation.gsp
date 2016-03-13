<html lang="en">
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    Invitation
    <title>
    </title>
    <style type="text/css">
    a:hover { text-decoration: none !important; }
    .header h1 {color: #020824; font: bold 54px Helvetica, Arial,sans-serif; margin: 0; padding: 0; line-height: 55px;letter-spacing: -3px; }
    .header p {color: #020824; font: normal 17px Helvetica, Arial,sans-serif; margin: 0; padding: 0; line-height: 18px; font-style: italic;}
    .header h3 {color: #020824; font: normal 18px Courier, 'Monaco', monospace;  margin: 0; padding: 0; line-height: 18px; }
    .header .subscribe p {font-size: 10px; line-height: 18px; color:#020824; margin: 0; padding: 0;font-family: 'Monaco', monospace; text-transform:uppercase; font-style: normal; word-spacing: -1px;}
    .header .subscribe p a{ color: #020824;}


    .content h2 {color:#020824; font-weight: bold; line-height: 31px; font-size: 31px; font-family: Helvetica, Arial,sans-serif; letter-spacing: -1px;  margin: 0; padding: 0; }
    .content p {color:#020824; font-weight: normal; margin: 0; padding: 0; line-height: 20px; font-size: 14px;font-family: Courier, 'Monaco', monospace;}
    .content a {color: #020824;}
    .content a.more {color: #fff; background: #000; text-decoration: none; line-height: 16px; padding: 2px 0;}
    .footer p {font-size: 11px;  line-height: 18px; color:#020824; margin: 0; padding: 0;font-family: Courier, 'Monaco', monospace; letter-spacing: -1px;}
    .footer p a{ color:#000;}
    .footer a.send {color: #fff; background: #000; text-decoration: none; line-height: 16px; padding: 2px 0}
    a {color: #000;}
    .case {background: #ffde00 url('images/bg_email.png'); }
    </style>
    <!--[if gte mso 9]>
	<style type="text/css">
     .body{background: #ffde00 url('images/bg_email.png');
	 .case { background:none;}
     </style>
	   <![endif]-->
</head>
<body style="margin: 0; padding: 0;" class="body">
<div style="color:#020824">
    <table cellpadding="0" cellspacing="0" border="0" align="center" width="100%">
        <tr>
            <td align="center" style="padding: 5px 0 50px; background: #E0E2EF url('images/bg_email.png');color:#020824" class="case">
                <!--[if gte mso 9]>
	            <td align="center" style="padding: 5px 0 50px; background: none;color:#000">
	         <![endif]-->
                <table cellpadding="0" cellspacing="0" border="0" align="center" width="600" style="font-family: Courier, 'Monaco', monospace;color:#020824" class="header">
                    <tr>
                        <td align="left" style="padding: 5px 0 15px; font-size: 11px; color:#020824; margin: 0; line-height: 1.4;font-family: Courier, 'Monaco', monospace;" valign="top" colspan="2" class="subscribe">
                            <p style="font-size: 10px; line-height: 18px; color:#020824; margin: 0; padding: 0;font-family: 'Monaco', monospace; text-transform:uppercase; font-style: normal; word-spacing: -1px;">You're receiving this invitation for subscription to ${topic.name} (${topic.visibility}).</p>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" style="padding: 10px 0 0;" colspan="2">
                            <h3 style="color: #020824; font: normal 14px 'Monaco', monospace;  margin: 0; padding: 0; line-height: 18px; "><%= new Date()%></h3>
                        </td>
                    </tr>
                    <tr>
                        <td align="left" style="padding: 0 0 26px;" valign="bottom" width="383">
                            <h1 style="color: #020824; font: bold 54px Helvetica, Arial,sans-serif; margin: 0; padding: 0; line-height: 55px;letter-spacing: -3px;">Invitaion to ${topic.name}</h1>
                            <p style="color: #020824; font: normal 17px Helvetica, Arial,sans-serif; margin: 0; padding: 0; line-height: 18px; font-style: italic;">Join us</p>
                        </td>
                    </tr>
                </table><!-- header-->
                <table cellpadding="0" cellspacing="0" border="0" align="center" width="600" style="font-family: Courier, 'Monaco', monospace; ">

                    <tr>
                        <td width="135" style="font-size: 1px; font-family: Courier, 'Monaco', monospace;padding: 25px 0 0;" align="left" valign="top"><a href="${grailsApplication.config.grails.serverURL}/home/show/${topic.createdBy.userName}"> <img src="${grailsApplication.config.grails.serverURL}/user/profilePhoto/${topic.createdBy.userName}" class="img-responsive" width="114" height="96"></a></td>
                        <td width="465" valign="top" align="left" style="font-family: Courier, 'Monaco', monospace;" class="content">
                            <table cellpadding="0" cellspacing="0" border="0"  style="color: #020824; font: normal 11px Courier, 'Monaco', monospace; margin: 0; padding: 0;" width="465">
                                <tr>
                                    <td style="padding: 20px 0 25px;" align="left">
                                        <h2 style="color:#020824; font-weight: bold; line-height: 31px; font-size: 31px; font-family: Helvetica, Arial,sans-serif; letter-spacing: -1px;  margin: 0; padding: 0;">Share your links</h2>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding: 0px 0 25px;"  valign="top">
                                        <p style="color:#020824; font-weight: normal; margin: 0; padding: 0; line-height: 20px; font-size: 14px;font-family: Courier, 'Monaco', monospace; ">
                                            ${invitationText}
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="padding: 0px 0 25px;"  valign="top">
                                        <p style="color:#020824; font-weight: normal; margin: 0; padding: 0; line-height: 20px; font-size: 14px;font-family: Courier, 'Monaco', monospace; ">
                                            ${topic.description}
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="left" style="height:20px; font-size: 1px; line-height: 1px; background:#000" height="20" valign="top">&nbsp;</td>
                                </tr>
                                <tr>
                                    @Created By: ${topic.createdBy.name}
                                </tr>

                            </table>
                        </td>

                    </tr>

                </table>
            </td>
        </tr>
    </table>
</div>
</body>
</html>