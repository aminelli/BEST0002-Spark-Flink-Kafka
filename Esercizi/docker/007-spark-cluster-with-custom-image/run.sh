#!/bin/bash

# set -o errexit
# set -o nounset
# set -o pipefail



if [ "$SPARK_MODE" == "master" ]; then
    # Master constants
    exec /opt/spark/sbin/start-master.sh &
    # EXEC=$(command -v start-worker.sh)
    # ARGS=("--properties-file /opt/spark/conf/log4j2.properties")
    echo "** Starting Spark in master mode **"
else
    exec /opt/spark/sbin/start-worker.sh $SPARK_MASTER_URL  &
    # Worker constants
    # EXEC=$(command -v start-worker.sh)
    # ARGS=("$SPARK_MASTER_URL")
    echo "** Starting Spark in worker mode **"
fi

# exec "$EXEC" "${ARGS[@]-}"

tail -f /dev/null