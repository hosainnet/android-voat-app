package net.hosain.voat.di;

import net.hosain.voat.activity.subverse.ThreadListActivity;
import net.hosain.voat.activity.subverse.ThreadListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(ThreadListActivity threadListActivity);

    void inject(ThreadListFragment threadListFragment);
}
