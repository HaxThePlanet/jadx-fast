package androidx.compose.ui.tooling.data;

import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0003\u0018\u00002\u00020\u0001BW\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u0008\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0002\u0010\u0010J\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00062\u0008\u0010 \u001a\u0004\u0018\u00010\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0011R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0011R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0015¨\u0006!", d2 = {"Landroidx/compose/ui/tooling/data/SourceInformationContext;", "", "name", "", "sourceFile", "packageHash", "", "locations", "", "Landroidx/compose/ui/tooling/data/SourceLocationInfo;", "repeatOffset", "parameters", "Landroidx/compose/ui/tooling/data/Parameter;", "isCall", "", "isInline", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/util/List;ZZ)V", "()Z", "getLocations", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "nextLocation", "getPackageHash", "()I", "getParameters", "getRepeatOffset", "getSourceFile", "nextSourceLocation", "Landroidx/compose/ui/tooling/data/SourceLocation;", "sourceLocation", "callIndex", "parentContext", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SourceInformationContext {

    private final boolean isCall;
    private final boolean isInline;
    private final List<androidx.compose.ui.tooling.data.SourceLocationInfo> locations;
    private final String name;
    private int nextLocation;
    private final int packageHash;
    private final List<androidx.compose.ui.tooling.data.Parameter> parameters;
    private final int repeatOffset;
    private final String sourceFile;
    public SourceInformationContext(String name, String sourceFile, int packageHash, List<androidx.compose.ui.tooling.data.SourceLocationInfo> locations, int repeatOffset, List<androidx.compose.ui.tooling.data.Parameter> parameters, boolean isCall, boolean isInline) {
        super();
        this.name = name;
        this.sourceFile = sourceFile;
        this.packageHash = packageHash;
        this.locations = locations;
        this.repeatOffset = repeatOffset;
        this.parameters = parameters;
        this.isCall = isCall;
        this.isInline = isInline;
    }

    public final List<androidx.compose.ui.tooling.data.SourceLocationInfo> getLocations() {
        return this.locations;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    public final List<androidx.compose.ui.tooling.data.Parameter> getParameters() {
        return this.parameters;
    }

    public final int getRepeatOffset() {
        return this.repeatOffset;
    }

    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final boolean isCall() {
        return this.isCall;
    }

    public final boolean isInline() {
        return this.isInline;
    }

    public final androidx.compose.ui.tooling.data.SourceLocation nextSourceLocation() {
        int nextLocation;
        int intValue;
        int intValue3;
        int intValue2;
        if (this.nextLocation >= this.locations.size() && this.repeatOffset >= 0) {
            if (this.repeatOffset >= 0) {
                this.nextLocation = this.repeatOffset;
            }
        }
        if (this.nextLocation < this.locations.size()) {
            int nextLocation3 = this.nextLocation;
            this.nextLocation = nextLocation3 + 1;
            Object obj = this.locations.get(nextLocation3);
            Integer lineNumber = (SourceLocationInfo)obj.getLineNumber();
            intValue3 = -1;
            if (lineNumber != null) {
                intValue = lineNumber.intValue();
            } else {
                intValue = intValue3;
            }
            Integer offset = obj.getOffset();
            if (offset != null) {
                intValue2 = offset.intValue();
            } else {
                intValue2 = intValue3;
            }
            Integer length = obj.getLength();
            if (length != null) {
                intValue3 = length.intValue();
            }
            SourceLocation sourceLocation = new SourceLocation(intValue, intValue2, intValue3, this.sourceFile, this.packageHash);
            return sourceLocation;
        }
        return null;
    }

    public final androidx.compose.ui.tooling.data.SourceLocation sourceLocation(int callIndex, androidx.compose.ui.tooling.data.SourceInformationContext parentContext) {
        int locationIndex;
        int repeatOffset;
        int repeatOffset2;
        int packageHash;
        Integer valueOf;
        int repeatOffset3;
        int intValue3;
        int intValue2;
        int intValue4;
        int intValue;
        String sourceFile;
        if (callIndex >= this.locations.size() && this.repeatOffset >= 0 && this.repeatOffset < this.locations.size()) {
            if (this.repeatOffset >= 0) {
                if (this.repeatOffset < this.locations.size()) {
                    locationIndex = repeatOffset;
                }
            }
        }
        valueOf = 0;
        if (locationIndex < this.locations.size()) {
            Object obj = this.locations.get(locationIndex);
            Integer lineNumber = (SourceLocationInfo)obj.getLineNumber();
            intValue2 = -1;
            if (lineNumber != null) {
                intValue3 = lineNumber.intValue();
            } else {
                intValue3 = intValue2;
            }
            Integer offset = obj.getOffset();
            if (offset != null) {
                intValue4 = offset.intValue();
            } else {
                intValue4 = intValue2;
            }
            Integer length = obj.getLength();
            if (length != null) {
                intValue = length.intValue();
            } else {
                intValue = intValue2;
            }
            if (this.sourceFile == null) {
                sourceFile = parentContext != null ? parentContext.sourceFile : valueOf;
            }
            if (this.sourceFile == null) {
                if (parentContext != null) {
                    packageHash = parentContext.packageHash;
                    valueOf = Integer.valueOf(packageHash);
                }
            } else {
                packageHash = this.packageHash;
            }
            if (valueOf != null) {
                intValue2 = valueOf.intValue();
            }
            SourceLocation sourceLocation = new SourceLocation(intValue3, intValue4, intValue, sourceFile, intValue2);
            return sourceLocation;
        }
        return valueOf;
    }
}
