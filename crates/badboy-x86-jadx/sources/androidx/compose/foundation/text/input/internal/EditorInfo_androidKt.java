package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeAction.Companion;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardCapitalization.Companion;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.KeyboardType.Companion;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a@\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0010\u0008\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"hasFlag", "", "bits", "", "flag", "update", "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int bits, int flag) {
        int i;
        i = bits & flag == flag ? 1 : 0;
        return i;
    }

    public static final void update-pLxbY9I(EditorInfo $this$update_u2dpLxbY9I, java.lang.CharSequence text, long selection, ImeOptions imeOptions, String[] contentMimeTypes) {
        boolean imeAction-eUduSuo;
        Object platformImeOptions;
        int keyboardType-PjHm6EE;
        boolean singleLine;
        int equals-impl0;
        boolean autoCorrect;
        androidx.compose.foundation.text.input.internal.EditorInfoApi34 stylusHandwritingSupported;
        int done-eUduSuo;
        boolean sentences-IUNYP9k;
        int numberPassword-PjHm6EE;
        int i;
        int i2;
        imeAction-eUduSuo = contentMimeTypes.getImeAction-eUduSuo();
        final int i6 = 2;
        i2 = 6;
        final int i7 = 0;
        final int i8 = 1;
        if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getDefault-eUduSuo())) {
            if (contentMimeTypes.getSingleLine()) {
            } else {
                i2 = i7;
            }
            $this$update_u2dpLxbY9I.imeOptions = i2;
            platformImeOptions = contentMimeTypes.getPlatformImeOptions();
            platformImeOptions = platformImeOptions.getPrivateImeOptions();
            if (platformImeOptions != null && platformImeOptions != null) {
                platformImeOptions = platformImeOptions.getPrivateImeOptions();
                if (platformImeOptions != null) {
                    done-eUduSuo = 0;
                    $this$update_u2dpLxbY9I.privateImeOptions = platformImeOptions;
                }
            }
            LocaleListHelper.INSTANCE.setHintLocales($this$update_u2dpLxbY9I, contentMimeTypes.getHintLocales());
            keyboardType-PjHm6EE = contentMimeTypes.getKeyboardType-PjHm6EE();
            if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getText-PjHm6EE())) {
                i = i8;
                $this$update_u2dpLxbY9I.inputType = i;
                $this$update_u2dpLxbY9I.inputType = inputType7 |= i5;
                if (!contentMimeTypes.getSingleLine() && EditorInfo_androidKt.hasFlag($this$update_u2dpLxbY9I.inputType, i8) && ImeAction.equals-impl0(contentMimeTypes.getImeAction-eUduSuo(), ImeAction.Companion.getDefault-eUduSuo())) {
                    if (EditorInfo_androidKt.hasFlag($this$update_u2dpLxbY9I.inputType, i8)) {
                        $this$update_u2dpLxbY9I.inputType = inputType7 |= i5;
                        if (ImeAction.equals-impl0(contentMimeTypes.getImeAction-eUduSuo(), ImeAction.Companion.getDefault-eUduSuo())) {
                            $this$update_u2dpLxbY9I.imeOptions = imeOptions4 |= sentences-IUNYP9k;
                        }
                    }
                }
                if (EditorInfo_androidKt.hasFlag($this$update_u2dpLxbY9I.inputType, i8)) {
                    int capitalization-IUNYP9k = contentMimeTypes.getCapitalization-IUNYP9k();
                    if (KeyboardCapitalization.equals-impl0(capitalization-IUNYP9k, KeyboardCapitalization.Companion.getCharacters-IUNYP9k())) {
                        $this$update_u2dpLxbY9I.inputType = inputType2 |= 4096;
                    } else {
                        if (KeyboardCapitalization.equals-impl0(capitalization-IUNYP9k, KeyboardCapitalization.Companion.getWords-IUNYP9k())) {
                            $this$update_u2dpLxbY9I.inputType = inputType5 |= 8192;
                        } else {
                            if (KeyboardCapitalization.equals-impl0(capitalization-IUNYP9k, KeyboardCapitalization.Companion.getSentences-IUNYP9k())) {
                                $this$update_u2dpLxbY9I.inputType = inputType4 |= 16384;
                            }
                        }
                    }
                    if (contentMimeTypes.getAutoCorrect()) {
                        $this$update_u2dpLxbY9I.inputType = inputType3 |= sentences-IUNYP9k;
                    }
                }
                $this$update_u2dpLxbY9I.initialSelStart = TextRange.getStart-impl(selection);
                $this$update_u2dpLxbY9I.initialSelEnd = TextRange.getEnd-impl(selection);
                EditorInfoCompat.setInitialSurroundingText($this$update_u2dpLxbY9I, text);
                if (obj12 != null) {
                    EditorInfoCompat.setContentMimeTypes($this$update_u2dpLxbY9I, obj12);
                }
                $this$update_u2dpLxbY9I.imeOptions = imeOptions3 |= numberPassword-PjHm6EE;
                if (StylusHandwriting_androidKt.isStylusHandwritingSupported() && !KeyboardType.equals-impl0(contentMimeTypes.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPassword-PjHm6EE()) && !KeyboardType.equals-impl0(contentMimeTypes.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getNumberPassword-PjHm6EE())) {
                    if (!KeyboardType.equals-impl0(contentMimeTypes.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPassword-PjHm6EE())) {
                        if (!KeyboardType.equals-impl0(contentMimeTypes.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getNumberPassword-PjHm6EE())) {
                            EditorInfoCompat.setStylusHandwritingEnabled($this$update_u2dpLxbY9I, i8);
                            EditorInfoApi34.INSTANCE.setHandwritingGestures($this$update_u2dpLxbY9I);
                        } else {
                            EditorInfoCompat.setStylusHandwritingEnabled($this$update_u2dpLxbY9I, i7);
                        }
                    } else {
                    }
                } else {
                }
            } else {
                if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getAscii-PjHm6EE())) {
                    $this$update_u2dpLxbY9I.imeOptions = imeOptions2 |= sentences-IUNYP9k;
                    i = i8;
                } else {
                    if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getNumber-PjHm6EE())) {
                        i = i6;
                    } else {
                        if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getPhone-PjHm6EE())) {
                        } else {
                            if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getUri-PjHm6EE())) {
                                i = 17;
                            } else {
                                if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getEmail-PjHm6EE())) {
                                    i = 33;
                                } else {
                                    if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getPassword-PjHm6EE())) {
                                        i = 129;
                                    } else {
                                        if (KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getNumberPassword-PjHm6EE())) {
                                            i = 18;
                                        } else {
                                            if (!KeyboardType.equals-impl0(keyboardType-PjHm6EE, KeyboardType.Companion.getDecimal-PjHm6EE())) {
                                            } else {
                                                i = 8194;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Invalid Keyboard Type".toString());
            throw illegalStateException;
        } else {
            if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getNone-eUduSuo())) {
                i2 = i8;
            } else {
                if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getGo-eUduSuo())) {
                    i2 = i6;
                } else {
                    if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getNext-eUduSuo())) {
                        i2 = 5;
                    } else {
                        if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getPrevious-eUduSuo())) {
                            i2 = 7;
                        } else {
                            if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getSearch-eUduSuo())) {
                                i2 = i;
                            } else {
                                if (ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getSend-eUduSuo())) {
                                    i2 = 4;
                                } else {
                                    if (!ImeAction.equals-impl0(imeAction-eUduSuo, ImeAction.Companion.getDone-eUduSuo())) {
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("invalid ImeAction".toString());
        throw illegalStateException2;
    }

    public static void update-pLxbY9I$default(EditorInfo editorInfo, java.lang.CharSequence charSequence2, long l3, ImeOptions imeOptions4, String[] string5Arr5, int i6, Object object7) {
        int i;
        int obj11;
        i = object7 &= 8 != 0 ? obj11 : i6;
        EditorInfo_androidKt.update-pLxbY9I(editorInfo, charSequence2, l3, obj3, string5Arr5);
    }
}
