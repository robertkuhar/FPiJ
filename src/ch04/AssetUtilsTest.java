package ch04;

import static org.junit.Assert.*;
import static ch04.Asset.AssetType.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssetUtilsTest {

    @Test
    public void test() {
        final List<Asset> assets = Arrays.asList(
                new Asset( BOND, 10 ),
                new Asset( BOND, 20 ),
                new Asset( STOCK, 30 ),
                new Asset( STOCK, 40 ) );
        int sum = AssetUtil.totalAssetValues( assets );
        assertEquals( 100, sum );
    }
}
