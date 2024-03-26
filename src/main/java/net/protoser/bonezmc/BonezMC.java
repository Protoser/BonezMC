package net.protoser.bonezmc;

import org.bukkit.plugin.java.JavaPlugin;

public class BonezMC extends JavaPlugin{

    public void onEnable() {
        this.getCommand("equipbone").setExecutor(new EquipBone());
    }

    public void onDisable() {
    }
}