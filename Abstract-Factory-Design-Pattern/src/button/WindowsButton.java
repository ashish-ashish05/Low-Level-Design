package button;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows button.");
    }

    @Override
    public void click() {
        System.out.println("Windows button clicked.");
    }
}
