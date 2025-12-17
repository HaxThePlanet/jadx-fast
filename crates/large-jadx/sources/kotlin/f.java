package kotlin;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00172\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u000e\u0010\u000c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class f implements Comparable<kotlin.f> {

    public static final kotlin.f w;
    private final int a;
    private final int b;
    private final int c;
    private final int v;
    static {
        f.w = g.a();
    }

    public f(int i, int i2, int i3) {
        super();
        this.b = i;
        this.c = i2;
        this.v = i3;
        this.a = c(i, i2, i3);
    }

    private final int c(int i, int i2, int i3) {
        int i4;
        int i5;
        if (i < 0) {
            i4 = 0;
        } else {
            i5 = 255;
            if (i5 >= i) {
                if (i2 < 0) {
                } else {
                    if (i5 >= i2) {
                        if (i3 < 0) {
                        } else {
                            if (i5 >= i3) {
                                i4 = 1;
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        if (i4 == 0) {
        } else {
            return obj3 += i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Version components are out of range: ");
        stringBuilder.append(i);
        int obj3 = 46;
        stringBuilder.append(obj3);
        stringBuilder.append(i2);
        stringBuilder.append(obj3);
        stringBuilder.append(i3);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString().toString());
        throw obj4;
    }

    @Override // java.lang.Comparable
    public int a(kotlin.f f) {
        n.f(f, "other");
        return i -= obj2;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return a((f)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        Object obj4;
        if (this == object) {
            return 1;
        }
        if (!object instanceof f) {
            obj4 = 0;
        }
        int i2 = 0;
        if ((f)obj4 != null) {
            if (this.a == obj4.a) {
            } else {
                i = i2;
            }
            return i;
        }
        return i2;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        return this.a;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        int i2 = 46;
        stringBuilder.append(i2);
        stringBuilder.append(this.c);
        stringBuilder.append(i2);
        stringBuilder.append(this.v);
        return stringBuilder.toString();
    }
}
