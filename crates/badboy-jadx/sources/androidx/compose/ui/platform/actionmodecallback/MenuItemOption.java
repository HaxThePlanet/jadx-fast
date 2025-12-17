package androidx.compose.ui.platform.actionmodecallback;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\u0008\u0080\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0006j\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000e¨\u0006\u000f", d2 = {"Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "order", "getOrder", "titleResource", "getTitleResource", "Copy", "Paste", "Cut", "SelectAll", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum MenuItemOption {

    Copy(false),
    Paste(false),
    Cut(false),
    SelectAll(false);

    private final int id;
    private final int order;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal;
            int ordinal4;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[MenuItemOption.Copy.ordinal()] = 1;
            iArr[MenuItemOption.Paste.ordinal()] = 2;
            iArr[MenuItemOption.Cut.ordinal()] = 3;
            iArr[MenuItemOption.SelectAll.ordinal()] = 4;
            MenuItemOption.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    private static final androidx.compose.ui.platform.actionmodecallback.MenuItemOption[] $values() {
        return /* result */;
    }

    @Override // java.lang.Enum
    public final int getId() {
        return this.id;
    }

    @Override // java.lang.Enum
    public final int getOrder() {
        return this.order;
    }

    @Override // java.lang.Enum
    public final int getTitleResource() {
        int i;
        switch (i3) {
            case 1:
                i = 17039361;
                break;
            case 2:
                i = 17039371;
                break;
            case 3:
                i = 17039363;
                break;
            case 4:
                i = 17039373;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return i;
    }
}
