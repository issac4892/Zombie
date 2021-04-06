@file:Suppress("UNREACHABLE_CODE")

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
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.ScoreboardManager
import org.bukkit.scoreboard.Team
import io.github.issac4892.zombie.listener.OnDeath
import io.github.issac4892.zombie.listener.OnJoin



class Main : JavaPlugin(), Listener {
    override fun onEnable() {
        logger.info("Plugin Ready!")
        val manager: ScoreboardManager = Bukkit.getScoreboardManager()
        val board: Scoreboard = manager.newScoreboard
        Bukkit.getServer().pluginManager.registerEvents(this, this)
        Bukkit.getServer().pluginManager.registerEvents(OnDeath(), this)
        Bukkit.getServer().pluginManager.registerEvents(OnJoin(), this)

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




}

// RandomTP -> Toast message where they teleported
// 채팅 칭호 되나?