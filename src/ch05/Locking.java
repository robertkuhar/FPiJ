/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch05;

import static ch05.Locker.runLocked;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {
    Lock lock = new ReentrantLock(); // or mock

    protected void setLock( final Lock mock ) {
        lock = mock;
    }

    public void doOp1() {
        lock.lock();
        try {
            // ...critical code...
        } finally {
            lock.unlock();
        }
    }

    public void doOp2() {
        runLocked( lock, ( ) -> {
            /* ...critical code ... */
        } );
    }

    public void doOp3() {
        runLocked( lock, ( ) -> {
            /* ...critical code ... */
        } );
    }

    public void doOp4() {
        runLocked( lock, ( ) -> {
            /* ...critical code ... */
        } );
    }

}
