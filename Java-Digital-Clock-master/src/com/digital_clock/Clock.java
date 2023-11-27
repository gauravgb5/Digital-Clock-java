package com.digital_clock;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Clock extends JFrame{
	
	private JLabel clockLabel;	
	private Font clockFont=new Font("",Font.BOLD,35);
	
	public Clock() {

		super.setTitle("Java Digital Clock");
		super.setBounds(850, 450,300,150);
		
		this.clockGUI();
		this.clockCode();
		super.setVisible(true);
	}
	
	public void clockGUI() {
		
		clockLabel=new JLabel ("Time will be display here");
		
		clockLabel.setFont(clockFont);
		
		this.setLayout(new GridLayout(1,1));
		this.add(clockLabel);
		
	}
	
	public void clockCode() {		
		
		Thread timer=new Thread() {
			
			public void run() {				
				try {					
					while(true) {
						
						Date dt=new Date();						
						SimpleDateFormat sdf=new SimpleDateFormat("hh : mm : ss : a"); 
						
						String dateTime=sdf.format(dt);
						clockLabel.setText(dateTime);						
						
						Thread.sleep(1000);
						
					}
					
				} catch (Exception e) {					
					e.printStackTrace();					
				}
			}
			
		};	
		
		timer.start();
	
	}	
	
	
}



