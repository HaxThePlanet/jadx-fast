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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0008\u0010\u0008\u001a\u00020\u0000H&\u0082\u0001\u0002\u000b\u000c¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "Landroid/os/Parcelable;", "()V", "getCurrentTrick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getNextTrick", "getProgramInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "rotateTricks", "LibraryPlan", "ProgramPlan", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$LibraryPlan;", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$ProgramPlan;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class n implements Parcelable {

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\u0008\u0010\u000f\u001a\u00020\u0003H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\u0008\u0010\u0014\u001a\u00020\u0000H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$LibraryPlan;", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;)V", "getTrickItem", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "getCurrentTrick", "getNextTrick", "getProgramInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "hashCode", "rotateTricks", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends app.dogo.com.dogo_android.n.m.n {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.n.m.n.a> CREATOR;
        private final TrickItem a;
        static {
            n.a.a aVar = new n.a.a();
            n.a.CREATOR = aVar;
        }

        public a(TrickItem trickItem) {
            n.f(trickItem, "trickItem");
            super(0);
            this.a = trickItem;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public TrickItem a() {
            return this.a;
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
        public app.dogo.com.dogo_android.n.m.n d() {
            e();
            return this;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public int describeContents() {
            return 0;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public app.dogo.com.dogo_android.n.m.n.a e() {
            return this;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof n.a) {
                return i2;
            }
            if (!n.b(this.a, object.a)) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LibraryPlan(trickItem=");
            stringBuilder.append(this.a);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            this.a.writeToParcel(parcel, i2);
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0014\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B9\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\u000cJ\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\t\u0010\u001c\u001a\u00020\u0008HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\n\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J\u0008\u0010\"\u001a\u00020\u0006H\u0016J\t\u0010#\u001a\u00020\u0008HÖ\u0001J\u0008\u0010$\u001a\u00020\u0000H\u0016J\t\u0010%\u001a\u00020&HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$ProgramPlan;", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "trickItems", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSafeInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "currentTrickIndex", "", "newTraining", "", "firstLessonFlow", "(Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;IZZ)V", "getCurrentTrickIndex", "()I", "getFirstLessonFlow", "()Z", "getNewTraining", "getProgramSafeInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTrickItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "getCurrentTrick", "getNextTrick", "getProgramInfo", "hashCode", "rotateTricks", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends app.dogo.com.dogo_android.n.m.n {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.n.m.n.b> CREATOR;
        private final List<TrickItem> a;
        private final ProgramSaveInfo b;
        private final int c;
        private final boolean v;
        private final boolean w;
        static {
            n.b.a aVar = new n.b.a();
            n.b.CREATOR = aVar;
        }

        public b(List<TrickItem> list, ProgramSaveInfo programSaveInfo2, int i3, boolean z4, boolean z5) {
            n.f(list, "trickItems");
            n.f(programSaveInfo2, "programSafeInfo");
            super(0);
            this.a = list;
            this.b = programSaveInfo2;
            this.c = i3;
            this.v = z4;
            this.w = z5;
        }

        public b(List list, ProgramSaveInfo programSaveInfo2, int i3, boolean z4, boolean z5, int i6, g g7) {
            int i2;
            int i;
            int obj10;
            int obj11;
            final int i4 = 0;
            i2 = i6 & 4 != 0 ? i4 : i3;
            if (i6 & 8 != 0) {
                if (list instanceof Collection != null && list.isEmpty()) {
                    if (list.isEmpty()) {
                        obj11 = i4;
                    } else {
                        obj10 = list.iterator();
                        for (TrickItem obj11 : obj10) {
                        }
                    }
                } else {
                }
            }
            i = i6 & 16 != 0 ? i4 : z5;
            super(list, programSaveInfo2, i2, obj11, i);
        }

        public static app.dogo.com.dogo_android.n.m.n.b f(app.dogo.com.dogo_android.n.m.n.b n$b, List list2, ProgramSaveInfo programSaveInfo3, int i4, boolean z5, boolean z6, int i7, Object object8) {
            List obj4;
            ProgramSaveInfo obj5;
            int obj6;
            boolean obj7;
            boolean obj8;
            if (i7 & 1 != 0) {
                obj4 = b.a;
            }
            if (i7 & 2 != 0) {
                obj5 = b.b;
            }
            if (i7 & 4 != 0) {
                obj6 = b.c;
            }
            if (i7 & 8 != 0) {
                obj7 = b.v;
            }
            if (i7 & 16 != 0) {
                obj8 = b.w;
            }
            return b.e(obj4, obj5, obj6, obj7, obj8);
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public TrickItem a() {
            return (TrickItem)p.a0(this.a, this.c);
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public TrickItem b() {
            return (TrickItem)p.a0(this.a, i++);
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public ProgramSaveInfo c() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public app.dogo.com.dogo_android.n.m.n d() {
            return i();
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public int describeContents() {
            return 0;
        }

        public final app.dogo.com.dogo_android.n.m.n.b e(List<TrickItem> list, ProgramSaveInfo programSaveInfo2, int i3, boolean z4, boolean z5) {
            n.f(list, "trickItems");
            n.f(programSaveInfo2, "programSafeInfo");
            super(list, programSaveInfo2, i3, z4, z5);
            return bVar;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof n.b) {
                return i3;
            }
            if (!n.b(this.a, object.a)) {
                return i3;
            }
            if (!n.b(this.b, object.b)) {
                return i3;
            }
            if (this.c != object.c) {
                return i3;
            }
            if (this.v != object.v) {
                return i3;
            }
            if (this.w != object.w) {
                return i3;
            }
            return i;
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
        public int hashCode() {
            boolean z;
            int i;
            if (this.v) {
                z = i;
            }
            boolean z2 = this.w;
            if (z2) {
            } else {
                i = z2;
            }
            return i9 += i;
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public app.dogo.com.dogo_android.n.m.n.b i() {
            int i;
            i = this.c < p.i(this.a) ? i3 + 1 : 0;
            return n.b.f(this, 0, 0, i, false, false, 27, 0);
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ProgramPlan(trickItems=");
            stringBuilder.append(this.a);
            stringBuilder.append(", programSafeInfo=");
            stringBuilder.append(this.b);
            stringBuilder.append(", currentTrickIndex=");
            stringBuilder.append(this.c);
            stringBuilder.append(", newTraining=");
            stringBuilder.append(this.v);
            stringBuilder.append(", firstLessonFlow=");
            stringBuilder.append(this.w);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // app.dogo.com.dogo_android.n.m.n
        public void writeToParcel(Parcel parcel, int i2) {
            int size;
            n.f(parcel, "out");
            List list = this.a;
            parcel.writeInt(list.size());
            Iterator iterator = list.iterator();
            for (TrickItem size : iterator) {
                size.writeToParcel(parcel, i2);
            }
            this.b.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
            parcel.writeInt(this.v);
            parcel.writeInt(this.w);
        }
    }
    public n(g g) {
        super();
    }

    @Override // android.os.Parcelable
    public abstract TrickItem a();

    @Override // android.os.Parcelable
    public abstract TrickItem b();

    @Override // android.os.Parcelable
    public abstract ProgramSaveInfo c();

    @Override // android.os.Parcelable
    public abstract app.dogo.com.dogo_android.n.m.n d();
}
