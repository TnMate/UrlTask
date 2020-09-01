# UrlTask

1. Adott egy url lista (Egyelőre konstansként deklaráljuk). Listázzuk ki
az url-eken található html tartalmakban a 10 (vagy X) leggyakrabban
előfoduló szót, ami nem html tag vagy attribútum.

Legyen továbbá egy skipword halmaz, amit nem tekintünk szónak, ahova
kötőszavakat írjuk fel. HashMap-et és HashSet-et kell használni, hogy
elég gyors legyen. (ha ismeretlen a HashMap logikája, olvass róla itt:
https://beginnersbook.com/2013/12/hashmap-in-java-with-example/ -
továbbá google segítségével derítsd ki, mitől jó egy kulcs a HashMap esetén)

Legyen egy skipTags halmaz is, ami olyan tagokat sorol fel, amik közé
írt szavakat nem vesszük figyelembe.
(pl. <tag1> dsd dsfg ds<tag2><tag2>  dsfgdsf</tag2></tag2> dsfsd<tag1>
a skipTag-ek közé kezdetben a style, head szavakat vesszük fel.
