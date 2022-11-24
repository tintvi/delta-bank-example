package me.tintvi.Bank.bank;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import me.tintvi.Bank.actions.*;
import me.tintvi.Bank.menu.MenuChoices;
import me.tintvi.Bank.storage.GsonSerializationService;
import me.tintvi.Bank.storage.IOFileStorageService;
import me.tintvi.Bank.storage.Storage;
import me.tintvi.Bank.storage.StringSerialization;

public class BankInjector extends AbstractModule {

    //private EventBus eventBus = new EventBus("Default EventBus");
    @Override
    protected void configure() {
        this.bind(Storage.class).to(IOFileStorageService.class);
        this.bind(StringSerialization.class).to(GsonSerializationService.class);

        MapBinder<MenuChoices, Action> uriBinder = MapBinder.newMapBinder(binder(), MenuChoices.class, Action.class);

        uriBinder.addBinding(MenuChoices.LOAD).to(LoadBankAction.class);
        uriBinder.addBinding(MenuChoices.HELP).to(HelpAction.class);
        uriBinder.addBinding(MenuChoices.DETAIL).to(DetailAction.class);
        uriBinder.addBinding(MenuChoices.ACCOUNTS).to(AccountsAction.class);

//        this.bind(EventBus.class).toInstance(eventBus);
//        bindListener(Matchers.any(), new TypeListener() {
//            public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
//                typeEncounter.register(new InjectionListener<I>() {
//                    public void afterInjection(I i) {
//                        eventBus.register(i);
//                    }
//                });
//            }
//        });
    }
}
