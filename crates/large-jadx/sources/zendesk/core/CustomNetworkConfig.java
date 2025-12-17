package zendesk.core;

import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit.Builder;

/* loaded from: classes3.dex */
public abstract class CustomNetworkConfig {
    public void configureOkHttpClient(OkHttpClient.Builder okHttpClient$Builder) {
    }

    public void configureRetrofit(Retrofit.Builder retrofit$Builder) {
    }
}
