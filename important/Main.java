package important;

import org.bukkit.plugin.java.*;
import org.bukkit.command.*;
import gamemode.*;
import teleport.*;
import special_commands.*;

public class Main extends JavaPlugin
{
    public static Main plugin;
    
    public void onEnable() {
        System.out.println("\n|------------------------------------------\n|Intents version 1.0 by danio#7394 Enabled!\n|------------------------------------------");
        this.getCommand("gmc").setExecutor((CommandExecutor)new creative());
        this.getCommand("gms").setExecutor((CommandExecutor)new survival());
        this.getCommand("fly").setExecutor((CommandExecutor)new fly());
        this.getCommand("gma").setExecutor((CommandExecutor)new adventure());
        this.getCommand("gmsp").setExecutor((CommandExecutor)new spectator());
        this.getCommand("intents").setExecutor((CommandExecutor)new intents());
        this.getCommand("discord").setExecutor((CommandExecutor)new discord());
        this.getCommand("tphere").setExecutor((CommandExecutor)new tphere());
        this.getCommand("tp").setExecutor((CommandExecutor)new tp());
        this.getCommand("hat").setExecutor((CommandExecutor)new Hat());
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }
    
    public void OnDisable() {
        System.out.println("\n|------------------------------------------\n|Intents version 1.0 by danio#7394 Disabled!\n|------------------------------------------");
    }
    
    public void OnReload() {
        this.reloadConfig();
    }
    
    public static Main getInstance() {
        return Main.plugin;
    }
}
