package azzy.fabric.lumen;

import azzy.fabric.lumen.internal.cursed.CapacitorHashMap;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.math.BlockPos;

public class Lumen implements ModInitializer {
	@Override
	public void onInitialize() {
		CapacitorHashMap map = new CapacitorHashMap(3);
		map.get(new BlockPos(1, 1, 1));
	}
}
