# sbt-build-properties plugin
![Build status](https://travis-ci.org/scf37/sbt-build-properties.svg?branch=master)

This plugin creates build.properites at target classpath with basic information about the build: artefact name and version, build time, git revision, git origin url, last few commits.

## Why another build conf plugin?
- Properties should be readable by external tools/naked eyes
- Properties should be configurable

##Usage

Add this to project/plugins.sbt
```
resolvers += "Scf37" at "https://dl.bintray.com/scf37/maven/"
libraryDependencies += "me.scf37.buildprops" %% "sbt-build-properties" % "1.0.0"
```

Then, add this setting to project you want to write `build.properties` to:
```
resourceGenerators in Compile <+= buildProperties
```

To change set of properties written, override `buildPropertiesSource` task. To change target file name, override `buildPropertiesTarget` setting.

