LICENSE = "CLOSED"
inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "hello-world.service"

SRC_URI = " file://hello-world.service "
FILES:${PN} += "${systemd_unitdir}/system/hello-world.service"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/hello-world.service ${D}/${systemd_unitdir}/system
}
