SUMMARY = "Orion OS GUI Image with SOME/IP Camera Server with opencv support"

LICENSE = "CLOSED"

inherit core-image

IMAGE_FEATURES += "splash ssh-server-dropbear weston package-management"

# Base packages
IMAGE_INSTALL:append = " \
    bash \
    connman-client \
    tigervnc \
    systemd \
    systemd-analyze \
    systemd-boot \
"

# GUI components
IMAGE_INSTALL:append = " \
    weston \
    weston-init \
    weston-examples \
    qtbase \
    qtwayland \
    qtbase-plugins \
"

# opencv
IMAGE_INSTALL:append = " \
    opencv \
    opencv-apps \
    opencv-samples \
"

# SOME/IP stack
IMAGE_INSTALL:append = " \
    someip \
    capicxx-core-runtime \
    capicxx-someip-runtime \
    boost \
"

# Custom components
IMAGE_INSTALL:append = " \
    static-ip \
"

# Hardware support
IMAGE_INSTALL:append = " \
    userland \
    pi-blaster \
"

ROOTFS_MAXSIZE = "0"
