package application;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class XOButton extends Button {
	Image Ximg=new Image(getClass().getResourceAsStream("/img/x.png"),46,46,true,true);
	ImageView Xiv=new ImageView(Ximg);
		
	Image Oimg=new Image(getClass().getResourceAsStream("/img/o.png"),46,46,true,true);
	ImageView Oiv=new ImageView(Oimg);
	
	static boolean game=false;
	static int lastPlayed=-1;
	static int lastTurnPlayed=-1;
	static byte status=1;
	boolean fixed =false;
	char symbol=' ';
	boolean disable=false;
	
	public XOButton() {
		super();
		this.setPadding(new Insets(0,0,0,0));
		this.setAlignment(Pos.CENTER);
		this.setMinSize(50, 50);
	
	}
	public void reset() {
		symbol=' ';
		fixed=false;
		setGraphic(null);
		setStyle(null);
		disable=false;
		
	}
}