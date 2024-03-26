package net.protoser.bonezmc;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class EquipBone implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return false;
        }

        Player player = (Player) sender;

        // Check if the player's hand is holding a bone
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.getType() != Material.BONE) {
            player.sendMessage("You must be holding a bone to use this command.");
            return false;
        }

        // Check if the player's helmet slot is empty
        ItemStack helmet = player.getInventory().getHelmet();
        if (helmet != null && helmet.getType() != Material.AIR) {
            player.sendMessage("Your helmet slot is not empty.");
            return false;
        }

        // Set the bone from hand to the player's helmet slot
        player.getInventory().setHelmet(item);
        // Remove the bone from the player's hand
        player.getInventory().removeItem(item);

        player.sendMessage("Bone placed on your helmet slot!");

        return true;
    }
}
