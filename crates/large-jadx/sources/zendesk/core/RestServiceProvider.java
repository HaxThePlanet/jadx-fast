package zendesk.core;

import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public interface RestServiceProvider {
    public abstract <E> E createRestService(Class<E> class, String string2, String string3);

    public abstract <E> E createRestService(Class<E> class, String string2, String string3, zendesk.core.CustomNetworkConfig customNetworkConfig4);

    public abstract <E> E createUnauthenticatedRestService(Class<E> class, String string2, String string3, zendesk.core.CustomNetworkConfig customNetworkConfig4);

    public abstract OkHttpClient getCoreOkHttpClient();

    public abstract OkHttpClient getMediaOkHttpClient();
}
