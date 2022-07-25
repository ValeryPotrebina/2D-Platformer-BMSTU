package utilz;

public class Debug {

    int FPS;
    int UPS;

    public Debug() {

    }

    public void say() {
        System.out.println("FPS: " + FPS + " | UPS: " + UPS);
    }

    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

    public void setUPS(int UPS) {
        this.UPS = UPS;
    }

}

