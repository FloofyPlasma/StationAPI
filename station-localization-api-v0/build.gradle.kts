import com.floofyplasma.stationapi.gradle.SubprojectHelpers.getSubprojectVersion
import com.floofyplasma.stationapi.gradle.SubprojectHelpers.addModuleDependencies
base.archivesName.set("station-localization-api-v0")
version = getSubprojectVersion(project, "1.0.0")

addModuleDependencies(project,
        "station-api-base",
        "station-resource-loader-v0"
)
