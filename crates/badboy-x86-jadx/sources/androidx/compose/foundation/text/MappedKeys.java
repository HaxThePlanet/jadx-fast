package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u00082\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0017\u0010\u0006R\u0019\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0019\u0010\u0006R\u0019\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001d\u0010\u0006R\u0019\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u001f\u0010\u0006R\u0019\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008!\u0010\u0006R\u0019\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008#\u0010\u0006R\u0019\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008%\u0010\u0006R\u0019\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008)\u0010\u0006R\u0019\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008+\u0010\u0006R\u0019\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008-\u0010\u0006R\u0019\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008/\u0010\u0006R\u0019\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00081\u0010\u0006R\u0019\u00102\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00083\u0010\u0006R\u0019\u00104\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u00085\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00066", d2 = {"Landroidx/compose/foundation/text/MappedKeys;", "", "()V", "A", "Landroidx/compose/ui/input/key/Key;", "getA-EK5gGoQ", "()J", "J", "Backslash", "getBackslash-EK5gGoQ", "Backspace", "getBackspace-EK5gGoQ", "C", "getC-EK5gGoQ", "Copy", "getCopy-EK5gGoQ", "Cut", "getCut-EK5gGoQ", "Delete", "getDelete-EK5gGoQ", "DirectionDown", "getDirectionDown-EK5gGoQ", "DirectionLeft", "getDirectionLeft-EK5gGoQ", "DirectionRight", "getDirectionRight-EK5gGoQ", "DirectionUp", "getDirectionUp-EK5gGoQ", "Enter", "getEnter-EK5gGoQ", "H", "getH-EK5gGoQ", "Insert", "getInsert-EK5gGoQ", "MoveEnd", "getMoveEnd-EK5gGoQ", "MoveHome", "getMoveHome-EK5gGoQ", "PageDown", "getPageDown-EK5gGoQ", "PageUp", "getPageUp-EK5gGoQ", "Paste", "getPaste-EK5gGoQ", "Tab", "getTab-EK5gGoQ", "V", "getV-EK5gGoQ", "X", "getX-EK5gGoQ", "Y", "getY-EK5gGoQ", "Z", "getZ-EK5gGoQ", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MappedKeys {

    public static final int $stable;
    private static final long A;
    private static final long Backslash;
    private static final long Backspace;
    private static final long C;
    private static final long Copy;
    private static final long Cut;
    private static final long Delete;
    private static final long DirectionDown;
    private static final long DirectionLeft;
    private static final long DirectionRight;
    private static final long DirectionUp;
    private static final long Enter;
    private static final long H;
    public static final androidx.compose.foundation.text.MappedKeys INSTANCE;
    private static final long Insert;
    private static final long MoveEnd;
    private static final long MoveHome;
    private static final long PageDown;
    private static final long PageUp;
    private static final long Paste;
    private static final long Tab;
    private static final long V;
    private static final long X;
    private static final long Y;
    private static final long Z;
    static {
        MappedKeys mappedKeys = new MappedKeys();
        MappedKeys.INSTANCE = mappedKeys;
        MappedKeys.A = Key_androidKt.Key(29);
        MappedKeys.C = Key_androidKt.Key(31);
        MappedKeys.H = Key_androidKt.Key(36);
        MappedKeys.V = Key_androidKt.Key(50);
        MappedKeys.Y = Key_androidKt.Key(53);
        MappedKeys.X = Key_androidKt.Key(52);
        MappedKeys.Z = Key_androidKt.Key(54);
        MappedKeys.Backslash = Key_androidKt.Key(73);
        MappedKeys.DirectionLeft = Key_androidKt.Key(21);
        MappedKeys.DirectionRight = Key_androidKt.Key(22);
        MappedKeys.DirectionUp = Key_androidKt.Key(19);
        MappedKeys.DirectionDown = Key_androidKt.Key(20);
        MappedKeys.PageUp = Key_androidKt.Key(92);
        MappedKeys.PageDown = Key_androidKt.Key(93);
        MappedKeys.MoveHome = Key_androidKt.Key(122);
        MappedKeys.MoveEnd = Key_androidKt.Key(123);
        MappedKeys.Insert = Key_androidKt.Key(124);
        MappedKeys.Enter = Key_androidKt.Key(66);
        MappedKeys.Backspace = Key_androidKt.Key(67);
        MappedKeys.Delete = Key_androidKt.Key(112);
        MappedKeys.Paste = Key_androidKt.Key(279);
        MappedKeys.Cut = Key_androidKt.Key(277);
        MappedKeys.Copy = Key_androidKt.Key(278);
        MappedKeys.Tab = Key_androidKt.Key(61);
    }

    public final long getA-EK5gGoQ() {
        return MappedKeys.A;
    }

    public final long getBackslash-EK5gGoQ() {
        return MappedKeys.Backslash;
    }

    public final long getBackspace-EK5gGoQ() {
        return MappedKeys.Backspace;
    }

    public final long getC-EK5gGoQ() {
        return MappedKeys.C;
    }

    public final long getCopy-EK5gGoQ() {
        return MappedKeys.Copy;
    }

    public final long getCut-EK5gGoQ() {
        return MappedKeys.Cut;
    }

    public final long getDelete-EK5gGoQ() {
        return MappedKeys.Delete;
    }

    public final long getDirectionDown-EK5gGoQ() {
        return MappedKeys.DirectionDown;
    }

    public final long getDirectionLeft-EK5gGoQ() {
        return MappedKeys.DirectionLeft;
    }

    public final long getDirectionRight-EK5gGoQ() {
        return MappedKeys.DirectionRight;
    }

    public final long getDirectionUp-EK5gGoQ() {
        return MappedKeys.DirectionUp;
    }

    public final long getEnter-EK5gGoQ() {
        return MappedKeys.Enter;
    }

    public final long getH-EK5gGoQ() {
        return MappedKeys.H;
    }

    public final long getInsert-EK5gGoQ() {
        return MappedKeys.Insert;
    }

    public final long getMoveEnd-EK5gGoQ() {
        return MappedKeys.MoveEnd;
    }

    public final long getMoveHome-EK5gGoQ() {
        return MappedKeys.MoveHome;
    }

    public final long getPageDown-EK5gGoQ() {
        return MappedKeys.PageDown;
    }

    public final long getPageUp-EK5gGoQ() {
        return MappedKeys.PageUp;
    }

    public final long getPaste-EK5gGoQ() {
        return MappedKeys.Paste;
    }

    public final long getTab-EK5gGoQ() {
        return MappedKeys.Tab;
    }

    public final long getV-EK5gGoQ() {
        return MappedKeys.V;
    }

    public final long getX-EK5gGoQ() {
        return MappedKeys.X;
    }

    public final long getY-EK5gGoQ() {
        return MappedKeys.Y;
    }

    public final long getZ-EK5gGoQ() {
        return MappedKeys.Z;
    }
}
