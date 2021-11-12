public class Point {
    int x = 0;
    int y = 0;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return ("(x:"+x+",y:"+y+")");
    }

    public int hashCode(){
        return (17 + 31 * x + 31 * 31 *y);
    }
}