package io.github.issac4892.zombie.listener

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.ScoreboardManager
import org.bukkit.scoreboard.Team
import io.github.issac4892.zombie.util.RemoveTeam
import io.github.issac4892.zombie.util.addTeam


class OnJoin : Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val p = e.player
        val manager: ScoreboardManager = Bukkit.getScoreboardManager()
        val board: Scoreboard = manager.newScoreboard
        var humanteam: Team? = board.getTeam("HUMAN")
        if (board.getEntryTeam(p.toString()) == null) {
            addTeam(p, "ZOMBIE")
            board.getTeam("ZOMBIE")?.addEntry(p.toString())
        }
        if (board.getEntryTeam(p.toString()).toString() == "ZOMBIE") {
            val item1 = ItemStack(Material.STONE_SWORD, 1)
            p.inventory.addItem(item1)
            val potion = PotionEffect(PotionEffectType.SPEED, 99999999, 1, false, false)
            p.addPotionEffect(potion)
            TODO("RandomTP")
        }
        if (board.getEntryTeam(p.toString()).toString() == "HUMAN") {
            val potion = PotionEffect(PotionEffectType.SPEED, 99999999, 1, false, false)
            p.addPotionEffect(potion)
            p.health = 40.0
            TODO("Change health, 기본템 지급")
            //기본템: 갑옷, 검, 활, 황금사과

        }
    }
}