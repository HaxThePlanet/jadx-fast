package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/input/ImeAction;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class ImeAction {

    public static final androidx.compose.ui.text.input.ImeAction.Companion Companion;
    private static final int Default;
    private static final int Done;
    private static final int Go;
    private static final int Next;
    private static final int None;
    private static final int Previous;
    private static final int Search;
    private static final int Send;
    private static final int Unspecified;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001d\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007R$\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0010\u0010\u0002\u001a\u0004\u0008\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u0007R$\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0016\u0010\u0002\u001a\u0004\u0008\u0017\u0010\u0007R$\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0019\u0010\u0002\u001a\u0004\u0008\u001a\u0010\u0007R$\u0010\u001b\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u001c\u0010\u0002\u001a\u0004\u0008\u001d\u0010\u0007R$\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u001f\u0010\u0002\u001a\u0004\u0008 \u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006!", d2 = {"Landroidx/compose/ui/text/input/ImeAction$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/input/ImeAction;", "getDefault-eUduSuo$annotations", "getDefault-eUduSuo", "()I", "I", "Done", "getDone-eUduSuo$annotations", "getDone-eUduSuo", "Go", "getGo-eUduSuo$annotations", "getGo-eUduSuo", "Next", "getNext-eUduSuo$annotations", "getNext-eUduSuo", "None", "getNone-eUduSuo$annotations", "getNone-eUduSuo", "Previous", "getPrevious-eUduSuo$annotations", "getPrevious-eUduSuo", "Search", "getSearch-eUduSuo$annotations", "getSearch-eUduSuo", "Send", "getSend-eUduSuo$annotations", "getSend-eUduSuo", "Unspecified", "getUnspecified-eUduSuo$annotations", "getUnspecified-eUduSuo", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getDefault-eUduSuo$annotations() {
        }

        public static void getDone-eUduSuo$annotations() {
        }

        public static void getGo-eUduSuo$annotations() {
        }

        public static void getNext-eUduSuo$annotations() {
        }

        public static void getNone-eUduSuo$annotations() {
        }

        public static void getPrevious-eUduSuo$annotations() {
        }

        public static void getSearch-eUduSuo$annotations() {
        }

        public static void getSend-eUduSuo$annotations() {
        }

        public static void getUnspecified-eUduSuo$annotations() {
        }

        public final int getDefault-eUduSuo() {
            return ImeAction.access$getDefault$cp();
        }

        public final int getDone-eUduSuo() {
            return ImeAction.access$getDone$cp();
        }

        public final int getGo-eUduSuo() {
            return ImeAction.access$getGo$cp();
        }

        public final int getNext-eUduSuo() {
            return ImeAction.access$getNext$cp();
        }

        public final int getNone-eUduSuo() {
            return ImeAction.access$getNone$cp();
        }

        public final int getPrevious-eUduSuo() {
            return ImeAction.access$getPrevious$cp();
        }

        public final int getSearch-eUduSuo() {
            return ImeAction.access$getSearch$cp();
        }

        public final int getSend-eUduSuo() {
            return ImeAction.access$getSend$cp();
        }

        public final int getUnspecified-eUduSuo() {
            return ImeAction.access$getUnspecified$cp();
        }
    }
    static {
        ImeAction.Companion companion = new ImeAction.Companion(0);
        ImeAction.Companion = companion;
        ImeAction.Unspecified = ImeAction.constructor-impl(-1);
        ImeAction.Default = ImeAction.constructor-impl(1);
        ImeAction.None = ImeAction.constructor-impl(0);
        ImeAction.Go = ImeAction.constructor-impl(2);
        ImeAction.Search = ImeAction.constructor-impl(3);
        ImeAction.Send = ImeAction.constructor-impl(4);
        ImeAction.Previous = ImeAction.constructor-impl(5);
        ImeAction.Next = ImeAction.constructor-impl(6);
        ImeAction.Done = ImeAction.constructor-impl(7);
    }

    private ImeAction(int value) {
        super();
        this.value = value;
    }

    public static final int access$getDefault$cp() {
        return ImeAction.Default;
    }

    public static final int access$getDone$cp() {
        return ImeAction.Done;
    }

    public static final int access$getGo$cp() {
        return ImeAction.Go;
    }

    public static final int access$getNext$cp() {
        return ImeAction.Next;
    }

    public static final int access$getNone$cp() {
        return ImeAction.None;
    }

    public static final int access$getPrevious$cp() {
        return ImeAction.Previous;
    }

    public static final int access$getSearch$cp() {
        return ImeAction.Search;
    }

    public static final int access$getSend$cp() {
        return ImeAction.Send;
    }

    public static final int access$getUnspecified$cp() {
        return ImeAction.Unspecified;
    }

    public static final androidx.compose.ui.text.input.ImeAction box-impl(int i) {
        ImeAction imeAction = new ImeAction(i);
        return imeAction;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof ImeAction) {
            return i3;
        }
        if (i != (ImeAction)object2.unbox-impl()) {
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

    public static String toString-impl(int arg0) {
        String str;
        str = ImeAction.equals-impl0(arg0, ImeAction.Unspecified) ? "Unspecified" : equals-impl02 ? "None" : equals-impl03 ? "Default" : equals-impl04 ? "Go" : equals-impl05 ? "Search" : equals-impl06 ? "Send" : equals-impl07 ? "Previous" : equals-impl08 ? "Next" : equals-impl09 ? "Done" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return ImeAction.equals-impl(this.value, object);
    }

    public int hashCode() {
        return ImeAction.hashCode-impl(this.value);
    }

    public String toString() {
        return ImeAction.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
