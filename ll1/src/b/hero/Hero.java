package b.hero;

import b.move.MoveStrategy;
import b.move.RunMoveStrategy;

public class Hero {
    private String id;
    private MoveStrategy moveStrategy;

    public Hero(String id){
        this.id=id;
        this.moveStrategy=new RunMoveStrategy();
    }

    public void setMoveStrategy(MoveStrategy moveStrategy){
        this.moveStrategy=moveStrategy;
    }
    public void move(){
        System.out.print(id+" ");
        moveStrategy.move();
    }
}
