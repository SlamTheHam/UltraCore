----------------------------------------------------------------------------------------- 
|                                                                                        |
|       ██╗   ██╗██╗  ████████╗██████╗  █████╗  ██████╗ ██████╗ ██████╗ ███████╗         |
|       ██║   ██║██║  ╚══██╔══╝██╔══██╗██╔══██╗██╔════╝██╔═══██╗██╔══██╗██╔════╝         |
|       ██║   ██║██║     ██║   ██████╔╝███████║██║     ██║   ██║██████╔╝█████╗           |
|       ██║   ██║██║     ██║   ██╔══██╗██╔══██║██║     ██║   ██║██╔══██╗██╔══╝           |
|       ╚██████╔╝███████╗██║   ██║  ██║██║  ██║╚██████╗╚██████╔╝██║  ██║███████╗         |
|        ╚═════╝ ╚══════╝╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝         |
-----------------------------------------------------------------------------------------
A complete Java remake of the popular Skript Plugin UltimateEssentialsPro

--------------------------------------------------------------------------------------------------------
COMMAND(S) | PERMISSION(S) | DESCRIPTION | ALIASES (<> = required [] = optional) 
--------------------------------------------------------------------------------------------------------
| Main Command(s) |
-------------------
/core <admin/help/reload/update/info/ver> | none | Main command for majority of plugin features. | /uc, /ucore
  - /core admin | core.admin | Open the Admin menu to configure the plugin ingame.
  - /core help | core.help | Sends executor help message.
  - /core reload | core.admin | Reloads the plugin and all configuration files.
  - /core update | core.admin | Updates the plugin if theres an update avalible.
  - /core info | core.admin | Displays information about the plugin and server information | /core information
  - /core ver | core.admin | Displays plugin version and updates if avalible
----------------------------
| Teleportation Command(s) |
----------------------------
/teleport <player> | core.forceteleport | Teleports you to player(no delay, no request) | /tp, /tpo
/teleportask <player> | core.teleportask | Sends player a request for you to teleport to them(60 second timeout) | /tpa
/teleporthere <player> | core.forceteleport | Teleports player to you(no delay, no request) | /tphere, tpohere
/teleportaskhere <player> | core.teleportask.here | Sends player a request to teleport them to you(60 second timeout) | /tpahere 
/teleportall | core.forceteleport | Teleports all online players to you(no delay, no request) | /tpall, /tpoall
/teleportaccept | core.teleport.accept | Accepts a requested teleport | /tpaccept, /tpoaccept
/teleportdeny | core.teleport.deny | Denys a requested teleport | /tpdeny, /tpodeny
/teleportposition <x> <y> <z> [yaw] [pitch] | core.forceteleport | Teleports you to desired position | /tppos, /tpopos
/homes <set/teleport/list> [player] | core.homes | Open homes menu with all your avalible homes | /home
  - /homes set | core.homes.admin | Sets a home for you | /sethome
  - /homes list | Open homes menu with all your avalible homes | /homes
  - /homes teleport <player> | Teleport to another player's home |
/warps <set/list/teleport> [warp] [player] | Opens  warps menu with all your avalible warps | /warp
  - /warps set <name> [x] [y] [z] [yaw] [pitch] | Set warp where your standing or with cordinates with desired name | /setwarp 
  - /warps list | Opens warps menu with all your avalible warps 
  - /warps teleport <warp> <player>
