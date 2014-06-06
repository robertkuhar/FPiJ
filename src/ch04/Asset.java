package ch04;

public class Asset {
    public enum AssetType {
        BOND, STOCK
    };

    public final AssetType type;
    public final int value;

    public Asset( AssetType type, int value ) {
        this.type = type;
        this.value = value;
    }
}
