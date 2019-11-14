# Copyright (C) 2019 SenzaCarta

require recipes-bsp/u-boot/u-boot.inc
#require u-boot-fslc-common_${PV}.inc
inherit fsl-u-boot-localversion

SUMMARY = "U-Boot bootloader with support for SenzaCarta Board"

DESCRIPTION = "U-Boot bootloader with support for SenzaCarta Board. \
				Contact MAINTAINER for more support."

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

DEPENDS += "bison-native"
DEPENDS_mxs += "elftosb-native openssl-native"
DEPENDS_append = " bc-native dtc-native"

COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx7|vf|use-mainline-bsp|imx7dsenzacarta)"

PROVIDES += "u-boot"

#PV = "v2019.07+git${SRCPV}"
PV .= ""

SRCBRANCH ??= "master"
SRC_URI = "git://github.com/en-vikrant/senzacarta-uboot-v2019.07.git;branch=${SRCBRANCH}"
SRCREV = "ddefa0056b9086a51301de304d8f4bf8ff32e23c"

S = "${WORKDIR}/git"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"
