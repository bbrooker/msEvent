package net.bbrooker.parkour;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Fmain extends JavaPlugin {
  
  
  public void onEnable {
    
    getLogger().Info("== PARKOUR ADDON ACTIVATED ==");
    
    //Check Config and Folder if it null or missing then it will create new one (comment by bbrooker)
    
    if(!getDataFolder().exists())
        getDataFolder().mkDir();
        
    if(!getConfig() == null)
        saveDefaultConfig();
  
  //Register event and listener here
  
  getServer().getPluginManager().registerEvent(new GameListener(this), this);
    
    
  }
  
  public void onDisable {
    
    getLogger().Info("== PARKOUR ADDON DEACTIVATED ==");
    
    
    //Save config when disable plugin or shutdown a server
    saveConfig();
  }
  
  
  @Override
  public boolean onFreeRunCommand(CommandSender sender, Command cmd, String label, String arg[]) {
  
  Player player = (Player) sender;
  
  if(!(sender instance of Player)) {
    
  sender.sendMessage("Only player can perform this command");
  
  return true;  
  } 
    
    if(cmd.getName().eqaulsIgnoreCase("Freerun") && player.hasPermission("minespace.freerun")) {
      
      sender.sendMessage(ChatColor.AQUA + "[MINESPACE]" + ChatColor.GOLD + "Free Running Addons Version 1.0B");
      sender.sendMessage(ChatColor.GREEN + "Type /freerun help to see all command you can use")      
      
      return true;
    }
  
    if(cmd.getName().eqaulsIgnoreCase("Freerun help") && player.hasPermission("minespace.freerun.help")){
      
      
      sender.sendMessage(ChatColor.AQUA + "=== FREERUN EVENT BY MINESPACE ===");
      sender.sendMessage(ChatColor.GOLD + "/freerun join" + ChatColor.WHITE + "==" + ChatColor.RED + " Quick enter Freerun event");
      sender.sendMessage(ChatColor.GOLD + "/freerun exit" + ChatColor.WHITE + "==" + ChatColor.RED + " Exit Freerun event");
      sender.sendMessage(ChatColor.GOLD + "/freerun help" + ChatColor.WHITE + "==" + ChatColor.RED + " See detail about Freerun event");
      
    }
    
    /*
    
    
    ADMIN HELP COMMAND
    
    
    */
      if(cmd.getName().eqaulsIgnoreCase("Freerun admin") && player.hasPermission("minespace.freerun.admin")){
      
      
      sender.sendMessage(ChatColor.RED + "=== FREE RUN ADDON BY MINESPACE ===");
      sender.sendMessage(ChatColor.GREEN + "/freerun join" + ChatColor.WHITE + "==" + ChatColor.RED + " Quick enter Freerun event");
      sender.sendMessage(ChatColor.GREEN + "/freerun exit" + ChatColor.WHITE + "==" + ChatColor.RED + " Exit Freerun event");
      sender.sendMessage(ChatColor.GREEN + "/freerun help" + ChatColor.WHITE + "==" + ChatColor.RED + " See detail about Freerun event");
      sender.sendMessage(ChatColor.AQUA + "/freerun create" + ChatColor.WHITE + "==" + ChatColor.RED + "Create Freerun Zone");
      sender.sendMessage(ChatColor.AQUA + "/freerun kick" + ChatColor.WHITE + "==" + ChatColor.RED + "Kick Player form This event");
      
    }
  
  
  
  
  
  else {
  
  sender.sendMessage(ChatColor.RED + "[MINESPACE]" + ChatColor.DARK_RED + "You dont have Permission to do this");  
  
  }
    
  }
  
  
  
  
  
  
}
