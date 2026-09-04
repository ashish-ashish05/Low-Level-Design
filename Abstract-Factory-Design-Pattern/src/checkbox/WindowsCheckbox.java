package checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering Windows checkbox.");
    }

    @Override
    public void check() {
        System.out.println("Windows checkbox selected.");
    }
}
