package huihui.crsc;

import huihui.crsc.minecars.ScanPlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.Console;


public final class ClickRailSpawnCar extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ScanPlayerEvents(), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Plugin plugin = huihui.crsc.ClickRailSpawnCar.getPlugin(huihui.crsc.ClickRailSpawnCar.class);
        System.out.println(ChatColor.RED + "[crsc]插件已启动");
        int tick = plugin.getConfig().getInt("WaitTime") * 20 * 60;
        BukkitTask Clean = new huihui.crsc.minecars.CleanMinecars().runTaskTimer(this, 0, tick);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "[crsc]插件已注销");
    }
}
