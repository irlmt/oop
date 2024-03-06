package labs.l1pack;

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
    public String move(){
        return (moveStrategy.move());
    }
}
