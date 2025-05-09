# 💸 Alfa Currency GIF API (Spring Boot)

> 🇷🇺 **REST-сервис на русском языке.** Интеграция с OpenExchangeRates и GIPHY для отображения gif-реакции на изменение курса валют.

---

## 🧩 Описание
Spring Boot приложение, написанное в рамках тестового задания. 

📤 Принимает GET-запрос с кодом валюты, сравнивает текущий и вчерашний курс к USD, и:
- показывает gif из GIPHY со словом "rich" или "broke"
- может вернуть редирект, ссылку или полные данные о gif

---

## 📬 Примеры запросов

- `GET /course/test` — тестовый ответ
- `GET /course/gif/BYN` — редирект на gif (rich / broke)
- `GET /course/gif/ref/EUR` — получить ссылку на gif
- `GET /course/gif/data/JPY` — получить полный JSON gif-объекта

---

## ⚙️ Технологии
- Java 17
- Spring Boot 2.x
- Gradle
- Feign (для интеграции с внешними API)
- REST conventions
- GIPHY API
- OpenExchangeRates API

---

## 🧾 Настройки (application.properties)

```properties
server.port=8080
foreign.gif.url=https://api.giphy.com
foreign.gif.param-q-rich=rich
foreign.gif.param-q-broke=broke
foreign.gif.param-limit=1
foreign.gif.param-api_key=<demo_key>
foreign.gif.limit_offset=500
foreign.course.url=https://openexchangerates.org
foreign.course.param-base=USD
foreign.course.param-app_id=<demo_key>
```

---

## 🗃 Валюты
Список поддерживаемых валют — в `currency.md`

---

## ⚠️ Disclaimer
> Интерфейс, документация и структура предназначены для **русскоязычных разработчиков**. 
> Проект создан в рамках тестового задания и не предназначен для продакшн-развёртывания.


---

## 📦 Сборка

```bash
gradle build
java -jar build/libs/alfa-0.0.1-SNAPSHOT.jar
```

> ⚙️ Требуется Java 17+

-----------------------------------
-----------------------------------
-----------------------------------

ТЕХНИЧЕСКОЕ ЗАДАНИЕ К ПРОГРАММЕ ALFA:

Сервис на Spring Boot 2 + Java 
Запросы приходят на HTTP endpoint (должен быть написан в соответствии с rest conventions), 
туда передается код валюты по отношению с которой сравнивается USD
Для взаимодействия с внешними сервисами используется Feign
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) 
вынесены в настройки
Для сборки должен использоваться Gradle

Программа Alfa принимает GET запросы.
 
СИНТАКСИС:  

{home}/course/test - чтобы получить тестовый ответ от приложения.
{home}/course/gif/{id} - чтобы получить редирект по выданной на gif ссылке.
{home}/course/gif/ref/{id} - чтобы получить ссылку на gif.
{home}/course/gif/data/{id} - чтобы получить полные данные о gif + ссылки на gif в различном размере. 

где {id} - это сокращенное название интересуемой валюты. 
Gif выдаются с сервиса GIPHY.

ВОЗВРАЩАЕМЫЙ ОБЪЕКТ:

Возвращаемый объект программы alfa: 
либо редирект по ссылке на gif, 
либо ссылка на gif, 
либо полный документ объекта Gif.

ПРИМЕРЫ: 

Примеры запроса к программе alfa: 
http://localhost:8080/course/gif/BTH
http://localhost:8080/course/gif/ref/SOS
http://localhost:8080/course/gif/data/BAM

ПАРАМЕТР ВАЛЮТЫ В ПРИЛОЖЕНИИ ALFA:

Список всех валют, поддерживаемых приложением alfa и их сокращения в файле currency.md

НАСТРОЙКИ ПРИЛОЖЕНИЯ ALFA

(настройки приложения выведены в файле application properties)

-- порт --
server.port=8080

-- адрес gif сервиса + path и параметры --
foreign.gif.url=https://api.giphy.com
foreign.gif.path=v1/gifs/search
foreign.gif.param-q-rich=rich
foreign.gif.param-q-broke=broke
- приложение работает только со значением limit=1 -
foreign.gif.param-limit=1
- ключ расчитан на 100 запросов, далее он должен быть заменен -
foreign.gif.param-api_key=J0DkR56nQnh5hab8zdmM0K86rafi43vB
- рандом выбирает число в диапазоне от 0 до указанного значения. Значение может быть от 0 до 4999 -
foreign.gif.limit_offset=500

