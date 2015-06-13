package net.hosain.voat.di;

import net.hosain.voat.activity.ThreadListActivity;
import net.hosain.voat.activity.ThreadListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(ThreadListActivity threadListActivity);

    void inject(ThreadListFragment threadListFragment);
}
