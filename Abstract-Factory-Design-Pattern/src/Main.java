import factory.*;
import button.*;
import checkbox.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Windows UI");

        UIFactory windowsFactory =
                new WindowsUIFactory();

        Button windowsButton =
                windowsFactory.createButton();

        Checkbox windowsCheckbox =
                windowsFactory.createCheckbox();

        windowsButton.render();
        windowsButton.click();

        windowsCheckbox.render();
        windowsCheckbox.check();


        System.out.println("\nMacOS UI");

        UIFactory macFactory =
                new MacOSUIFactory();

        Button macButton =
                macFactory.createButton();

        Checkbox macCheckbox =
                macFactory.createCheckbox();

        macButton.render();
        macButton.click();

        macCheckbox.render();
        macCheckbox.check();
    }
}