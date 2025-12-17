package app.dogo.com.dogo_android.i;

import androidx.lifecycle.e0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.service.r2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import kotlin.z.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00050\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel;", "Landroidx/lifecycle/ViewModel;", "remoteKey", "", "initialSelectionList", "", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Ljava/lang/String;Ljava/util/List;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "currentSelectionOrder", "", "getInitialSelectionList", "()Ljava/util/List;", "getRemoteKey", "()Ljava/lang/String;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "selectedTricks", "", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel$SelectionRecord;", "updateRemoteConfig", "", "updateSelectedItem", "item", "SelectionRecord", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s0 extends e0 {

    private final String a;
    private final List<String> b;
    private final r2 c;
    private final x<List<app.dogo.com.dogo_android.i.q0>> d;
    private final Map<String, app.dogo.com.dogo_android.i.s0.a> e;
    private int f;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000f\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel$SelectionRecord;", "", "id", "", "isSelected", "", "selectionOrder", "", "(Ljava/lang/String;ZI)V", "getId", "()Ljava/lang/String;", "()Z", "getSelectionOrder", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class a {

        private final String a;
        private final boolean b;
        private final int c;
        public a(String string, boolean z2, int i3) {
            n.f(string, "id");
            super();
            this.a = string;
            this.b = z2;
            this.c = i3;
        }

        public final String a() {
            return this.a;
        }

        public final int b() {
            return this.c;
        }

        public final boolean c() {
            return this.b;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof s0.a) {
                return i3;
            }
            if (!n.b(this.a, object.a)) {
                return i3;
            }
            if (this.b != object.b) {
                return i3;
            }
            if (this.c != object.c) {
                return i3;
            }
            return i;
        }

        public int hashCode() {
            boolean z;
            if (this.b) {
                z = 1;
            }
            return i4 += i7;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SelectionRecord(id=");
            stringBuilder.append(this.a);
            stringBuilder.append(", isSelected=");
            stringBuilder.append(this.b);
            stringBuilder.append(", selectionOrder=");
            stringBuilder.append(this.c);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Comparator {
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf((s0.a)t.b()), Integer.valueOf((s0.a)t2.b()));
        }
    }
    public s0(String string, List<String> list2, r2 r23) {
        String str;
        int next;
        app.dogo.com.dogo_android.i.s0.a q0Var;
        int i2;
        int i;
        LinkedHashMap obj6;
        Object obj7;
        n.f(string, "remoteKey");
        n.f(list2, "initialSelectionList");
        n.f(r23, "remoteConfigService");
        super();
        this.a = string;
        this.b = list2;
        this.c = r23;
        obj6 = new x();
        this.d = obj6;
        obj6 = new LinkedHashMap();
        this.e = obj6;
        Iterator obj5 = r23.F(string).iterator();
        obj7 = 1;
        for (String obj6 : obj5) {
            i2 = this.f;
            this.f = i2 + 1;
            q0Var = new s0.a(obj6, obj7, i2);
            this.e.put(obj6, q0Var);
            obj7 = 1;
        }
        obj5 = p.C0(this.b);
        obj6 = new ArrayList(p.r(obj5, 10));
        obj5 = obj5.iterator();
        while (obj5.hasNext()) {
            next = obj5.next();
            i2 = this.e.get((String)next);
            i = 0;
            if ((s0.a)i2 == null) {
            } else {
            }
            if ((s0.a)i2.c() == obj7) {
            }
            q0Var = new q0(next, i);
            obj6.add(q0Var);
            i = obj7;
        }
        this.d.postValue(obj6);
    }

    public final x<List<app.dogo.com.dogo_android.i.q0>> h() {
        return this.d;
    }

    @Override // androidx.lifecycle.e0
    public final void i() {
        Object value;
        int i;
        boolean key;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = this.e.entrySet().iterator();
        while (iterator.hasNext()) {
            value = iterator.next();
            if ((s0.a)(Map.Entry)value.getValue().c()) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
        }
        s0.b bVar = new s0.b();
        List list = p.D0(linkedHashMap.values(), bVar);
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator2 = list.iterator();
        for (s0.a next3 : iterator2) {
            arrayList.add(next3.a());
        }
        this.c.b(this.a, arrayList);
    }

    @Override // androidx.lifecycle.e0
    public final void j(app.dogo.com.dogo_android.i.q0 q0) {
        n.f(q0, "item");
        final int i = this.f;
        this.f = i + 1;
        s0.a aVar = new s0.a(q0.a(), q0.b(), i);
        this.e.put(q0.a(), aVar);
    }
}
