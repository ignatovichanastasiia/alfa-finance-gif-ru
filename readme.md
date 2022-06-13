Gif data:
type: string(default:"gif")
By default, this is almost always GIF.	"gif"
id: string
This GIF's unique ID	"YsTs5ltWtEhnq"
slug: string
The unique slug used in this GIF's URL	"confused-flying-YsTs5ltWtEhnq"
url: string
The unique URL for this GIF	"http://giphy.com/gifs/confused-flying-YsTs5ltWtEhnq"
bitly_url: string
The unique bit.ly URL for this GIF	"http://gph.is/1gsWDcL"
embed_url: string
A URL used for embedding this GIF	"http://giphy.com/embed/YsTs5ltWtEhnq"
username: string
The username this GIF is attached to, if applicable	"JoeCool4000"
source: string
The page on which this GIF was found	"http://www.reddit.com/r/reactiongifs/comments/1xpyaa/superman_goes_to_hollywood/"
rating: string
The MPAA-style rating for this content. Examples include Y, G, PG, PG-13 and R	"g"

GET query property:
api_key: строка (обязательно)	YOUR_API_KEY	Ключ API GIPHY.
q: строка (обязательно)	cheeseburgers	Поисковый запрос или фраза. Добавление @<username> в любом месте параметра q эффективно изменяет поисковый запрос на поиск GIF-файлов конкретного пользователя (пользователь должен быть общедоступным и проверенным пользователем GIPHY.)
Если параметр q содержит одно из следующих слов: наклейка, наклейки или прозрачный, поиск вернет наклейкисодержание.
Максимальная длина: 50 символов.
предел: целое число (int32)	20	Максимальное количество возвращаемых объектов. (По умолчанию: “25”).
For beta keys max limit is 50
смещение: целое число (int32)	5	Задает начальную позицию результатов.
По умолчанию: “0”
Максимум: “4999”
рейтинг: string	g	Фильтрует результаты по заданному рейтингу. Допустимые значения включают g, pg, pg-13, r. Если вы не укажете рейтинг, вы получите результаты всех возможных рейтингов.
lang: строка	en	Укажите язык по умолчанию для регионального контента; используйте 2-буквенный код языка ISO 639-1.
random_id: строка	e826c9fc5c929e0d6c6d423841a282aa	Идентификатор / прокси для конкретного пользователя.
пакет: строка	messaging_non_clips	Возвращает только версии, соответствующие названному пакету. Подробнее о версиях.

alfa-up - API Key:
AYvKGn4IoBaKZltiQj8auY55llhbkOi7

alfa-down - API Key:
J0DkR56nQnh5hab8zdmM0K86rafi43vB



