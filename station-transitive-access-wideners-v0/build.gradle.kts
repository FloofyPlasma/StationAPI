import com.floofyplasma.stationapi.gradle.SubprojectHelpers.getSubprojectVersion

base.archivesName.set("station-transitive-access-wideners-v0")
version = getSubprojectVersion(project, "1.0.0")

loom {
    accessWidenerPath = file("src/main/resources/station-transitive-access-wideners-v0.accesswidener")
}
