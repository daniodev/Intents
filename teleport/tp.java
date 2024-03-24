package teleport;

import org.bukkit.plugin.*;
import important.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class tp implements CommandExecutor
{
    private Plugin plugin;
    
    public tp() {
        this.plugin = (Plugin)Main.getPlugin((Class)Main.class);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("intents.teleport.use")) {
                if (args.length == 0) {
                    final String messaggio = this.plugin.getConfig().getString("Messagges.specify-command").replaceAll("&", "§").replaceAll("%command%", "/tp");
                    sender.sendMessage(messaggio);
                }
                else if (args.length == 1) {
                    final Player senderp = (Player)sender;
                    final Player target = Bukkit.getServer().getPlayerExact(args[0]);
                    senderp.teleport((Entity)target);
                    final String messaggio2 = this.plugin.getConfig().getString("Messagges.tp-mess").replaceAll("&", "2");
                    sender.sendMessage(messaggio2);
                }
                else if (args.length == 2) {
                    final Player target2 = Bukkit.getServer().getPlayerExact(args[0]);
                    final Player targer2 = Bukkit.getServer().getPlayerExact(args[1]);
                    target2.teleport((Entity)targer2);
                    if (target2 != null || targer2 != null) {
                        final String messaggio2 = this.plugin.getConfig().getString("Messagges.tp-mess").replaceAll("&", "§");
                        targer2.sendMessage(messaggio2);
                        target2.sendMessage(messaggio2);
                    }
                    else {
                        final String messaggio2 = this.plugin.getConfig().getString("Messagges.tp-mess").replaceAll("&", "§");
                        sender.sendMessage(messaggio2);
                    }
                }
            }
            else {
                final String messaggio = this.plugin.getConfig().getString("Messaggi.no-perms").replaceAll("&", "§");
                sender.sendMessage(messaggio);
            }
        }
        else {
            final String messop = this.plugin.getConfig().getString("Messagges.only-player").replaceAll("&", "§");
            System.out.println(messop);
        }
        return true;
    }
}
