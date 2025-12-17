package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lkotlin/text/SystemProperties;", "", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class SystemProperties {

    public static final kotlin.text.SystemProperties INSTANCE;
    public static final String LINE_SEPARATOR;
    static {
        SystemProperties systemProperties = new SystemProperties();
        SystemProperties.INSTANCE = systemProperties;
        String property = System.getProperty("line.separator");
        Intrinsics.checkNotNull(property);
        SystemProperties.LINE_SEPARATOR = property;
    }
}
