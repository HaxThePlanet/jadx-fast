package androidx.compose.ui.autofill;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0081@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014", d2 = {"Landroidx/compose/ui/autofill/ContentDataType;", "", "dataType", "", "constructor-impl", "(I)I", "getDataType", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class ContentDataType {

    public static final androidx.compose.ui.autofill.ContentDataType.Companion Companion;
    private static final int Date;
    private static final int List;
    private static final int None;
    private static final int Text;
    private static final int Toggle;
    private final int dataType;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/ui/autofill/ContentDataType$Companion;", "", "()V", "Date", "Landroidx/compose/ui/autofill/ContentDataType;", "getDate-A48pgw8", "()I", "I", "List", "getList-A48pgw8", "None", "getNone-A48pgw8", "Text", "getText-A48pgw8", "Toggle", "getToggle-A48pgw8", "from", "value", "", "from-LGGHU18$ui_release", "(I)I", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int from-LGGHU18$ui_release(int value) {
            int list-A48pgw8;
            switch (value) {
                case 0:
                    list-A48pgw8 = getNone-A48pgw8();
                    break;
                case 1:
                    list-A48pgw8 = getText-A48pgw8();
                    break;
                case 2:
                    list-A48pgw8 = getToggle-A48pgw8();
                    break;
                case 3:
                    list-A48pgw8 = getList-A48pgw8();
                    break;
                case 4:
                    list-A48pgw8 = getDate-A48pgw8();
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Invalid autofill type value: ").append(value).toString());
                    throw illegalArgumentException;
            }
            return list-A48pgw8;
        }

        public final int getDate-A48pgw8() {
            return ContentDataType.access$getDate$cp();
        }

        public final int getList-A48pgw8() {
            return ContentDataType.access$getList$cp();
        }

        public final int getNone-A48pgw8() {
            return ContentDataType.access$getNone$cp();
        }

        public final int getText-A48pgw8() {
            return ContentDataType.access$getText$cp();
        }

        public final int getToggle-A48pgw8() {
            return ContentDataType.access$getToggle$cp();
        }
    }
    static {
        ContentDataType.Companion companion = new ContentDataType.Companion(0);
        ContentDataType.Companion = companion;
        ContentDataType.Text = ContentDataType.constructor-impl(1);
        ContentDataType.List = ContentDataType.constructor-impl(3);
        ContentDataType.Date = ContentDataType.constructor-impl(4);
        ContentDataType.Toggle = ContentDataType.constructor-impl(2);
        ContentDataType.None = ContentDataType.constructor-impl(0);
    }

    private ContentDataType(int dataType) {
        super();
        this.dataType = dataType;
    }

    public static final int access$getDate$cp() {
        return ContentDataType.Date;
    }

    public static final int access$getList$cp() {
        return ContentDataType.List;
    }

    public static final int access$getNone$cp() {
        return ContentDataType.None;
    }

    public static final int access$getText$cp() {
        return ContentDataType.Text;
    }

    public static final int access$getToggle$cp() {
        return ContentDataType.Toggle;
    }

    public static final androidx.compose.ui.autofill.ContentDataType box-impl(int i) {
        ContentDataType contentDataType = new ContentDataType(i);
        return contentDataType;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof ContentDataType) {
            return i3;
        }
        if (i != (ContentDataType)object2.unbox-impl()) {
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

    public static String toString-impl(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ContentDataType(dataType=").append(i).append(')').toString();
    }

    public boolean equals(Object object) {
        return ContentDataType.equals-impl(this.dataType, object);
    }

    public final int getDataType() {
        return this.dataType;
    }

    public int hashCode() {
        return ContentDataType.hashCode-impl(this.dataType);
    }

    public String toString() {
        return ContentDataType.toString-impl(this.dataType);
    }

    public final int unbox-impl() {
        return this.dataType;
    }
}
