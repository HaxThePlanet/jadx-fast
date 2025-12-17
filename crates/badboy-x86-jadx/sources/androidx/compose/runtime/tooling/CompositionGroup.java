package androidx.compose.runtime.tooling;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\nR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0018À\u0006\u0003", d2 = {"Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/runtime/tooling/CompositionData;", "data", "", "", "getData", "()Ljava/lang/Iterable;", "groupSize", "", "getGroupSize", "()I", "identity", "getIdentity", "()Ljava/lang/Object;", "key", "getKey", "node", "getNode", "slotsSize", "getSlotsSize", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CompositionGroup extends androidx.compose.runtime.tooling.CompositionData {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static androidx.compose.runtime.tooling.CompositionGroup find(androidx.compose.runtime.tooling.CompositionGroup $this, Object identityToFind) {
            return CompositionGroup.access$find$jd($this, identityToFind);
        }

        @Deprecated
        public static int getGroupSize(androidx.compose.runtime.tooling.CompositionGroup $this) {
            return CompositionGroup.access$getGroupSize$jd($this);
        }

        @Deprecated
        public static Object getIdentity(androidx.compose.runtime.tooling.CompositionGroup $this) {
            return CompositionGroup.access$getIdentity$jd($this);
        }

        @Deprecated
        public static int getSlotsSize(androidx.compose.runtime.tooling.CompositionGroup $this) {
            return CompositionGroup.access$getSlotsSize$jd($this);
        }
    }
    public static androidx.compose.runtime.tooling.CompositionGroup access$find$jd(androidx.compose.runtime.tooling.CompositionGroup $this, Object identityToFind) {
        return super.find(identityToFind);
    }

    public static int access$getGroupSize$jd(androidx.compose.runtime.tooling.CompositionGroup $this) {
        return super.getGroupSize();
    }

    public static Object access$getIdentity$jd(androidx.compose.runtime.tooling.CompositionGroup $this) {
        return super.getIdentity();
    }

    public static int access$getSlotsSize$jd(androidx.compose.runtime.tooling.CompositionGroup $this) {
        return super.getSlotsSize();
    }

    public abstract Iterable<Object> getData();

    @Override // androidx.compose.runtime.tooling.CompositionData
    public int getGroupSize() {
        return 0;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public Object getIdentity() {
        return null;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public abstract Object getKey();

    @Override // androidx.compose.runtime.tooling.CompositionData
    public abstract Object getNode();

    @Override // androidx.compose.runtime.tooling.CompositionData
    public int getSlotsSize() {
        return 0;
    }

    @Override // androidx.compose.runtime.tooling.CompositionData
    public abstract String getSourceInfo();
}
