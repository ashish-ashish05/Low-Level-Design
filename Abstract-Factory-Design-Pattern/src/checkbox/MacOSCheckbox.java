package checkbox;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering MacOS checkbox.");
    }

    @Override
    public void check() {
        System.out.println("MacOS checkbox selected.");
    }
}
