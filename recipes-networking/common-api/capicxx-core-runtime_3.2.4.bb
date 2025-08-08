SUMMARY = "CommonAPI C++ Core Runtime"
DESCRIPTION = "CommonAPI core runtime for automotive middleware"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "git://github.com/COVESA/capicxx-core-runtime.git;protocol=https;branch=master"
SRCREV = "0e1d97ef0264622194a42f20be1d6b4489b310b5"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS = "boost dlt-daemon"

#EXTRA_OECMAKE += "\
#    -DINSTALL_LIB_DIR:PATH=${libdir} \
#    -DINSTALL_INCLUDE_DIR:PATH=${includedir} \
#    -DCMAKE_INSTALL_SYSCONFDIR:PATH=${sysconfdir} \
#"

#FILES:${PN} += "${libdir}/lib*.so.*"
#FILES:${PN}-dev += "${includedir}/* ${libdir}/cmake ${libdir}/lib*.so"

EXTRA_OECMAKE += "-DCMAKE_INSTALL_PREFIX=/usr \
    -DINSTALL_LIB_DIR:PATH=${baselib} \
    -DINSTALL_CMAKE_DIR:PATH=${baselib}/cmake/CommonAPI \
    "

FILES_${PN}-dev += "${includedir} ${baselib}/cmake ${baselib}/*.so"

