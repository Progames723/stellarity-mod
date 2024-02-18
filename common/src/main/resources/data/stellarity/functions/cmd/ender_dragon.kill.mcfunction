execute as @e[type=minecraft:ender_dragon] run data merge entity @s {DragonPhase:9}
function far_end:mobs/ender_dragon/phase/transition/killed

function stellarity:utils/tellraw/command {string:"stellarity.messages.cmd.kill_ender_dragon",fallback:"Killed the Ender Dragon"}

function kohara:send_command_feedback/off
