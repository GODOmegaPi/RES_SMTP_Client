# RES_SMTP_Client

## Installation
You need to clone the git repository :

```sh
git clone git@github.com:SoftEng-HEIGVD/Teaching-HEIGVD-RES-2019-Labo-SMTP.git 
```

## Configuration

### Victims emails
Victims emails addresses are defined in *emails.txt* file.

You must provide a list of email addresses in this file with one email address by line.

Example :

```
gaetan.bacso@heig-vd.ch
jerome.bagnoud@heig-vd.ch
mickael.bonjour@heig-vd.ch
```

Please check emailsExample.txt to see a more thorough example.

### Messages
Messages to send are defined in *messagesExample.txt* file.

You must provide a list of messages in this file.

Each message is terminated by a line equals to "---".

Example :

```
C'est le jour de la pêche <0((((()< !
Viens t'inscrire ici : https://www.poissons.gov
---
Lorem ipsum ?!
---
```

Please check *messagesExample.txt* to see a more thorough example.

### Groups
Groups are generated based on your email list. You just need to specify the quantity of group by running the app with the number of group in argument.

Example :

```
java -jar RES_SMTP_Client-1.0-SNAPSHOT.jar 10
```
