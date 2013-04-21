SECTION = "Software"
DESCRIPTION = "OpenBTS"  
PR = "r1"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d73201eaa7756524349718536abd889"
SRC_URI = "file://openbts-P2.8.0Opelousas.tar.gz"
RDEPENDS ="libosip2 ortp asterisk"
S = "${WORKDIR}/openbts-P2.8.0Opelousas"
PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"
FILES_${PN} += "/usr/local/share/OpenBTS"
FILES_${PN} += "${D}${bindir}"
inherit autotools pkgconfig gettext
do_configure () {
    autoreconf -i
   ./configure --with-uhd CFLAGS="-march=armv7-a -mtune=cortex-a8 -mfpu=neon -mfloat-abi=softfp -O3" CXXFLAGS="-march=armv7-a -mtune=cortex-a8 -mfpu=neon -mfloat-abi=softfp -O3" --host=${TARGET_SYS} 
}
do_compile () {
   oe_runmake
}
do_install () {
    oe_runmake DESTDIR=${D} install
    install -d ${D}${bindir}
    install -m 0644 ${S}/apps/OpenBTS ${D}${bindir}
}

SRC_URI[md5sum] = "f0d69d68c52aa8a074ac18a669162dac"
SRC_URI[sha256sum] = "63f869f65245a9fcb07bc6124f98a91e99d2f115ae2efb6857fd5fc1deb2bd87"

