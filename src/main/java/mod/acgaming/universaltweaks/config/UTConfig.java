package mod.acgaming.universaltweaks.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import mod.acgaming.universaltweaks.UniversalTweaks;
import mod.acgaming.universaltweaks.bugfixes.blockoverlay.UTBlockOverlayLists;
import mod.acgaming.universaltweaks.tweaks.UTLoadSound;
import mod.acgaming.universaltweaks.tweaks.swingthroughgrass.UTSwingThroughGrassLists;
import mod.acgaming.universaltweaks.util.UTObsoleteModsScreenHandler;

@Config(modid = UniversalTweaks.MODID, name = "UniversalTweaks")
public class UTConfig
{
    @Config.Name("Bugfixes")
    @Config.Comment("Bugfixes Category")
    public static BugfixesCategory bugfixes = new BugfixesCategory();

    @Config.Name("Debug")
    @Config.Comment("Debug Category")
    public static DebugCategory debug = new DebugCategory();

    @Config.Name("Mods")
    @Config.Comment("Mods Category")
    public static ModsCategory mods = new ModsCategory();

    @Config.Name("Tweaks")
    @Config.Comment("Tweaks Category")
    public static TweaksCategory tweaks = new TweaksCategory();

    public static class BugfixesCategory
    {
        @Config.Name("Block Fire Fix")
        @Config.Comment("Prevents fire projectiles burning entities when blocking with shields")
        public boolean utBlockFireToggle = true;

        @Config.Name("Block Overlay Fix")
        @Config.Comment("Fixes x-ray when standing in non-suffocating blocks")
        public boolean utBlockOverlayToggle = true;

        @Config.Name("Block Overlay Fix Blacklist")
        @Config.Comment
            ({
                "Excludes blocks from the block overlay fix",
                "Syntax: modid:block"
            })
        public String[] utBlockOverlayBlacklist = new String[] {};

        @Config.Name("Block Overlay Fix Whitelist")
        @Config.Comment
            ({
                "Includes blocks in the block overlay fix",
                "Syntax: modid:block"
            })
        public String[] utBlockOverlayWhitelist = new String[] {};

        @Config.Name("Boat Riding Offset Fix")
        @Config.Comment("Fixes entities glitching through the bottom of boats")
        public boolean utBoatOffsetToggle = true;

        @Config.Name("Comparator Timing Fix")
        @Config.Comment("Fixes inconsistent delays of comparators to prevent redstone timing issues")
        public boolean utComparatorTimingToggle = true;

        @Config.Name("Death Time Fix")
        @Config.Comment("Fixes corrupted entities exceeding the allowed death time")
        public boolean utDeathTimeToggle = true;

        @Config.Name("Destroy Entity Packets Fix")
        @Config.Comment("Fixes lag caused by dead entities by sending additional packets when the player is not alive")
        public boolean utDestroyPacketToggle = true;

        @Config.Name("Disconnect Dupe Fix")
        @Config.Comment("Fixes item dupes when players are dropping items and disconnecting")
        public boolean utDisconnectDupeToggle = true;

        @Config.Name("Hopper Bounding Box Fix")
        @Config.Comment("Slims down the hopper bounding box for easier access of nearby blocks")
        public boolean utDietHopperToggle = true;

        @Config.Name("Dimension Change Player States Fix")
        @Config.Comment("Fixes missing player states when changing dimensions by sending additional packets")
        public boolean utDimensionChangeToggle = true;

        @Config.Name("Entity Bounding Box Fix")
        @Config.Comment("Saves entity bounding boxes to tags to prevent breakouts and suffocation")
        public boolean utEntityAABBToggle = true;

        @Config.Name("Entity Desync Fix")
        @Config.Comment("Fixes entity motion desyncs most notable with arrows and thrown items")
        public boolean utEntityDesyncToggle = true;

        @Config.Name("Entity NaN Fix")
        @Config.Comment("Prevents corruption of entities caused by invalid health or damage values")
        public boolean utEntityNaNToggle = true;

        @Config.Name("Entity Suffocation Fix")
        @Config.Comment("Pushes entities out of blocks when growing up to prevent suffocation")
        public boolean utEntitySuffocationToggle = true;

