package special_commands;

import org.bukkit.event.*;
import org.bukkit.plugin.*;
import important.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class Hat implements CommandExecutor, Listener
{
    private Plugin plugin;
    
    public Hat() {
        this.plugin = (Plugin)Main.getPlugin((Class)Main.class);
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            final PlayerInventory inv = player.getInventory();
            final ItemStack held = inv.getItemInHand();
            final ItemStack helm = inv.getHelmet();
            if (player.hasPermission("intents.hat.item." + held.getType().name())) {
                if (held.getType() == Material.AIR) {
                    final String messair = this.plugin.getConfig().getString("Messagges.airhat").replaceAll("&", "§");
                    player.sendMessage(messair);
                }
                else {
                    inv.setHelmet(held);
                    inv.setItemInHand(helm);
                    player.updateInventory();
                    final String messhat = this.plugin.getConfig().getString("Messagges.hatsetup").replaceAll("%item%", held.getType().name()).replaceAll("&", "§");
                    player.sendMessage(messhat);
                }
            }
            else {
                final String messaggio = this.plugin.getConfig().getString("Messagges.no-perms").replaceAll("&", "§");
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
