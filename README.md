# char-frequency-project

## Требования
- JRE 17 - скачать можно [тут](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
## Запуск
- Скачать последнюю версию .jar файла https://github.com/Hulio13/char-frequency-project/releases
- Открыть консоль и написать команду java -jar путь/к/файлу.jar(если двойным кликом, то откроется без консоли и будет работать в фоне)
## Использование
### Endpoint для вычисления частоты символов
POST (host)/api/charFrequency/calculateFrequency (если запущен локально, host можно заменить на localhost:8080)

#### Входные параметры
`inputString (строка, обязательный) - Входная строка, для которой вы хотите вычислить частоту символов.`

#### Пример запроса

json
```
{
    "inputString": "aaaaabcccc"
}
```
#### Пример ответа

json

```{
    "status": "OK",
    "data": [
        {"key": "a", "value": 5},
        {"key": "c", "value": 4},
        {"key": "b", "value": 1}
    ]
}
```

#### Ошибки

Если inputString не передан или пуст, API вернет ошибку с кодом 400 Bad Request и сообщением "inputString' parameter must be passed in request body."
