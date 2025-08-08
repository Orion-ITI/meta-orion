SUMMARY = "CommonAPI C++ SOME/IP Runtime"
DESCRIPTION = "CommonAPI SOME/IP runtime bindings"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "git://github.com/COVESA/capicxx-someip-runtime.git;protocol=https;branch=master"
SRCREV = "86dfd69802e673d00aed0062f41eddea4670b571"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS = "someip capicxx-core-runtime"

#EXTRA_OECMAKE = "-DINSTALL_LIB_DIR:PATH=${libdir} \
#                 -DINSTALL_INCLUDE_DIR:PATH=${includedir}"

#FILES:${PN} += "${libdir}/lib*.so.*"
#FILES:${PN}-dev += "${includedir}/* ${libdir}/cmake ${libdir}/lib*.so"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/usr \
    -DINSTALL_LIB_DIR:PATH=${baselib} \
    -DINSTALL_CMAKE_DIR:PATH=${baselib}/cmake/CommonAPI \
    -DCommonAPI_DIR=${RECIPE_SYSROOT}/usr/lib/cmake/CommonAPI \
    -DCMAKE_PREFIX_PATH=${RECIPE_SYSROOT}/usr/lib/cmake/CommonAPI"


FILES_${PN}-dev += "${baselib}/cmake"

