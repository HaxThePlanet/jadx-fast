package kotlin.i0.z.e.m0.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.e;

/* loaded from: classes3.dex */
public enum n {

    UBYTE("kotlin/UByte"),
    USHORT("fromString(\"kotlin/UByte\")"),
    UINT("fromString(\"kotlin/UShort\")"),
    ULONG("fromString(\"kotlin/UInt\")");

    private final a arrayClassId;
    private final a classId;
    private final e typeName;
    @Override // java.lang.Enum
    public final a getArrayClassId() {
        return this.arrayClassId;
    }

    @Override // java.lang.Enum
    public final a getClassId() {
        return this.classId;
    }

    @Override // java.lang.Enum
    public final e getTypeName() {
        return this.typeName;
    }
}
