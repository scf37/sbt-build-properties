# sbt-build-properties plugin
This plugin creates build.properites at target classpath with basic information about the build: artefact name and version, build time, git revision, git origin url, last few commits.

## Why another build conf plugin?
- Written properties should be readable by external tools/naked eyes
- Written properties should be configurable

## Usage

Add this to project/plugins.sbt
```
addSbtPlugin("me.scf37.buildprops" % "sbt-build-properties" % "1.0.8")
```

Then, add this setting to project you want to write `build.properties` to:
```
Compile / resourceGenerators += buildProperties
```

To change set of properties written, override `buildPropertiesSource` task. To change target file name, override `buildPropertiesTarget` setting.

