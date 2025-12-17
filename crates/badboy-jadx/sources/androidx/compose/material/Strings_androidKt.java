package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.R.string;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0006", d2 = {"getString", "", "string", "Landroidx/compose/material/Strings;", "getString-4foXLRw", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Strings_androidKt {
    public static final String getString-4foXLRw(int string, Composer $composer, int $changed) {
        boolean traceInProgress;
        String string2;
        String str;
        int i = -726638443;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(getString)P(0:c#material.Strings)25@921L7,26@962L7:Strings.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.getString (Strings.android.kt:24)");
        }
        int i2 = 0;
        int i4 = 0;
        int i6 = 2023513938;
        final String str3 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, i6, str3);
        $composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i3 = 0;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, i6, str3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Resources resources = (Context)$composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalContext()).getResources();
        if (Strings.equals-impl0(string, Strings.Companion.getNavigationMenu-UdPEhr4())) {
            string2 = resources.getString(R.string.navigation_menu);
        } else {
            if (Strings.equals-impl0(string, Strings.Companion.getCloseDrawer-UdPEhr4())) {
                string2 = resources.getString(R.string.close_drawer);
            } else {
                if (Strings.equals-impl0(string, Strings.Companion.getCloseSheet-UdPEhr4())) {
                    string2 = resources.getString(R.string.close_sheet);
                } else {
                    if (Strings.equals-impl0(string, Strings.Companion.getDefaultErrorMessage-UdPEhr4())) {
                        string2 = resources.getString(R.string.default_error_message);
                    } else {
                        if (Strings.equals-impl0(string, Strings.Companion.getExposedDropdownMenu-UdPEhr4())) {
                            string2 = resources.getString(R.string.dropdown_menu);
                        } else {
                            if (Strings.equals-impl0(string, Strings.Companion.getSliderRangeStart-UdPEhr4())) {
                                string2 = resources.getString(R.string.range_start);
                            } else {
                                if (Strings.equals-impl0(string, Strings.Companion.getSliderRangeEnd-UdPEhr4())) {
                                    string2 = resources.getString(R.string.range_end);
                                } else {
                                    string2 = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return string2;
    }
}
