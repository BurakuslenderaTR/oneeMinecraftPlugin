package nani.my;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import java.util.Random;
public class MyPlugin implements Listener {
    private My plugin;
    private Random Random = new Random();

    public MyPlugin(My plugin) {
        this.plugin = plugin;
    }
//---------------------------------------------------------------------------------------------------//
    //  * Bir oyunucu sunucuya giriş yaptığı zaman hoşgeldin mesajı//
    //  * Bir oyuncu girdidiği zaman giriş yaptığını göstermemesi için sadece e.setJoinMessage(null); //
//---------------------------------------------------------------------------------------------------//
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.BLACK + "Aramiza Hoşgeldin " + ChatColor.BLUE + player.getName() + ChatColor.RED + "!");
                        // * Aramıza Hoşgeldın yazısı siyah çıkar // + //  * Sunucuya giren Oyuncun ismi mavi çıkar// + //  * ünlem işareti kırmızı çıkar !//
    }
    //---------------------------------------------------------------------------------------------------//
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        ItemStack item = player.getInventory().getItemInMainHand();
        if ((item != null) && (item.getType() == Material.AIR)) {
            if (block.getType() == Material.ORANGE_SHULKER_BOX) {
            e.setDropItems(false);
            int şans = 2+Random.nextInt(228);
            player.getWorld().dropItemNaturally(block.getLocation(),new ItemStack(Material.RED_SAND, şans));
            }
        }
    }
    //---------------------------------------------------------------------------------------------------//
    // * Normal Bir Oyunucu Sadece elini kullanarak Blok kırabilir//
    // * Turuncu Shulker Box Kırdığı zaman 2 ile 228 sayısı arası ile  Kırmızı Sand alabilir //
    //---------------------------------------------------------------------------------------------------//
    // * Dip not //
    // * Bu arada Creative Mode (Gamemode 1 ) ile koyduğunuz blokları kırdığınız zaman Kırmızı Kum Gelmez//
    // *Survival Mode (Gamemode 0 ) ile koyduğunuz bloğu kırdığınız zaman Kırmızı Kum Gelir 2 ile 228 arasında rastgele sayıda kum gelir //
    //---------------------------------------------------------------------------------------------------//
}
//---------------------------------------------------------------------------------------------------//
// * Uzun kod yazınca büyük bir yazılımıcı olmazsın az kod çok işlev bir kod yazarsan o zaman yazılımıcı olmuşun demek//
// * Bu arada Bu denemeyi yazan kişi == Burakuslendera//
// 5 dakika da yazip github 'a atmisimdir//
//Herneyse SEA OF THIEVES yüklenirken 5 dk da yaptım hepinize iyi oyunlar//