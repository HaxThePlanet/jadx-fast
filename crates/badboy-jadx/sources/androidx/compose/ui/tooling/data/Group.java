package androidx.compose.ui.tooling.data;

import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.unit.IntRect;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001B]\u0008\u0004\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0017\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u001a\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010\u001f\u0082\u0001\u0003%&'¨\u0006(", d2 = {"Landroidx/compose/ui/tooling/data/Group;", "", "key", "name", "", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "identity", "box", "Landroidx/compose/ui/unit/IntRect;", "data", "", "children", "isInline", "", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/tooling/data/SourceLocation;Ljava/lang/Object;Landroidx/compose/ui/unit/IntRect;Ljava/util/Collection;Ljava/util/Collection;Z)V", "getBox", "()Landroidx/compose/ui/unit/IntRect;", "getChildren", "()Ljava/util/Collection;", "getData", "getIdentity", "()Ljava/lang/Object;", "()Z", "getKey", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "modifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "getModifierInfo", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "parameters", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "getParameters", "Landroidx/compose/ui/tooling/data/CallGroup;", "Landroidx/compose/ui/tooling/data/EmptyGroup;", "Landroidx/compose/ui/tooling/data/NodeGroup;", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Group {

    public static final int $stable = 8;
    private final IntRect box;
    private final Collection<androidx.compose.ui.tooling.data.Group> children;
    private final Collection<Object> data;
    private final Object identity;
    private final boolean isInline;
    private final Object key;
    private final androidx.compose.ui.tooling.data.SourceLocation location;
    private final String name;
    static {
        final int i = 8;
    }

    private Group(Object key, String name, androidx.compose.ui.tooling.data.SourceLocation location, Object identity, IntRect box, Collection<? extends Object> data, Collection<? extends androidx.compose.ui.tooling.data.Group> children, boolean isInline) {
        super();
        this.key = key;
        this.name = name;
        this.location = location;
        this.identity = identity;
        this.box = box;
        this.data = data;
        this.children = children;
        this.isInline = isInline;
    }

    public Group(Object object, String string2, androidx.compose.ui.tooling.data.SourceLocation sourceLocation3, Object object4, IntRect intRect5, Collection collection6, Collection collection7, boolean z8, DefaultConstructorMarker defaultConstructorMarker9) {
        super(object, string2, sourceLocation3, object4, intRect5, collection6, collection7, z8);
    }

    public final IntRect getBox() {
        return this.box;
    }

    public final Collection<androidx.compose.ui.tooling.data.Group> getChildren() {
        return this.children;
    }

    public final Collection<Object> getData() {
        return this.data;
    }

    public final Object getIdentity() {
        return this.identity;
    }

    public final Object getKey() {
        return this.key;
    }

    public final androidx.compose.ui.tooling.data.SourceLocation getLocation() {
        return this.location;
    }

    public List<ModifierInfo> getModifierInfo() {
        return CollectionsKt.emptyList();
    }

    public final String getName() {
        return this.name;
    }

    public List<androidx.compose.ui.tooling.data.ParameterInformation> getParameters() {
        return CollectionsKt.emptyList();
    }

    public final boolean isInline() {
        return this.isInline;
    }
}
