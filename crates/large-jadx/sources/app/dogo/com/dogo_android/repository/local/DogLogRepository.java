package app.dogo.com.dogo_android.s.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.android.network.DogoApiClient;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.externalmodel.model.DogLogModel;
import app.dogo.externalmodel.model.requests.AddDogLogRequest;
import app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog;
import app.dogo.externalmodel.model.requests.UpdateDogLogRequest;
import app.dogo.externalmodel.model.responses.DogLogResponse;
import i.b.a0;
import i.b.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;

/* compiled from: DogLogRepository.kt */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000  2\u00020\u0001:\u0002 !B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\u0008\u0012\u0004\u0012\u00020\u0013`\u0014J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bJ$\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u00182\u0006\u0010\u0010\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000b2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0008J.\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\u0008\u0012\u0004\u0012\u00020\u0013`\u0014J\u001e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000b2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0002R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;", "", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/Utilities;)V", "cachedDogLogs", "", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository$DogLogEntity;", "currentlyCachedDogId", "", "lastUpdateTimeMs", "", "addDogLog", "Lio/reactivex/Completable;", "dogId", "logs", "Ljava/util/ArrayList;", "Lapp/dogo/externalmodel/model/requests/AddDogLogRequest$DogLog;", "Lkotlin/collections/ArrayList;", "deleteDogLog", "logId", "getDogLogs", "Lio/reactivex/Single;", "forceRemote", "", "updateCache", "", "Lapp/dogo/externalmodel/model/DogLogModel;", "updateDogLog", "updateEntityCache", "Companion", "DogLogEntity", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f1, reason: from kotlin metadata */
public final class DogLogRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final f1.a INSTANCE = new f1$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final DogoApiClient cachedDogLogs;
    /* renamed from: b, reason: from kotlin metadata */
    private final v2 currentlyCachedDogId;
    /* renamed from: c, reason: from kotlin metadata */
    private long dogoApiClient;
    /* renamed from: d, reason: from kotlin metadata */
    private String lastUpdateTimeMs = "";
    /* renamed from: e, reason: from kotlin metadata */
    private List<f1.b> utilities;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogRepository$Companion;", "", "()V", "CACHE_LIFE_SPAN_MS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogRepository$DogLogEntity;", "Landroid/os/Parcelable;", "logId", "", "dogId", "dogLogType", "eventTimeMs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDogId", "()Ljava/lang/String;", "getDogLogType", "getEventTimeMs", "()J", "getLogId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements Parcelable {

        public static final Parcelable.Creator<f1.b> CREATOR = new f1$b$a<>();
        /* renamed from: a, reason: from kotlin metadata */
        private final String dogId;
        /* renamed from: b, reason: from kotlin metadata */
        private final String dogLogType;
        private final String c;
        private final long v;
        public b(String str, String str2, String str3, long j) {
            n.f(str, "logId");
            n.f(str2, "dogId");
            n.f(str3, "dogLogType");
            super();
            this.dogId = str;
            this.dogLogType = str2;
            this.c = str3;
            this.v = j;
        }

        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final String component1() {
            return this.dogLogType;
        }

        public final String b() {
            return this.c;
        }

        public final long c() {
            return this.v;
        }

        public final String d() {
            return this.dogId;
        }


        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z6 = false;
            if (!(other instanceof DogLogRepository_DogLogEntity)) {
                return false;
            }
            if (!n.b(this.dogId, other.dogId)) {
                return false;
            }
            if (!n.b(this.dogLogType, other.dogLogType)) {
                return false;
            }
            if (!n.b(this.c, other.c)) {
                return false;
            }
            return this.v != other.v ? z6 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.dogId.hashCode() * 31) + this.dogLogType.hashCode() * 31 + this.c.hashCode() * 31 + Long.hashCode(this.v);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "DogLogEntity(logId=";
            String str3 = ", dogId=";
            String str4 = ", dogLogType=";
            String str6 = ", eventTimeMs=";
            str = str2 + this.dogId + str3 + this.dogLogType + str4 + this.c + str6 + this.v + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.dogId);
            parcel.writeString(this.dogLogType);
            parcel.writeString(this.c);
            parcel.writeLong(this.v);
        }
    }
    public f1(DogoApiClient dogoApiClient, v2 v2Var) {
        n.f(dogoApiClient, "dogoApiClient");
        n.f(v2Var, "utilities");
        super();
        this.cachedDogLogs = dogoApiClient;
        this.currentlyCachedDogId = v2Var;
        this.utilities = p.g();
    }

    /* renamed from: b, reason: from kotlin metadata */
    private static final w updateDogLog(f1 dogId, String logId, DogLogResponse logs) {
        n.f(dogId, "this$0");
        n.f(logId, "$dogId");
        n.f(logs, "response");
        dogId.updateEntityCache(logId, logs.getLogs());
        return w.a;
    }

    private static final w d(f1 f1Var, String str, DogLogResponse dogLogResponse) {
        n.f(f1Var, "this$0");
        n.f(str, "$dogId");
        n.f(dogLogResponse, "response");
        f1Var.updateEntityCache(str, dogLogResponse.getLogs());
        return w.a;
    }

    private static final List f(f1 f1Var, String str, DogLogResponse dogLogResponse) {
        n.f(f1Var, "this$0");
        n.f(str, "$dogId");
        n.f(dogLogResponse, "response");
        f1Var.updateEntityCache(str, dogLogResponse.getLogs());
        return f1Var.utilities;
    }

    private static final w m(f1 f1Var, String str, DogLogResponse dogLogResponse) {
        n.f(f1Var, "this$0");
        n.f(str, "$dogId");
        n.f(dogLogResponse, "response");
        f1Var.updateEntityCache(str, dogLogResponse.getLogs());
        return w.a;
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final void addDogLog(String dogId, List<f1.b> logs) {
        this.utilities = logs;
        this.lastUpdateTimeMs = dogId;
        this.dogoApiClient = this.currentlyCachedDogId.g();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final b deleteDogLog(String dogId, ArrayList<AddDogLogRequest.DogLog> logId) {
        n.f(dogId, "dogId");
        n.f(logId, "logs");
        b ignoreElement = this.cachedDogLogs.saveDogLogSingle(dogId, new AddDogLogRequest(logId)).map(new app.dogo.com.dogo_android.repository.local.h(this, dogId)).ignoreElement();
        n.e(ignoreElement, "dogoApiClient.saveDogLogSingle(dogId, AddDogLogRequest(logs)).map { response ->\n            updateCache(dogId, response.logs)\n        }.ignoreElement()");
        return ignoreElement;
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final b getDogLogs(String dogId, String forceRemote) {
        n.f(dogId, "dogId");
        n.f(forceRemote, "logId");
        b ignoreElement = this.cachedDogLogs.removeDogLog(dogId, forceRemote).map(new app.dogo.com.dogo_android.repository.local.g(this, dogId)).ignoreElement();
        n.e(ignoreElement, "dogoApiClient.removeDogLog(dogId, logId).map { response ->\n            updateCache(dogId, response.logs)\n        }.ignoreElement()");
        return ignoreElement;
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final a0<List<f1.b>> updateCache(String dogId, boolean logs) {
        int i = 0;
        a0 just;
        n.f(dogId, "dogId");
        long l2 = this.currentlyCachedDogId.g() - this.dogoApiClient;
        i = 1;
        int r0 = this.currentlyCachedDogId > 1800000 ? i : 0;
        if (this.currentlyCachedDogId != 0 || !(i ^ n.b(dogId, this.lastUpdateTimeMs) != 0 && !logs)) {
            str = "{\n            dogoApiClient.getDogLogSingle(dogId).map { response ->\n                updateCache(dogId, response.logs)\n                cachedDogLogs\n            }\n        }";
            n.e(this.cachedDogLogs.getDogLogSingle(dogId).map(new app.dogo.com.dogo_android.repository.local.f(this, dogId)), str);
        }
        return just;
    }

    /* renamed from: k, reason: from kotlin metadata */
    public final void updateEntityCache(String dogId, List<DogLogModel> logs) {
        n.f(dogId, "dogId");
        n.f(logs, "logs");
        ArrayList arrayList = new ArrayList(p.r(logs, 10));
        final Iterator it = logs.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            DogLogRepository_DogLogEntity dogLogRepository_DogLogEntity = new DogLogRepository_DogLogEntity(item.getId(), item.getDogId(), item.getType(), item.getEventTimeMs(), obj);
            arrayList.add(dogLogRepository_DogLogEntity);
        }
        addDogLog(dogId, arrayList);
    }

    public final b l(String str, String str2, ArrayList<AddDogLogRequest.DogLog> arrayList) {
        n.f(str, "dogId");
        n.f(str2, "logId");
        n.f(arrayList, "logs");
        b ignoreElement = this.cachedDogLogs.updateDogLogSingle(str, str2, new UpdateDogLogRequest((AddDogLogRequest_DogLog)p.X(arrayList).getType(), (AddDogLogRequest_DogLog)p.X(arrayList).getEventTimeMs(), r4)).map(new app.dogo.com.dogo_android.repository.local.i(this, str)).ignoreElement();
        n.e(ignoreElement, "dogoApiClient.updateDogLogSingle(\n            dogId,\n            logId,\n            UpdateDogLogRequest(type = logs.first().type, eventTimeMs = logs.first().eventTimeMs)\n        ).map { response ->\n            updateCache(dogId, response.logs)\n        }.ignoreElement()");
        return ignoreElement;
    }


    public static /* synthetic */ List g(f1 f1Var, String str, DogLogResponse dogLogResponse) {
        return DogLogRepository.f(f1Var, str, dogLogResponse);
    }

    public static /* synthetic */ w h(f1 f1Var, String str, DogLogResponse dogLogResponse) {
        return DogLogRepository.d(f1Var, str, dogLogResponse);
    }

    public static /* synthetic */ w i(f1 f1Var, String str, DogLogResponse dogLogResponse) {
        return DogLogRepository.updateDogLog(f1Var, str, dogLogResponse);
    }

    public static /* synthetic */ w j(f1 f1Var, String str, DogLogResponse dogLogResponse) {
        return DogLogRepository.m(f1Var, str, dogLogResponse);
    }
}
