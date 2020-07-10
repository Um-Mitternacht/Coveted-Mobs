package com.covetedmobs;

//R DZH SVIV
//HFMXLMFIV11
//HKRMLHZFIFH111
//MLGOVTZOGVMWVI
//OVHLERPP
//WZGFIZ
//GSILFTS GSVHV ORMVH R WL WVXIVV
//GSZG YB NVIVOB KFGGRMT NB MZNV RM
//NB RMUOFVMXV TILDH, ZMW GSFH, R YVXLNV RNNLIGZO
//XBYVIMVGRX DVY


//GL HLNV, R ZN YFG Z HSZWV
//YFG SVIV, R VCVIG KLDVI LEVI GSVN
//R NZWV Z XZHGOV SVIV LM GSRH SROO
//ZMW SZEV KFG NB UOZT RM GSV TILFMW
//GSRH RH NB MVD DLIOW


//HSLFOW GSV GIVHKZHHVIH LU GSV LOW DLIOW
//ZIIREV SVIV, YVZIRMT SLHGRORGRVH
//GSVB DROO YV NVG DRGS DIZGS

import com.covetedmobs.client.handler.ClientHandler;
import com.covetedmobs.common.handler.GuiHandler;
import com.covetedmobs.proxy.ServerProxy;
import com.covetedmobs.registry.ModObjects;
import com.covetedmobs.registry.ModRecipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"ConstantConditions", "unused", "WeakerAccess"})
@Mod(modid = CovetedMobs.MODID, name = CovetedMobs.NAME, version = CovetedMobs.VERSION, guiFactory = CovetedMobs.GUI_FACTORY)
public class CovetedMobs {

    public static final String MODID = "covetedmobs", NAME = "Coveted Mobs", VERSION = "0.0.12", GUI_FACTORY = "com.covetedmobs.client.gui.GuiFactory";
    public static final CreativeTabs tab = new CreativeTabs(CovetedMobs.MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModObjects.elephant_skull);
        }
    };
    public static final Logger logger = LogManager.getLogger(NAME);
    @SidedProxy(serverSide = "com.covetedmobs.proxy.ServerProxy", clientSide = "com.covetedmobs.proxy.ClientProxy")
    public static ServerProxy proxy;
    @Mod.Instance
    public static CovetedMobs instance;
    public static SimpleNetworkWrapper network = new SimpleNetworkWrapper(MODID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("We need another and a wiser and perhaps a more mystical concept of animals.");
        logger.info("Remote from universal nature, and living by complicated artifice, man in civilization surveys the creature through the glass of his knowledge and sees thereby a feather magnified and the whole image in distortion.");
        logger.info("We patronize them for their incompleteness, for their tragic fate of having taken form so far below ourselves.");
        logger.info("And therein we err, and greatly err.");
        logger.info("For the animal shall not be measured by man.");
        logger.info("In a world older and more complete than ours they moved finished and complete, gifted with extensions of the senses we have lost or never attained, living by voices we shall never hear.");
        logger.info("They are not brethren, they are not underlings; they are other nations, caught with ourselves in the net of life and time, fellow prisoners of the splendour and travail of the earth.");

        proxy.registerRendersPreInit();
        NetworkRegistry.INSTANCE.registerGuiHandler(CovetedMobs.instance, new GuiHandler());
        if (FMLCommonHandler.instance().getSide().isClient()) MinecraftForge.EVENT_BUS.register(new ClientHandler());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRendersInit();
        int id = -1;
        ModRecipes.init();
    }
}