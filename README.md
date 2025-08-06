# meta-orion Layer

Yocto Project layer providing the **Orion Distribution** with support for Kirkstone (LTS), featuring Qt6, Wayland, vsomeip, opencv, and Raspberry Pi integration.

Dependencies
============

URI: git://git.yoctoproject.org/poky
branch: kirkstone

URI: git://git.yoctoproject.org/meta-yocto-bsp
branch: kirkstone

URI: git://code.qt.io/yocto/meta-qt6.git
branch: kirkstone

URI: git://git.yoctoproject.org/meta-wayland
branch: kirkstone

URI: git://git.openembedded.org/meta-openembedded
branch: kirkstone

URI: git://git.yoctoproject.org/meta-raspberrypi
branch: kirkstone

Patches
=======

Submit patches via GitHub Pull Requests to the kirkstone branch. Maintainers will review and merge.

Table of Contents
=================

  I. Adding the meta-orion layer to your build


I. Adding the meta-orion layer to your build
=================================================

Run 'bitbake-layers add-layer meta-orion'
