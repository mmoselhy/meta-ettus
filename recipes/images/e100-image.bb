require recipes-images/angstrom/core-image-e100.bb

DISTRO_SSH_DAEMON = "openssh"

DEPENDS += "task-base-extended \
	   "

IMAGE_INSTALL += " \
  task-base-extended \
  task-proper-tools \
  task-usrp-embedded \
  libosip2-dev \
  ortp-dev \
  asterisk \
  task-gnuradio \
  task-openbts \
"


export IMAGE_BASENAME = "e100-image"
