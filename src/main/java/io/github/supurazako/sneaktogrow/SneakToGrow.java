package io.github.supurazako.sneaktogrow;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.entity.Player;
import org.bukkit.block.BlockFace;

import io.github.supurazako.sneaktogrow.util.checkBonemealable;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public final class SneakToGrow extends JavaPlugin implements Listener {


    private final List<Block> boneMealBlocks = new ArrayList<>();
    private final Random random = new Random();


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
            // Bukkit.getLogger().info(player.getName() + "is sneaking" );


            // プレイヤーの座標を取得する
            World world = player.getWorld();
            Location center = player.getLocation();





            // 範囲内のブロックを取得する
            for (double x = center.getX() -2; x <= center.getX() +2; x++) {
                for (double y = center.getY() -1; y <= center.getY() +1; y++) {
                    for (double z = center.getZ() -2; z <= center.getZ() +2; z++) {
                        Location location = new Location(world, x, y, z);
                        Block block = location.getBlock();
                        // ブロックに対する処理
                        if(checkBonemealable.isBonemealable(block) ) {
                            // 骨粉が使用できるブロックの場合、リストに追加
                            boneMealBlocks.add(block);
                            //block.applyBoneMeal(BlockFace.EAST);

                        }
                    }
                }
            }


            // 骨粉が使用できるブロックにたいして骨粉を使用
            if (!boneMealBlocks.isEmpty()) {
                int randomIndex = random.nextInt(boneMealBlocks.size());
                Block boneMealBlock = boneMealBlocks.get(randomIndex);
                boneMealBlock.applyBoneMeal(BlockFace.EAST);

            }


            // リストをクリア
            boneMealBlocks.clear();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
