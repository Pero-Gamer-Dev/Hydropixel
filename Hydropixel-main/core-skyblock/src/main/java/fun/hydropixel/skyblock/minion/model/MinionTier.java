package fun.hydropixel.skyblock.minion.model;

public record MinionTier(int tier, int actionDelaySeconds, int storageSlots) {
    public int maxStorage() {
        return storageSlots * 64;
    }
}
