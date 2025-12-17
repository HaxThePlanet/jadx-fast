package kotlin;

import kotlin.jvm.JvmStatic;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005", d2 = {"Lkotlin/KotlinVersionCurrentValue;", "", "()V", "get", "Lkotlin/KotlinVersion;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class KotlinVersionCurrentValue {

    public static final kotlin.KotlinVersionCurrentValue INSTANCE;
    static {
        KotlinVersionCurrentValue kotlinVersionCurrentValue = new KotlinVersionCurrentValue();
        KotlinVersionCurrentValue.INSTANCE = kotlinVersionCurrentValue;
    }

    @JvmStatic
    public static final kotlin.KotlinVersion get() {
        KotlinVersion kotlinVersion = new KotlinVersion(2, 0, 21);
        return kotlinVersion;
    }
}
