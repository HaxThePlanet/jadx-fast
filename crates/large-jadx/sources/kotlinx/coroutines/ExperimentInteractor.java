package app.dogo.com.dogo_android.s.a;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.o;
import kotlin.y.p;

/* compiled from: ExperimentInteractor.kt */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/ExperimentInteractor;", "", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "(Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;)V", "getExperimentVariationsForTracking", "", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h2, reason: from kotlin metadata */
public final class ExperimentInteractor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final h2.a INSTANCE = new h2$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final FirebaseRemoteConfig remoteConfig;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/ExperimentInteractor$Companion;", "", "()V", "KEY_PREFIX", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public h2(FirebaseRemoteConfig firebaseRemoteConfig) {
        n.f(firebaseRemoteConfig, "remoteConfig");
        super();
        this.remoteConfig = firebaseRemoteConfig;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final List<String> getExperimentVariationsForTracking() {
        String str;
        boolean hasNext;
        String str2;
        java.util.Set keysByPrefix = this.remoteConfig.getKeysByPrefix("android_experiment_");
        n.e(keysByPrefix, "remoteConfig.getKeysByPrefix(KEY_PREFIX)");
        List list = p.U(keysByPrefix);
        int i4 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(list, i4));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            boolean z = false;
            int i3 = 4;
            Object obj = null;
            str3 = "";
            arrayList2.add(new Pair(l.G(item2, "android_experiment_", str3, z, i3, obj), this.remoteConfig.getString(item2)));
        }
        ArrayList arrayList = new ArrayList(p.r(arrayList2, i4));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            str2 = "Original";
            arrayList.add(str);
        }
        return arrayList;
    }

}
