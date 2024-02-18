scoreboard players reset #stellarity.config stellarity.config.join_message
scoreboard players reset #stellarity.config stellarity.config.always_generate_egg
scoreboard players reset #stellarity.config stellarity.config.dragon_health
scoreboard players reset #stellarity.config stellarity.config.eol_health
scoreboard players reset #stellarity.config stellarity.config.allow_disenchanting
scoreboard players reset #stellarity.config stellarity.config.enable_treasure_heads
scoreboard players reset #stellarity.config stellarity.config.track_loop_delay.eol
scoreboard players reset #stellarity.config stellarity.config.track_loop_delay.dragon
scoreboard players reset #stellarity.config stellarity.config.enable_dragon_screenshake
scoreboard players reset #stellarity.config stellarity.config.enable_creative_shock

function stellarity:config/init

function stellarity:utils/tellraw/command {string:"stellarity.messages.cmd.reset_config_to_default",fallback:"All configs have been reset to default"}

function kohara:send_command_feedback/off
