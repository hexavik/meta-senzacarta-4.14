# Copyright (C) 2019 SenzaCarta
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel for SenzaCarta Board"
DESCRIPTION = "Linux Kernel for SenzaCarta Board. Contact \
				MAINTAINER for more details."

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

#PV .= "+git${SRCPV}"
PV .= ""

SRCBRANCH = "4.14-2.0.x-imx"
SRC_URI = "git://github.com/Freescale/linux-fslc.git;branch=${SRCBRANCH} \
			file://defconfig"
LOCALVERSION = "-fslc"
SRCREV = "6b774eec1f9d3064e9b33634dfa99d5666d0a73a"

COMPATIBLE_MACHINE = "(mx6|mx7|imx7dsenzacarta)"
