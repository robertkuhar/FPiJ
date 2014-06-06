package ch04;

import java.util.List;

public class AssetUtil {
    public static int totalAssetValues( final List<Asset> assets ) {
        int totalAssetValues = assets.stream().mapToInt( asset -> asset.value ).sum();
        return totalAssetValues;
    }

    public static int totalAssetValues( final List<Asset> assets, final Asset.AssetType type ) {
        int totalAssetValues = assets.stream().filter( asset -> asset.type == type ).mapToInt( asset -> asset.value ).sum();
        return totalAssetValues;
    }
}
