README
=======

Copyright (C) 2011-2012 Takahiro Yoshimura <altakey@gmail.com>

This is tracing helper application for tablet devices.


0. HOW TO BUILD
=================

[Fire emulator/device up...]

$ ant clean debug uninstall install
...
BUILD SUCCESSFUL
Total time: xx seconds


If you have my lil' launcher script installed somewhere in your PATH,
then you can use the 'run' Ant task to quickly run/test it.

It is available at: https://gist.github.com/1223663 .


1. FEATURES
=============

 * Images can be rotated, flipped, scaled, at your fingertips
 * Load image, manipulate it, lock it, overlay that tracing paper, and
   go on drawing
 * Locking screen make it, and keep it bright
 * Easy unlock operation


2. BUGS
========

 * Images may stick with your finger when you're finished with
   two-fingered operation (i.e. rotation/scaling)


3. ACKNOWLEDGES
=================

Application icon and market image resources are courtesy of Monolith
Works Inc. design team.
