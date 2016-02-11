/**
 * Created by Shafs on 12.02.2016.
 */
public class Singleton {

    static Singleton instance;

    private Singleton(){}

    static {
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
    }

    public Singleton getInstance() {
        return instance;
    }
}
