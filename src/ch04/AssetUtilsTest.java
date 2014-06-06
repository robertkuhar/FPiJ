package ch04;

import static ch04.Asset.AssetType.BOND;
import static ch04.Asset.AssetType.STOCK;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssetUtilsTest {

    @Test
    public void totalAssetValues() {
        final List<Asset> assets = Arrays.asList(
                new Asset( BOND, 10 ),
                new Asset( BOND, 20 ),
                new Asset( STOCK, 30 ),
                new Asset( STOCK, 40 ) );
        int sum = AssetUtil.totalAssetValues( assets );
        assertEquals( 100, sum );

        int sumBonds = AssetUtil.totalAssetValues( assets, BOND );
        assertEquals( 30, sumBonds );

        int sumStocks = AssetUtil.totalAssetValues( assets, STOCK );
        assertEquals( 70, sumStocks );
    }

    @Test
    public void lambdasBaby() {
        final List<Asset> assets = new ArrayList<Asset>();
        for ( int i = 0; i < 10; i++ ) {
            Asset asset = new Asset( ( i % 2 == 0 ) ? STOCK : BOND, i + 1 );
            assets.add( asset );
        }
        int sumOfStockAssetsLessThanFive = AssetUtil.totalAssetValues( assets, asset -> asset.type == STOCK && asset.value < 5 );
        assertEquals( 4, sumOfStockAssetsLessThanFive );
    }
}
