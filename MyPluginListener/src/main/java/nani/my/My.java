package nani.my;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class My extends JavaPlugin {

    @Override
    public void onEnable() {
    System.out.println("Sistem Başlatılıyor");
    System.out.println("Sistem Başlatıldı");
        Bukkit.getPluginManager().registerEvents(new MyPlugin(this), this);

    }

    @Override
    public void onDisable() {
        System.out.println("Sistem durduruldu");
    }
}
