package application;
	
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {
	static Text turnlbl=new Text();
	static FlowPane fp=new FlowPane();
	static Scene scene=new Scene(fp);
	static Stage victory = new Stage();
	static MenuItem sgame=new MenuItem("Save Game");
	static GridPane sgp=new GridPane();
	Scene scene1 =  new Scene(sgp,540,560);
	static Text victoryLabel = new Text();
	static Button end = new Button();
	static GridPane gp[]=new GridPane[9];
	static GridPane mgp=new GridPane();
	static XOButton btns[]=new XOButton[81];
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("T 'n' T");
		primaryStage.setResizable(false);
		Image icon=new Image(getClass().getResourceAsStream("/img/tic-tac-toe.png"));
		primaryStage.getIcons().add(icon);
		
	/*	final URL resource = getClass().getResource("/application/Mahalo x DLMT - So Cold (feat. Lily Denning).mp3");
	    final Media media = new Media(resource.toString());
	    final MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.play();*/
		victory.setTitle("VICTORY!");
		victory.setResizable(false);
		FlowPane vic=new FlowPane();
		vic.setMinSize(300, 100);
		victoryLabel.setFont(new Font(30));
		vic.setAlignment(Pos.CENTER);
		vic.getChildren().add(victoryLabel);
		Scene v=new Scene(vic);
		victory.setScene(v);
		
		
		turnlbl.setText("   X's Turn");
		
		sgp.setMaxSize(500, 600);
		sgp.setPadding(new Insets(0,0,0,0));
		
		fp.setMaxSize(500, 600);
		fp.setPadding(new Insets(0,0,0,0));
		
		MenuBar mb=new MenuBar();
		Menu fmenu=new Menu("File");
		Menu helpmenu = new Menu("Help");
		MenuItem ngame=new MenuItem("New Game");
		MenuItem lgame=new MenuItem("Load Game");
		MenuItem help = new MenuItem("Instructions");
		MenuItem exit=new MenuItem("Exit");
		
		fmenu.getItems().addAll(ngame,lgame,sgame,new SeparatorMenuItem(),exit);
		mb.setMinWidth(560);
		helpmenu.getItems().addAll(help);
		mb.getMenus().addAll(fmenu,helpmenu);
		
		//mgp.setMaxSize(550, 600);
		mgp.setPrefSize(540, 560);
		mgp.setPadding(new Insets(10,10,10,10));
        mgp.setVgap(10);
        mgp.setHgap(10);
        mgp.setAlignment(Pos.CENTER);
		
		gp[0] = new GridPane();
		gp[0].setMinSize(170, 170);
        gp[0].setVgap(5);
        gp[0].setHgap(5);
        gp[0].setAlignment(Pos.CENTER);
        
        gp[1] = new GridPane();
		gp[1].setMinSize(170, 170);
        gp[1].setVgap(5);
        gp[1].setHgap(5);
        gp[1].setAlignment(Pos.CENTER);
        
        gp[2] = new GridPane();
		gp[2].setMinSize(170, 170);
        gp[2].setVgap(5);
        gp[2].setHgap(5);
        gp[2].setAlignment(Pos.CENTER);
        
        gp[3] = new GridPane();
		gp[3].setMinSize(170, 170);
        gp[3].setVgap(5);
        gp[3].setHgap(5);
        gp[3].setAlignment(Pos.CENTER);
        
        gp[4] = new GridPane();
		gp[4].setMinSize(170, 170);
        gp[4].setVgap(5);
        gp[4].setHgap(5);
        gp[4].setAlignment(Pos.CENTER);
        
        gp[5] = new GridPane();
		gp[5].setMinSize(170, 170);
        gp[5].setVgap(5);
        gp[5].setHgap(5);
        gp[5].setAlignment(Pos.CENTER);
        
        gp[6] = new GridPane();
		gp[6].setMinSize(170, 170);
        gp[6].setVgap(5);
        gp[6].setHgap(5);
        gp[6].setAlignment(Pos.CENTER);
        
        gp[7] = new GridPane();
		gp[7].setMinSize(170, 170);
        gp[7].setVgap(5);
        gp[7].setHgap(5);
        gp[7].setAlignment(Pos.CENTER);
        
        gp[8] = new GridPane();
		gp[8].setMinSize(170, 170);
        gp[8].setVgap(5);
        gp[8].setHgap(5);
        gp[8].setAlignment(Pos.CENTER);
		
		
		int t=0;
		
		for(;t<81;)
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++) {
					if(t<9) {
						btns[t]=new XOButton();
						gp[0].add(btns[t++], j, i);
					}else if(t>8&&t<18) {
						btns[t]=new XOButton();
						gp[1].add(btns[t++], j, i);
					}else if(t>17&&t<27) {
						btns[t]=new XOButton();
						gp[2].add(btns[t++], j, i);
					}else if(t>26&&t<36) {
						btns[t]=new XOButton();
						gp[3].add(btns[t++], j, i);
					}else if(t>35&&t<45) {
						btns[t]=new XOButton();
						gp[4].add(btns[t++], j, i);
					}else if(t>44&&t<54) {
						btns[t]=new XOButton();
						gp[5].add(btns[t++], j, i);
					}else if(t>53&&t<63) {
						btns[t]=new XOButton();
						gp[6].add(btns[t++], j, i);
					}else if(t>62&&t<72) {
						btns[t]=new XOButton();
						gp[7].add(btns[t++], j, i);
					}else if(t>71&&t<81) {
						btns[t]=new XOButton();
						gp[8].add(btns[t++], j, i);
					}
			}
		
		end.setText("End Turn");
	    end.setDefaultButton(true);
	    end.setDisable(true);
	    Logic.set();
	    
	    help.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				sgp.setPrefSize(540, 560);
				sgp.setPadding(new Insets(10,10,10,10));
				sgp.setVgap(10);
				sgp.setHgap(5);
				Button back=new Button("BACK");
				back.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent ae) {
						primaryStage.setScene(scene);
					}	
				});
				try {				    	
					    TextArea text = new TextArea();
				    	sgp.add(text, 0, 0,55,50);
				    	text.setEditable(false);
				    	BufferedReader  in = new BufferedReader(new FileReader("help.txt"));
				    	String line = in.readLine();
				    	while(line != null){
				    	  text.appendText(line + "\n");
				    	  text.setFont(Font.font(13));
				    	  line = in.readLine();
				    	}
				    	in.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				sgp.add(back, 50, 50);
				primaryStage.setScene(scene1);
                primaryStage.show();
			}	
		});
		
		ngame.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				for(int i=0;i<81;i++)
					btns[i].reset();
				for(int i=0;i<9;i++) {
					Logic.won[i]=3;
					gp[i].setStyle(null);
				}
				sgame.setDisable(false);
				XOButton.status=1;
				XOButton.game=false;
				XOButton.lastPlayed=XOButton.lastTurnPlayed=-1;
				mgp.requestFocus();
				end.setDisable(true);
			}	
		});
		
		sgame.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				FileOutputStream fos = null;
			    File file;
			      
			      try {
			          //Specify the file path here
				  file = new File("save.txt");
				  fos = new FileOutputStream(file);
				  if (!file.exists()) {
				     file.createNewFile();
				  }
				  
				  for(int t=0;t<81;t++) {
					  if(t!=XOButton.lastPlayed) {
						  	fos.write(btns[t].symbol);
						  	fos.flush();
					  }
					  else {
						  fos.write(' ');
						  fos.flush();
					  }
					 
				  }
				  fos.write((char)XOButton.lastTurnPlayed);
				  fos.flush();
				  fos.write((char)XOButton.status);
				  fos.flush();
				  for(int i=0;i<9;i++) {
					  fos.write((char)Logic.won[i]);
					  fos.flush();
				  }
					  
			       } 
			       catch (IOException ioe) {
				  ioe.printStackTrace();
			       }
			}
		});
		
		lgame.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				try {
					for(int i=0;i<81;i++)
						btns[i].reset();
				      FileInputStream fis = new FileInputStream("save.txt");
				      char current;
				      while (fis.available() > 0) {
				    	  for(int t=0;t<81;t++) {
				    		  current = (char) fis.read();
				    		  if(current=='X') {
				    			  btns[t].setGraphic(btns[t].Xiv);
				    			  btns[t].fixed=true;
				    			  btns[t].symbol='X';
				    		  }
				    		  else if(current=='O') {
				    			  btns[t].setGraphic(btns[t].Oiv);
				    			  btns[t].fixed=true;
				    			  btns[t].symbol='O';
				    		  }
				    		  else btns[t].setGraphic(null);
				    		
				        
				    	  }
				    	  XOButton.lastTurnPlayed=(int)fis.read();
				    	  
				    	  XOButton.status=(byte)fis.read();
				    	  switch(XOButton.status) {
							case 1: turnlbl.setText("   X's Turn");
									break;
							case 0: turnlbl.setText("   O's Turn");
									break;
							}
				    	  
				    	  for(int i=0;i<9;i++)
				    		  Logic.won[i]=(int)fis.read();
				    	 
							
				       }
				      
						
				      boolean filled=true;
						for(int k=((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9);k<((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9)+9;k++)
							if(!btns[k].fixed) {
								filled = false;
								break;
							}
						if(filled) {
							for(int i=0;i<81;i++)
								if(!btns[i].fixed)
									btns[i].disable=false;	
								else
									btns[i].disable=true;
						}
						else {
							for(int k=0;k<81;k++)
								if((k<(XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9||k>=((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9)+9))
									btns[k].disable=true;
								else 
									btns[k].disable=false;
						}
						for(int k=0;k<81;k++)
							if(btns[k].disable||btns[k].fixed)	btns[k].setStyle(null);
							else if(!btns[k].fixed)	btns[k].setStyle("-fx-background-color: green;");
						
						for(int k=0;k<9;k++)
							if(Logic.won[k]==0)	gp[k].setStyle("-fx-background-color: yellow;");
							else if(Logic.won[k]==1)	gp[k].setStyle("-fx-background-color: cyan;");
						
						btns[XOButton.lastTurnPlayed].requestFocus();
						fis.close();
				    } catch (IOException e) {
				      e.printStackTrace();
				    }
				
			}
		});
		
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				primaryStage.close();
				
			}
		});
		
		mgp.add(gp[0], 0, 0);
		mgp.add(gp[1], 1, 0);
		mgp.add(gp[2], 2, 0);
		mgp.add(gp[3], 0, 1);
		mgp.add(gp[4], 1, 1);
		mgp.add(gp[5], 2, 1);
		mgp.add(gp[6], 0, 2);
		mgp.add(gp[7], 1, 2);
		mgp.add(gp[8], 2, 2);
		
		Separator sp=new Separator();
		sp.setMinWidth(560);
		Separator sp1 = new Separator();
		sp1.setMinWidth(372);
		sp1.setOpacity(0);		
		turnlbl.setFont(Font.font(17));
		
		Text timer=new Text();
		
		fp.getChildren().addAll(mb,mgp,sp,turnlbl,timer,sp1,end);
		
		for(int i=0;i<81;i++) {
			final int temp=new Integer(i);
			btns[i].setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					
					
					if(!btns[temp].disable&&!btns[temp].fixed) {
						
						end.setDisable(false);
						
						if(XOButton.lastPlayed!=-1) {
							btns[XOButton.lastPlayed].symbol=' ';
							btns[XOButton.lastPlayed].setGraphic(null);
							for(int k=0;k<81;k++)
								btns[k].setStyle(null);
						}
						
						if(XOButton.lastTurnPlayed!=-1)
							for(int k=0;k<81;k++)
								if(!btns[k].fixed&&!btns[k].disable)	btns[k].setStyle("-fx-background-color: green;");
						
							
						boolean filled=true;
						for(int k=((temp-(temp/9)*9)*9);k<((temp-(temp/9)*9)*9)+9;k++)
							if(!btns[k].fixed) {
								filled = false;
								break;
							}
						if(filled) {
							for(int i=0;i<81;i++)
								if(!btns[i].fixed)
									btns[i].setStyle("-fx-background-color: red;");
						}
						else {
							for(int k=(temp-(temp/9)*9)*9;k<((temp-(temp/9)*9)*9)+9;k++)
								if(!btns[k].fixed&&k!=temp)	btns[k].setStyle("-fx-background-color: red;");
						}		
						btns[temp].setStyle(null);
						
						switch(XOButton.status) {
						case 1: btns[temp].setGraphic(btns[temp].Xiv); 
								btns[temp].symbol='X';
								break;
						case 0: btns[temp].setGraphic(btns[temp].Oiv);
								btns[temp].symbol='O';
								break;
						}
						XOButton.lastPlayed=temp;
						
								
							
							
					}
					else {
						if(XOButton.lastPlayed!=-1)
							btns[XOButton.lastPlayed].requestFocus();
						else
							btns[XOButton.lastTurnPlayed].requestFocus();
					
						
					}
					
					
				}
			});
		}
		end.setAlignment(Pos.CENTER_RIGHT);
		end.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				
				XOButton.status++;
				XOButton.status%=2;
				
				switch(XOButton.status) {
				case 1: turnlbl.setText("   X's Turn");
						break;
				case 0: turnlbl.setText("   O's Turn");
						break;
				}
				XOButton.lastTurnPlayed=XOButton.lastPlayed;
				
				if(Logic.won[XOButton.lastTurnPlayed/9]==3) {
					Logic.check(XOButton.lastTurnPlayed, false);
					
				}
				Logic.check(XOButton.lastTurnPlayed, true);
				
				btns[XOButton.lastTurnPlayed].fixed=true;
				
				
				
				boolean filled=true;
				for(int k=((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9);k<((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9)+9;k++)
					if(!btns[k].fixed) {
						filled = false;
						break;
					}
				if(filled) {
					for(int i=0;i<81;i++)
						if(!btns[i].fixed)
							btns[i].disable=false;	
						else
							btns[i].disable=true;
				}
				else {
					for(int k=0;k<81;k++)
						if((k<(XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9||k>=((XOButton.lastTurnPlayed-(XOButton.lastTurnPlayed/9)*9)*9)+9))
							btns[k].disable=true;
						else 
							btns[k].disable=false;
				}
				
				for(int k=0;k<81;k++)
					if(btns[k].disable||btns[k].fixed)	btns[k].setStyle(null);
					else if(!btns[k].fixed)	btns[k].setStyle("-fx-background-color: green;");
				
				end.setDisable(true);
				XOButton.game=true;
				XOButton.lastPlayed=-1;
				btns[XOButton.lastTurnPlayed].requestFocus();
			}
		});
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		mgp.requestFocus();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}