package important;

import org.bukkit.plugin.*;
import org.bukkit.command.*;

public class intents implements CommandExecutor
{
    private Plugin plugin;
    
    public intents() {
        this.plugin = (Plugin)Main.getPlugin((Class)Main.class);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (sender.hasPermission("intents.admin") && args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            final String messaggio = this.plugin.getConfig().getString("Messagges.reload-msg").replaceAll("&", "§");
            sender.sendMessage(messaggio);
            this.plugin.reloadConfig();
        }
        return true;
    }
}
