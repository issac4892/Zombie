package io.github.issac4892.zombie.commands

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.ScoreboardManager

class SetTeam : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender.isOp) {
            if (args.count() == 2) {
                val p = args[0]
                val manager: ScoreboardManager = Bukkit.getScoreboardManager()
                val board: Scoreboard = manager.newScoreboard
                if (board.getEntryTeam(p) == null) {
                    if (args[1].toUpperCase() == "HUMAN") {
                        board.getTeam("HUMAN")?.addEntry(p) //왜 nullable?
                    }
                    if (args[1].toUpperCase() == "ZOMBIE") {
                        board.getTeam("ZOMBIE")?.addEntry(p)
                    } else {
                        sender.sendMessage("Usage: /setTeam <Player> <ZOMBIE/HUMAN>")
                    }
                } else {
                    if (args[1].toUpperCase() == "HUMAN") {
                        if (board.getEntryTeam(p).toString() == "HUMAN") {
                            sender.sendMessage("Player already in Human Team!")
                        } else {
                            board.getTeam("ZOMBIE")?.removeEntry(p)
                            board.getTeam("HUMAN")?.addEntry(p)
                        }
                    } else if (args[1].toUpperCase() == "ZOMBIE") {
                        if (board.getEntryTeam(p).toString() == "ZOMBIE") {
                            sender.sendMessage("Player already in ZOMBIE Team!")
                        } else {
                            board.getTeam("HUMAN")?.removeEntry(p)
                            board.getTeam("ZOMBIE")?.addEntry(p)
                        }
                    } else {
                        sender.sendMessage("Usage: /setTeam <Player> <ZOMBIE/HUMAN>")
                        return false
                    }
                }
            } else {
                sender.sendMessage("Usage: /setTeam <Player> <ZOMBIE/HUMAN>")
                return false
            }
        } else {
            sender.sendMessage("You're not OP!")
            return false
        }
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String> {
        return emptyList<String>().toMutableList()
    }
}