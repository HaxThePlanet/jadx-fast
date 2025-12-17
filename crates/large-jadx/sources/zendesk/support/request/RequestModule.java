package zendesk.support.request;

import android.content.Context;
import com.squareup.picasso.t;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import o.a.a;
import o.a.b;
import o.b.f;
import o.b.i;
import o.b.n;
import o.b.q;
import o.b.r;
import o.b.r.a;
import okhttp3.OkHttpClient;
import zendesk.belvedere.a;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.AuthenticationProvider;
import zendesk.core.Zendesk;
import zendesk.support.RequestProvider;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;
import zendesk.support.SupportUiStorage;
import zendesk.support.UploadProvider;
import zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource;

/* loaded from: classes3.dex */
public class RequestModule {

    private final a configuration;
    RequestModule(a a) {
        super();
        this.configuration = a;
    }

    static zendesk.support.request.ActionFactory providesActionFactory(RequestProvider requestProvider, SupportSettingsProvider supportSettingsProvider2, UploadProvider uploadProvider3, a a4, SupportUiStorage supportUiStorage5, ExecutorService executorService6, Executor executor7, AuthenticationProvider authenticationProvider8, SupportBlipsProvider supportBlipsProvider9) {
        super(requestProvider, uploadProvider3, supportSettingsProvider2, a4, supportUiStorage5, executorService6, "5.0.3", authenticationProvider8, Zendesk.INSTANCE, supportBlipsProvider9, executor7);
        return actionFactory;
    }

    static zendesk.support.request.AsyncMiddleware providesAsyncMiddleware() {
        AsyncMiddleware.Queue queue = new AsyncMiddleware.Queue();
        AsyncMiddleware asyncMiddleware = new AsyncMiddleware(queue);
        return asyncMiddleware;
    }

    static zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader providesAttachmentDownloader(a a, zendesk.support.request.AttachmentDownloadService attachmentDownloadService2) {
        AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloader = new AttachmentDownloaderComponent.AttachmentDownloader(a, attachmentDownloadService2);
        return attachmentDownloader;
    }

    static zendesk.support.request.AttachmentDownloaderComponent providesAttachmentDownloaderComponent(f f, zendesk.support.request.ActionFactory actionFactory2, zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloaderComponent$AttachmentDownloader3) {
        AttachmentDownloaderComponent attachmentDownloaderComponent = new AttachmentDownloaderComponent(f, actionFactory2, attachmentDownloader3);
        return attachmentDownloaderComponent;
    }

    static zendesk.support.request.AttachmentDownloadService providesAttachmentToDiskService(OkHttpClient okHttpClient, ExecutorService executorService2) {
        AttachmentDownloadService attachmentDownloadService = new AttachmentDownloadService(okHttpClient, executorService2);
        return attachmentDownloadService;
    }

    static a providesBelvedere(Context context) {
        return a.c(context);
    }

    static zendesk.support.request.HeadlessComponentListener providesComponentListener(zendesk.support.request.ComponentPersistence componentPersistence, zendesk.support.request.AttachmentDownloaderComponent attachmentDownloaderComponent2, zendesk.support.request.ComponentUpdateActionHandlers componentUpdateActionHandlers3) {
        HeadlessComponentListener headlessComponentListener = new HeadlessComponentListener(componentPersistence, attachmentDownloaderComponent2, componentUpdateActionHandlers3);
        return headlessComponentListener;
    }

    static zendesk.support.request.ComponentUpdateActionHandlers providesConUpdatesComponent(Context context, ActionHandlerRegistry actionHandlerRegistry2, RequestInfoDataSource.LocalDataSource requestInfoDataSource$LocalDataSource3) {
        ComponentUpdateActionHandlers componentUpdateActionHandlers = new ComponentUpdateActionHandlers(context, actionHandlerRegistry2, localDataSource3);
        return componentUpdateActionHandlers;
    }

    static zendesk.support.request.ComponentPersistence.PersistenceQueue providesDiskQueue(ExecutorService executorService) {
        ComponentPersistence.PersistenceQueue persistenceQueue = new ComponentPersistence.PersistenceQueue(executorService);
        return persistenceQueue;
    }

    static f providesDispatcher(q q) {
        return q;
    }

    static zendesk.support.request.ComponentPersistence providesPersistenceComponent(SupportUiStorage supportUiStorage, zendesk.support.request.ComponentPersistence.PersistenceQueue componentPersistence$PersistenceQueue2, ExecutorService executorService3) {
        ComponentPersistence componentPersistence = new ComponentPersistence(supportUiStorage, persistenceQueue2, executorService3);
        return componentPersistence;
    }

    static List<n> providesReducer() {
        n[] arr = new n[7];
        ReducerProgress reducerProgress = new ReducerProgress();
        ReducerConfiguration reducerConfiguration = new ReducerConfiguration();
        ReducerConversation reducerConversation = new ReducerConversation();
        ReducerAttachments reducerAttachments = new ReducerAttachments();
        ReducerAndroidLifecycle reducerAndroidLifecycle = new ReducerAndroidLifecycle();
        ReducerUiState reducerUiState = new ReducerUiState();
        ReducerError reducerError = new ReducerError();
        return Arrays.asList(reducerProgress, reducerConfiguration, reducerConversation, reducerAttachments, reducerAndroidLifecycle, reducerUiState, reducerError);
    }

    static q providesStore(List<n> list, zendesk.support.request.AsyncMiddleware asyncMiddleware2) {
        r.a obj2 = r.b(list);
        o.b.m[] arr = new m[1];
        obj2.e(asyncMiddleware2);
        obj2.d(i.b);
        return obj2.b();
    }

    zendesk.support.request.CellFactory providesMessageFactory(Context context, t t2, zendesk.support.request.ActionFactory actionFactory3, f f4, ActionHandlerRegistry actionHandlerRegistry5, b b6) {
        super(context.getApplicationContext(), t2, actionFactory3, f4, actionHandlerRegistry5, b6, this.configuration);
        return cellFactory;
    }
}
