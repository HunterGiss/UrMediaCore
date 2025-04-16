package com.urmedia.app.dagger.module;

import com.urmedia.app.AppRunner;

import dagger.Module;
import dagger.Provides;
import jakarta.inject.Singleton;
import lombok.NoArgsConstructor;

@Module
@NoArgsConstructor
public class AppModule {

    public static final AppModule INSTANCE = new AppModule();

    @Provides
    @Singleton
    public AppRunner provideMainService() {
        return new AppRunner();
    }
}
