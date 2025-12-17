package kotlin.i0;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.n;
import kotlin.y.p;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0011\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0008\u0008\u0000\u0010\u0010*\u00020\r2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0012¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u000cH\u0016¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u0019\u001a\u00020\u0002H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001bH\u0016J\u0008\u0010\u001d\u001a\u00020\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020\u001bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "(Lkotlin/reflect/KTypeParameter;)V", "equals", "", "other", "", "getAnnotatedBounds", "", "", "()[Ljava/lang/annotation/Annotation;", "getAnnotation", "T", "annotationClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "getBounds", "Ljava/lang/reflect/Type;", "()[Ljava/lang/reflect/Type;", "getDeclaredAnnotations", "getGenericDeclaration", "getName", "", "getTypeName", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class v implements TypeVariable<GenericDeclaration>, Type {

    private final kotlin.i0.p a;
    public v(kotlin.i0.p p) {
        n.f(p, "typeParameter");
        super();
        this.a = p;
    }

    @Override // java.lang.reflect.TypeVariable
    public boolean equals(Object object) {
        boolean name;
        Object obj2;
        if (object instanceof TypeVariable) {
            if (n.b(getName(), (TypeVariable)object.getName())) {
            } else {
            }
            getGenericDeclaration();
            throw 0;
        }
        return 0;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        int i;
        int i2;
        java.util.List upperBounds = this.a.getUpperBounds();
        ArrayList arrayList = new ArrayList(p.r(upperBounds, 10));
        Iterator iterator = upperBounds.iterator();
        for (o next2 : iterator) {
            arrayList.add(x.a(next2, true));
        }
        Object[] array = arrayList.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Type[])array;
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getGenericDeclaration() is not yet supported for type variables created from KType: ");
        stringBuilder.append(this.a);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("An operation is not implemented: ");
        stringBuilder2.append(stringBuilder.toString());
        n nVar = new n(stringBuilder2.toString());
        throw nVar;
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.a.getName();
    }

    @Override // java.lang.reflect.TypeVariable
    public String getTypeName() {
        return getName();
    }

    @Override // java.lang.reflect.TypeVariable
    public int hashCode() {
        getName().hashCode();
        getGenericDeclaration();
        throw 0;
    }

    @Override // java.lang.reflect.TypeVariable
    public String toString() {
        return getTypeName();
    }
}
