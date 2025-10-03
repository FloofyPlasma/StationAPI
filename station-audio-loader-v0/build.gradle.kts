import com.floofyplasma.stationapi.gradle.SubprojectHelpers.getSubprojectVersion
import com.floofyplasma.stationapi.gradle.SubprojectHelpers.addModuleDependencies
base.archivesName.set("station-audio-loader-v0")
version = getSubprojectVersion(project, "1.0.0")

addModuleDependencies(project,
        "station-api-base"
)
