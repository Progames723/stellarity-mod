loot spawn ~ ~ ~ loot stellarity:pandoras_barrel/drops/hills
execute if predicate kohara:chance/15percent run loot spawn ~ ~ ~ loot stellarity:pandoras_barrel/drops/hills

summon sheep ~ ~ ~
summon sheep ~ ~ ~
execute if predicate kohara:chance/25percent run summon goat ~ ~ ~
execute if predicate kohara:chance/30percent run summon sheep ~ ~ ~

execute if predicate kohara:chance/25percent run function stellarity:items/pandoras_barrel/summons/light/hills 
