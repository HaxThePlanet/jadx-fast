package androidx.compose.ui.graphics;

import android.graphics.Shader.TileMode;
import android.os.Build.VERSION;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0003\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008\u001a\u000f\u0010\t\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000b", d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/TileMode;", "isSupported-0vamqd0", "(I)Z", "toAndroidTileMode", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toComposeTileMode", "(Landroid/graphics/Shader$TileMode;)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidTileMode_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[Shader.TileMode.CLAMP.ordinal()] = 1;
            iArr[Shader.TileMode.MIRROR.ordinal()] = 2;
            iArr[Shader.TileMode.REPEAT.ordinal()] = 3;
            AndroidTileMode_androidKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final boolean isSupported-0vamqd0(int $this$isSupported_u2d0vamqd0) {
        int i;
        int sDK_INT;
        if (Build.VERSION.SDK_INT < 31) {
            if (!TileMode.equals-impl0($this$isSupported_u2d0vamqd0, TileMode.Companion.getDecal-3opZhB0())) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final Shader.TileMode toAndroidTileMode-0vamqd0(int $this$toAndroidTileMode_u2d0vamqd0) {
        Shader.TileMode frameworkTileModeDecal;
        int i;
        if (TileMode.equals-impl0($this$toAndroidTileMode_u2d0vamqd0, TileMode.Companion.getClamp-3opZhB0())) {
            frameworkTileModeDecal = Shader.TileMode.CLAMP;
        } else {
            if (TileMode.equals-impl0($this$toAndroidTileMode_u2d0vamqd0, TileMode.Companion.getRepeated-3opZhB0())) {
                frameworkTileModeDecal = Shader.TileMode.REPEAT;
            } else {
                if (TileMode.equals-impl0($this$toAndroidTileMode_u2d0vamqd0, TileMode.Companion.getMirror-3opZhB0())) {
                    frameworkTileModeDecal = Shader.TileMode.MIRROR;
                } else {
                    if (TileMode.equals-impl0($this$toAndroidTileMode_u2d0vamqd0, TileMode.Companion.getDecal-3opZhB0())) {
                        if (Build.VERSION.SDK_INT >= 31) {
                            frameworkTileModeDecal = TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
                        } else {
                            frameworkTileModeDecal = Shader.TileMode.CLAMP;
                        }
                    } else {
                        frameworkTileModeDecal = Shader.TileMode.CLAMP;
                    }
                }
            }
        }
        return frameworkTileModeDecal;
    }

    public static final int toComposeTileMode(Shader.TileMode $this$toComposeTileMode) {
        int sDK_INT;
        int clamp-3opZhB0;
        int ordinal;
        switch (i) {
            case 1:
                clamp-3opZhB0 = TileMode.Companion.getClamp-3opZhB0();
                break;
            case 2:
                clamp-3opZhB0 = TileMode.Companion.getMirror-3opZhB0();
                break;
            case 3:
                clamp-3opZhB0 = TileMode.Companion.getRepeated-3opZhB0();
                break;
            default:
                clamp-3opZhB0 = TileModeVerificationHelper.INSTANCE.getComposeTileModeDecal-3opZhB0();
                clamp-3opZhB0 = TileMode.Companion.getClamp-3opZhB0();
        }
        return clamp-3opZhB0;
    }
}
