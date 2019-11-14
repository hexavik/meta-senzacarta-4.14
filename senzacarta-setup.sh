#!/bin/sh

LAYERS_DIR=./sources/base/conf/
LAYERSENZACARTA_STRING="BBLAYERS += \"\${BSPDIR}/sources/meta-senzacarta\""

if [ -w ${LAYERS_DIR}/bblayers.conf ]
then
	grep "${LAYER_SENZACARTA_STRING}" "${LAYERS_DIR}/bblayers.conf" > /dev/null
	TMPRETVAL=$(echo $?)
	TMPPRINT=""

	if [ ${TMPRETVAL} -eq 0 ]
	then
		TMPPRINT="already present"
	fi

	if [ ${TMPRETVAL} -eq 1 ]
	then
		echo "${LAYER_SENZACARTA_STRING}" >> ${LAYERS_DIR}/bblayers.conf
		TMPPRINT="added"
	fi

	echo "Layer meta-senzacarta ${TMPPRINT}"
fi
