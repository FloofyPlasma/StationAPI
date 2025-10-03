# StationAPI for Minecraft Alpha 1.1.2_01 Aabric

<!---
Buildbot moment.
-->

A general use API for Fabric Loader mods on legacy Minecraft versions.

## Plugin Setup

Extra steps for better Mixin making and Fabric configuring in IntelliJ IDEA:

1. Go to `File > Settings...`
2. Go to `Plugins` and install the `Minecraft Development` plugin.
3. Restart IntelliJ IDEA.
4. Follow the instructions in [Using This to Make Mods](#using-this-to-make-mods).
5. Profit!

## Using This to Run Mods

You will want to install the [Aabric Prism instance](https://github.com/FloofyPlasma/aabric-example-mod) and [download the latest release of StationAPI](https://modrinth.com/mod/stationapi/version/latest).  
Put the downloaded StationAPI jar into your mods folder, do NOT add as a jar mod.
Make sure to use Java 17 (disable Java compatibility checks in Prism if it complains).

## Using This to Make Mods

[See the wiki.](https://github.com/ModificationStation/StationAPI/wiki)

Proper code documentation coming eventually. There are some JavaDoc comments for some commonly used classes.

## Common Issues

If you are having any issues with setting up StationAPI or the example mod, have a look at the [BIN Fabric Example Mod's readme entry for common issues](https://github.com/calmilamsy/BIN-fabric-example-mod/#common-issues) (outdated, but some solutions still apply).  

markdown
## License and Modifications

This version of StationAPI has been backported and heavily modified for Minecraft Alpha 1.1.2_01.  

- Original StationAPI copyright and MIT license are retained:
```
Copyright (c) 2022 Modification Station
```

- Modifications in this fork are copyrighted:

```
Copyright (c) 2025 FloofyPlasma
```

- This fork uses a distinct module and package namespace to avoid conflicts with upstream versions.  
- All modifications, backports, and renames are documented here and in code comments where applicable.  

This project remains licensed under the [MIT License](LICENSE), which permits reuse, modification, and redistribution with proper attribution.
