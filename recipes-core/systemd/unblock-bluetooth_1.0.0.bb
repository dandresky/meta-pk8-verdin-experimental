LICENSE = "CLOSED"
inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "unblock-bluetooth.service"

SRC_URI = " file://unblock-bluetooth.service "
FILES:${PN} += "${systemd_unitdir}/system/unblock-bluetooth.service"

do_install:append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/unblock-bluetooth.service ${D}/${systemd_unitdir}/system
}