        @Config.Name("Entity Tracker Fix")
        @Config.Comment("Fixes entity tracker to prevent client-sided desyncs when teleporting or changing dimensions")
        public boolean utEntityTrackerToggle = true;

        @Config.Name("Entity UUID Fix")
        @Config.Comment("Changes UUIDs of loaded entities in case their UUIDs are already assigned (and removes log spam)")
        public boolean utEntityUUIDToggle = true;

        @Config.Name("Exhaustion Fix")
        @Config.Comment("Fixes saturation depleting in peaceful mode")
        public boolean utExhaustionToggle = true;

        @Config.Name("Faster Background Startup")
        @Config.Comment("Fixes slow background startup edge case caused by checking tooltips during the loading process")
        public boolean utFasterBackgroundStartupToggle = true;

        @Config.Name("Frustum Culling Fix")
        @Config.Comment("Fixes invisible chunks in edge cases (small enclosed rooms at chunk borders)")
        public boolean utFrustumCullingToggle = true;

        //@Config.Name("Hash Code Fix")
        //@Config.Comment("Reduces CPU overhead caused by incorrect hash code")
        //public boolean utHashCodeToggle = true;

        @Config.Name("Help Fix")
        @Config.Comment("Replaces the help command, sorts and reports broken commands")
        public boolean utHelpToggle = true;

        @Config.Name("Item Frame Void Fix")
        @Config.Comment("Prevents voiding held items when right + left clicking on an item frame simultaneously")
        public boolean utItemFrameVoidToggle = true;

        @Config.Name("Ladder Flying Slowdown Fix")
        @Config.Comment("Disables climbing movement when flying")
        public boolean utLadderFlyingToggle = true;

        @Config.Name("Locale Fix")
        @Config.Comment("Prevents various crashes with Turkish locale")
        public boolean utLocaleToggle = true;

        @Config.Name("Max Health Fix")
        @Config.Comment("Saves increased player health to tags")
        public boolean utMaxHealthToggle = true;

        @Config.Name("Mining Glitch Fix")
        @Config.Comment("Avoids the need for multiple mining attempts by sending additional movement packets")
        public boolean utMiningGlitchToggle = true;

        @Config.Name("Piston Progress Fix")
        @Config.Comment("Properly saves the last state of pistons to tags")
        public boolean utPistonTileToggle = true;

        @Config.Name("Skeleton Aim Fix")
        @Config.Comment("Fixes skeletons not looking at their targets when strafing")
        public boolean utSkeletonAimToggle = true;

        @Config.Name("Tile Entity Update Order Fix")
        @Config.Comment("Keeps the order of tile entities on chunk load")
        public boolean utTELoadOrderToggle = true;

        @Config.Name("Villager Mantle Fix")
        @Config.Comment("Returns missing hoods to villager mantles")
        public boolean utVillagerMantleToggle = true;
    }

    public static class DebugCategory
    {
        @Config.Name("Debug Logging")
        @Config.Comment("Enables debug logging")
        public boolean utDebugToggle = false;

        @Config.Name("Obsolete Mods Screen")
        @Config.Comment("Enables a screen displaying incompatible mods on game load")
        public boolean utObsoleteModsToggle = true;

        @Config.Name("Bypass Incompatibility Warnings")
        @Config.Comment("For those who live life on the edge, may or may not include Jons")
        public boolean utBypassIncompatibilityToggle = false;

        @Config.Name("Show Loading Time")
        @Config.Comment("Prints the time the game needed to launch to the log")
        public boolean utLoadingTimeToggle = true;
    }

    public static class ModsCategory
    {
        @Config.Name("[Biomes O' Plenty] Hot Spring Water")
        @Config.Comment("Fixes rapid inflection of regeneration effects in hot spring water")
        public boolean utBoPHotSpringWaterToggle = true;

        @Config.Name("[Epic Siege Mod] Disable Digger AI Debug")
        @Config.Comment("Disables leftover debug logging inside the digger AI of the beta builds")
        public boolean utESMDiggerDebugToggle = true;

        @Config.Name("[Storage Drawers] Render Range")
        @Config.Comment
            ({
                "Approximate range in blocks at which drawers render contained items",
                "0 for default unlimited range"
            })
        public int utSDRenderRange = 0;

