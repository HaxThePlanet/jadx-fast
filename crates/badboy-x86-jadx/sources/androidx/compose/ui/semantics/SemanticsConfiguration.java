package androidx.compose.ui.semantics;

import androidx.compose.ui.platform.JvmActuals_jvmKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010(\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u00012\u001a\u0012\u0016\u0012\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000H\u0000¢\u0006\u0002\u0008\u0013J\u001d\u0010\u0014\u001a\u00020\u0008\"\u0004\u0008\u0000\u0010\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002J\r\u0010\u0017\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0008\u0018J\u0006\u0010\u0019\u001a\u00020\u0000J\u0013\u0010\u001a\u001a\u00020\u00082\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\"\u0010\u001c\u001a\u0002H\u0015\"\u0004\u0008\u0000\u0010\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u0004H\u0086\u0002¢\u0006\u0002\u0010\u001dJ-\u0010\u001e\u001a\u0002H\u0015\"\u0004\u0008\u0000\u0010\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u00042\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u00150 ¢\u0006\u0002\u0010!J1\u0010\"\u001a\u0004\u0018\u0001H\u0015\"\u0004\u0008\u0000\u0010\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u00042\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00150 ¢\u0006\u0002\u0010!J\u0008\u0010#\u001a\u00020$H\u0016J!\u0010%\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030&H\u0096\u0002J\u0015\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0002\u0008)J*\u0010*\u001a\u00020\u0011\"\u0004\u0008\u0000\u0010\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u00042\u0006\u0010+\u001a\u0002H\u0015H\u0096\u0002¢\u0006\u0002\u0010,J\u0008\u0010-\u001a\u00020.H\u0016R\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\t\"\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\t\"\u0004\u0008\r\u0010\u000bR \u0010\u000e\u001a\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "()V", "isClearingSemantics", "", "()Z", "setClearingSemantics", "(Z)V", "isMergingSemanticsOfDescendants", "setMergingSemanticsOfDescendants", "props", "", "collapsePeer", "", "peer", "collapsePeer$ui_release", "contains", "T", "key", "containsImportantForAccessibility", "containsImportantForAccessibility$ui_release", "copy", "equals", "other", "get", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "hashCode", "", "iterator", "", "mergeChild", "child", "mergeChild$ui_release", "set", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SemanticsConfiguration implements androidx.compose.ui.semantics.SemanticsPropertyReceiver, Iterable<Map.Entry<? extends androidx.compose.ui.semantics.SemanticsPropertyKey<?>, ? extends Object>>, KMappedMarker {

    public static final int $stable = 8;
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;
    private final Map<androidx.compose.ui.semantics.SemanticsPropertyKey<?>, Object> props;
    static {
        final int i = 8;
    }

    public SemanticsConfiguration() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.props = (Map)linkedHashMap;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final void collapsePeer$ui_release(androidx.compose.ui.semantics.SemanticsConfiguration peer) {
        int value;
        Object key;
        Map props;
        Map props2;
        androidx.compose.ui.semantics.AccessibilityAction accessibilityAction;
        String label;
        kotlin.Function action;
        value = 1;
        if (peer.isMergingSemanticsOfDescendants) {
            this.isMergingSemanticsOfDescendants = value;
        }
        if (peer.isClearingSemantics) {
            this.isClearingSemantics = value;
        }
        Iterator iterator = peer.props.entrySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            key = (Map.Entry)next2.getKey();
            value = next2.getValue();
            if (!this.props.containsKey((SemanticsPropertyKey)key)) {
            } else {
            }
            props = this.props.get(key);
            Intrinsics.checkNotNull(props, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            if (value instanceof AccessibilityAction && (AccessibilityAction)props.getLabel() == null) {
            }
            props = this.props.get(key);
            Intrinsics.checkNotNull(props, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            if ((AccessibilityAction)props.getLabel() == null) {
            }
            if (props.getAction() == null) {
            }
            accessibilityAction = new AccessibilityAction(label, action);
            this.props.put(key, accessibilityAction);
            action = (AccessibilityAction)value.getAction();
            label = (AccessibilityAction)value.getLabel();
            this.props.put(key, value);
        }
    }

    public final <T> boolean contains(androidx.compose.ui.semantics.SemanticsPropertyKey<T> key) {
        return this.props.containsKey(key);
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final boolean containsImportantForAccessibility$ui_release() {
        boolean iterator;
        int i;
        boolean next;
        boolean it;
        int i2;
        Set keySet = this.props.keySet();
        final int i3 = 0;
        i = 0;
        if (keySet instanceof Collection != null && (Collection)(Iterable)keySet.isEmpty()) {
            if ((Collection)keySet.isEmpty()) {
            } else {
                iterator = keySet.iterator();
                for (Object next : iterator) {
                    i2 = 0;
                }
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final androidx.compose.ui.semantics.SemanticsConfiguration copy() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        semanticsConfiguration.isClearingSemantics = this.isClearingSemantics;
        semanticsConfiguration.props.putAll(this.props);
        return semanticsConfiguration;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof SemanticsConfiguration) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.props, obj.props)) {
            return i2;
        }
        if (this.isMergingSemanticsOfDescendants != obj2.isMergingSemanticsOfDescendants) {
            return i2;
        }
        if (this.isClearingSemantics != obj3.isClearingSemantics) {
            return i2;
        }
        return i;
    }

    public final <T> T get(androidx.compose.ui.semantics.SemanticsPropertyKey<T> key) {
        Object obj = this.props.get(key);
        if (obj == null) {
        } else {
            return obj;
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Key not present: ").append(key).append(" - consider getOrElse or getOrNull").toString());
        throw illegalStateException;
    }

    public final <T> T getOrElse(androidx.compose.ui.semantics.SemanticsPropertyKey<T> key, Function0<? extends T> defaultValue) {
        Object invoke;
        if (this.props.get(key) == null) {
            invoke = defaultValue.invoke();
        }
        return invoke;
    }

    public final <T> T getOrElseNullable(androidx.compose.ui.semantics.SemanticsPropertyKey<T> key, Function0<? extends T> defaultValue) {
        Object invoke;
        if (this.props.get(key) == null) {
            invoke = defaultValue.invoke();
        }
        return invoke;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public int hashCode() {
        return result += i6;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final boolean isClearingSemantics() {
        return this.isClearingSemantics;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final boolean isMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    public Iterator<Map.Entry<androidx.compose.ui.semantics.SemanticsPropertyKey<?>, Object>> iterator() {
        return this.props.entrySet().iterator();
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final void mergeChild$ui_release(androidx.compose.ui.semantics.SemanticsConfiguration child) {
        Object value;
        Object key;
        Object obj;
        Object merge;
        Map props;
        Iterator iterator = child.props.entrySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            key = (Map.Entry)next2.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
            merge = key.merge(this.props.get((SemanticsPropertyKey)key), next2.getValue());
            if (merge != null) {
            }
            this.props.put(key, merge);
        }
    }

    public <T> void set(androidx.compose.ui.semantics.SemanticsPropertyKey<T> key, T value) {
        boolean contains;
        Object prev;
        Map props;
        androidx.compose.ui.semantics.AccessibilityAction accessibilityAction;
        String label;
        kotlin.Function action;
        if (value instanceof AccessibilityAction && contains(key)) {
            if (contains(key)) {
                prev = this.props.get(key);
                Intrinsics.checkNotNull(prev, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                if ((AccessibilityAction)value.getLabel() == null) {
                    label = (AccessibilityAction)prev.getLabel();
                }
                if ((AccessibilityAction)value.getAction() == null) {
                    action = prev.getAction();
                }
                accessibilityAction = new AccessibilityAction(label, action);
                this.props.put(key, accessibilityAction);
            } else {
                this.props.put(key, value);
            }
        } else {
        }
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final void setClearingSemantics(boolean <set-?>) {
        this.isClearingSemantics = <set-?>;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final void setMergingSemanticsOfDescendants(boolean <set-?>) {
        this.isMergingSemanticsOfDescendants = <set-?>;
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public String toString() {
        String nextSeparator;
        boolean isMergingSemanticsOfDescendants;
        boolean isClearingSemantics;
        Object value;
        Object key;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.isMergingSemanticsOfDescendants) {
            stringBuilder.append("");
            stringBuilder.append("mergeDescendants=true");
            nextSeparator = ", ";
        }
        if (this.isClearingSemantics) {
            stringBuilder.append(nextSeparator);
            stringBuilder.append("isClearingSemantics=true");
            nextSeparator = ", ";
        }
        Iterator iterator = this.props.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            stringBuilder.append(nextSeparator);
            stringBuilder.append((SemanticsPropertyKey)next2.getKey().getName());
            stringBuilder.append(" : ");
            stringBuilder.append(next2.getValue());
            nextSeparator = ", ";
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        return stringBuilder2.append(JvmActuals_jvmKt.simpleIdentityToString(this, 0)).append("{ ").append(stringBuilder).append(" }").toString();
    }
}
