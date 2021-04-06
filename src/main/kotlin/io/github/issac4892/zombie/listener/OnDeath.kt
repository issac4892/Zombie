package io.github.issac4892.zombie.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.plugin.java.JavaPlugin

class OnDeath : Listener {
    @EventHandler
    fun onDeath(e: PlayerDeathEvent) {
        TODO("HUMAN DEATH: HUMAN TO ZOMBIE, ANNOUNCE")
        TODO("Check if there is left human")
        TODO("Toast message?")
        TODO("RandomTP")
    }
}