package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B³\u0001\u0012\u001b\u0008\u0002\u0010\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006\u0012\u001b\u0008\u0002\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006\u0012\u001b\u0008\u0002\u0010\u0008\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006\u0012\u001b\u0008\u0002\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006\u0012\u001b\u0008\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006\u0012\u001b\u0008\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0010\u000cJ\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R$\u0010\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR$\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR$\u0010\u0008\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000eR$\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000eR$\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000eR$\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0008\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000e¨\u0006\u001a", d2 = {"Landroidx/compose/foundation/text/KeyboardActions;", "", "onDone", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "", "Lkotlin/ExtensionFunctionType;", "onGo", "onNext", "onPrevious", "onSearch", "onSend", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnDone", "()Lkotlin/jvm/functions/Function1;", "getOnGo", "getOnNext", "getOnPrevious", "getOnSearch", "getOnSend", "equals", "", "other", "hashCode", "", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyboardActions {

    public static final int $stable;
    public static final androidx.compose.foundation.text.KeyboardActions.Companion Companion;
    private static final androidx.compose.foundation.text.KeyboardActions Default;
    private final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> onDone;
    private final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> onGo;
    private final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> onNext;
    private final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> onPrevious;
    private final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> onSearch;
    private final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> onSend;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/text/KeyboardActions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardActions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardActions;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getDefault$annotations() {
        }

        public final androidx.compose.foundation.text.KeyboardActions getDefault() {
            return KeyboardActions.access$getDefault$cp();
        }
    }
    static {
        KeyboardActions.Companion companion = new KeyboardActions.Companion(0);
        KeyboardActions.Companion = companion;
        KeyboardActions keyboardActions = new KeyboardActions(0, 0, 0, 0, 0, 0, 63, 0);
        KeyboardActions.Default = keyboardActions;
    }

    public KeyboardActions() {
        super(0, 0, 0, 0, 0, 0, 63, 0);
    }

    public KeyboardActions(Function1<? super androidx.compose.foundation.text.KeyboardActionScope, Unit> onDone, Function1<? super androidx.compose.foundation.text.KeyboardActionScope, Unit> onGo, Function1<? super androidx.compose.foundation.text.KeyboardActionScope, Unit> onNext, Function1<? super androidx.compose.foundation.text.KeyboardActionScope, Unit> onPrevious, Function1<? super androidx.compose.foundation.text.KeyboardActionScope, Unit> onSearch, Function1<? super androidx.compose.foundation.text.KeyboardActionScope, Unit> onSend) {
        super();
        this.onDone = onDone;
        this.onGo = onGo;
        this.onNext = onNext;
        this.onPrevious = onPrevious;
        this.onSearch = onSearch;
        this.onSend = onSend;
    }

    public KeyboardActions(Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        int obj8;
        final int i = 0;
        obj2 = i7 & 1 != 0 ? i : obj2;
        obj3 = i7 & 2 != 0 ? i : obj3;
        obj4 = i7 & 4 != 0 ? i : obj4;
        obj5 = i7 & 8 != 0 ? i : obj5;
        obj6 = i7 & 16 != 0 ? i : obj6;
        obj8 = i7 &= 32 != 0 ? i : function16;
        super(obj2, obj3, obj4, obj5, obj6, obj8);
    }

    public static final androidx.compose.foundation.text.KeyboardActions access$getDefault$cp() {
        return KeyboardActions.Default;
    }

    public boolean equals(Object other) {
        int i;
        Function1 onPrevious;
        Function1 onPrevious2;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof KeyboardActions) {
            return i2;
        }
        if (this.onDone == obj.onDone && this.onGo == obj2.onGo && this.onNext == obj3.onNext && this.onPrevious == obj4.onPrevious && this.onSearch == obj5.onSearch && this.onSend == obj6.onSend) {
            if (this.onGo == obj2.onGo) {
                if (this.onNext == obj3.onNext) {
                    if (this.onPrevious == obj4.onPrevious) {
                        if (this.onSearch == obj5.onSearch) {
                            if (this.onSend == obj6.onSend) {
                            } else {
                                i = i2;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> getOnDone() {
        return this.onDone;
    }

    public final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> getOnGo() {
        return this.onGo;
    }

    public final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> getOnNext() {
        return this.onNext;
    }

    public final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> getOnPrevious() {
        return this.onPrevious;
    }

    public final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> getOnSearch() {
        return this.onSearch;
    }

    public final Function1<androidx.compose.foundation.text.KeyboardActionScope, Unit> getOnSend() {
        return this.onSend;
    }

    public int hashCode() {
        int i5;
        int i4;
        int i6;
        int i;
        int i2;
        int i3;
        Function1 onDone = this.onDone;
        i4 = 0;
        if (onDone != null) {
            i5 = onDone.hashCode();
        } else {
            i5 = i4;
        }
        Function1 onGo = this.onGo;
        if (onGo != null) {
            i6 = onGo.hashCode();
        } else {
            i6 = i4;
        }
        Function1 onNext = this.onNext;
        if (onNext != null) {
            i = onNext.hashCode();
        } else {
            i = i4;
        }
        Function1 onPrevious = this.onPrevious;
        if (onPrevious != null) {
            i2 = onPrevious.hashCode();
        } else {
            i2 = i4;
        }
        Function1 onSearch = this.onSearch;
        if (onSearch != null) {
            i3 = onSearch.hashCode();
        } else {
            i3 = i4;
        }
        Function1 onSend = this.onSend;
        if (onSend != null) {
            i4 = onSend.hashCode();
        }
        return result4 += i4;
    }
}
