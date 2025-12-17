package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0080\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022d\u0008\u0006\u0010\u0003\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r0\u00042d\u0008\u0006\u0010\u000e\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\r0\u00042%\u0008\u0006\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\r0\u0011H\u0086\u0008\u001a4\u0010\u0013\u001a\u00020\u0001*\u00020\u00022%\u0008\u0004\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\r0\u0011H\u0086\u0008\u001as\u0010\u0015\u001a\u00020\u0001*\u00020\u00022d\u0008\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\r0\u0004H\u0086\u0008\u001as\u0010\u0016\u001a\u00020\u0001*\u00020\u00022d\u0008\u0004\u0010\u0014\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\r0\u0004H\u0086\u0008¨\u0006\u0017", d2 = {"addTextChangedListener", "Landroid/text/TextWatcher;", "Landroid/widget/TextView;", "beforeTextChanged", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "text", "", "start", "count", "after", "", "onTextChanged", "before", "afterTextChanged", "Lkotlin/Function1;", "Landroid/text/Editable;", "doAfterTextChanged", "action", "doBeforeTextChanged", "doOnTextChanged", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextViewKt {
    public static final TextWatcher addTextChangedListener(TextView $this$addTextChangedListener, Function4<? super java.lang.CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> beforeTextChanged, Function4<? super java.lang.CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> onTextChanged, Function1<? super Editable, Unit> afterTextChanged) {
        final int i = 0;
        TextViewKt.addTextChangedListener.textWatcher.1 anon = new TextViewKt.addTextChangedListener.textWatcher.1(afterTextChanged, beforeTextChanged, onTextChanged);
        $this$addTextChangedListener.addTextChangedListener((TextWatcher)anon);
        return (TextWatcher)anon;
    }

    public static TextWatcher addTextChangedListener$default(TextView $this$addTextChangedListener_u24default, Function4 beforeTextChanged, Function4 onTextChanged, Function1 afterTextChanged, int i5, Object object6) {
        androidx.core.widget.TextViewKt.addTextChangedListener.1 obj2;
        androidx.core.widget.TextViewKt.addTextChangedListener.2 obj3;
        androidx.core.widget.TextViewKt.addTextChangedListener.3 obj4;
        int obj5;
        int obj6;
        if (i5 & 1 != 0) {
            obj2 = obj6;
        }
        if (i5 & 2 != 0) {
            obj3 = obj6;
        }
        if (i5 &= 4 != 0) {
            obj4 = obj5;
        }
        obj5 = 0;
        obj6 = new TextViewKt.addTextChangedListener.textWatcher.1(obj4, obj2, obj3);
        $this$addTextChangedListener_u24default.addTextChangedListener((TextWatcher)obj6);
        return (TextWatcher)obj6;
    }

    public static final TextWatcher doAfterTextChanged(TextView $this$doAfterTextChanged, Function1<? super Editable, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        TextViewKt.doAfterTextChanged$$inlined.addTextChangedListener.default.1 anon = new TextViewKt.doAfterTextChanged$$inlined.addTextChangedListener.default.1(action);
        $this$doAfterTextChanged.addTextChangedListener((TextWatcher)anon);
        return (TextWatcher)anon;
    }

    public static final TextWatcher doBeforeTextChanged(TextView $this$doBeforeTextChanged, Function4<? super java.lang.CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        TextViewKt.doBeforeTextChanged$$inlined.addTextChangedListener.default.1 anon = new TextViewKt.doBeforeTextChanged$$inlined.addTextChangedListener.default.1(action);
        $this$doBeforeTextChanged.addTextChangedListener((TextWatcher)anon);
        return (TextWatcher)anon;
    }

    public static final TextWatcher doOnTextChanged(TextView $this$doOnTextChanged, Function4<? super java.lang.CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> action) {
        final int i = 0;
        final int i2 = 0;
        TextViewKt.doOnTextChanged$$inlined.addTextChangedListener.default.1 anon = new TextViewKt.doOnTextChanged$$inlined.addTextChangedListener.default.1(action);
        $this$doOnTextChanged.addTextChangedListener((TextWatcher)anon);
        return (TextWatcher)anon;
    }
}
