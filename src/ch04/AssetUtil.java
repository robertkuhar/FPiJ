package ch04;

import java.util.List;

public class AssetUtil {
    public static int totalAssetValues( final List<Asset> assets ) {
        int totalAssetValues = assets.stream().mapToInt( asset -> asset.value ).sum();
        return totalAssetValues;
    }
}
