package huihui.crsc.minecars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;


public class ScanPlayerEvents implements Listener {
    public int Num = 1;
    @EventHandler
    public void ScanPlayer(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        if (block == null){
            return;
        }
        if(event.getAction() == Action.LEFT_CLICK_BLOCK){
            return;
        }
        if (event.getHand() == EquipmentSlot.OFF_HAND){
            return;
        }
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();

        String x1 = String.valueOf(x);
        String y1 = String.valueOf(y + 1);
        String z1 = String.valueOf(z);

        Material clickType = block.getType(); // 获取方块的类型

        if (clickType == Material.RAIL) {
            spawnCar(x1, y1, z1);
            System.out.println("玩家:" + event.getPlayer() + "召唤了一个矿车 坐标:" + x1 + y1 + z1);
        }
        if (clickType == Material.POWERED_RAIL){
            spawnCar(x1, y1, z1);
            System.out.println("玩家:" + event.getPlayer() + "召唤了一个矿车 坐标:" + x1 + y1 + z1);
        }
        if (clickType == Material.ACTIVATOR_RAIL){
            spawnCar(x1, y1, z1);
            System.out.println("玩家:" + event.getPlayer() + "召唤了一个矿车 坐标:" + x1 + y1 + z1);
        }
        if (clickType == Material.DETECTOR_RAIL){
            spawnCar(x1, y1, z1);
            System.out.println("玩家:" + event.getPlayer() + "召唤了一个矿车 坐标:" + x1 + y1 + z1);
        }

    }

    public void spawnCar(String x1, String y1, String z1){

//        String x1 = String.valueOf(x);
//        String y1 = String.valueOf(y + 1);
//        String z1 = String.valueOf(z);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "summon minecraft:minecart " + x1 + " " + y1 + " " + z1 + " {CustomName:\"[{\\\"text\\\":\\\"Minecart" + Num + "\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",CustomNameVisible:0b}");
//        Player console = (Player)Bukkit.getServer().getConsoleSender();

//        console.performCommand("summon minecraft:minecart " + x1 + " " + y1 + " " + z1 + " {CustomName:\"[{\\\"text\\\":\\\"Minecart" + Num + "\\\",\\\"bold\\\":false,\\\"italic\\\":false,\\\"underlined\\\":false,\\\"strikethrough\\\":false,\\\"obfuscated\\\":false}]\",CustomNameVisible:0b}");

    }

}
