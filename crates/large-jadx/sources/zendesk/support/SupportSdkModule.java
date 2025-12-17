package zendesk.support;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.squareup.picasso.s;
import com.squareup.picasso.t;
import com.squareup.picasso.t.b;
import f.e.a.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import o.a.b;
import okhttp3.OkHttpClient;
import zendesk.core.ActionHandler;
import zendesk.core.ApplicationConfiguration;
import zendesk.core.SessionStorage;
import zendesk.support.requestlist.RequestInfoDataSource.Disk;
import zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource;

/* loaded from: classes3.dex */
class SupportSdkModule {

    private static final int MAX_DISK_CACHE_SIZE = 20971520;
    b configurationHelper() {
        b bVar = new b();
        return bVar;
    }

    Executor mainThreadExecutor() {
        SupportSdkModule.1 anon = new SupportSdkModule.1(this);
        return anon;
    }

    s okHttp3Downloader(OkHttpClient okHttpClient) {
        s sVar = new s(okHttpClient);
        return sVar;
    }

    Gson provides() {
        Gson gson = new Gson();
        return gson;
    }

    List<ActionHandler> providesActionHandlers() {
        ArrayList arrayList = new ArrayList();
        DeepLinkToRequestActionHandler deepLinkToRequestActionHandler = new DeepLinkToRequestActionHandler();
        arrayList.add(deepLinkToRequestActionHandler);
        return arrayList;
    }

    t providesPicasso(Context context, s s2, ExecutorService executorService3) {
        t.b bVar = new t.b(context);
        bVar.c(s2);
        bVar.d(executorService3);
        bVar.b(Bitmap.Config.RGB_565);
        return bVar.a();
    }

    a providesRequestDiskLruCache(SessionStorage sessionStorage) {
        try {
            File file = new File(sessionStorage.getZendeskDataDir(), "request");
            int obj4 = 1;
            return a.K(file, obj4, obj4, 20971520);
            sessionStorage.printStackTrace();
            sessionStorage = null;
            return sessionStorage;
        }
    }

    String providesZendeskUrl(ApplicationConfiguration applicationConfiguration) {
        return applicationConfiguration.getZendeskUrl();
    }

    RequestInfoDataSource.LocalDataSource requestInfoDataSource(zendesk.support.SupportUiStorage supportUiStorage, Executor executor2, ExecutorService executorService3) {
        RequestInfoDataSource.Disk disk = new RequestInfoDataSource.Disk(executor2, executorService3, supportUiStorage, "local_request_infos");
        RequestInfoDataSource.LocalDataSource localDataSource = new RequestInfoDataSource.LocalDataSource(disk);
        return localDataSource;
    }

    zendesk.support.SupportUiStorage supportUiStorage(a a, Gson gson2) {
        SupportUiStorage supportUiStorage = new SupportUiStorage(a, gson2);
        return supportUiStorage;
    }
}
