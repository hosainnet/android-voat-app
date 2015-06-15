package net.hosain.voat.di;

import net.hosain.voat.activity.subverse.SubverseActivity;
import net.hosain.voat.activity.subverse.SubverseAdapter;
import net.hosain.voat.activity.subverse.SubverseFragment;
import net.hosain.voat.activity.thread.DetailCommentsFragment;
import net.hosain.voat.service.ImageService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(SubverseActivity threadListActivity);
    void inject(SubverseFragment subverseFragment);

    void inject(DetailCommentsFragment detailCommentsFragment);

    void inject(ImageService imageService);

    void inject(SubverseAdapter subverseAdapter);
}
