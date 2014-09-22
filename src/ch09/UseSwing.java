/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package ch09;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class UseSwing {
    public static void main( String[] args ) {
        final JFrame frame = new JFrame();
        final JButton button = new JButton( "click me" );
        frame.getContentPane()
                .add( button );

        frame.setSize( 400, 300 );
        frame.setVisible( true );

        button.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event ) {
                JOptionPane.showMessageDialog( frame, "you clicked!" );
            }
        } );

        button.addActionListener( event -> JOptionPane.showMessageDialog( frame, "you clicked!" ) );
    }
}
