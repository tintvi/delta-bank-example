package me.tintvi.Bank.bank;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import me.tintvi.Bank.actions.Action;
import me.tintvi.Bank.actions.DetailAction;
import me.tintvi.Bank.actions.HelpAction;
import me.tintvi.Bank.actions.LoadBankAction;
import me.tintvi.Bank.menu.MenuChoices;
import me.tintvi.Bank.storage.GsonSerializationService;
import me.tintvi.Bank.storage.IOFileStorageService;
import me.tintvi.Bank.storage.Storage;
import me.tintvi.Bank.storage.StringSerialization;

public class BankInjector extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Storage.class).to(IOFileStorageService.class);
        this.bind(StringSerialization.class).to(GsonSerializationService.class);

        MapBinder<MenuChoices, Action> uriBinder = MapBinder.newMapBinder(binder(), MenuChoices.class, Action.class);

        uriBinder.addBinding(MenuChoices.LOAD).to(LoadBankAction.class);
        uriBinder.addBinding(MenuChoices.HELP).to(HelpAction.class);
        uriBinder.addBinding(MenuChoices.DETAIL).to(DetailAction.class);
    }
}
