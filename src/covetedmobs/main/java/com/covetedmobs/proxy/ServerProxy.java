package com.covetedmobs.proxy;

@SuppressWarnings({"unused"})
public class ServerProxy {
	public List<ItemStack> getEntireInventory(EntityPlayer player) {
		List<ItemStack> fin = new ArrayList<>();
		if (player != null) {
			for (int i = 0; i < BaublesApi.getBaublesHandler(player).getSlots(); i++) fin.add(BaublesApi.getBaublesHandler(player).getStackInSlot(i));
			fin.addAll(player.inventory.mainInventory);
			fin.addAll(player.inventory.armorInventory);
			fin.addAll(player.inventory.offHandInventory);
		}
		return fin;
	}
	
	public boolean doesPlayerHaveAdvancement(EntityPlayer player, ResourceLocation name) {
		if (player instanceof EntityPlayerMP) {
			Advancement advancement = ((EntityPlayerMP) player).getServerWorld().getAdvancementManager().getAdvancement(new ResourceLocation(CovetedMobs.MODID, "crafted_altar"));
			return advancement != null && ((EntityPlayerMP) player).getAdvancements().getProgress(advancement).isDone();
		}
		return false;
	}
	
	public boolean isFancyGraphicsEnabled() {
		return false;
	}
	
	public void registerRendersInit() {
	}
	
	public void registerRendersPreInit() {
	}
	
	public void registerTexture(Item item, String variant) {
	}
	
	public void registerTextureVariant(Item item, List<Predicate<ItemStack>> predicates) {
	}
	
	public void ignoreProperty(Block block, IProperty<?>... properties) {
	}
}