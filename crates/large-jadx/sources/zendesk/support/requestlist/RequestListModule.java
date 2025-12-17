package zendesk.support.requestlist;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import zendesk.core.MemoryCache;
import zendesk.support.RequestProvider;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;
import zendesk.support.SupportUiStorage;

/* loaded from: classes3.dex */
public class RequestListModule {
    static zendesk.support.requestlist.RequestListSyncHandler refreshHandler(zendesk.support.requestlist.RequestListPresenter requestListPresenter) {
        RequestListSyncHandler requestListSyncHandler = new RequestListSyncHandler(requestListPresenter);
        return requestListSyncHandler;
    }

    static zendesk.support.requestlist.RequestInfoDataSource.Repository repository(zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource requestInfoDataSource$LocalDataSource, SupportUiStorage supportUiStorage2, RequestProvider requestProvider3, Executor executor4, ExecutorService executorService5) {
        RequestInfoDataSource.Network network = new RequestInfoDataSource.Network(requestProvider3);
        RequestInfoDataSource.Disk obj4 = new RequestInfoDataSource.Disk(executor4, executorService5, supportUiStorage2, "remote_request_infos");
        RequestInfoDataSource.RemoteDataSource obj3 = new RequestInfoDataSource.RemoteDataSource(network, obj4);
        RequestInfoMerger obj5 = new RequestInfoMerger();
        obj4 = new RequestInfoDataSource.Repository(localDataSource, obj3, obj5);
        return obj4;
    }

    zendesk.support.requestlist.RequestListModel model(zendesk.support.requestlist.RequestInfoDataSource.Repository requestInfoDataSource$Repository, MemoryCache memoryCache2, SupportBlipsProvider supportBlipsProvider3, SupportSettingsProvider supportSettingsProvider4) {
        RequestListModel requestListModel = new RequestListModel(repository, memoryCache2, supportBlipsProvider3, supportSettingsProvider4);
        return requestListModel;
    }

    zendesk.support.requestlist.RequestListPresenter presenter(zendesk.support.requestlist.RequestListModel requestListModel) {
        RequestListPresenter requestListPresenter = new RequestListPresenter(requestListModel);
        return requestListPresenter;
    }
}
