package ch04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class CalculateNAVTest {
    @Test
    public void computeStockWorth() {
        final CalculateNAV calculateNAV = new CalculateNAV( ticker -> new BigDecimal( "6.01" ) );
        BigDecimal expected = new BigDecimal( "6010.00" );
        assertEquals( 0, calculateNAV.computeStockWorth( "GOOG", 1000 ).compareTo( expected ), 0.001 );
    }

    @Test
    public void yahooFinanceIntegrationTest() {
        final CalculateNAV calculateNav = new CalculateNAV( YahooFinance::getPrice );
        BigDecimal oneGOOGShare = calculateNav.computeStockWorth( "GOOG", 1 );
        assertNotNull( oneGOOGShare );
        BigDecimal zero = new BigDecimal( 0 );
        assertTrue( oneGOOGShare.compareTo( zero ) >= 0 );

        // This is a crappy test, what if it changes between oneGOOGShare calc
        // and now?
        BigDecimal expectedTenGOOGShares = oneGOOGShare.multiply( new BigDecimal( 10 ) );
        BigDecimal actualTenGOOGShares = calculateNav.computeStockWorth( "GOOG", 10 );
        assertEquals( expectedTenGOOGShares, actualTenGOOGShares );
    }
}
