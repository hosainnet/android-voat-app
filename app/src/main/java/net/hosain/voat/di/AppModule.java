package net.hosain.voat.di;

import android.content.Context;

import com.squareup.picasso.Picasso;

import net.hosain.voat.service.ApiService;
import net.hosain.voat.service.ImageService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

import static net.hosain.voat.AppConfig.VOAT_HOST;
import static net.hosain.voat.AppConfig.VOAT_PUB_KEY;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return context.getApplicationContext();
    }

    @Singleton
    @Provides
    RequestInterceptor provideRequestInterceptor() {
        return request -> request.addHeader("Voat-ApiKey", VOAT_PUB_KEY);
    }

    @Singleton
    @Provides
    RestAdapter provideRestAdapter(RequestInterceptor requestInterceptor) {
        return new RestAdapter.Builder()
                .setRequestInterceptor(requestInterceptor)
                .setEndpoint(VOAT_HOST)
                .build();
    }

    @Singleton
    @Provides
    ApiService provideApiService(RestAdapter restAdapter) {
        return restAdapter.create(ApiService.class);
    }

    @Singleton
    @Provides
    Picasso providePicasso(Context context) {
        return new Picasso.Builder(context).build();
    }

    @Singleton
    @Provides
    ImageService provideImageService() {
        return new ImageService();
    }
}
