package app.dogo.com.dogo_android.n.m;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: TrickDetailsPlan.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0008\u0010\u0008\u001a\u00020\u0000H&\u0082\u0001\u0002\u000b\u000c¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "Landroid/os/Parcelable;", "()V", "getCurrentTrick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getNextTrick", "getProgramInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "rotateTricks", "LibraryPlan", "ProgramPlan", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$LibraryPlan;", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$ProgramPlan;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public abstract /* sealed */ class TrickDetailsPlan implements Parcelable {

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\u0008\u0010\u000f\u001a\u00020\u0003H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\u0008\u0010\u0014\u001a\u00020\u0000H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$LibraryPlan;", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;)V", "getTrickItem", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getCurrentTrick", "getNextTrick", "getProgramInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "hashCode", "rotateTricks", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends n {

        public static final Parcelable.Creator<n.a> CREATOR = new n$a$a<>();
        /* renamed from: a, reason: from kotlin metadata */
        private final TrickItem trickItem;
        public a(TrickItem trickItem) {
            n.f(trickItem, "trickItem");
            super(null);
            this.trickItem = trickItem;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public TrickItem component1() {
            return this.trickItem;
        }


        @Override // app.dogo.com.dogo_android.n.m.n
        public TrickItem b() {
            return null;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public ProgramSaveInfo c() {
            return null;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public int describeContents() {
            return 0;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public n.a e() {
            return this;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof TrickDetailsPlan_LibraryPlan)) {
                return false;
            }
            return !n.b(this.trickItem, other.trickItem) ? z3 : z;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public int hashCode() {
            return this.trickItem.hashCode();
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "LibraryPlan(trickItem=";
            str = str2 + this.trickItem + 41;
            return str;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            this.trickItem.writeToParcel(parcel, flags);
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0014\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B9\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\u000cJ\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\t\u0010\u001c\u001a\u00020\u0008HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\n\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J\u0008\u0010\"\u001a\u00020\u0006H\u0016J\t\u0010#\u001a\u00020\u0008HÖ\u0001J\u0008\u0010$\u001a\u00020\u0000H\u0016J\t\u0010%\u001a\u00020&HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$ProgramPlan;", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "trickItems", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSafeInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "currentTrickIndex", "", "newTraining", "", "firstLessonFlow", "(Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;IZZ)V", "getCurrentTrickIndex", "()I", "getFirstLessonFlow", "()Z", "getNewTraining", "getProgramSafeInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTrickItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "getCurrentTrick", "getNextTrick", "getProgramInfo", "hashCode", "rotateTricks", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends n {

        public static final Parcelable.Creator<n.b> CREATOR = new n$b$a<>();
        private final List<TrickItem> a;
        private final ProgramSaveInfo b;
        private final int c;
        private final boolean v;
        private final boolean w;
        public b(List<TrickItem> list, ProgramSaveInfo programSaveInfo, int i, boolean z, boolean z2) {
            n.f(list, "trickItems");
            n.f(programSaveInfo, "programSafeInfo");
            super(null);
            this.a = list;
            this.b = programSaveInfo;
            this.c = i;
            this.v = z;
            this.w = z2;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public TrickItem component1() {
            return (TrickItem)p.a0(this.a, this.c);
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public TrickItem b() {
            return (TrickItem)p.a0(this.a, this.c + 1);
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public ProgramSaveInfo c() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public final boolean g() {
            return this.w;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public final ProgramSaveInfo h() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public n.b i() {
            int i = 0;
            i = this.c < p.i(this.a) ? i3 + 1 : 0;
            return TrickDetailsPlan_ProgramPlan.f(this, null, null, i, false, false, 27, null);
        }

        public /* synthetic */ b(List list, ProgramSaveInfo programSaveInfo, int i, boolean z, boolean z2, int i2, g gVar) {
            int i32;
            boolean z52;
            Iterator it;
            i32 = 0;
            int r4 = i2 & 4 != 0 ? i32 : i;
            i32 = i2 & 8;
            if (i2 & 8 != 0) {
                empty = list instanceof Collection;
                z = i32;
            }
            int r6 = i2 & 16 != 0 ? i32 : z2;
            this(list, programSaveInfo, i32, i32, (i2 & 16 != 0 ? i32 : z2));
        }


        public static /* synthetic */ n.b f(n.b bVar, List list, ProgramSaveInfo programSaveInfo, int i, boolean z, boolean z2, int i2, Object object) {
            List list22;
            ProgramSaveInfo object82;
            int i42;
            boolean z52;
            boolean z62;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            if (i2 & 4 != 0) {
            }
            if (i2 & 8 != 0) {
            }
            if (i2 & 16 != 0) {
            }
            return bVar.copy(list22, object82, i42, z52, z62);
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public int describeContents() {
            return 0;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        /* renamed from: e, reason: from kotlin metadata */
        public final n.b copy(List<TrickItem> trickItems, ProgramSaveInfo programSafeInfo, int currentTrickIndex, boolean newTraining, boolean firstLessonFlow) {
            n.f(trickItems, "trickItems");
            n.f(programSafeInfo, "programSafeInfo");
            TrickDetailsPlan_ProgramPlan trickDetailsPlan_ProgramPlan = new TrickDetailsPlan_ProgramPlan(trickItems, programSafeInfo, currentTrickIndex, newTraining, firstLessonFlow);
            return trickDetailsPlan_ProgramPlan;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z7 = false;
            if (!(other instanceof TrickDetailsPlan_ProgramPlan)) {
                return false;
            }
            if (!n.b(this.a, other.a)) {
                return false;
            }
            if (!n.b(this.b, other.b)) {
                return false;
            }
            if (this.c != other.c) {
                return false;
            }
            if (this.v != other.v) {
                return false;
            }
            return this.w != other.w ? z7 : z;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public int hashCode() {
            boolean z;
            int i = 1;
            i = 1;
            if (this.v) {
            }
            if (!(this.w)) {
            }
            return (this.a.hashCode() * 31) + this.b.hashCode() * 31 + Integer.hashCode(this.c) * 31 + z * 31 + i;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ProgramPlan(trickItems=";
            String str3 = ", programSafeInfo=";
            String str4 = ", currentTrickIndex=";
            String str5 = ", newTraining=";
            String str6 = ", firstLessonFlow=";
            str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.v + str6 + this.w + 41;
            return str;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeInt(this.a.size());
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                (TrickItem)it.next().writeToParcel(parcel, flags);
            }
            this.b.writeToParcel(parcel, flags);
            parcel.writeInt(this.c);
            parcel.writeInt(this.v);
            parcel.writeInt(this.w);
        }
    }
    private n() {
        super();
    }

    public /* synthetic */ n(g gVar) {
        this();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public abstract TrickItem getCurrentTrick();

    public abstract TrickItem b();

    public abstract ProgramSaveInfo c();

    public abstract n d();
}
