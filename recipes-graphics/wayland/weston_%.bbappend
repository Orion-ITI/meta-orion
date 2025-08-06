# Enable VNC support
PACKAGECONFIG:append = " remoting"
EXTRA_OECONF:append = " -Dremoting=true"

# Explicitly define the search path
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://weston-vnc.socket"

do_install:append() {
    # Install socket file
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/weston-vnc.socket ${D}${systemd_system_unitdir}
    
    # Enable socket
    install -d ${D}${sysconfdir}/systemd/system/sockets.target.wants
    ln -s ${systemd_system_unitdir}/weston-vnc.socket \
          ${D}${sysconfdir}/systemd/system/sockets.target.wants/
}

FILES:${PN} += " \
    ${systemd_system_unitdir}/weston-vnc.socket \
    ${sysconfdir}/systemd/system/sockets.target.wants/weston-vnc.socket \
"