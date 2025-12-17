package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0083@\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u00072\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u0013\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\u0008\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r\u0088\u0001\u0002¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/GroupKind;", "", "value", "", "constructor-impl", "(I)I", "isNode", "", "isNode-impl", "(I)Z", "isReusable", "isReusable-impl", "getValue", "()I", "equals", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
final class GroupKind {

    public static final androidx.compose.runtime.GroupKind.Companion Companion;
    private static final int Group;
    private static final int Node;
    private static final int ReusableNode;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/GroupKind$Companion;", "", "()V", "Group", "Landroidx/compose/runtime/GroupKind;", "getGroup-ULZAiWs", "()I", "I", "Node", "getNode-ULZAiWs", "ReusableNode", "getReusableNode-ULZAiWs", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getGroup-ULZAiWs() {
            return GroupKind.access$getGroup$cp();
        }

        public final int getNode-ULZAiWs() {
            return GroupKind.access$getNode$cp();
        }

        public final int getReusableNode-ULZAiWs() {
            return GroupKind.access$getReusableNode$cp();
        }
    }
    static {
        GroupKind.Companion companion = new GroupKind.Companion(0);
        GroupKind.Companion = companion;
        GroupKind.Group = GroupKind.constructor-impl(0);
        GroupKind.Node = GroupKind.constructor-impl(1);
        GroupKind.ReusableNode = GroupKind.constructor-impl(2);
    }

    private GroupKind(int value) {
        super();
        this.value = value;
    }

    public static final int access$getGroup$cp() {
        return GroupKind.Group;
    }

    public static final int access$getNode$cp() {
        return GroupKind.Node;
    }

    public static final int access$getReusableNode$cp() {
        return GroupKind.ReusableNode;
    }

    public static final androidx.compose.runtime.GroupKind box-impl(int i) {
        GroupKind groupKind = new GroupKind(i);
        return groupKind;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof GroupKind) {
            return i3;
        }
        if (i != (GroupKind)object2.unbox-impl()) {
            return i3;
        }
        return 1;
    }

    public static final boolean equals-impl0(int i, int i2) {
        int i3;
        i3 = i == i2 ? 1 : 0;
        return i3;
    }

    public static int hashCode-impl(int i) {
        return Integer.hashCode(i);
    }

    public static final boolean isNode-impl(int arg0) {
        int i;
        final int i2 = 0;
        i = arg0 != GroupKind.Companion.getGroup-ULZAiWs() ? 1 : 0;
        return i;
    }

    public static final boolean isReusable-impl(int arg0) {
        int i;
        final int i2 = 0;
        i = arg0 != GroupKind.Companion.getNode-ULZAiWs() ? 1 : 0;
        return i;
    }

    public static String toString-impl(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("GroupKind(value=").append(i).append(')').toString();
    }

    public boolean equals(Object object) {
        return GroupKind.equals-impl(this.value, object);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return GroupKind.hashCode-impl(this.value);
    }

    public String toString() {
        return GroupKind.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
