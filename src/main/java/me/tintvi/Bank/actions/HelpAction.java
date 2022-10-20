package me.tintvi.Bank.actions;

import me.tintvi.Bank.menu.MenuChoices;

public class HelpAction implements Action {
    @Override
    public void processAction() {
        MenuChoices.help();
    }
}