        @Config.Name("[Thaumcraft] Firebat Particles")
        @Config.Comment("Adds particles to firebats similar to legacy versions")
        public boolean utTCFirebatParticlesToggle = true;

        @Config.Name("[Thaumcraft] Stable Thaumometer")
        @Config.Comment("Stops the thaumometer from bobbing rapidly when using it to scan objects")
        public boolean utTCStableThaumometerToggle = true;

        @Config.Name("[Thaumcraft] Wisp Particles")
        @Config.Comment("Increases particle size of wisps similar to legacy versions")
        public boolean utTCWispParticlesToggle = true;

        @Config.Name("[Tinkers' Construct] Gaseous Fluids")
        @Config.Comment("Excludes gaseous fluids from being transferable via faucets")
        public boolean utTConGaseousFluidsToggle = false;

        @Config.Name("[Tinkers' Construct] Projectile Despawning")
        @Config.Comment("Despawns unbreakable projectiles faster to improve framerates")
        public boolean utTConProjectileToggle = true;

        @Config.Name("[Tinkers' Construct] Offhand Shuriken")
        @Config.Comment("Suppresses special abilities of long swords and rapiers when shurikens are wielded in the offhand")
        public boolean utTConShurikenToggle = true;

        @Config.Name("[Mo' Creatures] Custom Modded Biomes")
        @Config.Comment
            ({
                "Adds support for modded biome spawns",
                "Syntax: modid;name;key;tag;filename",
                "modid    Mod ID required for this to be added",
                "name     Mod name",
                "key      Used for class lookups, needs to be a unique part of the modded package, e.g. mod.acgaming.*universaltweaks*.mods",
                "tag      Short tag for logs",
                "filename Filename to use for the generated config"
            })
        public String[] utMoCBiomeMods = new String[]
            {
                "pvj;vibrantjourneys;vibrantjourneys;PVJ;ProjectVibrantJourneys.cfg",
                "traverse;traverse;traverse;TRAV;Traverse.cfg",
                "dimdoors;dimdoors;dimdoors;DD;DimDoors.cfg"
            };
    }

    public static class TweaksCategory
    {
        @Config.Name("AI Replacement")
        @Config.Comment("Replaces entity AI for improved server performance")
        public boolean utAIReplacementToggle = true;

        @Config.Name("AI Removal")
        @Config.Comment("Removes entity AI for improved server performance")
        public boolean utAIRemovalToggle = false;

        @Config.Name("Attributes Uncap")
        @Config.Comment("Virtually uncaps entity attributes")
        public boolean utAttributesToggle = true;

        @Config.Name("Auto Jump Replacement")
        @Config.Comment("Replaces auto jump with an increased step height")
        public boolean utAutoJumpToggle = true;

        @Config.Name("Auto Switch Tools")
        @Config.Comment("Switches the selected hotbar slot to a proper tool if required")
        public boolean utAutoSwitchToggle = false;

        @Config.Name("No Attack Cooldown")
        @Config.Comment("Disables the 1.9 combat update attack cooldown")
        public boolean utAttackCooldownToggle = false;

        @Config.Name("Bed Obstruction Replacement")
        @Config.Comment("Replaces bed obstruction checks with an improved version")
        public boolean utBedObstructionToggle = true;

        @Config.Name("Better Burning: Cooked Items")
        @Config.Comment("Fixes some edge cases where fire damage sources won't cause mobs to drop their cooked items")
        public boolean utBBCookedToggle = true;

        @Config.Name("Better Burning: Flaming Arrows")
        @Config.Comment("Allows skeletons to shoot flaming arrows when on fire (30% chance * regional difficulty")
        public boolean utBBArrowsToggle = true;

        @Config.Name("Better Burning: Extinguishing")
        @Config.Comment("If entities have fire resistance, they get extinguished right away when on fire")
        public boolean utBBExtinguishToggle = true;

        @Config.Name("Better Burning: Spreading Fire")
        @Config.Comment("Allows fire to spread from entity to entity (30% chance * regional difficulty)")
        public boolean utBBSpreadingToggle = true;

        @Config.Name("Better Burning: Fire Overlay")
        @Config.Comment("Prevents the fire animation overlay from being displayed when the player is immune to fire")
        public boolean utBBOverlayToggle = true;

