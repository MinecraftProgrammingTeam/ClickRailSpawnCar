package huihui.crsc.minecars;

import huihui.crsc.ClickRailSpawnCar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class CleanMinecars extends BukkitRunnable {
    @Override
    public void run(){
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "准备清理右键铁轨生成的矿车...");
        CommandSender sender = Bukkit.getConsoleSender();
        Bukkit.dispatchCommand(sender, "execute at @e[name=Minecart1] run kill @e[name=Minecart1]");
//        Player console = (Player)sender;
//        console.performCommand("execute at @e[name=Minecart1] run kill @e[name=Minecart1]");
    }

}
