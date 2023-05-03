package io.github.supurazako.sneaktogrow;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.entity.Player;

public final class SneakToGrow extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

    }


    // PlayerToggleSneakEventを処理する
    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        if (event.isSneaking()) {
            // スニークしたプレイヤーを取得する
            Player player = event.getPlayer();
            // プレイヤーの名前をコンソールに表示する。
            Bukkit.getLogger().info(player.getName() + "is sneaking" );


            // プレイヤーの座標を取得する
            World world = player.getWorld();
            Location center = player.getLocation();


            // 範囲内のブロックを取得する
            for (double x = center.getX() -2.5; x <= center.getX() +2.5; x++) {
                for (int yOffset = -1; yOffset <= 1; yOffset++) {
                    for (int zOffset = -2; zOffset <= 2; zOffset++) {
                        Block block = location.getWorld().getBlockAt(x + xOffset, y + yOffset, z + zOffset);
                    }
                }
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
