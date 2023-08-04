package huihui.crsc.events;

import huihui.crsc.utils.PlayerUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static huihui.crsc.ClickRailSpawnCar.playerCarTimeCount;


public class ScanPlayerEvents implements Listener {

    // 检测玩家点击
    @EventHandler
    public void onClickBlock(PlayerInteractEvent event) {
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        if (block == null){
            return;
        }
        if (event.getAction() == Action.LEFT_CLICK_BLOCK){
            return;
        }
        if (event.getHand() == EquipmentSlot.OFF_HAND){
            return;
        }
        double x = block.getX();
        double y = block.getY() + 1;
        double z = block.getZ();

        Material clickType = block.getType(); // 获取方块的类型

        if (clickType == Material.RAIL) {
            spawnCar(x, y, z, player);
        }
        else if (clickType == Material.POWERED_RAIL){
            spawnCar(x, y, z, player);
        }
        else if (clickType == Material.ACTIVATOR_RAIL){
            spawnCar(x, y, z, player);
        }
        else if (clickType == Material.DETECTOR_RAIL){
            spawnCar(x, y, z, player);
        }

    }

    // 检测玩家上车
    @EventHandler
    public void onEnterCar(VehicleEnterEvent event){
        // 获取进入到矿车的玩家
        if (event.getVehicle().getType().equals(EntityType.MINECART)){
            // 防止动物进入，报错
            if (event.getEntered() instanceof Player){
                Player player = (Player) event.getEntered();
                Long enterTime = System.currentTimeMillis();
                // 给玩家计时
                playerCarTimeCount.put(player, enterTime);
                PlayerUtils.send(player, "#AQUA#欢迎乘坐NameFlying第%d号列车，已开始计时。", randomCarNum());
            }
        }

    }

    // 检测玩家下车
    @EventHandler
    public void onCarUnuseful(VehicleExitEvent event){
        if (event.getVehicle().getType().equals(EntityType.MINECART)){
            // 防止动物进入，报错
            if (event.getExited() instanceof Player){
                Player player = (Player)  event.getExited();
                // 停止计时，并告知玩家
                if (playerCarTimeCount.containsKey(player)){
                    Long enterTime = playerCarTimeCount.get(player);
                    Long stopTime = System.currentTimeMillis();
                    double spendTime = (double) (stopTime - enterTime) / 1000;
                    PlayerUtils.send(player, "#AQUA#本次旅程共花费：#GREEN#" + spendTime + " #AQUA#秒，感谢乘坐NameFlying此次列车。");
                    // 删除Map中的玩家
                    playerCarTimeCount.remove(player);
                }
                // 将车子销毁
                event.getVehicle().remove();
            }
        }
    }

    public void spawnCar(double x, double y, double z, Player player){
        // console报告
        System.out.println("玩家:" + player.getName() + "召唤了一个矿车 坐标:(" + x + ", " + y + ", " + z + ")");
        // 获取玩家所在world
        World world = player.getWorld();
        // 定义矿车位置
        Location location = new Location(world, x, y, z);
        // 生成矿车并让玩家坐上去
        world.spawnEntity(location, EntityType.MINECART).addPassenger(player);
    }

    public int randomCarNum(){
        List<Integer> numList = new ArrayList<>();
        numList.add(114);
        numList.add(514);
        numList.add(1919);
        numList.add(810);
        Random random = new Random();
        return numList.get(random.nextInt(4));
    }

}
