## Парсер вопросов по списку на Ответы@Mail.Ru с последующей отправкой по email [ java версия ]

Необходимые настройки:

1)Задать параметры для соединениея с почтовым сервером:
`mail.properties`

    mail.smtp.host=адрес SMTP-сервера
    mail.smtp.socketFactory.port=порт SMTP-сервера
    mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
    mail.smtp.auth=true
    mail.smtp.port=порт SMTP-сервера
    subject=Тема сообщения
    username=Имя пользователя для авторизации на SMTP-сервере
    password=Пароль для авторизации на SMTP-сервере
    to_user=Получатель сообщения
2)Задать набор слов для поиска в вопросах:
`wordslist.txt` <br/>

3)Запустить `appStart.java`
или собрать проект и запустить `java -jar parser_mail_answers.jar` 





