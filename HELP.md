# Как поднять сервис MiniEnterpriseIT
## Как поднять базу данных PostreSql

1) Установить Docker локально на свой компьютер
2) docker run --name minientrepriseit -p 5454:5432 -e POSTGRES_PASSWORD=password -e POSTGRES_USER=root -e POSTGRES_DB=minientrepriseit -d postgres

## Как запустить сервис 

1) Должна быть установлена Java 11 локально на компьютере
2) В системных переменных должна быть переменная JAVA_HOME, которая ссылается на 11 Java

