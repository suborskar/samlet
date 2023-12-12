package de.suborskar.samlet.iogr;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class IOGRResponse {
    @JsonProperty("permalink_id")
    private String permalinkId;

    private String patch;

    private String patchName;

    private String spoiler;

    private String spoilerName;

    private String version;

    public String getPermalinkId() {
        return permalinkId;
    }

    public void setPermalinkId(String permalinkId) {
        this.permalinkId = permalinkId;
    }

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public String getPatchName() {
        return patchName;
    }

    public void setPatchName(String patchName) {
        this.patchName = patchName;
    }

    public String getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(String spoiler) {
        this.spoiler = spoiler;
    }

    public String getSpoilerName() {
        return spoilerName;
    }

    public void setSpoilerName(String spoilerName) {
        this.spoilerName = spoilerName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
