execute unless block ~ ~ ~ #ccars115_gshn28:nonsolid run summon tnt ~ ~ ~ {Fuse:1}
execute unless block ~ ~ ~ #ccars115_gshn28:nonsolid run kill @s
execute if entity @e[type=!item,name=!cannon_fire,distance=..1.5] run summon tnt ~ ~ ~ {Fuse:1}
execute if entity @e[type=!item,name=!cannon_fire,distance=..1.5] run kill @s

