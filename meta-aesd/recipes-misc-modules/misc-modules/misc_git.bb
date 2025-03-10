# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f098732a73b5f6f3430472f5b094ffdb"

SRC_URI = "\
    git://git@github.com/cu-ecen-aeld/assignment-7-japa7016.git;branch=main;protocol=ssh \
    file://S98misc \
"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "f4dba83ff02c0780b9071055e58a0ef389ad2fdc"

S = "${WORKDIR}/git"

inherit module update-rc.d

EXTRA_OEMAKE += " -C ${STAGING_KERNEL_DIR} M=${S}/misc-modules"

do_install:append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/S98misc ${D}${sysconfdir}/init.d
}

INITSCRIPT_NAME = "S98misc"
INITSCRIPT_PARAMS = "defaults 98"
