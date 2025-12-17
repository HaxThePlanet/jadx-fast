package zendesk.support.requestlist;

import com.zendesk.service.f;
import f.g.e.a;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import zendesk.support.Comment;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.SupportUiStorage;

/* loaded from: classes3.dex */
public interface RequestInfoDataSource {

    public static final String LOCAL = "local_request_infos";
    public static final String REMOTE = "remote_request_infos";

    public static class Disk implements zendesk.support.requestlist.RequestInfoDataSource {

        private final Executor backgroundThreadExecutor;
        private final String cacheKey;
        private final Executor mainThreadExecutor;
        private final SupportUiStorage supportUiStorage;
        public Disk(Executor executor, Executor executor2, SupportUiStorage supportUiStorage3, String string4) {
            super();
            this.mainThreadExecutor = executor;
            this.backgroundThreadExecutor = executor2;
            this.supportUiStorage = supportUiStorage3;
            this.cacheKey = string4;
        }

        static String access$200(zendesk.support.requestlist.RequestInfoDataSource.Disk requestInfoDataSource$Disk) {
            return disk.cacheKey;
        }

        static SupportUiStorage access$300(zendesk.support.requestlist.RequestInfoDataSource.Disk requestInfoDataSource$Disk) {
            return disk.supportUiStorage;
        }

        static Executor access$400(zendesk.support.requestlist.RequestInfoDataSource.Disk requestInfoDataSource$Disk) {
            return disk.mainThreadExecutor;
        }

        public void load(f<List<zendesk.support.requestlist.RequestInfo>> f) {
            RequestInfoDataSource.Disk.1 anon = new RequestInfoDataSource.Disk.1(this, f);
            this.backgroundThreadExecutor.execute(anon);
        }

        void save(List<zendesk.support.requestlist.RequestInfo> list, f<List<zendesk.support.requestlist.RequestInfo>> f2) {
            RequestInfoDataSource.Disk.2 anon = new RequestInfoDataSource.Disk.2(this, list, f2);
            this.backgroundThreadExecutor.execute(anon);
        }
    }

    public static class LocalDataSource implements zendesk.support.requestlist.RequestInfoDataSource {

        private static final Comparator<zendesk.support.requestlist.RequestInfo> REQUEST_INFO_COMPARATOR;
        private final zendesk.support.requestlist.RequestInfoDataSource.Disk disk;
        static {
            RequestInfo.LastUpdatedComparator lastUpdatedComparator = new RequestInfo.LastUpdatedComparator();
            RequestInfoDataSource.LocalDataSource.REQUEST_INFO_COMPARATOR = lastUpdatedComparator;
        }

        public LocalDataSource(zendesk.support.requestlist.RequestInfoDataSource.Disk requestInfoDataSource$Disk) {
            super();
            this.disk = disk;
        }

        static Comparator access$800() {
            return RequestInfoDataSource.LocalDataSource.REQUEST_INFO_COMPARATOR;
        }

        static zendesk.support.requestlist.RequestInfoDataSource.Disk access$900(zendesk.support.requestlist.RequestInfoDataSource.LocalDataSource requestInfoDataSource$LocalDataSource) {
            return localDataSource.disk;
        }

        public void insert(zendesk.support.requestlist.RequestInfo requestInfo, f<List<zendesk.support.requestlist.RequestInfo>> f2) {
            RequestInfoDataSource.LocalDataSource.1 anon = new RequestInfoDataSource.LocalDataSource.1(this, requestInfo, f2);
            this.disk.load(anon);
        }

        public void load(f<List<zendesk.support.requestlist.RequestInfo>> f) {
            this.disk.load(f);
        }

        public void remove(String string, f<List<zendesk.support.requestlist.RequestInfo>> f2) {
            RequestInfoDataSource.LocalDataSource.2 anon = new RequestInfoDataSource.LocalDataSource.2(this, string, f2);
            this.disk.load(anon);
        }
    }

    public static class Network implements zendesk.support.requestlist.RequestInfoDataSource {

        private final RequestProvider requestProvider;
        Network(RequestProvider requestProvider) {
            super();
            this.requestProvider = requestProvider;
        }

