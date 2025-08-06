SUMMARY = "Static IP configuration"
LICENSE = "CLOSED"
PROVIDES = "static-ip"
RPROVIDES:${PN} = "static-ip"

SRC_URI = "file://00-eth0.network"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/00-eth0.network ${D}${sysconfdir}/systemd/network/
}

FILES:${PN} = "${sysconfdir}/systemd/network/00-eth0.network"