-- адрес сервиса курса валют + path + параметры --
- приложение делает два запроса к сервису, сравнивая вчерашний курс с сегодняшним -
foreign.course.url=https://openexchangerates.org
foreign.course.path-latest=api/latest.json
foreign.course.path-historical=api/historical/
foreign.course.parh-endformatter=.json
- демо ключ имеет ограничения -
foreign.course.param-app_id=8d7224dd749348298567a6cc1f2f9685
- для демо ключа значение базисной валюты ограничено USD -
- после смены ключа на основной, значение может быть любым из предоставленого списка сокращений валют -
foreign.course.param-base=USD

СЕРВИС GIPHY

GIPHY - источник, с которого добывается адрес gif. Приложение с определенными параметрами 
обращается к API этого сервиса.
Возвращаемый объект сервиса GIPHY  - Gif. 
Всю информацию об объекте можно получить здесь: https://developers.giphy.com/docs/api/schema/#gif-object
Объект полностью можно получить только по запросу к приложению alfa типа: {home}/course/gif/data/{id}
В ином случае, приложение получит из данных ссылку на объект и выдаст ее или редирект по ней.
 
ПАРАМЕТРЫ GET ЗАПРОСА ОТ ПРОГРАММЫ ALFA К СЕРВИСУ GIPHY:

(приложение настраивает параметры самостоятельно, представленная ниже информация нужна только в случае, 
если разработчик собрался вторгаться в логику программы)

api-key (ключи указаны в настройках и описаны выше. 
Для доступа к gif через API GIPHY необходимы ключи. Бета ключи рассчитаны на 100 доступов. 
При введении приложения в работу, ключи нужно сменить на постоянные.),
q ("rich" или "broke" в зависимости от подъема или снижения курса запрашиваемой валюты относительно базовой установленной), 
(Приложение alfa обращается по адресу rich или broke, руководствуясь полученным после 
сравнения курсов значением boolean
true = up or not changed
false = down)
limit (=1). Для нормальной работы приложения значение должно быть 1. 
Засчет значения offset, приложение реализует random-выдачу. 
Остальный настройки - по умолчанию. 

GET настройки GIPHY API:
(Перечисленные ниже настройки относятся к сервису GIPHY и могут быть полезны только при изменении запросов к этому сервису)

api_key: строка (обязательно)  YOUR_API_KEY	Ключ API GIPHY.


q: строка (обязательно)	       cheeseburgers	Поисковый запрос или фраза. Добавление @<username> в любом месте
                                                параметра q эффективно изменяет поисковый запрос на поиск GIF-файлов 
                                                конкретного пользователя (пользователь должен быть общедоступным и 
                                                проверенным пользователем GIPHY.)
                                                Максимальная длина: 
                                                50 символов.


limit: integer (int32)   	20	        Максимальное количество возвращаемых объектов. 
                                                (По умолчанию: “25”).Для бета ключей максимальное количество - 50.


offset: integer (int32)     	5               Задает начальную позицию результатов.
                                                По умолчанию: “0”
                                                Максимум: “4999”


rating: string                  g               Фильтрует результаты по заданному рейтингу. Допустимые значения включают g, pg, pg-13, r. Если вы не укажете рейтинг, вы получите результаты всех возможных рейтингов.


lang: string                    en              Укажите язык по умолчанию для регионального контента; используйте 2-буквенный код языка ISO 639-1.


random_id: string               -               Идентификатор / прокси для конкретного пользователя.


bundle: string  	messaging_non_clips	Возвращает только версии, соответствующие названному пакету. Подробнее о версиях.

СЕРВИС OPEN EXCHANGE RATES

Приложение Alfa делает два запроса к сервису openexchangerates за время обработки одного запроса. 
Первый запрос отправляется для получения текущего курса указанной пользователем валюты. 
Подробная информация https://docs.openexchangerates.org/docs/latest-json
Второй запрос отправляется для получения курса указанной валюты за вчерашний день
Подробная информация https://docs.openexchangerates.org/docs/historical-json
Демо ключ позволяет использовать в качестве базовой валюты USB.
Список поддерживаемых валюс лежит в файле currency.md
либо по адресу сервиса openexchangerates: https://docs.openexchangerates.org/docs/supported-currencies 

Основная документация - 20.07.22
Описание проекта - 14.04.25
Корректировка дат - 06.05.25

