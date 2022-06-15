Программа Alfa принимает get запросы: 
{home}/course/gif/{id}
{home}/course/json-gif/{id}
где {id} - это сокращенное название интересуемой валюты. 
В случае обращения к /gif/ - в ответ придет ссылка на gif объект.
В случае обращения к /json-gif/ - ответом будет полный документ Gif объекта, который выдает по запросу GIPHY.

Примеры запроса к программе alfa: 
http://localhost8080/course/gif/BTH
http://localhost8080/course/json-gif/BTH
Список всех валют и их сокращения в файле currency.md


Настройки приложения Alfa(файл application properties)

-- порт --
server.port=8080

-- название обращения -- 
gif.service.up-name=gif-service-up

-- ключ --
gif.service.up-gif-app-key=AYvKGn4IoBaKZltiQj8auY55llhbkOi7

-- адрес для GET запроса с параметрами --
gif.service.up-url=api.giphy.com/v1/gifs/search?api_key=AYvKGn4IoBaKZltiQj8auY55llhbkOi7&q=rich&limit=1

-- название обращения -- 
gif.service.down-name=gif-service-down

-- ключ --
gif.service.down-gif-app-key=J0DkR56nQnh5hab8zdmM0K86rafi43vB

-- адрес для GET запроса с параметрами --
gif.service.down-url=api.giphy.com/v1/gifs/search?api_key=J0DkR56nQnh5hab8zdmM0K86rafi43vB&q=broke&limit=1

-- название обращения --
course.service.name=course-service

-- адрес обращения --
course.service.url=https://openexchangerates.org/api/

-- составные части адреса для GET запроса c параметрами --
- обращение за последними имеющимися данными -
course.service.url-get-path-latest=latest

- обращение к сохраненным данным -
course.service.url-get-path-historical=historical/

- расширение -
course.service.url-get-path-endformatter=.json

- ключ -
course.service.url-get-path-appID=app_id=YOUR_APP_ID

- базовая валюта, относительно которой идет сравнение - 
course.serviced.url-get-path-base-currency=base=USD

-- пример GET запроса, который принимает openexchangerates.org --
#this day course https://openexchangerates.org/api/latest.json?app_id=YOUR_APP_ID&base=USD
#y-day course https://openexchangerates.org/api/historical/2013-02-16.json?app_id=YOUR_APP_ID&base=USD


Возвращаемый объект программы alfa - либо ссылка на gif, либо полный документ объекта Gif.

GIPHY - источник, с которого добывается адрес gif.
Возвращаемый объект - Gif. Ниже представлены далеко не все параметры объекта. 

type: string(default:"gif")    By default, this is almost always GIF.	"gif"
id: string                     This GIF's unique ID                     "YsTs5ltWtEhnq"
slug: string                   The unique slug used in this GIF's URL	"confused-flying-YsTs5ltWtEhnq"
url: string                    The unique URL for this GIF              "http://giphy.com/gifs/confused-flying-YsTs5ltWtEhnq"
bitly_url: string              The unique bit.ly URL for this GIF       "http://gph.is/1gsWDcL"
embed_url: string              A URL used for embedding this GIF        "http://giphy.com/embed/YsTs5ltWtEhnq"
username: string               The username this GIF is attached to, if applicable	"JoeCool4000"
source: string                 The page on which this GIF was found	"http://www.reddit.com/r/reactiongifs/comments/1xpyaa/superman_goes_to_hollywood/"
rating: string                 The MPAA-style rating for this content. Examples include Y, G, PG, PG-13 and R	"g"

Всю информацию об объекте можно получить здесь: https://developers.giphy.com/docs/api/schema/#gif-object 


GET запрос к GIPHY в программе Alfa имеет параметры: 
api-key (ключи указаны в настройках и описаны выше), 
q ("rich" или "broke" в зависимости от подъема или снижения курса запрашиваемой валюты относительно базовой установленной), 
limit (=1).
В логике программы добавляется значение offset для обеспечения random. 
Остальный настройки - по умолчанию. 

GET настройки GIPHY API:
api_key: строка (обязательно)  YOUR_API_KEY	Ключ API GIPHY.
q: строка (обязательно)	       cheeseburgers	Поисковый запрос или фраза. Добавление @<username> в любом месте
                                                параметра q эффективно изменяет поисковый запрос на поиск GIF-файлов 
                                                конкретного пользователя (пользователь должен быть общедоступным и 
                                                проверенным пользователем GIPHY.)

                                                Максимальная длина: 
                                                50 символов.
limit: integer (int32)   	20	        Максимальное количество возвращаемых объектов. 
                                                (По умолчанию: “25”).
                                                Для бета ключей максимальное количество - 50.
offset: integer (int32)     	5               Задает начальную позицию результатов.
                                                По умолчанию: “0”
                                                Максимум: “4999”
rating: string                  g               Фильтрует результаты по заданному рейтингу. Допустимые значения включают g, pg, pg-13, r. Если вы не укажете рейтинг, вы получите результаты всех возможных рейтингов.
lang: string                    en              Укажите язык по умолчанию для регионального контента; используйте 2-буквенный код языка ISO 639-1.
random_id: string               -               Идентификатор / прокси для конкретного пользователя.
bundle: string  	messaging_non_clips	Возвращает только версии, соответствующие названному пакету. Подробнее о версиях.


Для доступа к gif через API GIPHY необходимы ключи. Бета ключи рассчитаны на 100 доступов. 
При введении приложения в работу, ключи нужно сменить на постоянные. 

Ключи приложения для GIPHY:
alfa - API Key:
AYvKGn4IoBaKZltiQj8auY55llhbkOi7
alfa - second API Key:
J0DkR56nQnh5hab8zdmM0K86rafi43vB

Open Exchange Rates
Ключ позволяет только базу usd 

//true = up or not changed
//false = down
