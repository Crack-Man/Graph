package GraphRedactor.Main;

public class Parameters {
    private int width, height, butHeight;
    private static Parameters me;

    public static Parameters get() {
        if(me == null) {
            me = new Parameters();
        }
        return me;
    }

    private Parameters() {
    }

    public void setParameters(int width, int height, int butHeight) {
        this.width = width;
        this.height = height;
        this.butHeight = butHeight;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getButHeight() {
        return this.butHeight;
    }
}
