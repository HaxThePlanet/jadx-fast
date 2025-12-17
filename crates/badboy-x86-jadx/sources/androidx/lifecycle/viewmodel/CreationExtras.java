package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008&\u0018\u0000 \u00162\u00020\u0001:\u0003\u0014\u0015\u0016B\t\u0008\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003J$\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\u0008\u0000\u0010\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u0006H¦\u0002¢\u0006\u0002\u0010\u000cJ\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R&\u0010\u0004\u001a\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0017", d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras;", "", "<init>", "()V", "extras", "", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "getExtras$lifecycle_viewmodel_release", "()Ljava/util/Map;", "get", "T", "key", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "Key", "Empty", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CreationExtras {

    public static final androidx.lifecycle.viewmodel.CreationExtras.Companion Companion;
    private final Map<androidx.lifecycle.viewmodel.CreationExtras.Key<?>, Object> extras;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0008f\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0003À\u0006\u0001", d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "T", "", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Key {
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0006\u0008\u0000\u0010\u0006\u0018\u0001H\u0087\u0008¨\u0006\u0007", d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras$Companion;", "", "<init>", "()V", "Key", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "T", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        @JvmStatic
        public final <T> androidx.lifecycle.viewmodel.CreationExtras.Key<T> Key() {
            final int i = 0;
            Intrinsics.needClassReification();
            CreationExtras.Companion.Key.1 anon = new CreationExtras.Companion.Key.1();
            return (CreationExtras.Key)anon;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J$\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\u0008\u0000\u0010\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00050\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"Landroidx/lifecycle/viewmodel/CreationExtras$Empty;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "<init>", "()V", "get", "T", "key", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Empty extends androidx.lifecycle.viewmodel.CreationExtras {

        public static final androidx.lifecycle.viewmodel.CreationExtras.Empty INSTANCE;
        static {
            CreationExtras.Empty empty = new CreationExtras.Empty();
            CreationExtras.Empty.INSTANCE = empty;
        }

        public <T> T get(androidx.lifecycle.viewmodel.CreationExtras.Key<T> key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return 0;
        }
    }
    static {
        CreationExtras.Companion companion = new CreationExtras.Companion(0);
        CreationExtras.Companion = companion;
    }

    public CreationExtras() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.extras = (Map)linkedHashMap;
    }

    public boolean equals(Object other) {
        boolean equal;
        int i;
        Map extras;
        if (other instanceof CreationExtras && Intrinsics.areEqual(this.extras, obj.extras)) {
            i = Intrinsics.areEqual(this.extras, obj.extras) ? 1 : 0;
        } else {
        }
        return i;
    }

    public abstract <T> T get(androidx.lifecycle.viewmodel.CreationExtras.Key<T> creationExtras$Key);

    public final Map<androidx.lifecycle.viewmodel.CreationExtras.Key<?>, Object> getExtras$lifecycle_viewmodel_release() {
        return this.extras;
    }

    public int hashCode() {
        return this.extras.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CreationExtras(extras=").append(this.extras).append(')').toString();
    }
}
