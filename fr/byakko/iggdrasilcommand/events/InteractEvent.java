/*    */ package fr.byakko.iggdrasilcommand.events;
/*    */ 
/*    */ import fr.byakko.iggdrasilcommand.IggDrasilCommand;
/*    */ import net.minecraft.server.v1_12_R1.ItemStack;
/*    */ import net.minecraft.server.v1_12_R1.NBTTagCompound;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Event;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class InteractEvent implements Listener {
/*    */   public InteractEvent(IggDrasilCommand iggDrasilCommand) {
/* 21 */     this.iggDrasilCommand = iggDrasilCommand;
/*    */   }
/*    */   private final IggDrasilCommand iggDrasilCommand;
/*    */   @EventHandler
/*    */   public void onInteract(PlayerInteractEvent event) {
/* 26 */     Player player = event.getPlayer();
/* 27 */     Action action = event.getAction();
/* 28 */     ItemStack itemStack = event.getItem();
/*    */     
/* 30 */     if (itemStack == null)
/*    */       return; 
/* 32 */     if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
/*    */       
/* 34 */       ItemStack stack = CraftItemStack.asNMSCopy(itemStack);
/* 35 */       NBTTagCompound tag = (stack.getTag() != null) ? stack.getTag() : new NBTTagCompound();
/*    */       
/* 37 */       if (tag.hasKey("iggdrasilcommande") && 
/* 38 */         tag.getString("iggdrasilcommande") != null) {
/* 39 */         String command = tag.getString("iggdrasilcommande");
/* 40 */         Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command.replaceAll("@p", player.getName()));
/* 41 */         player.sendMessage(ChatColor.GOLD + "La commande a été effectuée !");
/* 42 */         event.setUseInteractedBlock(Event.Result.DENY);
/* 43 */         event.setCancelled(true);
/* 44 */         this.iggDrasilCommand.removeItems(player, (Inventory)player.getInventory(), itemStack, 1);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Byakk\Desktop\iggdrasilcommande-1.0.jar!\fr\byakko\iggdrasilcommand\events\InteractEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */