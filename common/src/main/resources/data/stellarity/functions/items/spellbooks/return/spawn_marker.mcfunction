summon marker ^ ^ ^ {Tags:["stellarity.book_of_return","stellarity.marker"]}
tp @e[type=marker,tag=stellarity.book_of_return,limit=1,sort=nearest] ~ ~ ~ ~ ~

scoreboard players operation @s stellarity.items.spellbook.return.id = #stellarity.book_of_return stellarity.items.spellbook.return.id
scoreboard players operation @e[type=marker,tag=stellarity.book_of_return,limit=1,sort=nearest] stellarity.items.spellbook.return.id = #stellarity.book_of_return stellarity.items.spellbook.return.id
