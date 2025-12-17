package app.dogo.com.dogo_android.repository.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\u0008\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0008\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickListData;", "", "dogId", "", "section", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "trickList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "shouldShowWorkoutUnlocked", "", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Ljava/util/List;Z)V", "getDogId", "()Ljava/lang/String;", "getSection", "()Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "getShouldShowWorkoutUnlocked", "()Z", "getTrickList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickListData {

    private final String dogId;
    private final app.dogo.com.dogo_android.repository.domain.LibrarySection section;
    private final boolean shouldShowWorkoutUnlocked;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem> trickList;
    public TrickListData(String string, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection2, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list3, boolean z4) {
        n.f(string, "dogId");
        super();
        this.dogId = string;
        this.section = librarySection2;
        this.trickList = list3;
        this.shouldShowWorkoutUnlocked = z4;
    }

    public TrickListData(String string, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection2, List list3, boolean z4, int i5, g g6) {
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? 0 : obj5;
        super(string, obj3, obj4, obj5);
    }

    public static app.dogo.com.dogo_android.repository.domain.TrickListData copy$default(app.dogo.com.dogo_android.repository.domain.TrickListData trickListData, String string2, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection3, List list4, boolean z5, int i6, Object object7) {
        String obj1;
        app.dogo.com.dogo_android.repository.domain.LibrarySection obj2;
        List obj3;
        boolean obj4;
        if (i6 & 1 != 0) {
            obj1 = trickListData.dogId;
        }
        if (i6 & 2 != 0) {
            obj2 = trickListData.section;
        }
        if (i6 & 4 != 0) {
            obj3 = trickListData.trickList;
        }
        if (i6 &= 8 != 0) {
            obj4 = trickListData.shouldShowWorkoutUnlocked;
        }
        return trickListData.copy(obj1, obj2, obj3, obj4);
    }

    public final String component1() {
        return this.dogId;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection component2() {
        return this.section;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> component3() {
        return this.trickList;
    }

    public final boolean component4() {
        return this.shouldShowWorkoutUnlocked;
    }

    public final app.dogo.com.dogo_android.repository.domain.TrickListData copy(String string, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection2, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list3, boolean z4) {
        n.f(string, "dogId");
        TrickListData trickListData = new TrickListData(string, librarySection2, list3, z4);
        return trickListData;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof TrickListData == null) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.section, object.section)) {
            return i2;
        }
        if (!n.b(this.trickList, object.trickList)) {
            return i2;
        }
        if (this.shouldShowWorkoutUnlocked != object.shouldShowWorkoutUnlocked) {
            return i2;
        }
        return i;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection getSection() {
        return this.section;
    }

    public final boolean getShouldShowWorkoutUnlocked() {
        return this.shouldShowWorkoutUnlocked;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> getTrickList() {
        return this.trickList;
    }

    public int hashCode() {
        int i;
        boolean shouldShowWorkoutUnlocked;
        int i2;
        app.dogo.com.dogo_android.repository.domain.LibrarySection section = this.section;
        if (section == null) {
            i = i2;
        } else {
            i = section.hashCode();
        }
        List trickList = this.trickList;
        if (trickList == null) {
        } else {
            i2 = trickList.hashCode();
        }
        if (this.shouldShowWorkoutUnlocked) {
            shouldShowWorkoutUnlocked = 1;
        }
        return i8 += shouldShowWorkoutUnlocked;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickListData(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", section=");
        stringBuilder.append(this.section);
        stringBuilder.append(", trickList=");
        stringBuilder.append(this.trickList);
        stringBuilder.append(", shouldShowWorkoutUnlocked=");
        stringBuilder.append(this.shouldShowWorkoutUnlocked);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
