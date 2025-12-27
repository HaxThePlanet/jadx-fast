package app.dogo.com.dogo_android.util.n0;

import app.dogo.com.dogo_android.k.e;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogLogSelection.kt */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection;", "", "()V", "Divider", "SelectionItem", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$SelectionItem;", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$Divider;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public abstract /* sealed */ class DogLogSelection {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$Divider;", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection;", "()V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends i {

        public static final i.a a = new i$a();
        private a() {
            super(null);
        }

    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$SelectionItem;", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection;", "type", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "(Lapp/dogo/com/dogo_android/enums/DogLogTypes;)V", "getType", "()Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends i {

        private final e a;
        public b(e eVar) {
            n.f(eVar, "type");
            super(null);
            this.a = eVar;
        }

        @Override // app.dogo.com.dogo_android.util.n0.i
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public final e component1() {
            return this.a;
        }

        @Override // app.dogo.com.dogo_android.util.n0.i
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof DogLogSelection_SelectionItem)) {
                return false;
            }
            return this.a != other.a ? z3 : z;
        }

        @Override // app.dogo.com.dogo_android.util.n0.i
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // app.dogo.com.dogo_android.util.n0.i
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "SelectionItem(type=";
            str = str2 + this.a + 41;
            return str;
        }
    }
    private i() {
        super();
    }

    public /* synthetic */ i(g gVar) {
        this();
    }
}