        @Config.Name("Better Harvest")
        @Config.Comment("Prevents breaking lower parts of sugar cane and cacti as well as unripe crops, unless sneaking")
        public boolean utBetterHarvestToggle = false;

        @Config.Name("Better Ignition")
        @Config.Comment("Enables ignition of entities by right-clicking instead of awkwardly lighting the block under them")
        public boolean utBetterIgnitionToggle = true;

        @Config.Name("Bow Infinity Remedy")
        @Config.Comment("Bows enchanted with Infinity no longer require arrows")
        public boolean utBowInfinityToggle = true;

        @Config.Name("Block Placement Click Delay")
        @Config.Comment("Sets the delay in ticks between placing blocks")
        public int utBPClickDelay = 4;

        @Config.Name("Cactus Size")
        @Config.Comment("Determines how tall cacti can grow")
        public int utCactusSize = 3;

        @Config.Name("Chunk Gen Limit")
        @Config.Comment("Limits maximum chunk generation per tick for improved server performance")
        public boolean utChunkGenLimitToggle = false;

        @Config.Name("Chunk Gen Limit Ticks")
        @Config.Comment("Maximum chunks to generate per tick per dimension")
        public int utChunkGenLimitTicks = 2;

        @Config.Name("Chunk Gen Limit Time")
        @Config.Comment("Maximum time in ms to spend generating chunks per tick per dimension")
        public int utChunkGenLimitTime = 5;

        @Config.Name("[Experimental] Crafting Cache")
        @Config.Comment("Adds an IRecipe cache to improve recipe performance in large modpacks")
        public boolean utCraftingCacheToggle = false;

        @Config.Name("Creeper Confetti")
        @Config.Comment("Replaces deadly creeper explosions with delightful confetti")
        public boolean utCreeperConfettiToggle = false;

        @Config.Name("Damage Tilt")
        @Config.Comment("Restores feature to tilt the camera when damaged")
        public boolean utDamageTiltToggle = true;

        @Config.Name("Dimension Unload")
        @Config.Comment("Unloads dimensions not in use to free up resources")
        public boolean utUnloaderToggle = true;

        @Config.Name("Dimension Unload Interval")
        @Config.Comment("Time (in ticks) to wait before checking dimensions")
        public int utUnloaderInterval = 600;

        @Config.Name("Dimension Unload Blacklist")
        @Config.Comment
            ({
                "List of dimensions which should not be unloaded",
                "Can be dimension name or ID", "Uses regular expressions"
            })
        public String[] utUnloaderBlacklist = new String[]
            {
                "0",
                "overworld"
            };

        @Config.Name("Disable Animated Models")
        @Config.Comment("Improves model load times by removing Forge's animated models")
        public boolean utDisableAnimatedModelsToggle = false;

        @Config.Name("Disable Audio Debug")
        @Config.Comment("Improves loading times by removing debug code for missing sounds and subtitles")
        public boolean utDisableAudioDebugToggle = true;

        @Config.Name("Easy Breeding")
        @Config.Comment("Enables easy breeding of animals by tossing food on the ground")
        public boolean utEasyBreedingToggle = false;

        @Config.Name("Easy Breeding Search Distance")
        @Config.Comment("Determines the distance for animals to search for food")
        public double utEasyBreedingDistance = 10;

        @Config.Name("Fast Dye Blending")
        @Config.Comment("Replaces color lookup for sheep to check a predefined table rather than querying the recipe registry")
        public boolean utDyeBlendingToggle = true;

        @Config.Name("Fast Leaf Decay")
        @Config.Comment("Makes leaves decay faster when trees are chopped")
        public boolean utLeafDecayToggle = true;

        @Config.Name("Fast Prefix Checking")
        @Config.Comment("Optimizes Forge's ID prefix checking and removes prefix warnings impacting load time")
        public boolean utPrefixCheckToggle = true;

        @Config.Name("Fence/Wall Jump")
        @Config.Comment("Allows the player to jump over fences and walls")
        public boolean utFenceWallJumpToggle = true;

        @Config.Name("Finite Water")
        @Config.Comment("Prevents creation of infinite water sources outside of ocean and river biomes")
        public boolean utFiniteWaterToggle = false;

