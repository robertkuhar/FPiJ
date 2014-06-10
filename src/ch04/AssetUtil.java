/***
 * Excerpted from "Functional Programming in Java", published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch04;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtil {
    public static int totalAssetValues( final List<Asset> assets ) {
        return totalAssetValues( assets, asset -> true );
    }

    public static int totalAssetValues( final List<Asset> assets, final Asset.AssetType type ) {
        return totalAssetValues( assets, asset -> asset.type == type );
    }

    public static int totalAssetValues( final List<Asset> assets, final Predicate<Asset> assetSelector ) {
        int totalAssetValues = assets.stream()
                .filter( assetSelector )
                .mapToInt( asset -> asset.value )
                .sum();
        return totalAssetValues;
    }
}
