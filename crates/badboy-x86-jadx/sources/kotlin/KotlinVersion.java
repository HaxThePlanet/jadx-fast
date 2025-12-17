package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00172\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u000e\u0010\u000c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KotlinVersion implements Comparable<kotlin.KotlinVersion> {

    public static final kotlin.KotlinVersion CURRENT = null;
    public static final kotlin.KotlinVersion.Companion Companion = null;
    public static final int MAX_COMPONENT_VALUE = 255;
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lkotlin/KotlinVersion$Companion;", "", "()V", "CURRENT", "Lkotlin/KotlinVersion;", "MAX_COMPONENT_VALUE", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        KotlinVersion.Companion companion = new KotlinVersion.Companion(0);
        KotlinVersion.Companion = companion;
        KotlinVersion.CURRENT = KotlinVersionCurrentValue.get();
    }

    public KotlinVersion(int major, int minor) {
        super(major, minor, 0);
    }

    public KotlinVersion(int major, int minor, int patch) {
        super();
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.version = versionOf(this.major, this.minor, this.patch);
    }

    private final int versionOf(int major, int minor, int patch) {
        int i;
        int i3;
        int i2;
        i = 256;
        i3 = 1;
        int i9 = 0;
        if (major >= 0 && major < i) {
            i2 = major < i ? i3 : i9;
        } else {
        }
        if (i2 != 0) {
            if (minor >= 0 && minor < i) {
                i2 = minor < i ? i3 : i9;
            } else {
            }
            if (i2 != 0) {
                if (patch >= 0 && patch < i) {
                    i = patch < i ? i3 : i9;
                } else {
                }
                if (i != 0) {
                } else {
                    i3 = i9;
                }
            } else {
            }
        } else {
        }
        if (i3 == 0) {
        } else {
            return i5 += patch;
        }
        int i7 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int i10 = 46;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Version components are out of range: ").append(major).append(i10).append(minor).append(i10).append(patch).toString().toString());
        throw illegalArgumentException;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object other) {
        return compareTo((KotlinVersion)other);
    }

    @Override // java.lang.Comparable
    public int compareTo(kotlin.KotlinVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return version -= version2;
    }

    @Override // java.lang.Comparable
    public boolean equals(Object other) {
        int i;
        Object obj;
        if (this == other) {
            return 1;
        }
        if (other instanceof KotlinVersion) {
            obj = other;
        } else {
            obj = 0;
        }
        final int i2 = 0;
        if (obj == null) {
            return i2;
        }
        if (this.version == obj.version) {
        } else {
            i = i2;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public final int getMajor() {
        return this.major;
    }

    @Override // java.lang.Comparable
    public final int getMinor() {
        return this.minor;
    }

    @Override // java.lang.Comparable
    public final int getPatch() {
        return this.patch;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return this.version;
    }

    @Override // java.lang.Comparable
    public final boolean isAtLeast(int major, int minor) {
        int major2;
        int i;
        if (this.major <= major) {
            if (this.major == major && this.minor >= minor) {
                if (this.minor >= minor) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Comparable
    public final boolean isAtLeast(int major, int minor, int patch) {
        int major2;
        int i;
        if (this.major <= major) {
            if (this.major == major) {
                if (this.minor <= minor) {
                    if (this.minor == minor && this.patch >= patch) {
                        if (this.patch >= patch) {
                            i = 1;
                        } else {
                            i = 0;
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

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 46;
        return stringBuilder.append(this.major).append(i).append(this.minor).append(i).append(this.patch).toString();
    }
}
