import smtplib

#email variables
SMTP_SERVER = 'smtp.gmail.com'
SMTP_PORT = 587
GMAIL_USERNAME = 'josephboothby37@gmail.com'
GMAIL_PASSWORD = 'Joe37896'

class Emailer:
    def sendmail(self, recipient, subject, content):

        #create headers
        headers = ["From: " + GMAIL_USERNAME, "Subject: " + subject, "To: " + recipient,
                    "MIME-Version: 1.0", "Content-Type: text/html"]
        headers = "\r\n".join(headers)

        #Conect to gmail server
        session = smtplib.SMTP(SMTP_SERVER, SMTP_PORT)
        session.ehlo()
        session.starttls()
        session.ehlo()

        #login to gmail
        session.login(GMAIL_USERNAME, GMAIL_PASSWORD)

        #send email & exit
        session.sendmail(GMAIL_USERNAME, recipient, headers + "\r\n\r\n" + content)
        session.quit

sender = Emailer()

f = open("TodayCat.html", "r")
sendTo = 'josephboothby37@gmail.com'
emailSubject = "OHS Cats Of The Day"
emailContent = f.read();

#sends an email
sender.sendmail(sendTo, emailSubject, emailContent)
