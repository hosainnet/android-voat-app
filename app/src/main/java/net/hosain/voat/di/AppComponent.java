package net.hosain.voat.di;

import net.hosain.voat.activity.subverse.SubverseActivity;
import net.hosain.voat.activity.subverse.SubverseFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(SubverseActivity threadListActivity);

    void inject(SubverseFragment subverseFragment);
}
