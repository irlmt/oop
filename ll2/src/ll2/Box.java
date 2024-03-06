package ll2;

public class Box {
    private static double width = 1.0;
    private static double height = 1.0;
    private static double depth = 1.0;
    public Box() {
    }

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box(double len) {
        this.width = this.height = this.depth = len;
    }
    @MyAnno(2)
    public static void getWidthMul(double a){
        System.out.println("width * " + a+ ": " + width*a);
    }

    public static double getHeight() {
        return height;
    }

    public static double getDepth() {
        return depth;
    }
    @MyAnno(3)
    protected static void getVolumeSum(double a, double b){
        System.out.println("Volume + " + (a+b) +": " + (width*height*depth + a + b));
    }
    protected double getSquare(){
        return width*height*2+width*depth*2+height*depth*2;
    }
    @MyAnno(4)
    private static void checkWidth(){
        if(width<=0.0){
            System.out.println("width <= 0");
        }
        else{
            System.out.println("width > 0");
        }
    }
    private boolean checkHeight(){
        return height>0.0;
    }
    private boolean checkDepth(){
        return depth>0.0;
    }
}
