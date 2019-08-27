package vazkii.quark.base.world.config;

import net.minecraft.world.World;
import vazkii.quark.base.module.Config;
import vazkii.quark.base.module.IConfigType;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DimensionConfig implements IConfigType {

	@Config
	private boolean isBlacklist;
	@Config
	private List<String> dimensions;

	public DimensionConfig(boolean blacklist, String... dims) {
		isBlacklist = blacklist;

		dimensions = new LinkedList<>();
		Collections.addAll(dimensions, dims);
	}

	public static DimensionConfig overworld(boolean blacklist) {
		return new DimensionConfig(blacklist, "minecraft:overworld");
	}

	public static DimensionConfig nether(boolean blacklist) {
		return new DimensionConfig(blacklist, "minecraft:the_nether");
	}

	public static DimensionConfig end(boolean blacklist) {
		return new DimensionConfig(blacklist, "minecraft:the_end");
	}

	public static DimensionConfig all() {
		return new DimensionConfig(true);
	}

	public boolean canSpawnHere(World world) {
		if (world == null)
			return false;

		return dimensions.contains(world.getDimension().getType().getRegistryName().toString()) != isBlacklist;
	}

}