        @Config.Name("Hardcore Buckets")
        @Config.Comment("Prevents placing of liquid source blocks in the world")
        public boolean utHardcoreBucketsToggle = false;

        @Config.Name("Horizontal Collision Damage")
        @Config.Comment("Applies horizontal collision damage to the player akin to elytra collision")
        public boolean utCollisionDamageToggle = false;

        @Config.Name("Horizontal Collision Damage Factor")
        @Config.Comment
            ({
                "The damage factor that gets multiplied with the player speed",
                "Vanilla default for elytra damage is 10"
            })
        public int utCollisionDamageFactor = 10;

        @Config.Name("Husk & Stray Spawning")
        @Config.Comment("Lets husks and strays spawn underground like regular zombies and skeletons")
        public boolean utHuskStraySpawningToggle = true;

        @Config.Name("Infinite Music")
        @Config.Comment("Lets background music play continuously without delays")
        public boolean utInfiniteMusicToggle = false;

        @Config.Name("Item Entity Combination")
        @Config.Comment("Stops combination of item entities if their maximum stack size is reached")
        public boolean utCombineItemEntityToggle = true;

        @Config.Name("Linear XP Amount")
        @Config.Comment
            ({
                "Sets the amount of XP needed for each level, effectively removing the increasing level scaling",
                "0 for vanilla default"
            })
        public int utLinearXP = 0;

        @Config.Name("Load Sounds Mode")
        @Config.RangeInt(min = 0, max = 3)
        @Config.Comment
            ({
                "Play sound on...",
                "0 = Nothing",
                "1 = Minecraft load",
                "2 = World load",
                "3 = Minecraft and world load"
            })
        public int utLoadSoundMode = 0;

        @Config.Name("Load Sounds Minecraft")
        @Config.Comment({"Sounds to play when Minecraft is loaded", "Syntax: eventname;pitch"})
        public String[] utLoadSoundMC = new String[]
            {
                "entity.experience_orb.pickup;1.0",
                "entity.player.levelup;1.0"
            };

        @Config.Name("Load Sounds World")
        @Config.Comment({"Sounds to play when the world is loaded", "Syntax: eventname;pitch"})
        public String[] utLoadSoundWorld = new String[]
            {
                "entity.experience_orb.pickup;1.0",
                "entity.player.levelup;1.0"
            };

        @Config.Name("Mending Fix")
        @Config.Comment("Only repairs damaged equipment with XP")
        public boolean utMendingToggle = true;

        @Config.Name("Mending Fix Ratio")
        @Config.Comment("Determines the amount of durability mending will repair, on average, per point of experience")
        public float utMendingRatio = 2.0F;

        @Config.Name("Mending Fix Overpowered")
        @Config.Comment("If mending fix is enabled, repairs entire damaged inventory with XP")
        public boolean utMendingOPToggle = false;

        @Config.Name("Mob Despawn Improvement")
        @Config.Comment("Mobs carrying picked up items will drop their equipment and despawn properly")
        public boolean utMobDespawnToggle = true;

        @Config.Name("No Lightning Flash")
        @Config.Comment("Disables the flashing of skybox and ground brightness on lightning strikes")
        public boolean utLightningFlashToggle = false;

        @Config.Name("No Night Vision Flash")
        @Config.Comment("Disables the flashing effect when the night vision potion effect is about to run out")
        public boolean utNightVisionFlashToggle = false;

        @Config.Name("No Potion Shift")
        @Config.Comment("Disables the inventory shift when potion effects are active")
        public boolean utPotionShiftToggle = true;

        @Config.Name("No Redstone Lighting")
        @Config.Comment("Disables lighting of active redstone, repeaters, and comparators to improve performance")
        public boolean utRedstoneLightingToggle = false;

        @Config.Name("No Saddled Wandering")
        @Config.Comment("Stops horses wandering around when saddled")
        public boolean utSaddledWanderingToggle = true;

        @Config.Name("Offhand Improvement")
        @Config.Comment("Prevents placing offhand blocks when blocks or food are held in the mainhand")
        public boolean utOffhandToggle = true;

        @Config.Name("Player Fly Speed")
        @Config.Comment("Determines the player's base fly speed")
        public double utPlayerFlySpeed = 0.05;

