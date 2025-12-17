package app.dogo.com.dogo_android.repository.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B#\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ,\u0010\u000f\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "", "trickList", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "scrollPosition", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getScrollPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTrickList", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lapp/dogo/com/dogo_android/repository/domain/RecentlyViewedTricks;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecentlyViewedTricks {

    private final Integer scrollPosition;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem> trickList;
    public RecentlyViewedTricks() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public RecentlyViewedTricks(List<app.dogo.com.dogo_android.repository.domain.TrickItem> list, Integer integer2) {
        super();
        this.trickList = list;
        this.scrollPosition = integer2;
    }

    public RecentlyViewedTricks(List list, Integer integer2, int i3, g g4) {
        int obj2;
        int obj3;
        final int i = 0;
        obj2 = i3 & 1 != 0 ? i : obj2;
        obj3 = i3 &= 2 != 0 ? i : obj3;
        super(obj2, obj3);
    }

    public static app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks copy$default(app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks recentlyViewedTricks, List list2, Integer integer3, int i4, Object object5) {
        List obj1;
        Integer obj2;
        if (i4 & 1 != 0) {
            obj1 = recentlyViewedTricks.trickList;
        }
        if (i4 &= 2 != 0) {
            obj2 = recentlyViewedTricks.scrollPosition;
        }
        return recentlyViewedTricks.copy(obj1, obj2);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> component1() {
        return this.trickList;
    }

    public final Integer component2() {
        return this.scrollPosition;
    }

    public final app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks copy(List<app.dogo.com.dogo_android.repository.domain.TrickItem> list, Integer integer2) {
        RecentlyViewedTricks recentlyViewedTricks = new RecentlyViewedTricks(list, integer2);
        return recentlyViewedTricks;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof RecentlyViewedTricks) {
            return i2;
        }
        if (!n.b(this.trickList, object.trickList)) {
            return i2;
        }
        if (!n.b(this.scrollPosition, object.scrollPosition)) {
            return i2;
        }
        return i;
    }

    public final Integer getScrollPosition() {
        return this.scrollPosition;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> getTrickList() {
        return this.trickList;
    }

    public int hashCode() {
        int i;
        int i2;
        List trickList = this.trickList;
        if (trickList == null) {
            i = i2;
        } else {
            i = trickList.hashCode();
        }
        final Integer scrollPosition = this.scrollPosition;
        if (scrollPosition == null) {
        } else {
            i2 = scrollPosition.hashCode();
        }
        return i3 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecentlyViewedTricks(trickList=");
        stringBuilder.append(this.trickList);
        stringBuilder.append(", scrollPosition=");
        stringBuilder.append(this.scrollPosition);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
