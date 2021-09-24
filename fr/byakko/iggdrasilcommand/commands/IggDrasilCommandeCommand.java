/*    */ package fr.byakko.iggdrasilcommand.commands;
/*    */ 
/*    */ import fr.byakko.iggdrasilcommand.IggDrasilCommand;
/*    */ import net.minecraft.server.v1_12_R1.ItemStack;
/*    */ import net.minecraft.server.v1_12_R1.NBTTagCompound;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class IggDrasilCommandeCommand implements CommandExecutor {
/*    */   private IggDrasilCommand iggDrasilCommand;
/*    */   
/*    */   public IggDrasilCommandeCommand(IggDrasilCommand iggDrasilCommand) {
/* 19 */     this.iggDrasilCommand = iggDrasilCommand;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
/* 25 */     if (!(sender instanceof Player)) {
/* 26 */       sender.sendMessage(ChatColor.RED + "Seul un joueur peut executer cette commande !");
/* 27 */       return false;
/*    */     } 
/*    */     
/* 30 */     Player player = (Player)sender;
/*    */     
/* 32 */     if (args.length == 0) {
/* 33 */       player.sendMessage(ChatColor.RED + "Syntaxe: /iggdrasilcommande add <commande>");
/* 34 */       return false;
/*    */     } 
/*    */     
/* 37 */     if (!player.hasPermission("iggdrasilcommande.add")) {
/* 38 */       player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'executer cette commande !");
/* 39 */       return false;
/*    */     } 
/*    */     
/* 42 */     if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
/* 43 */       player.sendMessage(ChatColor.RED + "Vous devez avoir un objet dans votre main !");
/* 44 */       return false;
/*    */     } 
/*    */     
/* 47 */     StringBuilder cmd = new StringBuilder();
/* 48 */     for (String str : args) {
/* 49 */       cmd.append(str).append(" ");
/*    */     }
/*    */     
/* 52 */     String finalCmd = cmd.toString().replaceFirst(args[0] + " ", "");
/* 53 */     ItemStack itemStack = player.getInventory().getItemInMainHand();
/*    */     
/* 55 */     ItemStack stack = CraftItemStack.asNMSCopy(itemStack);
/* 56 */     NBTTagCompound tag = (stack.getTag() != null) ? stack.getTag() : new NBTTagCompound();
/* 57 */     tag.setString("iggdrasilcommande", finalCmd);
/* 58 */     stack.setTag(tag);
/*    */     
/* 60 */     CraftItemStack craftItemStack = CraftItemStack.asCraftMirror(stack);
/*    */     
/* 62 */     player.getInventory().setItem(player.getInventory().getHeldItemSlot(), (ItemStack)craftItemStack);
/*    */     
/* 64 */     player.sendMessage(ChatColor.YELLOW + "La commande /" + ChatColor.GOLD + finalCmd + ChatColor.YELLOW + "sera executée lorsque vous cliquerez sur cet item !");
/*    */     
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Byakk\Desktop\iggdrasilcommande-1.0.jar!\fr\byakko\iggdrasilcommand\commands\IggDrasilCommandeCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */