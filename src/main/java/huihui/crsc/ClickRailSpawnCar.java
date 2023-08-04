package huihui.crsc;

import huihui.crsc.events.ScanPlayerEvents;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;


public final class ClickRailSpawnCar extends JavaPlugin {
    // 新建一个Map，存放玩家的坐车时长，reload或重启服务器刷新。
    public static Map<Player, Long> playerCarTimeCount = new HashMap<>();
    // normal
    public static String normal = "[Crsc]";
    public static ClickRailSpawnCar instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ScanPlayerEvents(), this);
        instance = this;
        System.out.println(ChatColor.RED + "[crsc]插件已启动");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        playerCarTimeCount.clear();
        System.out.println(ChatColor.RED + "[crsc]插件已注销");
    }
}
