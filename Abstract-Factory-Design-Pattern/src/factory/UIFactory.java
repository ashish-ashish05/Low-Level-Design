package factory;

import button.Button;
import checkbox.Checkbox;

public interface UIFactory {
    Button createButton();

    Checkbox createCheckbox();
}