        @Config.Name("Player Walk Speed")
        @Config.Comment("Determines the player's base walk speed")
        public double utPlayerWalkSpeed = 0.1;

        @Config.Name("Remove Realms Button")
        @Config.Comment("Removes the redundant Minecraft Realms button from the main menu")
        public boolean utRealmsButtonToggle = true;

        @Config.Name("Remove Recipe Book")
        @Config.Comment("Removes the recipe book button from GUIs")
        public boolean utRecipeBookToggle = false;

        @Config.Name("Skip Credits")
        @Config.Comment("Skips the credits screen after the player goes through the end podium portal")
        public boolean utSkipCreditsToggle = false;

        @Config.Name("Smooth Scrolling")
        @Config.Comment("Adds smooth scrolling to every in-game list")
        public boolean utSmoothScrollingToggle = true;

        @Config.Name("Smooth Scrolling Bounce Back Multiplier")
        public double utSmoothScrollingBounce = 0.24;

        @Config.Name("Smooth Scrolling Scroll Duration")
        public int utSmoothScrollingDuration = 600;

        @Config.Name("Smooth Scrolling Scroll Step")
        public double utSmoothScrollingStep = 19.0;

        @Config.Name("Stronghold Replacement")
        @Config.Comment("Replaces stronghold generation with a safer variant")
        public boolean utStrongholdToggle = true;

        @Config.Name("Sugar Cane Size")
        @Config.Comment("Determines how tall sugar cane can grow")
        public int utSugarCaneSize = 3;

        @Config.Name("Super Hot Torch")
        @Config.Comment("Enables one-time ignition of entities by hitting them with a torch")
        public boolean utSuperHotTorchToggle = false;

        @Config.Name("Swing Through Grass")
        @Config.Comment("Allows hitting entities through grass instead of breaking it")
        public boolean utSwingThroughGrassToggle = true;

        @Config.Name("Swing Through Grass Blacklist")
        @Config.Comment
            ({
                "Excludes blocks from the swing through grass tweak",
                "Syntax: modid:block"
            })
        public String[] utSwingThroughGrassBlacklist = new String[] {};

        @Config.Name("Swing Through Grass Whitelist")
        @Config.Comment
            ({
                "Includes blocks in the swing through grass tweak",
                "Syntax: modid:block"
            })
        public String[] utSwingThroughGrassWhitelist = new String[] {};

        @Config.Name("Tidy Chunk")
        @Config.Comment("Tidies newly generated chunks by removing scattered item entities")
        public boolean utTidyChunkToggle = false;

        @Config.Name("Toggle Cheats Button")
        @Config.Comment("Adds a button to the pause menu to toggle cheats")
        public boolean utToggleCheatsToggle = true;

        @Config.Name("Uncap FPS")
        @Config.Comment("Removes the hardcoded 30 FPS limit in screens like the main menu")
        public boolean utUncapFPSToggle = true;

        @Config.Name("Water Fall Damage")
        @Config.Comment("Re-implements an improved version of pre-1.4 fall damage in water")
        public boolean utFallDamageToggle = false;

        @Config.Name("Water Fall Damage Reduction")
        @Config.Comment("How much fall damage gets reduced by water per tick")
        public float utFallDamageValue = 2.0F;

        @Config.Name("XP Bottle Amount")
        @Config.Comment
            ({
                "Sets the amount of experience spawned by bottles o' enchanting",
                "-1 for vanilla default"
            })
        public int utXPBottleAmount = -1;
    }

    @Mod.EventBusSubscriber(modid = UniversalTweaks.MODID)
    public static class EventHandler
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if (event.getModID().equals(UniversalTweaks.MODID))
            {
                ConfigManager.sync(UniversalTweaks.MODID, Config.Type.INSTANCE);
                if (bugfixes.utBlockOverlayToggle) UTBlockOverlayLists.initLists();
                if (tweaks.utSwingThroughGrassToggle) UTSwingThroughGrassLists.initLists();
                if (tweaks.utLoadSoundMode != 0) UTLoadSound.initLists();
                UTObsoleteModsScreenHandler.shouldDisplay = true;
                UniversalTweaks.LOGGER.info("Universal Tweaks config reloaded");
            }
        }
    }
}