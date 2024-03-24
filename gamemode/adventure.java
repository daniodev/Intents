package gamemode;

import org.bukkit.plugin.*;
import important.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class adventure implements CommandExecutor
{
    private Plugin plugin;
    
    public adventure() {
        this.plugin = (Plugin)Main.getPlugin((Class)Main.class);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String s, final String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("intents.gamemode.creative")) {
                if (args.length == 0) {
                    final Player p = (Player)sender;
                    p.setGameMode(GameMode.ADVENTURE);
                    final String messaggio = this.plugin.getConfig().getString("Messagges.gma-msg").replaceAll("&", "§");
                    p.sendMessage(messaggio);
                }
                else if (args.length == 1) {
                    final Player p2 = Bukkit.getServer().getPlayerExact(args[0]);
                    if (p2 != null) {
                        if (p2 == sender) {
                            p2.setGameMode(GameMode.ADVENTURE);
                            final String messaggios = this.plugin.getConfig().getString("Messagges.gma-msg").replaceAll("&", "§");
                            p2.sendMessage(messaggios);
                        }
                        if (p2 != sender) {
                            p2.setGameMode(GameMode.ADVENTURE);
                            final String messaggios = this.plugin.getConfig().getString("Messagges.gma-msg").replaceAll("&", "§");
                            final String messaggiose = this.plugin.getConfig().getString("Messagges.gamemode-change-msg-other").replaceAll("&", "§").replaceAll("%target%", p2.getName());
                            p2.sendMessage(messaggios);
                            sender.sendMessage(messaggiose);
                        }
                    }
                    else {
                        final String messaggios = this.plugin.getConfig().getString("Messagges.offline-player").replaceAll("&", "§");
                        sender.sendMessage(messaggios);
                    }
                }
            }
            else {
                final String messaggiose2 = this.plugin.getConfig().getString("Messagges.no-perms").replaceAll("&", "§");
                sender.sendMessage(messaggiose2);
            }
        }
        else if (args.length == 1) {
            final Player p = Bukkit.getServer().getPlayerExact(args[0]);
            if (p != null) {
                p.setGameMode(GameMode.ADVENTURE);
                final String messaggios = this.plugin.getConfig().getString("Messagges.gma-msg").replaceAll("&", "§");
                final String messaggio2 = this.plugin.getConfig().getString("Messagges.gamemode-change-msg-other").replaceAll("&", "§").replaceAll("%target%", p.getName());
                System.out.println(messaggio2);
                p.sendMessage(messaggios);
            }
            else {
                final String messaggios = this.plugin.getConfig().getString("Messagges.offline-player").replaceAll("&", "§");
                sender.sendMessage(messaggios);
            }
        }
        else {
            final String messaggios2 = this.plugin.getConfig().getString("Messagges.only-player").replaceAll("&", "§");
            System.out.println(messaggios2);
        }
        return true;
    }
}
