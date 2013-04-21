DESCRIPTION = "My hello world program"
PR = "r0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e2665feebe35bc97aff1b329c87b87e7"

SRC_URI = "file://hello.c \
           file://README.txt"



do_compile() {
        ${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/hello.c -o hello
}


do_install() {
        install -m 0755 -d ${D}${bindir} ${D}${docdir}/hello
        install -m 0755 ${S}/hello ${D}${bindir}
        install -m 0644 ${WORKDIR}/README.txt ${D}${docdir}/hello
}
