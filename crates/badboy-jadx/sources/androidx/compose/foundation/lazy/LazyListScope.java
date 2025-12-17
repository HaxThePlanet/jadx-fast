package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@LazyScopeMarker
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008g\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\tH\u0017¢\u0006\u0002\u0010\nJC\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\tH\u0016¢\u0006\u0002\u0010\u000cJ\u0096\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2%\u0008\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062%\u0008\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000621\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\tH\u0016¢\u0006\u0002\u0010\u0015Jo\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2%\u0008\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000621\u0010\u0013\u001a-\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\tH\u0017¢\u0006\u0002\u0010\u0016JC\u0010\u0017\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0008\tH'¢\u0006\u0002\u0010\u000cø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0018À\u0006\u0003", d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", "", "item", "", "key", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "contentType", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyListScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void item(androidx.compose.foundation.lazy.LazyListScope $this, Object key, Object contentType, Function3<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Composer, ? super Integer, Unit> content) {
            LazyListScope.access$item$jd($this, key, contentType, content);
        }

        @Deprecated
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        public static void item(androidx.compose.foundation.lazy.LazyListScope $this, Object key, Function3 content) {
            LazyListScope.access$item$jd($this, key, content);
        }

        public static void item$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, Object object2, Object object3, Function3 function34, int i5, Object object6) {
            LazyListScope.item$default(lazyListScope, object2, object3, function34, i5, object6);
        }

        public static void item$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, Object object2, Function3 function33, int i4, Object object5) {
            LazyListScope.item$default(lazyListScope, object2, function33, i4, object5);
        }

        @Deprecated
        public static void items(androidx.compose.foundation.lazy.LazyListScope $this, int count, Function1<? super Integer, ? extends Object> key, Function1<? super Integer, ? extends Object> contentType, Function4<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
            LazyListScope.access$items$jd($this, count, key, contentType, itemContent);
        }

        @Deprecated
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        public static void items(androidx.compose.foundation.lazy.LazyListScope $this, int count, Function1 key, Function4 itemContent) {
            LazyListScope.access$items$jd($this, count, key, itemContent);
        }

        public static void items$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, int i2, Function1 function13, Function1 function14, Function4 function45, int i6, Object object7) {
            LazyListScope.items$default(lazyListScope, i2, function13, function14, function45, i6, object7);
        }

        public static void items$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, int i2, Function1 function13, Function4 function44, int i5, Object object6) {
            LazyListScope.items$default(lazyListScope, i2, function13, function44, i5, object6);
        }

        public static void stickyHeader$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, Object object2, Object object3, Function3 function34, int i5, Object object6) {
            LazyListScope.stickyHeader$default(lazyListScope, object2, object3, function34, i5, object6);
        }
    }
    public static void access$item$jd(androidx.compose.foundation.lazy.LazyListScope $this, Object key, Object contentType, Function3 content) {
        super.item(key, contentType, content);
    }

    public static void access$item$jd(androidx.compose.foundation.lazy.LazyListScope $this, Object key, Function3 content) {
        super.item(key, content);
    }

    public static void access$items$jd(androidx.compose.foundation.lazy.LazyListScope $this, int count, Function1 key, Function1 contentType, Function4 itemContent) {
        super.items(count, key, contentType, itemContent);
    }

    public static void access$items$jd(androidx.compose.foundation.lazy.LazyListScope $this, int count, Function1 key, Function4 itemContent) {
        super.items(count, key, itemContent);
    }

    public static void item$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, Object object2, Object object3, Function3 function34, int i5, Object object6) {
        int obj2;
        int obj3;
        if (object6 != null) {
        } else {
            final int i = 0;
            if (i5 & 1 != 0) {
                obj2 = i;
            }
            if (i5 &= 2 != 0) {
                obj3 = i;
            }
            lazyListScope.item(obj2, obj3, function34);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        throw obj1;
    }

    public static void item$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, Object object2, Function3 function33, int i4, Object object5) {
        int obj1;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj1 = 0;
            }
            lazyListScope.item(obj1, function33);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        throw obj0;
    }

    public static void items$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, int i2, Function1 function13, Function1 function14, Function4 function45, int i6, Object object7) {
        int obj2;
        androidx.compose.foundation.lazy.LazyListScope.items.1 obj3;
        if (object7 != null) {
        } else {
            if (i6 & 2 != 0) {
                obj2 = 0;
            }
            if (i6 &= 4 != 0) {
                obj3 = LazyListScope.items.1.INSTANCE;
            }
            lazyListScope.items(i2, obj2, obj3, function45);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        throw obj0;
    }

    public static void items$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, int i2, Function1 function13, Function4 function44, int i5, Object object6) {
        int obj2;
        if (object6 != null) {
        } else {
            if (i5 &= 2 != 0) {
                obj2 = 0;
            }
            lazyListScope.items(i2, obj2, function44);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        throw obj0;
    }

    public static void stickyHeader$default(androidx.compose.foundation.lazy.LazyListScope lazyListScope, Object object2, Object object3, Function3 function34, int i5, Object object6) {
        int obj2;
        int obj3;
        if (object6 != null) {
        } else {
            final int i = 0;
            if (i5 & 1 != 0) {
                obj2 = i;
            }
            if (i5 &= 2 != 0) {
                obj3 = i;
            }
            lazyListScope.stickyHeader(obj2, obj3, function34);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
        throw obj1;
    }

    public void item(Object key, Object contentType, Function3<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Composer, ? super Integer, Unit> content) {
        IllegalStateException illegalStateException = new IllegalStateException("The method is not implemented".toString());
        throw illegalStateException;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public void item(Object key, Function3 content) {
        item(key, 0, content);
    }

    public void items(int count, Function1<? super Integer, ? extends Object> key, Function1<? super Integer, ? extends Object> contentType, Function4<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
        IllegalStateException illegalStateException = new IllegalStateException("The method is not implemented".toString());
        throw illegalStateException;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public void items(int count, Function1 key, Function4 itemContent) {
        items(count, key, (Function1)LazyListScope.items.2.INSTANCE, itemContent);
    }

    public abstract void stickyHeader(Object object, Object object2, Function3<? super androidx.compose.foundation.lazy.LazyItemScope, ? super Composer, ? super Integer, Unit> function33);
}
