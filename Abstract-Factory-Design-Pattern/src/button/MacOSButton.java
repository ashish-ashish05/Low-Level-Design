package button;

public class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering MacOS button.");
    }

    @Override
    public void click() {
        System.out.println("MacOS button clicked.");
    }
}
