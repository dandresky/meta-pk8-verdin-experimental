LICENSE = "CLOSED"
inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "unblock-bluetooth.service"

SRC_URI:append = " file://unblock-bluetooth.service "
FILES:${PN} += "${systemd_unitdir}/system/unblock-bluetooth.service"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0744 ${WORKDIR}/unblock-bluetooth.service ${D}/${systemd_unitdir}/system
}
