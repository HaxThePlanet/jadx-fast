package kotlin.internal.jdk8;

import java.lang.reflect.Field;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0010\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0010", d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations;", "Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "()V", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "sdkIsNullOrAtLeast", "", "version", "", "ReflectSdkVersion", "kotlin-stdlib-jdk8"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006", d2 = {"Lkotlin/internal/jdk8/JDK8PlatformImplementations$ReflectSdkVersion;", "", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk8"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class ReflectSdkVersion {

        public static final kotlin.internal.jdk8.JDK8PlatformImplementations.ReflectSdkVersion INSTANCE;
        public static final Integer sdkVersion;
        static {
            int i;
            int obj;
            boolean intValue;
            int i2;
            int i3;
            JDK8PlatformImplementations.ReflectSdkVersion reflectSdkVersion = new JDK8PlatformImplementations.ReflectSdkVersion();
            JDK8PlatformImplementations.ReflectSdkVersion.INSTANCE = reflectSdkVersion;
            i = 0;
            if (obj instanceof Integer) {
            } else {
                obj = i;
            }
            if (obj != null) {
                i2 = 0;
                i3 = (Number)obj.intValue() > 0 ? 1 : 0;
                if (i3 != 0) {
                    i = obj;
                }
            }
            try {
                JDK8PlatformImplementations.ReflectSdkVersion.sdkVersion = i;
            }
        }
    }
    private final boolean sdkIsNullOrAtLeast(int version) {
        int i;
        Integer sdkVersion;
        if (JDK8PlatformImplementations.ReflectSdkVersion.sdkVersion != null) {
            if (JDK8PlatformImplementations.ReflectSdkVersion.sdkVersion.intValue() >= version) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.internal.jdk7.JDK7PlatformImplementations
    public Random defaultPlatformRandom() {
        Random platformThreadLocalRandom;
        if (sdkIsNullOrAtLeast(34)) {
            platformThreadLocalRandom = new PlatformThreadLocalRandom();
        } else {
            platformThreadLocalRandom = super.defaultPlatformRandom();
        }
        return platformThreadLocalRandom;
    }

    @Override // kotlin.internal.jdk7.JDK7PlatformImplementations
    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String name) {
        int i;
        int matchGroup;
        int intValue;
        int str;
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        if (matchResult instanceof Matcher) {
            i = matchResult;
        } else {
            i = matchGroup;
        }
        if (i == 0) {
        } else {
            IntRange intRange = new IntRange(i.start(name), i2--);
            if (intRange.getStart().intValue() >= 0) {
                intValue = i.group(name);
                Intrinsics.checkNotNullExpressionValue(intValue, "group(...)");
                matchGroup = new MatchGroup(intValue, intRange);
            } else {
            }
            return matchGroup;
        }
        UnsupportedOperationException matcher = new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        throw matcher;
    }
}
