package io.github.issac4892.zombie.util

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.ScoreboardManager

fun addTeam(p: Player, team: String){
    val manager: ScoreboardManager = Bukkit.getScoreboardManager()
    val board: Scoreboard = manager.newScoreboard
    board.getTeam(team)?.addEntry(p.toString())
}