package com.urmedia.app.dagger.component;

import com.urmedia.app.App;
import com.urmedia.app.dagger.module.AppModule;

import dagger.Component;
import jakarta.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);
}
