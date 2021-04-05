package io.github.issac4892.zombie

import io.github.issac4892.zombie.commands.SetTeam
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.Material
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.ScoreboardManager
import org.bukkit.scoreboard.Team


class Main : JavaPlugin(), Listener {
    override fun onEnable() {
        logger.info("Plugin Ready!")
        val manager: ScoreboardManager = Bukkit.getScoreboardManager()
        val board: Scoreboard = manager.newScoreboard
        Bukkit.getServer().pluginManager.registerEvents(this, this)
        val humanteam: Team = board.registerNewTeam("HUMAN")
        val zombieteam: Team = board.registerNewTeam("ZOMBIE")
        humanteam.prefix = "HUMAN"
        zombieteam.prefix = "ZOMBIE"
        humanteam.color = ChatColor.BLUE
        zombieteam.color = ChatColor.RED
        humanteam.setAllowFriendlyFire(false)
        zombieteam.setAllowFriendlyFire(false)
        getCommand("setTeam")?.setExecutor(SetTeam())
        //getCommand("setTeam")?.tabCompleter = SetTeam
    }

    override fun onDisable() {
        logger.info("Plugin Stopping!")
    }

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val p = e.player
        val manager: ScoreboardManager = Bukkit.getScoreboardManager()
        val board: Scoreboard = manager.newScoreboard
        var humanteam: Team? = board.getTeam("HUMAN")
        if (board.getEntryTeam(p.toString()) == null) {
            board.getTeam("ZOMBIE")?.addEntry(p.toString())
        }
        if (board.getEntryTeam(p.toString()).toString() == "ZOMBIE") {
            val item1 = ItemStack(Material.STONE_SWORD, 1)
            p.inventory.addItem(item1)
            TODO("RandomTP")
        }
        if (board.getEntryTeam(p.toString()).toString() == "HUMAN") {
            TODO("Change health, 기본템 지급")
            //기본템: 갑옷, 검, 활, 황금사과, 대가리
        }
    }

    @EventHandler
    fun onDeath(e: PlayerDeathEvent) {
        TODO("HUMAN DEATH: HUMAN TO ZOMBIE, ANNOUNCE")
        TODO("Check if there is left human")
        TODO("Toast message?")
        TODO("RandomTP")
    }
}

// RandomTP -> Toast message where they teleported
// 채팅 칭호 되나?