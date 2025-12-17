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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/ExperimentInteractor;", "", "remoteConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "(Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;)V", "getExperimentVariationsForTracking", "", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h2 {

    public static final app.dogo.com.dogo_android.s.a.h2.a Companion;
    private final FirebaseRemoteConfig a;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/ExperimentInteractor$Companion;", "", "()V", "KEY_PREFIX", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        h2.a aVar = new h2.a(0);
        h2.Companion = aVar;
    }

    public h2(FirebaseRemoteConfig firebaseRemoteConfig) {
        n.f(firebaseRemoteConfig, "remoteConfig");
        super();
        this.a = firebaseRemoteConfig;
    }

    public final List<String> a() {
        int string2;
        int string;
        boolean stringBuilder;
        String str;
        FirebaseRemoteConfig firebaseRemoteConfig;
        String str2;
        int i;
        int i2;
        int i3;
        o oVar;
        java.util.Set keysByPrefix = this.a.getKeysByPrefix("android_experiment_");
        n.e(keysByPrefix, "remoteConfig.getKeysByPrefix(KEY_PREFIX)");
        List list = p.U(keysByPrefix);
        int i4 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(list, i4));
        Iterator iterator = list.iterator();
        for (String next3 : iterator) {
            oVar = new o(l.G(next3, "android_experiment_", "", false, 4, 0), this.a.getString(next3));
            arrayList2.add(oVar);
        }
        ArrayList arrayList = new ArrayList(p.r(arrayList2, i4));
        Iterator iterator2 = arrayList2.iterator();
        while (iterator2.hasNext()) {
            Object next2 = iterator2.next();
            if (n.b((o)next2.d(), "Original")) {
            } else {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)next2.c());
            stringBuilder.append(':');
            stringBuilder.append((String)next2.d());
            string2 = stringBuilder.toString();
            arrayList.add(string2);
            string2 = n.o((String)next2.c(), ":O");
        }
        return arrayList;
    }
}
