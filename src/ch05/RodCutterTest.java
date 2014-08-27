package ch05;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static ch05.TestHelper.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RodCutterTest {
    private RodCutter rodCutter;
    private List<Integer> prices;

    protected RodCutter createCutter() {
        return new RodCutter( false );
    }

    @Before
    public void initialize() {
        rodCutter = createCutter();
        prices = Arrays.asList( 1, 1, 2, 2, 3, 4, 5 );
    }

    // Verbose, yet specific
    @Test
    public void VerboseExceptionTest() {
        rodCutter.setPrices( prices );
        try {
            rodCutter.maxProfit( 0 );
            fail( "Expected exception for zero length" );
        } catch ( RodCutterException ex ) {
            assertTrue( "expected", true );
        }
    }

    // Its terse and not really accurate. Did maxProfit fail or something else?
    @Test( expected = RodCutterException.class )
    public void TerseExceptionTest() {
        rodCutter.setPrices( prices );
        rodCutter.maxProfit( 0 );
    }

    // I love this!
    @Test
    public void ConciseExTest() {
        rodCutter.setPrices( prices );
        Runnable r = ( ) -> rodCutter.maxProfit( 0 );
        assertThrows( RodCutterException.class, r );
    }

    @Test
    public void ConciseExTestFast() {
        rodCutter.setPrices( prices );
        Runnable r = new Runnable() {
            @Override
            public void run() {
                rodCutter.maxProfit( 0 );
            }
        };
        assertThrows( RodCutterException.class, r );
    }
}
