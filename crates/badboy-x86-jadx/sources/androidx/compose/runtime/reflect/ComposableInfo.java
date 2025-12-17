package androidx.compose.runtime.reflect;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0011\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\n¨\u0006\u0018", d2 = {"Landroidx/compose/runtime/reflect/ComposableInfo;", "", "isComposable", "", "realParamsCount", "", "changedParams", "defaultParams", "(ZIII)V", "getChangedParams", "()I", "getDefaultParams", "()Z", "getRealParamsCount", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposableInfo {

    public static final int $stable;
    private final int changedParams;
    private final int defaultParams;
    private final boolean isComposable;
    private final int realParamsCount;
    static {
    }

    public ComposableInfo(boolean isComposable, int realParamsCount, int changedParams, int defaultParams) {
        super();
        this.isComposable = isComposable;
        this.realParamsCount = realParamsCount;
        this.changedParams = changedParams;
        this.defaultParams = defaultParams;
    }

    public static androidx.compose.runtime.reflect.ComposableInfo copy$default(androidx.compose.runtime.reflect.ComposableInfo composableInfo, boolean z2, int i3, int i4, int i5, int i6, Object object7) {
        boolean obj1;
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj1 = composableInfo.isComposable;
        }
        if (i6 & 2 != 0) {
            obj2 = composableInfo.realParamsCount;
        }
        if (i6 & 4 != 0) {
            obj3 = composableInfo.changedParams;
        }
        if (i6 &= 8 != 0) {
            obj4 = composableInfo.defaultParams;
        }
        return composableInfo.copy(obj1, obj2, obj3, obj4);
    }

    public final boolean component1() {
        return this.isComposable;
    }

    public final int component2() {
        return this.realParamsCount;
    }

    public final int component3() {
        return this.changedParams;
    }

    public final int component4() {
        return this.defaultParams;
    }

    public final androidx.compose.runtime.reflect.ComposableInfo copy(boolean z, int i2, int i3, int i4) {
        ComposableInfo composableInfo = new ComposableInfo(z, i2, i3, i4);
        return composableInfo;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ComposableInfo) {
            return i2;
        }
        Object obj = object;
        if (this.isComposable != obj.isComposable) {
            return i2;
        }
        if (this.realParamsCount != obj.realParamsCount) {
            return i2;
        }
        if (this.changedParams != obj.changedParams) {
            return i2;
        }
        if (this.defaultParams != obj.defaultParams) {
            return i2;
        }
        return i;
    }

    public final int getChangedParams() {
        return this.changedParams;
    }

    public final int getDefaultParams() {
        return this.defaultParams;
    }

    public final int getRealParamsCount() {
        return this.realParamsCount;
    }

    public int hashCode() {
        return i6 += i10;
    }

    public final boolean isComposable() {
        return this.isComposable;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ComposableInfo(isComposable=").append(this.isComposable).append(", realParamsCount=").append(this.realParamsCount).append(", changedParams=").append(this.changedParams).append(", defaultParams=").append(this.defaultParams).append(')').toString();
    }
}
