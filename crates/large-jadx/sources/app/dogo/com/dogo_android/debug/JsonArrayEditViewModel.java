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

/* compiled from: JsonArrayEditViewModel.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00050\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel;", "Landroidx/lifecycle/ViewModel;", "remoteKey", "", "initialSelectionList", "", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Ljava/lang/String;Ljava/util/List;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "currentSelectionOrder", "", "getInitialSelectionList", "()Ljava/util/List;", "getRemoteKey", "()Ljava/lang/String;", "result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "getResult", "()Landroidx/lifecycle/MutableLiveData;", "selectedTricks", "", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel$SelectionRecord;", "updateRemoteConfig", "", "updateSelectedItem", "item", "SelectionRecord", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s0, reason: from kotlin metadata */
public final class JsonArrayEditViewModel extends e0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final String currentSelectionOrder;
    /* renamed from: b, reason: from kotlin metadata */
    private final List<String> initialSelectionList;
    /* renamed from: c, reason: from kotlin metadata */
    private final r2 remoteConfigService;
    private final x<List<q0>> d = new x<>();
    private final Map<String, s0.a> e = new LinkedHashMap<>();
    /* renamed from: f, reason: from kotlin metadata */
    private int selectedTricks;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000f\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel$SelectionRecord;", "", "id", "", "isSelected", "", "selectionOrder", "", "(Ljava/lang/String;ZI)V", "getId", "()Ljava/lang/String;", "()Z", "getSelectionOrder", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class a {

        private final String a;
        private final boolean b;
        private final int c;
        public a(String str, boolean z, int i) {
            n.f(str, "id");
            super();
            this.a = str;
            this.b = z;
            this.c = i;
        }

        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final String component1() {
            return this.a;
        }

        public final int b() {
            return this.c;
        }

        public final boolean c() {
            return this.b;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof JsonArrayEditViewModel_SelectionRecord)) {
                return false;
            }
            if (!n.b(this.a, other.a)) {
                return false;
            }
            if (this.b != other.b) {
                return false;
            }
            return this.c != other.c ? z5 : z;
        }

        public int hashCode() {
            boolean z = true;
            if (this.b) {
                int i8 = 1;
            }
            return (this.a.hashCode() * 31) + z * 31 + Integer.hashCode(this.c);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "SelectionRecord(id=";
            String str4 = ", isSelected=";
            String str5 = ", selectionOrder=";
            str = str2 + this.a + str4 + this.b + str5 + this.c + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(t.b()), Integer.valueOf(t2.b()));
        }
    }
    public s0(String str, List<String> list, r2 r2Var) {
        app.dogo.com.dogo_android.i.s0.a jsonArrayEditViewModel_SelectionRecord;
        int selectedTricks2;
        int i2;
        boolean r2Var32 = false;
        n.f(str, "remoteKey");
        n.f(list, "initialSelectionList");
        str2 = "remoteConfigService";
        n.f(r2Var, str2);
        super();
        this.currentSelectionOrder = str;
        this.initialSelectionList = list;
        this.remoteConfigService = r2Var;
        x xVar2 = new x();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = r2Var.F(str).iterator();
        r2Var32 = true;
        while (it.hasNext()) {
            linkedHashMap = it.next();
            this.selectedTricks++;
            this.e.put(linkedHashMap, new JsonArrayEditViewModel_SelectionRecord(linkedHashMap, r2Var32, selectedTricks2));
            r2Var32 = true;
        }
        List list3 = p.C0(this.initialSelectionList);
        ArrayList arrayList = new ArrayList(p.r(list3, 10));
        Iterator it2 = list3.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            Object value = this.e.get(item);
            int i4 = 0;
            JsonArrayEditItem jsonArrayEditItem = new JsonArrayEditItem(item, r2Var32);
            arrayList.add(jsonArrayEditItem);
        }
        this.d.postValue(arrayList);
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: h, reason: from kotlin metadata */
    public final x<List<q0>> updateRemoteConfig() {
        return this.d;
    }

    @Override // androidx.lifecycle.e0
    public final void i() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next();
        }
        List list = p.D0(linkedHashMap.values(), new app.dogo.com.dogo_android.debug.s0.b());
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add((JsonArrayEditViewModel_SelectionRecord)it2.next().component1());
        }
        this.remoteConfigService.b(this.currentSelectionOrder, arrayList);
    }

    @Override // androidx.lifecycle.e0
    /* renamed from: j, reason: from kotlin metadata */
    public final void updateSelectedItem(q0 item) {
        n.f(item, "item");
        this.selectedTricks++;
        this.e.put(item.component1(), new JsonArrayEditViewModel_SelectionRecord(item.component1(), item.b(), selectedTricks2));
    }
}
