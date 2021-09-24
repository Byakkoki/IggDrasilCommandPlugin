/*    */ package fr.byakko.iggdrasilcommand;
/*    */ 
/*    */ import fr.byakko.iggdrasilcommand.commands.IggDrasilCommandeCommand;
/*    */ import fr.byakko.iggdrasilcommand.events.InteractEvent;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public final class IggDrasilCommand
/*    */   extends JavaPlugin
/*    */ {
/*    */   public void onEnable() {
/* 18 */     getCommand("iggdrasilcommande").setExecutor((CommandExecutor)new IggDrasilCommandeCommand(this));
/* 19 */     Bukkit.getPluginManager().registerEvents((Listener)new InteractEvent(this), (Plugin)this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onDisable() {}
/*    */ 
/*    */   
/*    */   public void removeItems(Player player, Inventory inventory, ItemStack item, int amount) {
/* 28 */     if (amount <= 0)
/* 29 */       return;  int size = inventory.getSize();
/* 30 */     for (int slot = 0; slot < size; slot++) {
/* 31 */       ItemStack is = inventory.getItem(slot);
/* 32 */       if (is != null) {
/* 33 */         if (item.isSimilar(is)) {
/* 34 */           int newAmount = is.getAmount() - amount;
/* 35 */           if (newAmount > 0) {
/* 36 */             is.setAmount(newAmount);
/*    */             break;
/*    */           } 
/* 39 */           inventory.clear(slot);
/* 40 */           amount = -newAmount;
/* 41 */           if (amount == 0)
/*    */             break; 
/*    */         } 
/* 44 */         player.updateInventory();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Byakk\Desktop\iggdrasilcommande-1.0.jar!\fr\byakko\iggdrasilcommand\IggDrasilCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */