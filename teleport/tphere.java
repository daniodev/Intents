package teleport;

import org.bukkit.plugin.*;
import important.*;
import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class tphere implements CommandExecutor
{
    private Plugin plugin;
    
    public tphere() {
        this.plugin = (Plugin)Main.getPlugin((Class)Main.class);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("intents.tphere.use")) {
                if (args.length == 0) {
                    final String messaggio = this.plugin.getConfig().getString("Messagges.specify-command").replaceAll("&", "§").replaceAll("%command%", "/tphere");
                    sender.sendMessage(messaggio);
                }
                else if (args.length == 1) {
                    final Player senderp = (Player)sender;
                    final Player target = Bukkit.getServer().getPlayerExact(args[0]);
                    if (target != null) {
                        if (target != senderp) {
                            target.teleport((Entity)senderp);
                            final String messaggio2 = this.plugin.getConfig().getString("Messagges.tp-mess").replaceAll("&", "§");
                            sender.sendMessage(messaggio2);
                        }
                    }
                    else {
                        final String messaggio2 = this.plugin.getConfig().getString("Messagges.offline-player").replaceAll("&", "§");
                        sender.sendMessage(messaggio2);
                    }
                }
            }
        }
        else {
            final String messop = this.plugin.getConfig().getString("Messagges.only-player").replaceAll("&", "§");
            System.out.println(messop);
        }
        return true;
    }
}
