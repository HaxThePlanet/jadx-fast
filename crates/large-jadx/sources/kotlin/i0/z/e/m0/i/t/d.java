package kotlin.i0.z.e.m0.i.t;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.i0.z.e.m0.b.i;
import kotlin.i0.z.e.m0.f.b;

/* loaded from: classes3.dex */
public enum d {

    BOOLEAN(field_3, "boolean", "Z", "java.lang.Boolean");

    private final String desc;
    private final String name;
    private final i primitiveType;
    private final b wrapperFqName;
    private static void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        Object obj7;
        final int i3 = 4;
        final int i4 = 2;
        if (i != i4 && i != i3) {
            if (i != i3) {
                str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            } else {
            }
        } else {
        }
        if (i != i4 && i != i3) {
            if (i != i3) {
                i2 = /* condition */ ? i4 : 3;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        str2 = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
        int i5 = 0;
        switch (i) {
            case 1:
                arr[i5] = "name";
                break;
            case 2:
                arr[i5] = str2;
                break;
            case 3:
                arr[i5] = "type";
                break;
            case 4:
                arr[i5] = "desc";
                break;
            case 5:
                arr[i5] = "primitiveType";
                break;
            case 6:
                arr[i5] = "wrapperClassName";
                break;
            default:
                arr[i5] = "className";
        }
        String str4 = "get";
        int i6 = 1;
        if (i != i4 && i != i3) {
            if (i != i3) {
                switch (i) {
                    case 10:
                        arr[i6] = "getPrimitiveType";
                        break;
                    case 11:
                        arr[i6] = "getJavaKeywordName";
                        break;
                    case 12:
                        arr[i6] = "getDesc";
                        break;
                    case 13:
                        arr[i6] = "getWrapperFqName";
                        break;
                    default:
                        arr[i6] = str2;
                }
            } else {
                arr[i6] = str4;
            }
        } else {
        }
        switch (i) {
            case 1:
                arr[i4] = str4;
                break;
            case 3:
                arr[i4] = "getByDesc";
                break;
            case 4:
                arr[i4] = "<init>";
                break;
            default:
                arr[i4] = "isWrapperClassName";
        }
        String format = String.format(str, arr);
        if (i != i4 && i != i3) {
            if (i != i3) {
                if (/* condition */) {
                    obj7 = new IllegalStateException(format);
                } else {
                    obj7 = new IllegalArgumentException(format);
                }
            } else {
            }
        } else {
        }
        throw obj7;
    }

    public static kotlin.i0.z.e.m0.i.t.d get(String string) {
        int i;
        Object obj3;
        if (string == null) {
            d.$$$reportNull$$$0(1);
        }
        Object obj = d.TYPE_BY_NAME.get(string);
        if ((d)obj == null) {
        } else {
            if ((d)obj == null) {
                d.$$$reportNull$$$0(2);
            }
            return (d)obj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Non-primitive type name passed: ");
        stringBuilder.append(string);
        AssertionError assertionError = new AssertionError(stringBuilder.toString());
        throw assertionError;
    }

    public static kotlin.i0.z.e.m0.i.t.d get(i i) {
        int i2;
        Map tYPE_BY_PRIMITIVE_TYPE;
        if (i == null) {
            d.$$$reportNull$$$0(3);
        }
        final Object obj1 = d.TYPE_BY_PRIMITIVE_TYPE.get(i);
        if ((d)obj1 == null) {
            d.$$$reportNull$$$0(4);
        }
        return (d)obj1;
    }

    @Override // java.lang.Enum
    public String getDesc() {
        int i;
        final String desc = this.desc;
        if (desc == null) {
            d.$$$reportNull$$$0(12);
        }
        return desc;
    }

    @Override // java.lang.Enum
    public String getJavaKeywordName() {
        int i;
        final String name = this.name;
        if (name == null) {
            d.$$$reportNull$$$0(11);
        }
        return name;
    }

    @Override // java.lang.Enum
    public i getPrimitiveType() {
        int i;
        final i primitiveType = this.primitiveType;
        if (primitiveType == null) {
            d.$$$reportNull$$$0(10);
        }
        return primitiveType;
    }

    @Override // java.lang.Enum
    public b getWrapperFqName() {
        int i;
        final b wrapperFqName = this.wrapperFqName;
        if (wrapperFqName == null) {
            d.$$$reportNull$$$0(13);
        }
        return wrapperFqName;
    }
}
