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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000  2\u00020\u0001:\u0002 !B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\u0008\u0012\u0004\u0012\u00020\u0013`\u0014J\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bJ$\u0010\u0017\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u00182\u0006\u0010\u0010\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000b2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0008J.\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\u0008\u0012\u0004\u0012\u00020\u0013`\u0014J\u001e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000b2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0002R\u0014\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;", "", "dogoApiClient", "Lapp/dogo/android/network/DogoApiClient;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/Utilities;)V", "cachedDogLogs", "", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository$DogLogEntity;", "currentlyCachedDogId", "", "lastUpdateTimeMs", "", "addDogLog", "Lio/reactivex/Completable;", "dogId", "logs", "Ljava/util/ArrayList;", "Lapp/dogo/externalmodel/model/requests/AddDogLogRequest$DogLog;", "Lkotlin/collections/ArrayList;", "deleteDogLog", "logId", "getDogLogs", "Lio/reactivex/Single;", "forceRemote", "", "updateCache", "", "Lapp/dogo/externalmodel/model/DogLogModel;", "updateDogLog", "updateEntityCache", "Companion", "DogLogEntity", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f1 {

    public static final app.dogo.com.dogo_android.s.b.f1.a Companion;
    private final DogoApiClient a;
    private final v2 b;
    private long c;
    private String d;
    private List<app.dogo.com.dogo_android.s.b.f1.b> e;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogRepository$Companion;", "", "()V", "CACHE_LIFE_SPAN_MS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/local/DogLogRepository$DogLogEntity;", "Landroid/os/Parcelable;", "logId", "", "dogId", "dogLogType", "eventTimeMs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDogId", "()Ljava/lang/String;", "getDogLogType", "getEventTimeMs", "()J", "getLogId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.s.b.f1.b> CREATOR;
        private final String a;
        private final String b;
        private final String c;
        private final long v;
        static {
            f1.b.a aVar = new f1.b.a();
            f1.b.CREATOR = aVar;
        }

        public b(String string, String string2, String string3, long l4) {
            n.f(string, "logId");
            n.f(string2, "dogId");
            n.f(string3, "dogLogType");
            super();
            this.a = string;
            this.b = string2;
            this.c = string3;
            this.v = l4;
        }

        @Override // android.os.Parcelable
        public final String a() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public final String b() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public final long c() {
            return this.v;
        }

        @Override // android.os.Parcelable
        public final String d() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof f1.b) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            if (!n.b(this.c, object.c)) {
                return i2;
            }
            if (Long.compare(l, l2) != 0) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i6 += i10;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DogLogEntity(logId=");
            stringBuilder.append(this.a);
            stringBuilder.append(", dogId=");
            stringBuilder.append(this.b);
            stringBuilder.append(", dogLogType=");
            stringBuilder.append(this.c);
            stringBuilder.append(", eventTimeMs=");
            stringBuilder.append(this.v);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeLong(this.v);
        }
    }
    static {
        f1.a aVar = new f1.a(0);
        f1.Companion = aVar;
    }

    public f1(DogoApiClient dogoApiClient, v2 v22) {
        n.f(dogoApiClient, "dogoApiClient");
        n.f(v22, "utilities");
        super();
        this.a = dogoApiClient;
        this.b = v22;
        this.d = "";
        this.e = p.g();
    }

    private static final w b(app.dogo.com.dogo_android.s.b.f1 f1, String string2, DogLogResponse dogLogResponse3) {
        n.f(f1, "this$0");
        n.f(string2, "$dogId");
        n.f(dogLogResponse3, "response");
        f1.k(string2, dogLogResponse3.getLogs());
        return w.a;
    }

    private static final w d(app.dogo.com.dogo_android.s.b.f1 f1, String string2, DogLogResponse dogLogResponse3) {
        n.f(f1, "this$0");
        n.f(string2, "$dogId");
        n.f(dogLogResponse3, "response");
        f1.k(string2, dogLogResponse3.getLogs());
        return w.a;
    }

    private static final List f(app.dogo.com.dogo_android.s.b.f1 f1, String string2, DogLogResponse dogLogResponse3) {
        n.f(f1, "this$0");
        n.f(string2, "$dogId");
        n.f(dogLogResponse3, "response");
        f1.k(string2, dogLogResponse3.getLogs());
        return f1.e;
    }

    public static List g(app.dogo.com.dogo_android.s.b.f1 f1, String string2, DogLogResponse dogLogResponse3) {
        return f1.f(f1, string2, dogLogResponse3);
    }

    public static w h(app.dogo.com.dogo_android.s.b.f1 f1, String string2, DogLogResponse dogLogResponse3) {
        return f1.d(f1, string2, dogLogResponse3);
    }

    public static w i(app.dogo.com.dogo_android.s.b.f1 f1, String string2, DogLogResponse dogLogResponse3) {
        return f1.b(f1, string2, dogLogResponse3);
    }

    public static w j(app.dogo.com.dogo_android.s.b.f1 f1, String string2, DogLogResponse dogLogResponse3) {
        return f1.m(f1, string2, dogLogResponse3);
    }

    private static final w m(app.dogo.com.dogo_android.s.b.f1 f1, String string2, DogLogResponse dogLogResponse3) {
        n.f(f1, "this$0");
        n.f(string2, "$dogId");
        n.f(dogLogResponse3, "response");
        f1.k(string2, dogLogResponse3.getLogs());
        return w.a;
    }

    private final void n(String string, List<app.dogo.com.dogo_android.s.b.f1.b> list2) {
        this.e = list2;
        this.d = string;
        this.c = this.b.g();
    }

    public final b a(String string, ArrayList<AddDogLogRequest.DogLog> arrayList2) {
        n.f(string, "dogId");
        n.f(arrayList2, "logs");
        AddDogLogRequest addDogLogRequest = new AddDogLogRequest(arrayList2);
        h hVar = new h(this, string);
        b obj3 = this.a.saveDogLogSingle(string, addDogLogRequest).map(hVar).ignoreElement();
        n.e(obj3, "dogoApiClient.saveDogLogSingle(dogId, AddDogLogRequest(logs)).map { response ->\n            updateCache(dogId, response.logs)\n        }.ignoreElement()");
        return obj3;
    }

    public final b c(String string, String string2) {
        n.f(string, "dogId");
        n.f(string2, "logId");
        g gVar = new g(this, string);
        b obj2 = this.a.removeDogLog(string, string2).map(gVar).ignoreElement();
        n.e(obj2, "dogoApiClient.removeDogLog(dogId, logId).map { response ->\n            updateCache(dogId, response.logs)\n        }.ignoreElement()");
        return obj2;
    }

    public final a0<List<app.dogo.com.dogo_android.s.b.f1.b>> e(String string, boolean z2) {
        int fVar;
        a0 obj5;
        String obj6;
        n.f(string, "dogId");
        int i2 = 1;
        fVar = Long.compare(i, i4) > 0 ? i2 : 0;
        if (fVar == 0 && i2 ^= z == 0) {
            if (i2 ^= z == 0) {
                if (z2) {
                    fVar = new f(this, string);
                    n.e(this.a.getDogLogSingle(string).map(fVar), "{\n            dogoApiClient.getDogLogSingle(dogId).map { response ->\n                updateCache(dogId, response.logs)\n                cachedDogLogs\n            }\n        }");
                } else {
                    n.e(a0.just(this.e), "{\n            Single.just(cachedDogLogs)\n        }");
                }
            } else {
            }
        } else {
        }
        return obj5;
    }

    public final void k(String string, List<DogLogModel> list2) {
        int next;
        app.dogo.com.dogo_android.s.b.f1.b bVar2;
        String str;
        String dogId;
        String type;
        long eventTimeMs;
        app.dogo.com.dogo_android.s.b.f1.b bVar;
        n.f(string, "dogId");
        n.f(list2, "logs");
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        final Iterator obj11 = list2.iterator();
        for (DogLogModel next : obj11) {
            super(next.getId(), next.getDogId(), next.getType(), next.getEventTimeMs(), obj7);
            arrayList.add(bVar);
        }
        n(string, arrayList);
    }

    public final b l(String string, String string2, ArrayList<AddDogLogRequest.DogLog> arrayList3) {
        n.f(string, "dogId");
        n.f(string2, "logId");
        n.f(arrayList3, "logs");
        UpdateDogLogRequest updateDogLogRequest = new UpdateDogLogRequest((AddDogLogRequest.DogLog)p.X(arrayList3).getType(), (AddDogLogRequest.DogLog)p.X(arrayList3).getEventTimeMs(), obj4);
        i obj8 = new i(this, string);
        b obj6 = this.a.updateDogLogSingle(string, string2, updateDogLogRequest).map(obj8).ignoreElement();
        n.e(obj6, "dogoApiClient.updateDogLogSingle(\n            dogId,\n            logId,\n            UpdateDogLogRequest(type = logs.first().type, eventTimeMs = logs.first().eventTimeMs)\n        ).map { response ->\n            updateCache(dogId, response.logs)\n        }.ignoreElement()");
        return obj6;
    }
}
