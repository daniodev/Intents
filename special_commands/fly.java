package special_commands;

import org.bukkit.plugin.*;
import important.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class fly implements CommandExecutor
{
    private Plugin plugin;
    
    public fly() {
        this.plugin = (Plugin)Main.getPlugin((Class)Main.class);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String s, final String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("intents.fly")) {
                if (args.length == 0) {
                    final Player p = (Player)sender;
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        final String messaggios = this.plugin.getConfig().getString("Messagges.fly-off-msg").replaceAll("&", "§");
                        p.sendMessage(messaggios);
                    }
                    else {
                        p.setAllowFlight(true);
                        final String messaggios = this.plugin.getConfig().getString("Messagges.fly-on-msg").replaceAll("&", "§");
                        p.sendMessage(messaggios);
                    }
                }
                else if (args.length == 1) {
                    final Player pi = Bukkit.getServer().getPlayerExact(args[0]);
                    if (pi != null) {
                        if (pi == sender) {
                            if (pi.getAllowFlight()) {
                                pi.setAllowFlight(false);
                                final String messaggiose = this.plugin.getConfig().getString("Messagges.fly-off-msg").replaceAll("&", "§");
                                pi.sendMessage(messaggiose);
                            }
                            else {
                                pi.setAllowFlight(true);
                                final String messaggiose = this.plugin.getConfig().getString("Messagges.fly-on-msg").replaceAll("&", "§");
                                pi.sendMessage(messaggiose);
                            }
                        }
                        if (pi != sender) {
                            if (pi.getAllowFlight()) {
                                pi.setAllowFlight(false);
                                final String messaggiose = this.plugin.getConfig().getString("Messagges.fly-off-msg").replaceAll("&", "§").replaceAll("%target%", pi.getName());
                                final String messaggio = this.plugin.getConfig().getString("Messagges.fly-on-msg-other-player").replaceAll("&", "§").replaceAll("%target%", pi.getName());
                                sender.sendMessage(messaggio);
                                pi.sendMessage(messaggiose);
                            }
                            else {
                                pi.setAllowFlight(true);
                                final String messaggiose = this.plugin.getConfig().getString("Messagges.fly-on-msg").replaceAll("&", "§");
                                final String messaggio = this.plugin.getConfig().getString("Messagges.fly-off-msg-other-player").replaceAll("&", "§").replaceAll("%target%", pi.getName());
                                sender.sendMessage(messaggio);
                                pi.sendMessage(messaggiose);
                            }
                        }
                    }
                    if (pi == null) {
                        final String messaggio2 = this.plugin.getConfig().getString("Messagges.offline-player").replaceAll("&", "§");
                        sender.sendMessage(messaggio2);
                    }
                }
            }
            else {
                final String messaggiose2 = this.plugin.getConfig().getString("Messagges.no-perms").replaceAll("&", "§");
                sender.sendMessage(messaggiose2);
            }
        }
        else if (args.length == 1) {
            final Player pi = Bukkit.getServer().getPlayerExact(args[0]);
            if (pi != null) {
                if (pi.getAllowFlight()) {
                    pi.setAllowFlight(false);
                    final String messaggiose = this.plugin.getConfig().getString("Messagges.fly-off-msg").replaceAll("&", "§");
                    final String messaggio = this.plugin.getConfig().getString("Messagges.fly-off-msg-other-player").replaceAll("&", "§");
                    System.out.println(messaggio);
                    pi.sendMessage(messaggiose);
                }
                else {
                    pi.setAllowFlight(true);
                    final String messaggiose = this.plugin.getConfig().getString("Messagges.fly-on-msg").replaceAll("&", "§");
                    final String messaggio = this.plugin.getConfig().getString("Messagges.fly-on-msg-other-player").replaceAll("&", "§");
                    System.out.println(messaggio);
                    pi.sendMessage(messaggiose);
                }
            }
            if (pi == null) {
                final String messaggio2 = this.plugin.getConfig().getString("Messagges.offline-player").replaceAll("&", "§");
                sender.sendMessage(messaggio2);
            }
        }
        else if (args.length == 0) {
            final String messaggio3 = this.plugin.getConfig().getString("Messagges.specify-command").replaceAll("&", "§").replaceAll("%command%", "/fly");
            System.out.println(messaggio3);
        }
        return true;
    }
}