        static zendesk.support.requestlist.RequestInfo access$500(zendesk.support.requestlist.RequestInfoDataSource.Network requestInfoDataSource$Network, Request request2, boolean z3) {
            return network.map(request2, z3);
        }

        static RequestProvider access$600(zendesk.support.requestlist.RequestInfoDataSource.Network requestInfoDataSource$Network) {
            return network.requestProvider;
        }

        private zendesk.support.requestlist.RequestInfo map(Request request, boolean z2) {
            final zendesk.support.requestlist.RequestInfoDataSource.Network request2 = this;
            Comment firstComment = request.getFirstComment();
            Comment lastComment = request.getLastComment();
            RequestInfoDataSource.Network.2 anon = new RequestInfoDataSource.Network.2(this);
            RequestInfoDataSource.Network.3 anon2 = new RequestInfoDataSource.Network.3(this);
            RequestInfo.MessageInfo messageInfo = new RequestInfo.MessageInfo(String.valueOf(firstComment.getId()), firstComment.getCreatedAt(), firstComment.getBody());
            RequestInfo.MessageInfo messageInfo2 = new RequestInfo.MessageInfo(String.valueOf(lastComment.getId()), lastComment.getCreatedAt(), lastComment.getBody());
            HashSet hashSet = new HashSet();
            super("", request.getId(), request.getStatus(), z2, request.getPublicUpdatedAt(), a.k(a.f(request.getLastCommentingAgents(), anon), anon2), messageInfo, messageInfo2, hashSet);
            return requestInfo;
        }

        public void load(f<List<zendesk.support.requestlist.RequestInfo>> f) {
            RequestInfoDataSource.Network.1 anon = new RequestInfoDataSource.Network.1(this, f);
            this.requestProvider.getAllRequests(anon);
        }
    }

    public static class RemoteDataSource implements zendesk.support.requestlist.RequestInfoDataSource {

        private final zendesk.support.requestlist.RequestInfoDataSource.Disk disk;
        private final zendesk.support.requestlist.RequestInfoDataSource.Network network;
        RemoteDataSource(zendesk.support.requestlist.RequestInfoDataSource.Network requestInfoDataSource$Network, zendesk.support.requestlist.RequestInfoDataSource.Disk requestInfoDataSource$Disk2) {
            super();
            this.network = network;
            this.disk = disk2;
        }

        static zendesk.support.requestlist.RequestInfoDataSource.Disk access$700(zendesk.support.requestlist.RequestInfoDataSource.RemoteDataSource requestInfoDataSource$RemoteDataSource) {
            return remoteDataSource.disk;
        }

        public void load(f<List<zendesk.support.requestlist.RequestInfo>> f) {
            RequestInfoDataSource.RemoteDataSource.1 anon = new RequestInfoDataSource.RemoteDataSource.1(this, f);
            this.network.load(anon);
        }
    }

    public static class Repository implements zendesk.support.requestlist.RequestInfoDataSource {

        private final zendesk.support.requestlist.RequestInfoDataSource localDataSource;
        private final zendesk.support.requestlist.RequestInfoMerger merger;
        private final zendesk.support.requestlist.RequestInfoDataSource remoteDataSource;
        Repository(zendesk.support.requestlist.RequestInfoDataSource requestInfoDataSource, zendesk.support.requestlist.RequestInfoDataSource requestInfoDataSource2, zendesk.support.requestlist.RequestInfoMerger requestInfoMerger3) {
            super();
            this.localDataSource = requestInfoDataSource;
            this.remoteDataSource = requestInfoDataSource2;
            this.merger = requestInfoMerger3;
        }

        static zendesk.support.requestlist.RequestInfoMerger access$000(zendesk.support.requestlist.RequestInfoDataSource.Repository requestInfoDataSource$Repository) {
            return repository.merger;
        }

        static zendesk.support.requestlist.RequestInfoDataSource access$100(zendesk.support.requestlist.RequestInfoDataSource.Repository requestInfoDataSource$Repository) {
            return repository.remoteDataSource;
        }

        public void load(f<List<zendesk.support.requestlist.RequestInfo>> f) {
            RequestInfoDataSource.Repository.1 anon = new RequestInfoDataSource.Repository.1(this, f);
            this.localDataSource.load(anon);
        }
    }
    public abstract void load(f<List<zendesk.support.requestlist.RequestInfo>> f);
}
