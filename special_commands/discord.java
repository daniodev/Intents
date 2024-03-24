package special_commands;

import org.bukkit.plugin.*;
import important.*;
import org.bukkit.command.*;

public class discord implements CommandExecutor
{
    private Plugin plugin;
    
    public discord() {
        this.plugin = (Plugin)Main.getPlugin((Class)Main.class);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String s, final String[] args) {
        if (sender.hasPermission("intents.discord")) {
            if (args.length == 0) {
                final String messaggio = this.plugin.getConfig().getString("Messagges.discord-message").replaceAll("&", "§");
                sender.sendMessage(messaggio);
            }
            else if (args[0].equalsIgnoreCase("link")) {
                final String messaggios = this.plugin.getConfig().getString("Messagges.discord-message").replaceAll("&", "§");
                sender.sendMessage(messaggios);
            }
        }
        else {
            final String messaggio = this.plugin.getConfig().getString("Messagges.no-perms").replaceAll("&", "§");
            sender.sendMessage(messaggio);
        }
        return true;
    }
}
