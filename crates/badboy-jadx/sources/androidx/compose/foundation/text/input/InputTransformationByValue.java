package androidx.compose.foundation.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B=\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\tJ9\u0010\u000c\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JC\u0010\r\u001a\u00020\u000028\u0008\u0002\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\u000c\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0016RA\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/text/input/InputTransformationByValue;", "Landroidx/compose/foundation/text/input/InputTransformation;", "transformation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "proposed", "(Lkotlin/jvm/functions/Function2;)V", "getTransformation", "()Lkotlin/jvm/functions/Function2;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class InputTransformationByValue implements androidx.compose.foundation.text.input.InputTransformation {

    private final Function2<java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence> transformation;
    public InputTransformationByValue(Function2<? super java.lang.CharSequence, ? super java.lang.CharSequence, ? extends java.lang.CharSequence> transformation) {
        super();
        this.transformation = transformation;
    }

    public static androidx.compose.foundation.text.input.InputTransformationByValue copy$default(androidx.compose.foundation.text.input.InputTransformationByValue inputTransformationByValue, Function2 function22, int i3, Object object4) {
        Function2 obj1;
        if (i3 &= 1 != 0) {
            obj1 = inputTransformationByValue.transformation;
        }
        return inputTransformationByValue.copy(obj1);
    }

    public final Function2<java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence> component1() {
        return this.transformation;
    }

    public final androidx.compose.foundation.text.input.InputTransformationByValue copy(Function2<? super java.lang.CharSequence, ? super java.lang.CharSequence, ? extends java.lang.CharSequence> function2) {
        InputTransformationByValue inputTransformationByValue = new InputTransformationByValue(function2);
        return inputTransformationByValue;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof InputTransformationByValue) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.transformation, obj.transformation)) {
            return i2;
        }
        return i;
    }

    public final Function2<java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence> getTransformation() {
        return this.transformation;
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public int hashCode() {
        return this.transformation.hashCode();
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("InputTransformation.byValue(transformation=").append(this.transformation).append(')').toString();
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void transformInput(androidx.compose.foundation.text.input.TextFieldBuffer $this$transformInput) {
        final Object obj = $this$transformInput;
        final androidx.compose.foundation.text.input.TextFieldCharSequence obj7 = TextFieldBuffer.toTextFieldCharSequence-udt6zUU$foundation_release$default(obj, 0, obj2, 0, 3);
        Object invoke = this.transformation.invoke(obj.getOriginalValue$foundation_release(), obj7);
        if ((CharSequence)invoke == obj7) {
        }
        if ((CharSequence)invoke == obj.getOriginalValue$foundation_release()) {
            obj.revertAllChanges();
        } else {
            obj.setTextIfChanged$foundation_release((CharSequence)invoke);
        }
    }
}
