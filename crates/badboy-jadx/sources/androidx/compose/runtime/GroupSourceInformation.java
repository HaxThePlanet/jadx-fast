package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0001H\u0002J\u001e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0003J\u0010\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J\u0008\u0010-\u001a\u00020\u0000H\u0002J\u000e\u0010.\u001a\u00020\t2\u0006\u0010+\u001a\u00020,J\u0016\u0010/\u001a\u00020!2\u0006\u00100\u001a\u0002012\u0006\u0010\"\u001a\u00020\u0003J\u0016\u0010/\u001a\u00020!2\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u0003J\u001e\u00102\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0003R\u001a\u0010\u0008\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0010R.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001f¨\u00063", d2 = {"Landroidx/compose/runtime/GroupSourceInformation;", "", "key", "", "sourceInformation", "", "dataStartOffset", "(ILjava/lang/String;I)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "dataEndOffset", "getDataEndOffset", "()I", "setDataEndOffset", "(I)V", "getDataStartOffset", "groups", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getGroups", "()Ljava/util/ArrayList;", "setGroups", "(Ljava/util/ArrayList;)V", "getKey", "getSourceInformation", "()Ljava/lang/String;", "setSourceInformation", "(Ljava/lang/String;)V", "add", "", "group", "addGroupAfter", "writer", "Landroidx/compose/runtime/SlotWriter;", "predecessor", "close", "dataOffset", "endGrouplessCall", "hasAnchor", "anchor", "Landroidx/compose/runtime/Anchor;", "openInformation", "removeAnchor", "reportGroup", "table", "Landroidx/compose/runtime/SlotTable;", "startGrouplessCall", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GroupSourceInformation {

    public static final int $stable = 8;
    private boolean closed;
    private int dataEndOffset;
    private final int dataStartOffset;
    private ArrayList<Object> groups;
    private final int key;
    private String sourceInformation;
    static {
        final int i = 8;
    }

    public GroupSourceInformation(int key, String sourceInformation, int dataStartOffset) {
        super();
        this.key = key;
        this.sourceInformation = sourceInformation;
        this.dataStartOffset = dataStartOffset;
    }

    private final void add(Object group) {
        ArrayList arrayList;
        if (this.groups == null) {
            arrayList = new ArrayList();
        }
        this.groups = arrayList;
        arrayList.add(group);
    }

    private final boolean hasAnchor(androidx.compose.runtime.Anchor anchor) {
        int $this$fastAny$iv;
        int i3;
        int i;
        ArrayList list;
        int i4;
        int index$iv$iv;
        int size;
        int i5;
        Object obj2;
        Object obj;
        int i6;
        int it;
        int i2;
        boolean anchor2;
        $this$fastAny$iv = this.groups;
        i3 = 0;
        if ($this$fastAny$iv != null) {
            i = 0;
            list = $this$fastAny$iv;
            i4 = 0;
            index$iv$iv = 0;
            i5 = 1;
            while (index$iv$iv < list.size()) {
                i6 = 0;
                Object obj3 = obj;
                i2 = 0;
                if (!Intrinsics.areEqual(obj3, anchor)) {
                } else {
                }
                it = i5;
                index$iv$iv++;
                i5 = 1;
                if (obj3 instanceof GroupSourceInformation && (GroupSourceInformation)obj3.hasAnchor(anchor)) {
                } else {
                }
                it = i3;
                if ((GroupSourceInformation)obj3.hasAnchor(anchor)) {
                } else {
                }
            }
            $this$fastAny$iv = i3;
            if ($this$fastAny$iv == i5) {
                i3 = i5;
            }
        }
        return i3;
    }

    private final androidx.compose.runtime.GroupSourceInformation openInformation() {
        boolean information;
        int i2;
        int i5;
        ArrayList list;
        int i;
        int index$iv;
        int i3;
        Object obj;
        Object obj2;
        int i4;
        int i6;
        boolean closed;
        ArrayList groups = this.groups;
        i2 = 0;
        if (groups != null) {
            i5 = 0;
            list = groups;
            i = 0;
            i3 = 1;
            size -= i3;
            while (index$iv >= 0) {
                obj2 = obj;
                i4 = 0;
                if (obj2 instanceof GroupSourceInformation && !obj3.closed) {
                } else {
                }
                i6 = 0;
                index$iv--;
                if (!obj3.closed) {
                } else {
                }
                i6 = i3;
            }
            obj = i2;
        } else {
            obj = i2;
        }
        if (obj instanceof GroupSourceInformation) {
            i2 = obj;
        }
        if (i2 != 0 && i2.openInformation() != null) {
            if (i2.openInformation() != null) {
            } else {
                information = this;
            }
        } else {
        }
        return information;
    }

    public final void addGroupAfter(androidx.compose.runtime.SlotWriter writer, int predecessor, int group) {
        ArrayList arrayList;
        ArrayList list;
        int it;
        int tryAnchor$runtime_release;
        ArrayList list2;
        int i3;
        int index$iv;
        int size;
        Object obj2;
        Object obj;
        int i;
        int i2;
        boolean anchor;
        if (this.groups == null) {
            arrayList = new ArrayList();
            tryAnchor$runtime_release = 0;
            this.groups = arrayList;
        }
        if (predecessor >= 0) {
            tryAnchor$runtime_release = writer.tryAnchor$runtime_release(predecessor);
            if (tryAnchor$runtime_release != null) {
                list2 = arrayList;
                i3 = 0;
                index$iv = 0;
                while (index$iv < list2.size()) {
                    obj = obj2;
                    i = 0;
                    if (!Intrinsics.areEqual(obj, tryAnchor$runtime_release)) {
                    } else {
                    }
                    i2 = 1;
                    index$iv++;
                    if (obj instanceof GroupSourceInformation && (GroupSourceInformation)obj.hasAnchor(tryAnchor$runtime_release)) {
                    } else {
                    }
                    i2 = it;
                    if ((GroupSourceInformation)obj.hasAnchor(tryAnchor$runtime_release)) {
                    } else {
                    }
                }
                it = -1;
            } else {
            }
        } else {
        }
        arrayList.add(it, writer.anchor(group));
    }

    public final void close(int dataOffset) {
        this.closed = true;
        this.dataEndOffset = dataOffset;
    }

    public final void endGrouplessCall(int dataOffset) {
        openInformation().close(dataOffset);
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getDataEndOffset() {
        return this.dataEndOffset;
    }

    public final int getDataStartOffset() {
        return this.dataStartOffset;
    }

    public final ArrayList<Object> getGroups() {
        return this.groups;
    }

    public final int getKey() {
        return this.key;
    }

    public final String getSourceInformation() {
        return this.sourceInformation;
    }

    public final boolean removeAnchor(androidx.compose.runtime.Anchor anchor) {
        int index;
        Object obj;
        boolean anchor2;
        final ArrayList groups = this.groups;
        int i = 1;
        if (groups != null) {
            size -= i;
            while (index >= 0) {
                obj = groups.get(index);
                if (obj instanceof Anchor) {
                } else {
                }
                if (obj instanceof GroupSourceInformation && !(GroupSourceInformation)obj.removeAnchor(anchor)) {
                }
                index--;
                if (!(GroupSourceInformation)obj.removeAnchor(anchor)) {
                }
                groups.remove(index);
                if (Intrinsics.areEqual(obj, anchor)) {
                }
                groups.remove(index);
            }
            if (groups.isEmpty()) {
                this.groups = 0;
                return 0;
            }
            return i;
        }
        return i;
    }

    public final void reportGroup(androidx.compose.runtime.SlotTable table, int group) {
        openInformation().add(table.anchor(group));
    }

    public final void reportGroup(androidx.compose.runtime.SlotWriter writer, int group) {
        openInformation().add(writer.anchor(group));
    }

    public final void setClosed(boolean <set-?>) {
        this.closed = <set-?>;
    }

    public final void setDataEndOffset(int <set-?>) {
        this.dataEndOffset = <set-?>;
    }

    public final void setGroups(ArrayList<Object> <set-?>) {
        this.groups = <set-?>;
    }

    public final void setSourceInformation(String <set-?>) {
        this.sourceInformation = <set-?>;
    }

    public final void startGrouplessCall(int key, String sourceInformation, int dataOffset) {
        GroupSourceInformation groupSourceInformation = new GroupSourceInformation(key, sourceInformation, dataOffset);
        openInformation().add(groupSourceInformation);
    }
}
