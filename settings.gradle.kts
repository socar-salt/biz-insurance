rootProject.name = "biz-insurance"

include(
    "module-core",
    "module-domain",
    "module-client",
    "module-batch",
    "module-socket"
)

makeProjectDir(rootProject, "subprojects")

fun makeProjectDir(project: ProjectDescriptor, group: String) {
    project.children.forEach {
        println("$group -> ${it.name}")

        it.projectDir = file("$group/${it.name}")
        makeProjectDir(it, "$group/${it.name}")
    }
}