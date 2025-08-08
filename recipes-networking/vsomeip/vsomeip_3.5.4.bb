SUMMARY = "SOME/IP library for automotive communication"
DESCRIPTION = "A library implementing the SOME/IP protocol for automotive use cases."
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9741c346eef56131163e13b9db1241b3"

SRC_URI = "git://github.com/COVESA/vsomeip.git;protocol=https;branch=release_3.5.4"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "boost dlt-daemon googletest"

inherit cmake pkgconfig

EXTRA_OECMAKE = "\
    -DCMAKE_INSTALL_PREFIX=${prefix} \
    -DCMAKE_INSTALL_LIBDIR=${libdir} \
    -DCMAKE_INSTALL_INCLUDEDIR=${includedir} \
    -DCMAKE_INSTALL_SYSCONFDIR=${sysconfdir} \
    -DBUILD_SHARED_LIBS=ON \
"


do_install:append() {
    install -d ${D}${sysconfdir}/vsomeip
    mv ${D}/usr/etc/vsomeip/* ${D}${sysconfdir}/vsomeip/ 2>/dev/null || true
    rmdir ${D}/usr/etc/vsomeip ${D}/usr/etc 2>/dev/null || true
}

FILES_${PN} += "${libdir}/lib*.so.* ${sysconfdir}/vsomeip"
FILES_${PN}-dev += "${includedir}/* ${libdir}/lib*.so"

