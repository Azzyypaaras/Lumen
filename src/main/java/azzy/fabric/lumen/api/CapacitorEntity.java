package azzy.fabric.lumen.api;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;

public abstract class CapacitorEntity extends BlockEntity implements Capacitor, BlockEntityClientSerializable {

    protected long lumenEnergy;
    protected long maxLumenEnergy;
    private final Int2ObjectMap<Capacitor> cachedCapacitors = new Int2ObjectArrayMap<>(4);

    public CapacitorEntity(BlockEntityType<?> type, long maxLumenEnergy) {
        super(type);
        this.maxLumenEnergy = maxLumenEnergy;
    }

    @Override
    public long getLumenEnergy() {
        return lumenEnergy;
    }

    @Override
    public boolean acceptsLumenEnergy() {
        return lumenEnergy < maxLumenEnergy || maxLumenEnergy < 0;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag.putLong("lumenEnergy", lumenEnergy);
        return super.toTag(tag);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        lumenEnergy = tag.getLong("lumenEnergy");
    }

    @Override
    public CompoundTag toClientTag(CompoundTag compoundTag) {
        compoundTag.putLong("lumenEnergy", lumenEnergy);
        return compoundTag;
    }

    @Override
    public void fromClientTag(CompoundTag compoundTag) {
        lumenEnergy = compoundTag.getLong("lumenEnergy");
    }
}
