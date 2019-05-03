package application;



public class Logic {
	static int won[]=new int[9];
	
	static void set() {
		for(int i=0;i<9;i++)
			won[i]=3;
	}
	static void result(int x,boolean victoryCheck) {
		if(victoryCheck) {
			for(int i=0;i<81;i++)
				Main.btns[i].fixed=true;
			Main.end.setDisable(true);
			Main.victoryLabel.setText(Main.btns[XOButton.lastTurnPlayed].symbol+" Wins!");
			Main.victory.show();
			Main.sgame.setDisable(true);
		}
			
		else {
			won[x/9]=XOButton.status;
			if(XOButton.status==0)
				Main.gp[x/9].setStyle("-fx-background-color: yellow;"); 
			else
				Main.gp[x/9].setStyle("-fx-background-color: cyan;");
		}
	}
	static void check(int move,boolean victoryCheck) {
		int startGridPos = (move/9)*9;
		boolean check=true;
			if((move%3==0&&!victoryCheck)||((move/9)%3==0&&victoryCheck)) {
				
				for(int i=0;i<3;i++) {
					//System.out.println("cond1 "+won[i*3]+" "+won[move/9]);
					if(((Main.btns[startGridPos+i*3].symbol!=Main.btns[move].symbol)&&!victoryCheck)||(((won[i*3]!=won[move/9])||won[move/9]==3)&&victoryCheck)) {
						check=false;
						break;
					}
				}
				if(check) {
					result(startGridPos,victoryCheck);
					return;
				}
			}
			check=true;
			if(((move-1)%3==0&&!victoryCheck)||((move/9-1)%3==0)&&victoryCheck) {
				for(int i=0;i<3;i++)  {
					//System.out.println("cond2 "+won[1+i*3]+" "+won[move/9]);
					if(((Main.btns[startGridPos+1+i*3].symbol!=Main.btns[move].symbol)&&!victoryCheck)||(((won[1+i*3]!=won[move/9])||won[move/9]==3)&&victoryCheck)) {
						check=false;
						break;
					}
				}
				if(check) {
					result(startGridPos,victoryCheck);
					return;
				}
			}
			check=true;
			if(((move-2)%3==0&&!victoryCheck)||((move/9-2)%3==0&&victoryCheck)) {
				for(int i=0;i<3;i++) {
					//System.out.println("cond3 "+won[2+i*3]+" "+won[move/9]);
					if(((Main.btns[startGridPos+2+i*3].symbol!=Main.btns[move].symbol)&&!victoryCheck)||(((won[2+i*3]!=won[move/9])||won[move/9]==3)&&victoryCheck)) {
						check=false;
						break;
					}
				}
				if(check) {
					result(startGridPos,victoryCheck);
					return;
				}
			}
			check=true;
			if((move<startGridPos+3&&!victoryCheck)||(move/9<3&&victoryCheck)) {
				for(int i=0;i<3;i++){
					//System.out.println("cond4 "+won[i]+" "+won[move/9]);
					if(((Main.btns[startGridPos+i].symbol!=Main.btns[move].symbol)&&!victoryCheck)||(((won[i]!=won[move/9])||won[move/9]==3)&&victoryCheck)) {
						check=false;
						break;
					}
				}
				if(check) {
					result(startGridPos,victoryCheck);
					return;
				}
			}
			check=true;
			if((move<startGridPos+6&&move>=startGridPos+3&&!victoryCheck)||(move/9<6&&move/9>=3&&victoryCheck)) {
				for(int i=0;i<3;i++)
					if(((Main.btns[startGridPos+3+i].symbol!=Main.btns[move].symbol)&&!victoryCheck)||(((won[i+3]!=won[move/9])||won[move/9]==3)&&victoryCheck)) {
						check=false;
						break;
					}
				if(check) {
					result(startGridPos,victoryCheck);
					return;
				}
			}
			check=true;
			if((move<startGridPos+9&&move>=startGridPos+6&&!victoryCheck)||(move/9<9&&move/9>=6&&victoryCheck)) {
				for(int i=0;i<3;i++)
					if(((Main.btns[startGridPos+6+i].symbol!=Main.btns[move].symbol)&&!victoryCheck)||(((won[i+6]!=won[move/9])||won[move/9]==3)&&victoryCheck)) {
						check=false;
						break;
					}
				if(check) {
					result(startGridPos,victoryCheck);
					return;
				}
			}
			check=true;
			if(((move-startGridPos)%2==0&&move!=startGridPos&&!victoryCheck)||((move/9)%2==0&&move!=0&&victoryCheck)) {
				for(int i=0;i<3;i++) {
					//System.out.println("cond4 "+Main.btns[startGridPos+2+i*2].symbol+" "+Main.btns[move].symbol);
					if(((Main.btns[startGridPos+2+i*2].symbol!=Main.btns[move].symbol)&&!victoryCheck)||(((won[i*2+2]!=won[move/9])||won[move/9]==3)&&victoryCheck)) {
						check=false;
						break;
					}
				}
				if(check) {
					result(startGridPos,victoryCheck);
					return;
				}
			}
			check=true;
			if(((move-startGridPos)%4==0&&!victoryCheck)||((move/9)%4==0&&victoryCheck)) {
				for(int i=0;i<3;i++) 
					if(((Main.btns[startGridPos+i*4].symbol!=Main.btns[move].symbol)&&!victoryCheck)||(((won[i*4]!=won[move/9])||won[move/9]==3)&&victoryCheck)) {
						check=false;
						break;
					}
				if(check) {
					result(startGridPos,victoryCheck);
					return;
				}
			}				
	}
}